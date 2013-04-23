/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import org.joda.time.LocalDate;
import smartenrol.model.Student;

/**
 *
 * @author Haijun
 */
public class StudentDAO extends UserDAO {

    public StudentDAO() {
        super();
    }

    /**
     * Return a Student instance by specifying student's ID (same as idUser).
     * @param idStudent
     * @return 
     * Tested!
     */
    public Student getStudentByID(int idStudent) {
        this.initConnection();
        Student student = new Student();
        
        try {
            ps = conn.prepareStatement("SELECT s.idUser, s.idProgram, u.givenName, u.surname, s.status, s.dateStarted, s.type, p.programName \n" +
                                    "FROM User u, Student s, Program p \n" +
                                    "WHERE u.idUser = ? AND s.idUser = ? AND p.idProgram = s.idProgram");
            ps.setInt(1, idStudent);
            ps.setInt(2, idStudent);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                student.setIdStudent(rs.getInt("idUser"));
                student.setGivenName(rs.getString("givenName"));
                student.setSurname(rs.getString("surname"));
                student.setIdProgram(rs.getString("idProgram"));
                student.setStatus(rs.getString("status"));
                student.setDateStarted(new LocalDate(rs.getString("dateStarted")));
                student.setType(rs.getString("type"));
                student.setProgramName(rs.getString("programName"));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return student;
    }
    
    /**
     * Return a list of students that are enrolled in specified Program.
     * @param idProgram
     * @return 
     * Tested!
     */
    public ArrayList<Student> getStudentByProgram(String idProgram) {
        this.initConnection();
        ArrayList<Student> studentList = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT s.idUser, s.idProgram, u.givenName, u.surname, s.status, s.dateStarted, s.type \n" +
                                    "FROM User u, Student s \n" +
                                    "WHERE s.idProgram = ? AND s.idUser = u.idUser");
            ps.setString(1, idProgram);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {studentList.add(new Student(
                    rs.getInt("idUser"),
                    rs.getString("idProgram"),
                    rs.getString("givenName"),
                    rs.getString("surname"),
                    rs.getString("status"),
                    new LocalDate(rs.getString("dateStarted")),
                    rs.getString("type")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }        
        
        this.psclose();
        return studentList;
    }
    

    /**
     * Check whether a Student is eligible for a course (especially when the course is restricted for a program).
     * @param idStudent
     * @param idDeparment
     * @param idCourse
     * @return 
     */
    public boolean isStudentEligibleForCourse(int idStudent, String idDepartment, int idCourse) {
        // if the course is not restriced, return false right away.
        if (!(new CourseDAO().isCourseRestricted(idDepartment, idCourse)))
            return true;
        
        ArrayList<Student> studentList = new ArrayList<>();
        
        try {
             this.initConnection();
            ps = conn.prepareStatement("SELECT DISTINCT s.idUser\n" +
                                    "FROM Student s, ProgramCourses pc, Course c\n" +
                                    "WHERE s.idProgram = pc.idProgram AND pc.idDepartment = c.idDepartment AND pc.idCourse = c.idCourse\n" +
                                    "AND s.idUser = ? AND c.idDepartment = ? AND c.idCourse = ?");
            ps.setInt(1, idStudent);
            ps.setString(2, idDepartment);
            ps.setInt(3, idCourse);
            rs = ps.executeQuery();
           
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
        }

        // parse the resultset
        try {
            while (rs.next()) {studentList.add(new Student(
                    rs.getInt("idUser")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
        }        
        
        this.psclose();
        if (studentList.size() == 0)
            return false;
        else 
            return true;
    }
    
        /*
     * update user profile
     */
    public boolean updateProfile(Student student) {
        this.initConnection();
        
        try {
            
            super.updateProfile(student);
            
            ps = conn.prepareStatement("UPDATE Student set "
                    + "idProgram = ?, type = ? "
                    + "WHERE idUser = ?;");
            
            ps.setString(1, student.getIdProgram());
            ps.setString(3, student.getType());
            ps.setInt(4, student.getIdUser());
           
            ps.executeUpdate();
            conn.commit();
            return true;
           }   
            catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return false;
        }

    }
    
    public boolean addStudent(Student student) {
        this.initConnection();
        int userID = addUser(student);
        try {
            ps = conn.prepareStatement("INSERT INTO Student (idProgram, type, idUser,dateStarted,status) VALUES (?,?,?,NOW(),'ongoing')");
            
            ps.setString(1, student.getIdProgram());
            ps.setString(2, student.getType());
            ps.setInt(3, userID);
           
            ps.executeUpdate();
            conn.commit();
            return true;
           }   
            catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return false;
        }

    }    
}
