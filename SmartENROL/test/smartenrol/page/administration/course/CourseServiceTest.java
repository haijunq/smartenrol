package smartenrol.page.administration.course;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import smartenrol.SmartEnrolException;
import smartenrol.page.administration.department.DepartmentService;

public class CourseServiceTest {

    CourseService courseService;

    @Test
    public void insertCourse() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("ID_COURSE", "1");
            userInputValueHolder.put("CREDITS", "1234");
            userInputValueHolder.put("COURSE_NAME", "JAVA");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void updateCourse() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("ID_COURSE", "1");
            userInputValueHolder.put("CREDITS", "123");
            userInputValueHolder.put("COURSE_NAME", "ORACLE");
            userInputValueHolder.put("COURSE_DESCRIPTION", "ORACLE BASICS");

            courseService = new CourseService(userInputValueHolder);
            courseService.updateCourse();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertCourseWithExistingData() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "1");
            userInputValueHolder.put("ID_COURSE", "1");
            userInputValueHolder.put("CREDITS", "123");
            userInputValueHolder.put("COURSE_NAME", "JAVA");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
            Assert.assertTrue(Boolean.TRUE);
        } catch (SmartEnrolException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void insertCourseWithWrongDeptId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11111111111");
            userInputValueHolder.put("ID_COURSE", "1");
            userInputValueHolder.put("CREDITS", "5435");
            userInputValueHolder.put("COURSE_NAME", "JAVA");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();

        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertCourseWithWrongCourseId() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("ID_COURSE", "2222222222222");
            userInputValueHolder.put("CREDITS", "3423");
            userInputValueHolder.put("COURSE_NAME", "JAVA");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertCourseWithWrongCredits() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("ID_COURSE", "22");
            userInputValueHolder.put("CREDITS", "23442223343322");
            userInputValueHolder.put("COURSE_NAME", "JAVA");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertCourseWithWrongCourseName() throws SmartEnrolException {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("ID_COURSE", "22");
            userInputValueHolder.put("CREDITS", "23");
            userInputValueHolder.put("COURSE_NAME", "JAVA_JUNIT_TSET JAVA_JUNIT_TSET JAVA_JUNIT_TSET JAVA_JUNIT_TSET JAVA_JUNIT_TSET JAVA_JUNIT_TSET JAVA_JUNIT_TSET");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
        } catch (CourseException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }

    @Test
    public void insertCourseWithWrongCourseDesc() {
        try {
            final Map<String, String> userInputValueHolder = new HashMap<String, String>();

            userInputValueHolder.put("ID_DEPARTMENT", "11");
            userInputValueHolder.put("ID_COURSE", "22");
            userInputValueHolder.put("CREDITS", "232");
            userInputValueHolder.put("COURSE_NAME", "JAVA_JUNIT_TSET");
            userInputValueHolder.put("COURSE_DESCRIPTION", "CORE JAVA CORE JAVA CORE JAVACORE JAVA CORE JAVA CORE JAVA CORE JAVA CORE JAVA CORE JAVA CORE JAVA CORE JAVA CORE JAVA");

            courseService = new CourseService(userInputValueHolder);
            courseService.insertCourse();
            Assert.fail();
        } catch (SmartEnrolException e) {
            Assert.assertTrue(Boolean.TRUE);
        }
    }
}
