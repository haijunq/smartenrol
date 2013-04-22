package smartenrol.page.administration.department;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import smartenrol.SmartEnrolException;
import smartenrol.page.administration.program.ProgramService;

public class DepartmentServiceTest {

    DepartmentService departmentService;

    @Test
    public void insertDepartment() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("NAME", "IT");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void updateDepartment() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.updateDepartment();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertDepartmentWithExistingData() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertDepartmentWithWrongDeptId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "111111111111");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongName() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SC COMP_SCCOMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongLocId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44444444444");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongFacultyId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Test Test Test Test Test ");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongDesc() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT IT DEPT IT DEPT IT DEPT IT DEPT IT DEPT IT DEPT IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongHeadId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4222222222222222222222222222222222222222222222222222222");
            userInputValueHolder.put("MAIN_CONTACT_ID", "98");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertDepartmentWithWrongContactId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("NAME", "COMP_SC");
            userInputValueHolder.put("ID_LOCATION", "44444444444");
            userInputValueHolder.put("ID_FACULTY", "Mr. John");
            userInputValueHolder.put("DESCRIPTION", "IT DEPT");
            userInputValueHolder.put("DEPARTMENT_HEAD_ID", "4");
            userInputValueHolder.put("MAIN_CONTACT_ID", "9864656565756765757567575675767575675686867978978978978080989");

            departmentService = new DepartmentService(userInputValueHolder);
            departmentService.insertDepartment();
        } catch (DepartmentException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }
}
