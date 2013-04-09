package smartenrol.page.administration.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseValidator {

    private static final String ERROR_MESSAGE = " cannot be null or empty";
    private final List<String[]> validatorList;

    public CourseValidator() {
        
        validatorList = new ArrayList<String[]>();
        validatorList.add(new String[]{ICourseServiceConstants.ID_DEPARTMENT, "10"});
        validatorList.add(new String[]{ICourseServiceConstants.ID_COURSE, "11"});
        validatorList.add(new String[]{ICourseServiceConstants.CREDITS, "5"});
        validatorList.add(new String[]{ICourseServiceConstants.COURSE_NAME, "45"});
        validatorList.add(new String[]{ICourseServiceConstants.COURSE_DESCRIPTION, "45"});
    }

   public void validate(final Map<String, String> userInputValueHolder) throws CourseException {
        for (final String[] validatorItem : validatorList) {
            if (isNullOrEmpty(userInputValueHolder.get(validatorItem[0]))) {
                throw new CourseException(validatorItem[0].concat(ERROR_MESSAGE));
            }
            if (Integer.valueOf(validatorItem[1]) < userInputValueHolder.get(validatorItem[0]).length()) {
                throw new CourseException("Maximum length for " + validatorItem[0] + " is " + validatorItem[1]);
            }
        }
    }

    private Boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }
}