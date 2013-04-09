package smartenrol.page.administration.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgramValidator {

    private static final String ERROR_MESSAGE = " cannot be null or empty";
    private final List<String[]> validatorList;

    public ProgramValidator() {
        validatorList = new ArrayList<String[]>();
        validatorList.add(new String[]{IProgramServiceConstants.ID_PROGRAM, "11"});
        validatorList.add(new String[]{IProgramServiceConstants.ID_DEPARTMENT, "45"});
        validatorList.add(new String[]{IProgramServiceConstants.PROGRAM_DESCRIPTION, "45"});
        validatorList.add(new String[]{IProgramServiceConstants.PROGRAM_NAME, "10"});
    }

    public void validate(final Map<String, String> userInputValueHolder) throws ProgramException {
        for (final String[] validatorItem : validatorList) {
            if (isNullOrEmpty(userInputValueHolder.get(validatorItem[0]))) {
                throw new ProgramException(validatorItem[0].concat(ERROR_MESSAGE));
            }
            if (Integer.valueOf(validatorItem[1]) < userInputValueHolder.get(validatorItem[0]).length()) {
                throw new ProgramException("Maximum length for " + validatorItem[0] + " is " + validatorItem[1]);
            }
        }
    }

    private Boolean isNullOrEmpty(final String value) {
        return value == null || "".equals(value.trim());
    }
}