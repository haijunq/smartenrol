package smartenrol.page.administration.program;

import java.util.List;
import java.util.Map;


import smartenrol.SmartEnrolException;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.Program;

public class ProgramService {

    private final Map<String, String> userInputValueHolder;
    private final ProgramDAO programDAO;

    public ProgramService(final Map<String, String> userInputValueHolder) {
        this.userInputValueHolder = userInputValueHolder;
        programDAO = new ProgramDAO();
    }

    public String insertProgram() throws SmartEnrolException {
        final ProgramValidator programValidator = new ProgramValidator();
        programValidator.validate(userInputValueHolder);
        final Program program = new Program();
        updateProgramFromUserInput(program);
        final Integer rowUpdateCount = programDAO.addProgram(program);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Insertion Failed.";
        } else {
            message = "Insertion Successful.";

        }
        return message;
    }

    public String updatePraogram() throws SmartEnrolException {
        final ProgramValidator programValidator = new ProgramValidator();
        programValidator.validate(userInputValueHolder);
        final Program program = new Program();
        updateProgramFromUserInput(program);
        final Integer rowUpdateCount = programDAO.updateProgram(program);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Updation Failed.";
        } else {
            message = "Updation Successful.";
        }
        return message;
    }

    private void updateProgramFromUserInput(Program program) {
        program.settotalCreditsToGraduate(Float.valueOf( userInputValueHolder.get(IProgramServiceConstants.TOTAL_GRADE)));
        program.setIdDepartment( userInputValueHolder.get(IProgramServiceConstants.ID_DEPARTMENT));
        program.setIdProgram(userInputValueHolder.get(IProgramServiceConstants.ID_PROGRAM));
        program.setProgramName(userInputValueHolder.get(IProgramServiceConstants.PROGRAM_NAME));
        program.setProgramDescription(userInputValueHolder.get(IProgramServiceConstants.PROGRAM_DESCRIPTION));
    }
}