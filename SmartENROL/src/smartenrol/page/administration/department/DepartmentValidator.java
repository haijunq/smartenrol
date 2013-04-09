package smartenrol.page.administration.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentValidator {

    private static final String ERROR_MESSAGE = " cannot be null or empty";
    private final List<String[]> validatorList;

    public DepartmentValidator() {

        validatorList = new ArrayList<String[]>();
        validatorList.add(new String[]{IDepartmentServiceConstants.ID_DEPARTMENT, "10","true"});
        validatorList.add(new String[]{IDepartmentServiceConstants.NAME, "45","false"});
        validatorList.add(new String[]{IDepartmentServiceConstants.ID_LOCATION, "11","false"});
       // validatorList.add(new String[]{IDepartmentServiceConstants.ID_FACULTY, "11"});
        //validatorList.add(new String[]{IDepartmentServiceConstants.DESCRIPTION, "40"});
        //validatorList.add(new String[]{IDepartmentServiceConstants.DEPARTMENT_HEAD_ID, "45"});
        //validatorList.add(new String[]{IDepartmentServiceConstants.MAIN_CONTACT_ID, "45"});
    }

    public void validate(final Map<String, String> userInputValueHolder) throws DepartmentException {
        for (final String[] validatorItem : validatorList) {
            if ("true".equals(validatorItem[2]) && isNullOrEmpty(userInputValueHolder.get(validatorItem[0]))) {
                throw new DepartmentException(validatorItem[0].concat(ERROR_MESSAGE));
            }
            if (userInputValueHolder.get(validatorItem[0]) != null && Integer.valueOf(validatorItem[1]) < userInputValueHolder.get(validatorItem[0]).length()) {
                throw new DepartmentException("Maximum length for " + validatorItem[0] + " is " + validatorItem[1]);
            }
        }
    }

    private Boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }
}