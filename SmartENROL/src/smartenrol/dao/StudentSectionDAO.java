/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.joda.time.LocalTime;
import smartenrol.model.ClassList;
import smartenrol.model.Course;
import smartenrol.model.CourseGradeRecord;
import smartenrol.model.Section;
import smartenrol.model.SectionNode;
import smartenrol.model.StudentGradeRecord;
import smartenrol.model.StudentSection;
import smartenrol.model.Term;
import smartenrol.model.Timetable;
import smartenrol.model.Transcript;
import smartenrol.model.User;

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
     * tested!
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
     * @return 0 if not enrolled, 1 if partially enrolled, 2 if totally enrolled, -1 if connection failed.
     * tested!
     */
    public int isStudentEnrolledInCourse(int idStudent, String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<StudentSection> stuCourseList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM StudentSection WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND year = ? AND term = ? AND onWaitlist = 0 ");
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
        
        // if no record, then not enrolled, return 0.
        if (stuCourseList.size() == 0)
            return 0;
        // if partially enrolled, return 1.
        else if (stuCourseList.size() < (new SectionDAO().getSectionTypesOfCourse(idDepartment, idCourse)))
            return 1;
        // otherwise, return 2, meaning totally enrolled.
        else 
            return 2;
    }
    

    /**
     * Check whether a section if full or not. 
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return true if full, false if not.
     * tested!
     */
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
     * tested!
     */
    public ArrayList<Section> getStudentHistoryCourseList(int idStudent) {
        this.initConnection();
        ArrayList<Section> stuHistoryCourseList = new ArrayList<>();
        ArrayList<Section> stuCurrentCourseList = this.getStudentCurrentTermCourseList(idStudent);
        
        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term\n" +
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
     * tested!
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
     * tested!
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
     * tested.
     */
    public ClassList getSectionClassList(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ClassList classList = new ClassList(new SectionDAO().getSectionByID(idDepartment, idCourse, idSection));
        ArrayList<StudentGradeRecord> recList = new ArrayList<>();
        User user = new UserDAO().getUserByID(classList.getIdInstructor());
        classList.setInstructorGivenName(user.getGivenName());
        classList.setInstructorSurname(user.getSurname());
        classList.setCourseName(new CourseDAO().getCourseByID(idDepartment, idCourse).getCourseName());

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
            while (rs.next()) {recList.add(new StudentGradeRecord(
                        rs.getInt("idUser"),
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
        
        classList.setStuRecordList(recList);
        this.psclose();
        return classList;
    }
    
    /**
     * Update the grade for a student and a section of current term. 
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @param grade
     * @return 1 if success, other if failed.
     * tested!
     */
    public int updateGrade(int idStudent, String idDepartment, int idCourse, String idSection, int grade) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("UPDATE StudentSection SET grade = ? WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ?");
            ps.setInt(1, grade);
            ps.setInt(2, idStudent);
            ps.setString(3, idDepartment);
            ps.setInt(4, idCourse);
            ps.setString(5, idSection);
            ps.setInt(6, currentTerm.getCurrentYear());
            ps.setString(7, currentTerm.getCurrentTerm());
            
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
           
            this.psclose();
            return count;
	}
    }
    
    /**
     * Return a transcript for a student showing the history courses and grades.
     * @param idStudent
     * @return 
     * tested!
     */
    public Transcript getStudentTranscript(int idStudent) {
        this.initConnection();
        Transcript transcript = new Transcript(new StudentDAO().getStudentByID(idStudent));
        ArrayList<CourseGradeRecord> gradeList = new ArrayList<>();
        ArrayList<CourseGradeRecord> currentTermList = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term, ss.grade\n" +
                                    "FROM StudentSection ss, Section sc, Course cs\n" +
                                    "WHERE ss.idStudent = ? AND onWaitlist = 0 AND ss.idDepartment = cs.idDepartment AND sc.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse AND sc.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {gradeList.add(new CourseGradeRecord(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getFloat("credits"),
                        rs.getString("courseName"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("grade")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        } 
        
        // should get the current term list
        try {
            ps = conn.prepareStatement("SELECT DISTINCT cs.idDepartment, cs.idCourse, cs.courseName, cs.credits, sc.year, sc.term, ss.grade\n" +
                                    "FROM StudentSection ss, Section sc, Course cs\n" +
                                    "WHERE ss.idStudent = ? AND ss.year = ? AND ss.term = ? AND onWaitlist = 0 AND ss.idDepartment = cs.idDepartment AND sc.idDepartment = cs.idDepartment AND ss.idCourse = cs.idCourse AND sc.idCourse = cs.idCourse");
            ps.setInt(1, idStudent);
            ps.setInt(2, currentTerm.getCurrentYear());
            ps.setString(3, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {currentTermList.add(new CourseGradeRecord(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getFloat("credits"),
                        rs.getString("courseName"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getInt("grade")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        } 
        
        // remove the records from the current term.
        for (Iterator<CourseGradeRecord> it = currentTermList.iterator(); it.hasNext();) {
            CourseGradeRecord cgrec = it.next();
            for (Iterator<CourseGradeRecord> it1 = gradeList.iterator(); it1.hasNext();) {
                CourseGradeRecord cgrec1 = it1.next();
                if (cgrec.getYear() == cgrec1.getYear() && cgrec.getTerm().equals(cgrec1.getTerm()))
                    it1.remove();
            }
        }
                    
        transcript.setGradeRecords(gradeList);
        this.psclose();
        return transcript;
    }
    
    /**
     * Return a timetable object for a student.
     * @param idStudent
     * @return 
     */
    public Timetable getStudentTimetable(int idStudent) {
        this.initConnection();
        Timetable timetable = new Timetable("Student");
        User thisUser = new UserDAO().getUserByID(idStudent);
        timetable.setIdUser(idStudent);
        timetable.setGivenName(thisUser.getGivenName());
        timetable.setSurname(thisUser.getSurname());
        timetable.setIdLocation(null);
        timetable.setIdRoom(null);       
        ArrayList<SectionNode> snlist = new ArrayList<>();
        
        try {
            this.initConnection();
            ps = conn.prepareStatement("SELECT sn.idDepartment, sn.idCourse, sn.idSection, sn.day, sn.startTime, sn.endTime, sn.idLocation, sn.idRoom\n" +
                                    "FROM SectionNode sn, StudentSection ss\n" +
                                    "WHERE ss.idStudent = ? AND sn.year = ? AND sn.term = ? AND sn.idDepartment = ss.idDepartment AND sn.idCourse = ss.idCourse AND sn.idSection = ss.idSection AND sn.year = ss.year AND sn.term = ss.term");
            ps.setInt(1, idStudent);
            ps.setInt(2, currentTerm.getCurrentYear());
            ps.setString(3, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {
                snlist.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getString("idSection"),
                        rs.getInt("day"),
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        timetable.setSectionNodeList(snlist);
        this.psclose();
        return timetable;
    }
    
    /**
     * Return the timetable for an instructor.
     * @param idInstructor
     * @return 
     */
    public Timetable getInstructorTimetable(int idInstructor) {
        this.initConnection();
        Timetable timetable = new Timetable("Instructor");
        User thisUser = new UserDAO().getUserByID(idInstructor);
        timetable.setIdUser(idInstructor);
        timetable.setGivenName(thisUser.getGivenName());
        timetable.setSurname(thisUser.getSurname());
        timetable.setIdLocation(null);
        timetable.setIdRoom(null);       
        ArrayList<SectionNode> snlist = new ArrayList<>();
        conn = MySQLConnection.getInstance().getConnection();
        try {
            ps = conn.prepareStatement("SELECT sn.idDepartment, sn.idCourse, sn.idSection, sn.day, sn.startTime, sn.endTime, sn.idLocation, sn.idRoom\n" +
                                    "FROM SectionNode sn, Section ss\n" +
                                    "WHERE ss.idInstructor = ? AND sn.year = ? AND sn.term = ? AND sn.idDepartment = ss.idDepartment AND sn.idCourse = ss.idCourse AND sn.idSection = ss.idSection AND sn.year = ss.year AND sn.term = ss.term");
            ps.setInt(1, idInstructor);
            ps.setInt(2, currentTerm.getCurrentYear());
            ps.setString(3, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {
                snlist.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getString("idSection"),
                        rs.getInt("day"),
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        timetable.setSectionNodeList(snlist);
        this.psclose();
        return timetable;
    } 
    
    public Timetable getClassroomTimetable(String idLocation, String idRoom) {
        this.initConnection();
        Timetable timetable = new Timetable("Classroom");
        timetable.setIdUser(0);
        timetable.setGivenName(null);
        timetable.setSurname(null);
        timetable.setIdLocation(idLocation);
        timetable.setIdRoom(idRoom);       
        ArrayList<SectionNode> snlist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT sn.idDepartment, sn.idCourse, sn.idSection, sn.day, sn.startTime, sn.endTime, sn.idLocation, sn.idRoom\n" +
                                    "FROM SectionNode sn \n" +
                                    "WHERE sn.idLocation = ? AND sn.idRoom = ? AND sn.year = ? AND sn.term = ?");
            ps.setString(1, idLocation);
            ps.setString(2, idRoom);
            ps.setInt(3, currentTerm.getCurrentYear());
            ps.setString(4, currentTerm.getCurrentTerm());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {
                snlist.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),                      
                        rs.getString("idSection"),
                        rs.getInt("day"),
                        new LocalTime(rs.getString("startTime")),
                        new LocalTime(rs.getString("endTime")),
                        rs.getString("idLocation"),
                        rs.getString("idRoom")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        timetable.setSectionNodeList(snlist);
        this.psclose();
        return timetable;
    }
    
    /**
     * This method writes a record to the StudentSection table with the current year and term.
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @param onWaitlist 0 if fully enrolled, 1 if put on the Waitlist
     * @return 1 if successfully, 0 if failed.
     */
    public int enrolStudentSection(int idStudent, String idDepartment, int idCourse, String idSection, int onWaitlist) {
        this.initConnection();
        int count = 0;
        
        try {            
            ps = conn.prepareStatement("INSERT INTO StudentSection " //(idStudent, idDepartment, idCourse, idSection, year, term, onWaitlist)"
                                    + "VALUES (?, ?, ?, ?, ?, ?,null, ?)");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setString(4, idSection);
            ps.setInt(5, currentTerm.getCurrentYear());
            ps.setString(6, currentTerm.getCurrentTerm());
            ps.setInt(7, onWaitlist);
            
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}
    }
    
    /**
     * This method writes a record to the StudentSection table with the current year and term.
     * @param idStudent
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @param onWaitlist
     * @return 1 if successfully, 0 if failed.
     */
    public int removeStudentSection(int idStudent, String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        int count = 0;
        
        try {            
            ps = conn.prepareStatement("DELETE FROM StudentSection " +
                                    "WHERE idStudent = ? AND idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ?");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            ps.setString(4, idSection);
            ps.setInt(5, currentTerm.getCurrentYear());
            ps.setString(6, currentTerm.getCurrentTerm());
            
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;
            
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());                
            }
            this.psclose();
            return 0;
	}
    }    
}
