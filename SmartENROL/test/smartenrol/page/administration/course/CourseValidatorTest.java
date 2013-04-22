package smartenrol.page.administration.course;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseValidatorTest {

    CourseValidator courseValidator;

    @Before
    public void setUp() {
        courseValidator = new CourseValidator();

    }
    
    @Test
    public void validate() throws CourseException {
        try {
            courseValidator.validate(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void validateFailure() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "2");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals(e.getMessage(), "CREDITS cannot be null or empty");
        }
    }

    @Test
    public void validateWithIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "");
        userInputValueHolder.put("ID_COURSE", "2");
        try {
            courseValidator.validate(userInputValueHolder);
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals(e.getMessage(), "ID_DEPARTMENT cannot be null or empty");
        }
    }

    @Test
    public void validateWithIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", null);
        userInputValueHolder.put("ID_COURSE", "2");
        try {
            courseValidator.validate(userInputValueHolder);
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals(e.getMessage(), "ID_DEPARTMENT cannot be null or empty");
        }
    }

    @Test
    public void validateSuccess1() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "2");
        userInputValueHolder.put("CREDITS", "5");
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (CourseException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithWrongDeptSize() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "111111111111");
        userInputValueHolder.put("ID_COURSE", "2");
        userInputValueHolder.put("CREDITS", "5");
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ID_DEPARTMENT is 10", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "");
        userInputValueHolder.put("CREDITS", "5");
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("ID_COURSE cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", null);
        userInputValueHolder.put("CREDITS", "5");
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("ID_COURSE cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCreditEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "");
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURCREDITSSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("CREDITS cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCreditNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", null);
        userInputValueHolder.put("COURSE_NAME", "Java");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("CREDITS cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseNameEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("COURSE_NAME cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseNameEmptyNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", null);
        userInputValueHolder.put("COURSE_DESCRIPTION", "Core Java");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("COURSE_NAME cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseDescEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", "");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("COURSE_DESCRIPTION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseDescNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", null);
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("COURSE_DESCRIPTION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithDeptIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "1@#$");
        userInputValueHolder.put("ID_COURSE", "12");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Test");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (CourseException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCourseIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("ID_COURSE", "12$%^^");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Test");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (CourseException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCreditsSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("ID_COURSE", "22");
        userInputValueHolder.put("CREDITS", "#$%%");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Test");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (CourseException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCourseNameSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("ID_COURSE", "223");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse$%%%%");
        userInputValueHolder.put("COURSE_DESCRIPTION", null);
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (CourseException e) {
            Assert.assertEquals("COURSE_DESCRIPTION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithCourseDescSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("ID_COURSE", "12$%^^");
        userInputValueHolder.put("CREDITS", "Test");
        userInputValueHolder.put("COURSE_NAME", "TestCourse");
        userInputValueHolder.put("COURSE_DESCRIPTION", "Test345$%##$$");
        try {
            courseValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (CourseException e) {
            Assert.fail();
        }
    }
}
