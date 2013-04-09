package smartenrol.page.administration.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacultyValidator {

    private static final String ERROR_MESSAGE = " cannot be null or empty";
    private final List<String[]> validatorList;

    public FacultyValidator() {
        validatorList = new ArrayList<String[]>();
        validatorList.add(new String[]{IFacultyServiceConstants.ID_FACULTY, "11","true"});
        validatorList.add(new String[]{IFacultyServiceConstants.NAME, "45","true"});
        //validatorList.add(new String[]{IFacultyServiceConstants.DESCRIPTION, "45"});
        //validatorList.add(new String[]{IFacultyServiceConstants.HEAD_OFFICE_LOCATION, "45"});
        //validatorList.add(new String[]{IFacultyServiceConstants.MAIN_PHONE, "45"});
        //validatorList.add(new String[]{IFacultyServiceConstants.DEAN_ID, "45"});
        //validatorList.add(new String[]{IFacultyServiceConstants.MAIN_CONTACT_ID, "45"});
    }

    public void validate(final Map<String, String> userInputValueHolder) throws FacultyException {
        for (final String[] validatorItem : validatorList) {
            if ("true".equals(validatorItem[2]) && isNullOrEmpty(userInputValueHolder.get(validatorItem[0]))) {
                throw new FacultyException(validatorItem[0].concat(ERROR_MESSAGE));
            }
            if (userInputValueHolder.get(validatorItem[0]) != null && Integer.valueOf(validatorItem[1]) < userInputValueHolder.get(validatorItem[0]).length()) {
                throw new FacultyException("Maximum length for " + validatorItem[0] + " is " + validatorItem[1]);
            }
        }
    }

    private Boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }
}