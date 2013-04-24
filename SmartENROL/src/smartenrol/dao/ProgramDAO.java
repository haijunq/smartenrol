/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.model.Program;
import java.sql.SQLException;
import java.util.ArrayList;
import smartenrol.UniqueConstraintException;

/**
 *
 * @author Terry Liu
 */
public class ProgramDAO extends SmartEnrolDAO {

    public ProgramDAO() {
        super();
    }

    /**
     * get program by idProgram
     *
     * @param String idProgram
     * @return program
     *
     */
    public Program getProgrambyID(String idProgram) {
        this.initConnection();
        Program program = new Program();

        try {
            ps = conn.prepareStatement("SELECT * FROM Program WHERE idProgram = ?");
            ps.setString(1, idProgram);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                program.setIdProgram(rs.getString("idProgram"));
                program.setIdDepartment(rs.getString("idDepartment"));
                program.setProgramName(rs.getString("programName"));
                program.setProgramDescription(rs.getString("programDescription"));
                program.settotalCreditsToGraduate(rs.getFloat("totalCreditsToGraduate"));

            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return program;
    }

    /**
     * Gets the program by the student id.
     * @param int idStudent
     * @return program
     *
     */
    public Program getProgrambyStudent(int idStudent) {
        this.initConnection();
        Program program = new Program();

        try {
            ps = conn.prepareStatement("SELECT Program.* "
                    + "FROM Program,Student "
                    + "WHERE Student.idProgram = Program.idProgram AND Student.idStudent = ?");
            ps.setInt(1, idStudent);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                program.setIdProgram(rs.getString("idProgram"));
                program.setIdDepartment(rs.getString("idDepartment"));
                program.setProgramName(rs.getString("programName"));
                program.setProgramDescription(rs.getString("programDescription"));
                program.settotalCreditsToGraduate(rs.getFloat("totalCreditsToGraduate"));

            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return program;
    }    
    
    /**
     * This method returns a list of Programs that a department offers.
     * @param idDepartment
     * @return 
     */
    public ArrayList<Program> getProgrambyDepartment(String idDepartment) {
        this.initConnection();
        ArrayList<Program> programList = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM Program WHERE idDepartment = ?");
            ps.setString(1, idDepartment);
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {programList.add(new Program(
                rs.getString("idProgram"),
                rs.getString("programName"),
                rs.getString("programDescription"),
                rs.getString("idDepartment"),
                rs.getFloat("totalCreditsToGraduate")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return programList;
    }
    
    /**
     * Search programs by up to 3 keywords on searchable field idDepartment,
     * idProgram and ProgramName
     *
     * @author Terry Liu
     * @param keyword a string array of user input keywords
     * @return list of programs
     *
     */
    public ArrayList<Program> searchProgrambyKeyword(String[] keyword, String deptFilter) {
        String keywordquery = "select * from Program where (idDepartment=? or idProgram=? or programName LIKE ?) AND (idDepartment=? or idProgram=? or programName LIKE ?) AND (idDepartment=? or idProgram=? or programName LIKE ?)";
        String deptFilterAddition = " AND idDepartment=?";
        boolean usefilter = false;
        this.initConnection();
        ArrayList<Program> ProgramList = new ArrayList<>();
        if (!(deptFilter.equalsIgnoreCase("") || deptFilter.equalsIgnoreCase("all"))) {
            usefilter = true;
        }

        if (usefilter) {
            keywordquery = keywordquery + deptFilterAddition;
        }

        try {
            ps = conn.prepareStatement(keywordquery);
            ps.setString(1, keyword[0]);
            ps.setString(2, keyword[0]);
            ps.setString(3, "%" + keyword[0] + "%");
            ps.setString(4, keyword[1]);
            ps.setString(5, keyword[1]);
            ps.setString(6, "%" + keyword[1] + "%");
            ps.setString(7, keyword[2]);
            ps.setString(8, keyword[2]);
            ps.setString(9, "%" + keyword[2] + "%");
            if (usefilter) {
                ps.setString(10, deptFilter);
            }
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
                ProgramList.add(new Program(
                        rs.getString("idProgram"),
                        rs.getString("programName"),
                        rs.getString("idDepartment"),
                        rs.getFloat("totalCreditsToGraduate")));
            }
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return ProgramList;
    }

    public int addProgram(Program program) throws UniqueConstraintException {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("INSERT INTO Program VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, program.getProgramDescription());
            ps.setString(2, program.getProgramName());
            ps.setString(3, program.getIdDepartment());
            ps.setString(4, program.getIdProgram());
            ps.setFloat(5, program.gettotalCreditsToGraduate());
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;

        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 1169) {
                throw new UniqueConstraintException("Duplicate entries are not allowed from insertion in this table");
            }
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

    public int updateProgram(final Program program) {
        this.initConnection();
        int count = 0;
        try {
            ps = conn.prepareStatement("UPDATE PROGRAM SET programDescription = ?,programName = ?,totalCreditsToGraduate = ? WHERE idDepartment = ? and idProgram = ?");
            ps.setString(1, program.getProgramDescription());
            ps.setString(2, program.getProgramName());
            ps.setFloat(3, program.gettotalCreditsToGraduate());
            ps.setString(4, program.getIdDepartment());
            ps.setString(5, program.getIdProgram());
            count = ps.executeUpdate();
            conn.commit();
            this.psclose();
            return count;
        } catch (final SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            try {
                conn.rollback();
            } catch (final SQLException sqlex2) {
                System.err.println("SQLException: " + sqlex2.getMessage());
            }
            this.psclose();
            return count;
        }
    }
    
    public ArrayList<String> getAllProgramID()
    {
         
        this.initConnection();
        ArrayList<String> List = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT idProgram FROM Program");
          
            rs = ps.executeQuery();
        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            return null;
        }

        // parse the resultset
        try {
            while (rs.next()) {
               List.add(rs.getString("idProgram"));
            }

        } catch (SQLException sqlex) {
            System.err.println("SQLException: " + sqlex.getMessage());
            sqlex.printStackTrace();
            this.psclose();
            return null;
        }

        this.psclose();
        return List;
    
    }
}
