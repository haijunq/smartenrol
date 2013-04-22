package smartenrol.page.administration.program;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ProgramValidatorTest {

    ProgramValidator programValidator;

    @Before
    public void setUp() {
        programValidator = new ProgramValidator();

    }
    
     @Test
    public void validateNull() throws ProgramException {
        try {
            programValidator.validate(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void validateSuceess() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "1");
        userInputValueHolder.put("ID_DEPARTMENT", "2");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        Assert.assertTrue(Boolean.TRUE);
        try {
            programValidator.validate(userInputValueHolder);
        } catch (ProgramException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithProgramIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", null);
        userInputValueHolder.put("ID_DEPARTMENT", "2");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("ID_PROGRAM cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithProgramIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "");
        userInputValueHolder.put("ID_DEPARTMENT", "2");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("ID_PROGRAM cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithWrongProgramIdSize() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "111111111111111111");
        userInputValueHolder.put("ID_DEPARTMENT", "2");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("Maximum length for ID_PROGRAM is 11", e.getMessage());
        }
    }

    @Test
    public void validateWithNullMap() {
        try {
            programValidator.validate(null);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.fail();
        } catch (NullPointerException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithDeptIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", null);
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("ID_DEPARTMENT cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithDeptIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "Program_Test");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("ID_DEPARTMENT cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithDescNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", null);
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("PROGRAM_DESCRIPTION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithDescEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "");
        userInputValueHolder.put("PROGRAM_NAME", "Program");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithNameNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "aaa");
        userInputValueHolder.put("PROGRAM_NAME", null);
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertEquals("PROGRAM_NAME cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithNameEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "aaa");
        userInputValueHolder.put("PROGRAM_NAME", "");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (ProgramException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithProgramIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "1@#$%&");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "aaa");
        userInputValueHolder.put("PROGRAM_NAME", "test");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (ProgramException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDeptIdSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12#$%#$#");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "aaa");
        userInputValueHolder.put("PROGRAM_NAME", "test");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (ProgramException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithDescSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "@#$#%");
        userInputValueHolder.put("PROGRAM_NAME", "aaa");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (ProgramException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNameSpecialChar() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_PROGRAM", "tt");
        userInputValueHolder.put("ID_DEPARTMENT", "12");
        userInputValueHolder.put("PROGRAM_DESCRIPTION", "aaa");
        userInputValueHolder.put("PROGRAM_NAME", "@$$#$#@!$$");
        try {
            programValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (ProgramException e) {
            Assert.fail();
        }
    }
}
