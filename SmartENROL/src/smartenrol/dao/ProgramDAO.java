/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.dao;

import smartenrol.model.Program;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Terry Liu
 */
public class ProgramDAO extends SmartEnrolDAO{
    
   
    
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
    
    public Program getProgrambyID(String idProgram)
    {
          this.initConnection();
          Program program = new Program();
          
          try 
          {
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
 * Search programs by up to 3 keywords on searchable field idDepartment, idProgram and ProgramName
 * @author Terry Liu
 * @param keyword a string array of user input keywords
 * @return list of programs
 * 
 */
   public ArrayList<Program> searchProgrambyKeyword(String[] keyword, String deptFilter)
   {
        String keywordquery="select * from Program where (idDepartment=? or idProgram=? or programName LIKE ?) AND (idDepartment=? or idProgram=? or programName LIKE ?) AND (idDepartment=? or idProgram=? or programName LIKE ?)";
        String deptFilterAddition=" AND idDepartment=?"; 
        boolean usefilter=false;
        this.initConnection();
        ArrayList<Program> ProgramList = new ArrayList<>();
        if (!(deptFilter.equalsIgnoreCase("") || deptFilter.equalsIgnoreCase("any")))
        {
                usefilter=true;
        }
       
        if (usefilter)
        {
            keywordquery=keywordquery+deptFilterAddition;
        }
       
        try {
            ps = conn.prepareStatement(keywordquery);
            ps.setString(1, keyword[0]);
            ps.setString(2, keyword[0]);
            ps.setString(3, "%"+keyword[0]+"%");
            ps.setString(4, keyword[1]);
            ps.setString(5, keyword[1]);
            ps.setString(6, "%"+keyword[1]+"%");
            ps.setString(7, keyword[2]);
            ps.setString(8, keyword[2]);
            ps.setString(9, "%"+keyword[2]+"%");
            if (usefilter)
            {
                ps.setString(10,deptFilter);
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
    
    
}
    

