/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class SectionDAO extends SmartEnrolDAO {
    private Term currentTerm;
     
    public SectionDAO() {
        super();
        currentTerm = new Term();
    }
    
    /**
     * Return a list of sections for a course.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListByCourse(Course course) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
            ps.setString(1, course.getIdDepartment());
            ps.setInt(2, course.getIdCourse());
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
     /**
     * Return a list of sections for a course.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListByCourse(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
    /**
     * Return a list of sections offered which is required and a student has not passed in this term.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListForStudent(int idStudent) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        ArrayList<Section> passlist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT se.idDepartment, se.idCourse, se.idSection, se.year, se.term, se.notes, se.type, se.maxClassSize, se.idInstructor"
                    + " FROM Student st, ProgramCourses pc, Section se "
                    + "WHERE st.idUser = ? AND st.idProgram = pc.idProgram AND pc.idDepartment = se.idDepartment AND pc.idCourse = se.idCourse AND term = ? AND year = ? ");
            ps.setInt(1, idStudent);
            ps.setString(2, currentTerm.getCurrentTerm());
            ps.setInt(3, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        for (Iterator<Section> it = passlist.iterator(); it.hasNext();) {
            Section p = it.next();
            for (Iterator<Section> it1 = seclist.iterator(); it1.hasNext();) {
                Section s = it1.next();
                if (p.getIdDepartment().equals(s.getIdDepartment()) && p.getIdCourse() == s.getIdCourse())
                    it1.remove();
            }
        }
        
        this.psclose();
        return seclist;
    }
    
    /**
     * Return a list of sections offered this term for an instructor.
     * @param course
     * @return 
     */
    public ArrayList<Section> getSectionListForInstructor(int idInstructor) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT se.idDepartment, se.idCourse, se.idSection, cs.courseName, se.year, se.term, se.notes, se.type, se.maxClassSize, se.idInstructor"
                    + " FROM Section se, Course cs "
                    + "WHERE se.idInstructor = ? AND se.term = ? AND se.year = ? AND se.idDepartment = cs.idDepartment AND se.idCourse = cs.idCourse");
            ps.setInt(1, idInstructor);
            ps.setString(2, currentTerm.getCurrentTerm());
            ps.setInt(3, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getString("courseName"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
    /**
     * Return a section instance by course id with section id.
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public Section getSectionByID(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        Section sec = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM Section WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND term = ? AND year = ? ");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, idSection);
            ps.setString(4, currentTerm.getCurrentTerm());
            ps.setInt(5, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                sec = new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return sec;
    }
    
    /**
     * Return the number of section types of a course.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public int getSectionTypesOfCourse(String idDepartment, int idCourse) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("SELECT type\n" +
                                    "FROM Section \n" +
                                    "WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ?  \n" +
                                    "GROUP BY type");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {
                count ++;
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        this.psclose();
        return count;
    }
    
    /**
     * Return a list of sections for a course, with instructor's name.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public ArrayList<Section> getSectionListByCourseWithInstructorName(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<Section> seclist = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT s.*, u.givenName, u.surname FROM Section s, User u WHERE s.idDepartment = ? AND s.idCourse = ? AND s.term = ? AND s.year = ? AND s.idInstructor = u.idUser ");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                seclist.add(new Section(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
                        rs.getString("notes"), 
                        rs.getString("type"),
                        rs.getInt("maxClassSize"),
                        rs.getInt("idInstructor"),
                        rs.getString("givenName"),
                        rs.getString("surname")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return seclist;
    }
    
    /**
     * Remove a section by the primary key of an instance of section.
     * @param section
     * @return 1 if success, 0 otherwise
     */
    public int removeSection(Section section) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("DELETE FROM Section WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ?");
            ps.setString(1,section.getIdDepartment());
            ps.setInt(2, section.getIdCourse());
            ps.setString(3, section.getIdSection());
            ps.setInt(4, section.getYear());
            ps.setString(5, section.getTerm());
            
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
     * This method updates a section in the database with new info.
     * @param section
     * @return 
     */
    public int updateSection(Section section) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("UPDATE Section SET notes = ?, type = ?, idInstructor = ?, maxClassList = ? "
                    + " WHERE idDepartment = ? AND idCourse = ? AND idSection = ? "
                    + " AND year = ? AND term = ?");
            ps.setString(1, section.getNotes());
            ps.setString(2, section.getType());
            ps.setInt(3, section.getIdInstructor());
            ps.setInt(4, section.getMaxClassSize());
            ps.setString(5, section.getIdDepartment());
            ps.setInt(6, section.getIdCourse());
            ps.setString(7, section.getIdSection());
            ps.setInt(8, section.getYear());
            ps.setString(9, section.getTerm());
            
            
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
    
}
