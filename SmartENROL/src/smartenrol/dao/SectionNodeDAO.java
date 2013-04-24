/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.LocalTime;
import smartenrol.model.Course;
import smartenrol.model.Section;
import smartenrol.model.SectionNode;
import smartenrol.model.Term;

/**
 *
 * @author Haijun
 */
public class SectionNodeDAO extends SmartEnrolDAO {
    private Term currentTerm;
    
    public SectionNodeDAO() {
        super();
        currentTerm = new Term();
    }
    
    // todo:return a list of sectionNode for a student.
    
    /**
     * Return a list of sectionNodes for a course of current term.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeByCourse(String idDepartment, int idCourse) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? ");
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
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
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
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }
    
    /**
     * Return a list of sectionNodes for a classroom.
     * @param idDepartment
     * @param idCourse
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeByClassRoom(String idLocation, String idRoom) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idLocation = ? AND idRoom = ? ");
            ps.setString(1, idLocation);
            ps.setString(2, idRoom);

            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
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
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }
    
    /**
     * Return a list of SectionNode of a section. 
     * @param idDepartment
     * @param idCourse
     * @param idSection
     * @return 
     */
    public ArrayList<SectionNode> getSectionNodeListBySection(String idDepartment, int idCourse, String idSection) {
        this.initConnection();
        ArrayList<SectionNode> secNodeList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT * FROM SectionNode WHERE idDepartment = ? AND idCourse = ? AND term = ? AND year = ? AND idSection = ?");
            ps.setString(1, idDepartment);
            ps.setInt(2, idCourse);
            ps.setString(3, currentTerm.getCurrentTerm());
            ps.setInt(4, currentTerm.getCurrentYear());
            ps.setString(5, idSection);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                secNodeList.add(new SectionNode(
                        rs.getString("idDepartment"),
                        rs.getInt("idCourse"),
                        rs.getString("idSection"),
                        rs.getInt("year"),
                        rs.getString("term"),
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
            return null;
        }        
        
        this.psclose();
        return secNodeList;
    }

	/**
	 *  Adds the section node into the database
	 * @param sectionNode 
	 * @return 1 if successful.
	 */
	public int addSectionNode(SectionNode sectionNode) {

		this.initConnection();
		int count = 0;

        try {
            
            ps = conn.prepareStatement("INSERT INTO SectionNode (idDepartment, idCourse, idSection, year, term, day, startTime, endTime, idLocation, idRoom) " +  
									   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, sectionNode.getIdDepartment());
            ps.setInt(2, sectionNode.getIdCourse());
            ps.setString(3, sectionNode.getIdSection());
            ps.setInt(4, sectionNode.getYear());
            ps.setString(5, sectionNode.getTerm());
            ps.setInt(6, sectionNode.getDay());
            ps.setString(7, sectionNode.getStartTime().toString("HH:mm:ss"));
            ps.setString(8, sectionNode.getEndTime().toString("HH:mm:ss"));
            ps.setString(9, sectionNode.getIdLocation());
            ps.setString(10, sectionNode.getIdRoom());

			System.out.println(ps.toString()) ;
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
     * Remove a sectionNOde by the primary key of an instance of sectionNode.
     * @param section
     * @return 1 if success, 0 otherwise
     */
    public int removeSection(SectionNode snode) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("DELETE FROM SectionNode WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND day = ? ");
            ps.setString(1,snode.getIdDepartment());
            ps.setInt(2, snode.getIdCourse());
            ps.setString(3, snode.getIdSection());
            ps.setInt(4, snode.getYear());
            ps.setString(5, snode.getTerm());
            ps.setInt(6, snode.getDay());
                    
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
     * This method updates a sectionNode in the database with new info.
     * @param SectionNode
     * @return 1 if success, 0 otherwise
     */
    public int updateSection(SectionNode snode) {
        this.initConnection();
        int count = 0;
        
        try {
            ps = conn.prepareStatement("UPDATE SectionNode SET startTime = ?, endTime = ?, idLocation = ?, idRoom = ? "
                    + " WHERE idDepartment = ? AND idCourse = ? AND idSection = ? AND year = ? AND term = ? AND day = ?");
            ps.setString(1, snode.getStartTime().toString("HH:MM:SS"));
            ps.setString(2, snode.getEndTime().toString("HH:MM:SS"));
            ps.setString(3, snode.getIdLocation());
            ps.setString(4, snode.getIdRoom());
            ps.setString(5, snode.getIdDepartment());
            ps.setInt(6, snode.getIdCourse());
            ps.setString(7, snode.getIdSection());
            ps.setInt(8, snode.getYear());
            ps.setString(9, snode.getTerm());
            
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
