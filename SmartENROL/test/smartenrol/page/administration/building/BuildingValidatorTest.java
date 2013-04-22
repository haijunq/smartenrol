package smartenrol.page.administration.building;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuildingValidatorTest {

    BuildingValidator buildingValidator;

    @Before
    public void setUp() {
        buildingValidator = new BuildingValidator();
    }

    @Test
    public void validate() throws BuildingException {
        try {
            buildingValidator.validate(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void validateSuccess() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.fail();
        }
    }

    @Test
    public void validateWithIdNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", null);
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_LOCATION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithAddress1Null() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", null);
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithAddress2Null() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", null);
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCityNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", null);
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithProvinceNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "111111111111");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", null);
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ID_LOCATION is 11", e.getMessage());
        }
    }

    @Test
    public void validateWithCountryNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", null);
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithPostalCodeNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", null);
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNotesNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test");
        userInputValueHolder.put("NOTES", null);
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNamesNull() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test");
        userInputValueHolder.put("NOTES", "Test");
        userInputValueHolder.put("NAME", null);
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithAddress1Empty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithAddress2Empty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithAddress3Null() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCityEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithIdEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_LOCATION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithProvinceEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("ID_LOCATION cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void validateWithWrongIdSIze() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "111111111111");
        userInputValueHolder.put("ADDRESS_1", "TestAddr");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ID_LOCATION is 11", e.getMessage());
        }
    }

    @Test
    public void validateWithWrongAddress1() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "sample test sample test sample test sample test sample test sample test sample test sample test");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test1");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
            Assert.assertEquals("Maximum length for ADDRESS_1 is 45", e.getMessage());
        }
    }

    @Test
    public void validateWithCountryEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "Test_Note");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithPostalCodeEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNotesEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "");
        userInputValueHolder.put("NAME", "Test3");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNamesEmpty() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "1");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "saas");
        userInputValueHolder.put("NAME", "");
        try {
            buildingValidator.validate(userInputValueHolder);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithIdSpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "@TestTest###");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "aas");
        userInputValueHolder.put("NAME", "sdw");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.fail();
        } catch (BuildingException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void validateWithAddr1SpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1@#%");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "asdd");
        userInputValueHolder.put("NAME", "asss");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithAddr2SpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2#$%^");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "asd");
        userInputValueHolder.put("NAME", "dsdss");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCitySpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1#$%%");
        userInputValueHolder.put("PROVINCE", "Test");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "sample test");
        userInputValueHolder.put("NAME", "sample test");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithProvinceSpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "Test@#$%");
        userInputValueHolder.put("COUNTRY", "Test");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "sample test");
        userInputValueHolder.put("NAME", "sample test");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithCountrySpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "TestProvince");
        userInputValueHolder.put("COUNTRY", "$%#%Country$%%");
        userInputValueHolder.put("POSTAL_CODE", "Test2");
        userInputValueHolder.put("NOTES", "sample test");
        userInputValueHolder.put("NAME", "sample test");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithPostalCodeSpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "TestProvince");
        userInputValueHolder.put("COUNTRY", "Country");
        userInputValueHolder.put("POSTAL_CODE", "PostalCode#$%@#$");
        userInputValueHolder.put("NOTES", "sample test");
        userInputValueHolder.put("NAME", "sample test");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNotesSpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "TestProvince");
        userInputValueHolder.put("COUNTRY", "Country");
        userInputValueHolder.put("POSTAL_CODE", "PostalCode");
        userInputValueHolder.put("NOTES", "#$%%^^^");
        userInputValueHolder.put("NAME", "sample test");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateWithNameSpecialCharacter() {
        final Map<String, String> userInputValueHolder = new HashMap<String, String>();
        userInputValueHolder.put("ID_LOCATION", "11");
        userInputValueHolder.put("ADDRESS_1", "TestAddr1");
        userInputValueHolder.put("ADDRESS_2", "TestAddr2");
        userInputValueHolder.put("CITY", "City1");
        userInputValueHolder.put("PROVINCE", "TestProvince");
        userInputValueHolder.put("COUNTRY", "Country");
        userInputValueHolder.put("POSTAL_CODE", "PostalCode");
        userInputValueHolder.put("NOTES", "TestNote");
        userInputValueHolder.put("NAME", "#$%%%TT");
        try {
            buildingValidator.validate(userInputValueHolder);
            Assert.assertTrue(Boolean.TRUE);
        } catch (BuildingException e) {
            Assert.fail();
        }
    }
}
