package smartenrol.page.administration.building;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingValidator {

    private static final String ERROR_MESSAGE = " cannot be null or empty";
    private final List<String[]> validatorList;

    public BuildingValidator() {
        validatorList = new ArrayList<String[]>();
        validatorList.add(new String[]{IBuildingServiceConstants.ID_LOCATION, "11", "true"});
        validatorList.add(new String[]{IBuildingServiceConstants.ADDRESS_1, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.ADDRESS_2, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.CITY, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.PROVINCE, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.COUNTRY, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.POSTAL_CODE, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.NOTES, "45", "false"});
        validatorList.add(new String[]{IBuildingServiceConstants.NAME, "45", "false"});
    }

    public void validate(final Map<String, String> userInputValueHolder) throws BuildingException {
        for (final String[] validatorItem : validatorList) {
            if ("true".equals(validatorItem[2]) && isNullOrEmpty(userInputValueHolder.get(validatorItem[0]))) {
                throw new BuildingException(validatorItem[0].concat(ERROR_MESSAGE));
            }
            if (userInputValueHolder.get(validatorItem[0]) != null && Integer.valueOf(validatorItem[1]) < userInputValueHolder.get(validatorItem[0]).length()) {
                throw new BuildingException("Maximum length for " + validatorItem[0] + " is " + validatorItem[1]);
            }
        }
    }

    private Boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }
}
