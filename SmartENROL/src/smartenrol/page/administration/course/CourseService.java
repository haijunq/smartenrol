package smartenrol.page.administration.course;

import java.util.Map;

import smartenrol.SmartEnrolException;
import smartenrol.dao.CourseDAO;
import smartenrol.model.Course;

public class CourseService {

    private final Map<String, String> userInputValueHolder;
    private final CourseDAO courseDAO;

    public CourseService(final Map<String, String> userInputValueHolder) {
        this.userInputValueHolder = userInputValueHolder;
        courseDAO = new CourseDAO();
    }

    public String insertCourse() throws SmartEnrolException {
        final CourseValidator courseValidator = new CourseValidator();
        courseValidator.validate(userInputValueHolder);
        final Course course = new Course();
        updateCourseFromUserInput(course);
        final Integer rowUpdateCount = courseDAO.addCourse(course);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Insertion Failed.";
        } else {
            message = "Insertion Successful.";
            return message;
        }
        return message;
    }

    public String updateCourse() throws SmartEnrolException {
        final CourseValidator courseValidator = new CourseValidator();
        courseValidator.validate(userInputValueHolder);
        final Course course = new Course();
        updateCourseFromUserInput(course);
        final Integer rowUpdateCount = courseDAO.updateCourse(course);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Updation Failed.";
        } else {
            message = "Updation Successful.";
        }
        return message;
    }

    private void updateCourseFromUserInput(final Course course) {
        course.setIdDepartment(userInputValueHolder.get(ICourseServiceConstants.ID_DEPARTMENT));
        course.setIdCourse(Integer.valueOf(userInputValueHolder.get(ICourseServiceConstants.ID_COURSE)));
        course.setCourseName(userInputValueHolder.get(ICourseServiceConstants.COURSE_NAME));
        course.setCourseDescription(userInputValueHolder.get(ICourseServiceConstants.COURSE_DESCRIPTION));
        course.setCredits(Float.valueOf(userInputValueHolder.get(ICourseServiceConstants.CREDITS)));
    }
}
