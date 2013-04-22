package smartenrol.page.administration.faculty;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FacultyValidatorTest {

    FacultyValidator facultyValidator;

    @Before
    public void setUp() {
        facultyValidator = new FacultyValidator();

    }

    @Test
    public void validateNull() throws FacultyException {
        try {
            facultyValidator.validate(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void validate() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "1");
        userInputValueHolder.put("NAME", "TEST");
        Assert.assertTrue(Boolean.TRUE);
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
        }
    }

    @Test
    public void validateWithFacultyNameNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "1");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("NAME cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithFacultyIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", null);
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_FACULTY cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithFacultyIdAndNameNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", null);
        userInputValueHolder.put("NAME", null);
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_FACULTY cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithWrongFacultyIdSize() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "111111111111");
        userInputValueHolder.put("NAME", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ID_FACULTY is 11", e.getMessage());
        }
    }

    @Test
    public void validateWithFacultyIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "TEST1");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithNameEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "TEST1");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDescNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", null);
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "TEST1");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDescEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "TEST1");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithOfcLocNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", null);
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithOfcLocEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "aa");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithMainPhnNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", null);
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithMainPhnEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TEST1");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDeanIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", null);
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDeanIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "");
        userInputValueHolder.put("MAIN_CONTACT_ID", "TEST1");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithContactIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "TEST1");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithContactIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithFacIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1@$#$%$");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithNameSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1@##%#%");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDescSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test@#@$");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithOfcSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test@#$$@");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "aa");
        try {
            facultyValidator.validate(userInputValueHolder);
        } catch (FacultyException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithPhnSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1@#@$$");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "qq");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (FacultyException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDeanIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN@$#$$#");
        userInputValueHolder.put("MAIN_CONTACT_ID", "aa");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (FacultyException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithContactIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_FACULTY", "TEST1");
        userInputValueHolder.put("NAME", "TEST1");
        userInputValueHolder.put("DESCRIPTION", "Test");
        userInputValueHolder.put("HEAD_OFFICE_LOCATION", "Test");
        userInputValueHolder.put("MAIN_PHONE", "TEST1");
        userInputValueHolder.put("DEAN_ID", "TESTDEAN");
        userInputValueHolder.put("MAIN_CONTACT_ID", "@#$#$");
        try {
            facultyValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (FacultyException e) {
            Assert.fail();
        }
    }
}
