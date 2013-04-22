package smartenrol.page.administration.faculty;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import smartenrol.SmartEnrolException;

public class FacultyServiceTest {

    FacultyService facultyService;

    @Before
    public void setUp() {

        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "1");
        userInputValueHolder.put("NAME", "Test");
        facultyService = new FacultyService(userInputValueHolder);
    }

    @Test
    public void insertFaculty() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_FACULTY", "1");
            userInputValueHolder.put("NAME", "Test");
            facultyService = new FacultyService(userInputValueHolder);
            facultyService.insertFaculty();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void updateFaculty() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_FACULTY", "1");
            userInputValueHolder.put("NAME", "NewName");
            userInputValueHolder.put("DESCRIPTION", "NewName");
            userInputValueHolder.put("HEAD_OFFICE_LOCATION", "TestLocation");
            userInputValueHolder.put("MAIN_PHONE", "665544");
            userInputValueHolder.put("DEAN_ID", "113");
            userInputValueHolder.put("MAIN_CONTACT_ID", "123");
            facultyService = new FacultyService(userInputValueHolder);
            facultyService.updateFaculty();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertFacultyFailure() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();
            userInputValueHolder.put("ID_FACULTY", "1");
            userInputValueHolder.put("NAME", "TestName");
            userInputValueHolder.put("DESCRIPTION", "Desc");
            userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Ofc");
            facultyService = new FacultyService(userInputValueHolder);
            facultyService.insertFaculty();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
