package smartenrol.page.administration.department;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepartmentValidatorTest {

    DepartmentValidator deptValidator;

    @Before
    public void setUp() {
        deptValidator = new DepartmentValidator();

    }

    @Test
    public void validate() throws DepartmentException {
        try {
            deptValidator.validate(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void validateSuceess() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("NAME", "IT");
        userInputValueHolder.put("ID_LOCATION", "4");
        Assert.assertTrue(Boolean.TRUE);
        try {
            deptValidator.validate(userInputValueHolder);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateFailureWithNoDeptId() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("NAME", "1");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_DEPARTMENT cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithDeptIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", null);
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_DEPARTMENT cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithWrongDeptSize() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11111111111");
        userInputValueHolder.put("NAME", "IT");
        userInputValueHolder.put("ID_LOCATION", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ID_DEPARTMENT is 10", e.getMessage());
        }
    }

    @Test
    public void validateWithDeptIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "");
        userInputValueHolder.put("NAME", "IT");
        userInputValueHolder.put("ID_LOCATION", "4");
        userInputValueHolder.put("ID_FACULTY", "4");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_DEPARTMENT cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithNameEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "");
        userInputValueHolder.put("ID_LOCATION", "4");
        userInputValueHolder.put("ID_FACULTY", "4");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNameNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", null);
        userInputValueHolder.put("ID_LOCATION", "4");
        userInputValueHolder.put("ID_FACULTY", "4");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithLocIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "");
        userInputValueHolder.put("ID_FACULTY", "4");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithLocIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", null);
        userInputValueHolder.put("ID_FACULTY", "4");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithFacIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "12");
        userInputValueHolder.put("ID_FACULTY", "");
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithFacIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", null);
        userInputValueHolder.put("DESCRIPTION", "4");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDescEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "12");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDescNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", null);
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithHeadIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "12");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "");
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithHeadIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", null);
        userInputValueHolder.put("MAIN_CONTACT_ID", "4");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithContactIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "12");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "88");
        userInputValueHolder.put("MAIN_CONTACT_ID", "");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithContactIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDeptIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "233@##");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            deptValidator.validate(userInputValueHolder);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNameSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test@#$$");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithLocIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123#$$");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithFacIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34##$#$$");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", null);
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDescSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest#$#");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "56");
        userInputValueHolder.put("MAIN_CONTACT_ID", "56");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithHeadIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "#$%$#");
        userInputValueHolder.put("MAIN_CONTACT_ID", "34");
        try {
            deptValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithContactIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "11");
        userInputValueHolder.put("NAME", "Test");
        userInputValueHolder.put("ID_LOCATION", "123");
        userInputValueHolder.put("ID_FACULTY", "34");
        userInputValueHolder.put("DESCRIPTION", "DescTest");
        userInputValueHolder.put("DEPARTMENT_HEAD_ID", "12");
        userInputValueHolder.put("MAIN_CONTACT_ID", "34545##@@3");
        try {
            deptValidator.validate(userInputValueHolder);
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }
}
