/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import smartenrol.model.ClassList;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.StudentGradeRecord;
import smartenrol.model.StudentSection;
import smartenrol.model.Term;

/**
 * This class is for query and update the StudentSection table. 
 * used in sectionsidebar, timetable
 * @author Haijun
 */
public class StudentSectionDAO extends SmartEnrolDAO {
    private Term currentTerm; 
    
    public StudentSectionDAO() {
        super();
        currentTerm = new Term();
    }

    /**
     * Check whether the student has already enrolled in a section. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 0 if not enrolled, 1 if in waitlist, 2 if enrolled, -1 if connection failed.
     */
    public int isStudentEnrolledInSection(int idStudent, String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ArrayList<StudentSection> stuSecList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM StudentSection WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ? ");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setString(4, idSection);
            ps.setInt(5, currentTerm.getCurrentYear());
            ps.setString(6, currentTerm.getCurrentTerm());

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return -1;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuSecList.add(new StudentSection(
                        rs.getInt("idStudent"), 
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("grade"), 
                        rs.getBoolean("onWaitlist")));

            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return -1;
        }        
        
        this.psclose();
        
        // if no record, then not enrolled.
        if (stuSecList.size() == 0)
            return 0;
        // if onwaitlist flag is on, then return 1.
        else if (stuSecList.get(0).isOnWaitlist())
            return 1;
        // otherwise, return 2, meaning enrolled.
        else 
            return 2;
    }
    
    /**
     * Check whether the student has already enrolled in a course. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @return 0 if not enrolled, 1 if in waitlist, 2 if enrolled, -1 if connection failed.
     */
    public int isStudentEnrolledInCourse(int idStudent, String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<StudentSection> stuCourseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM StudentSection WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND year = ? AND term = ? ");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return -1;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuCourseList.add(new StudentSection(
                        rs.getInt("idStudent"), 
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("grade"), 
                        rs.getBoolean("onWaitlist")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return -1;
        }        
        
        this.psclose();
        
        // if no record, then not enrolled.
        if (stuCourseList.size() == 0)
            return 0;
        // if onwaitlist flag is on, then return 1.
        else if (stuCourseList.get(0).isOnWaitlist()) //need more logic.
            return 1;
        // otherwise, return 2, meaning enrolled.
        else 
            return 2;
    }
    

    public boolean isSectionFull(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
//        ArrayList<Section> sec = new ArrayList<>();
        int enrolledNum = 0;
        int maxNum = 0;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM StudentSection WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ? AND onWaitlist = 0");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idSection);
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }
        
        // parse the resultset
        try {
            while (rs.next()) {
                enrolledNum ++;
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idSection);
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        try {
            if (rs.next())
                maxNum = rs.getInt("maxClassSize");
        }catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }
        
        this.psclose();
        
        if (enrolledNum < maxNum)
            return false;
        else
            return true;
            
    }
    
    
    /**
     * Return a list of sections that the student has taken.
     * @param idStudent
     * @return 
     */
    public ArrayList<Section> getStudentHistoryCourseList(int idStudent) {
        this.initConnection();
        ArrayList<Section> stuHistoryCourseList = new ArrayList<>();
        ArrayList<Section> stuCurrentCourseList = this.getStudentCurrentTermCourseList(idStudent);
        
        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term \n" +
                                    "FROM StudentSection ss, Section sc, Course cs \n" +
                                    "WHERE ss.idStudent = ? AND onWaitlist = 0 AND ss.idDepartment = cs.idDepartment AND sc.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse AND sc.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuHistoryCourseList.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getString("courseName"),
                        rs.getFloat("credits"),
                        rs.getInt("year"),
                        rs.getString("term")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        for (Iterator<Section> it = stuCurrentCourseList.iterator(); it.hasNext();) {
            Section secc = it.next();
            for (Iterator<Section> it1 = stuHistoryCourseList.iterator(); it1.hasNext();) {
                Section sech = it1.next();
                if (secc.getIdDepartment().equals(sech.getIdDepartment()) && secc.getIdCourse() == sech.getIdCourse())
                    it1.remove();
            }
        }        
       
        this.psclose();
        return stuHistoryCourseList;
    }

    /**
     * Return a list of sections that the student is taking in the current term.
     * @param idStudent
     * @return course list + year + term
     */
    public ArrayList<Section> getStudentCurrentTermCourseList(int idStudent) {
        this.initConnection();
        ArrayList<Section> stuCurrentCourseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term \n" +
                                    "FROM StudentSection ss, Section sc, Course cs \n" +
                                    "WHERE ss.idStudent = ? AND ss.year = ? AND ss.term = ? AND onWaitlist = 0 AND ss.idDepartment = cs.idDepartment AND sc.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse AND sc.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);
            ps.setInt(2, currentTerm.getCurrentYear());
            ps.setString(3, currentTerm.getCurrentTerm());

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuCurrentCourseList.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("courseName"), 
                        rs.getFloat("credits"),
                        rs.getInt("year"),
                        rs.getString("term")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return stuCurrentCourseList;
    }
    
    /**
     * Return a list of sections that the student has passed (grade >= 60).
     * @param idStudent
     * @return 
     */
    public ArrayList<Section> getStudentPassedCourseList(int idStudent) {
        this.initConnection();
        ArrayList<Section> stuPassedCourseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term \n" +
                                    "FROM StudentSection ss, Section sc, Course cs \n" +
                                    "WHERE ss.idStudent = ? AND onWaitlist = 0 AND grade >= 60 AND ss.idDepartment = cs.idDepartment AND sc.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse AND sc.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }
        
        // parse the resultset
        try {
            while (rs.next()) {stuPassedCourseList.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getString("courseName"),
                        rs.getFloat("credits"),
                        rs.getInt("year"),
                        rs.getString("term")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return stuPassedCourseList;
    }

    /**
     * Return the classlist of a specified section of the current term.
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public ClassList getSectionClassList(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ClassList classList = new ClassList(new SectionDAO().getSectionByID(idDepartment, idCourse, idSection));
        try {
            ps = conn.prepareStatement("SELECT DISTINCT s.idUser, s.idProgram, u.givenName, u.surname, ss.grade\n" +
                                    "FROM StudentSection ss, Student s, User u\n" +
                                    "WHERE u.idUser = ss.idStudent AND s.idUser = ss.idStudent AND idDepartment = ? AND ss.idCourse = ? AND ss.idSection = ? AND ss.year = ? AND ss.term = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idSection);
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }
        
        // parse the resultset
        try {
            while (rs.next()) {classList.getStuRecordList().add(new StudentGradeRecord(
                        rs.getInt("idStudent"),
                        rs.getString("idProgram"),                      
                        rs.getString("givenName"),
                        rs.getString("surname"),
                        rs.getInt("grade")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        this.psclose();
        return classList;
    }
}
