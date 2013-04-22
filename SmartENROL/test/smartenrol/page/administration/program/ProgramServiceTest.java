package smartenrol.page.administration.program;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import smartenrol.SmartEnrolException;
import smartenrol.dao.FacultyDAO;
import smartenrol.page.administration.faculty.FacultyService;

public class ProgramServiceTest {

    ProgramService programService;

    @Test
    public void insertFaculty() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_PROGRAM", "1");
            userInputValueHolder.put("ID_DEPARTMENT", "4");
            userInputValueHolder.put("PROGRAM_NAME", "Java");
            userInputValueHolder.put("PROGRAM_DESCRIPTION", "Core Java");
            userInputValueHolder.put("TOTAL_GRADE", "10");
            programService = new ProgramService(userInputValueHolder);
            programService.insertProgram();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void updatePraogram() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_PROGRAM", "1");
            userInputValueHolder.put("ID_DEPARTMENT", "5");
            userInputValueHolder.put("PROGRAM_NAME", "Oracle");
            userInputValueHolder.put("PROGRAM_DESCRIPTION", "Oracle Basics");
            userInputValueHolder.put("TOTAL_GRADE", "9");
            programService = new ProgramService(userInputValueHolder);
            programService.updatePraogram();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertPraogramWithExistingId() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_PROGRAM", "1");
            userInputValueHolder.put("ID_DEPARTMENT", "5");
            userInputValueHolder.put("PROGRAM_NAME", "Oracle");
            userInputValueHolder.put("PROGRAM_DESCRIPTION", "Oracle Basics");
            userInputValueHolder.put("TOTAL_GRADE", "9");
            programService = new ProgramService(userInputValueHolder);
            programService.insertProgram();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertPraogramWithWrongValues() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_PROGRAM", null);
            userInputValueHolder.put("ID_DEPARTMENT", "5");
            userInputValueHolder.put("PROGRAM_NAME", "Oracle");
            userInputValueHolder.put("PROGRAM_DESCRIPTION", "Oracle Basics");
            userInputValueHolder.put("TOTAL_GRADE", "9");
            programService = new ProgramService(userInputValueHolder);
            programService.insertProgram();
            Assert.fail();
        } catch (SmartEnrolException e) {
           Assert.assertTrue(Boolean.TRUE);
        }
    }
}
