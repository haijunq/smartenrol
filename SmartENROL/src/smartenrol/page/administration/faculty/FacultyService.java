package smartenrol.page.administration.faculty;

import java.util.Map;
import smartenrol.SmartEnrolException;

import smartenrol.dao.FacultyDAO;
import smartenrol.model.Building;

import smartenrol.model.Faculty;

public class FacultyService {

    private final Map<String, String> userInputValueHolder;
    private final FacultyDAO facultyDAO;

    public FacultyService(final Map<String, String> userInputValueHolder) {
        this.userInputValueHolder = userInputValueHolder;
        facultyDAO = new FacultyDAO();
    }

    public String insertFaculty() throws SmartEnrolException {
        final Faculty faculty = new Faculty();
        final FacultyValidator facultyValidator = new FacultyValidator();
        facultyValidator.validate(userInputValueHolder);
        updateFacultytFromUserInput(faculty);
        final Integer rowUpdateCount = facultyDAO.addFaculty(faculty);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Insertion Failed.";
        } else {
            message = "Insertion Successful.";
            return message;
        }
        return message;
    }

    public String updateFaculty() throws SmartEnrolException {
        final Faculty faculty = new Faculty();
        final FacultyValidator facultyValidator = new FacultyValidator();
        facultyValidator.validate(userInputValueHolder);
        updateFacultytFromUserInput(faculty);
        final Integer rowUpdateCount = facultyDAO.updateFaculty(faculty);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Updation Failed.";
        } else {
            message = "Updation Successful.";
            return message;
        }
        return message;
    }

    private void updateFacultytFromUserInput(final Faculty faculty) {
//        faculty.setIdFaculty(userInputValueHolder.get(IFacultyServiceConstants.ID_FACULTY));
//        Building building = new Building();
//        building.setIdLocation(userInputValueHolder.get(IFacultyServiceConstants.HEAD_OFFICE_LOCATION));
//        faculty.setHeadOfficeLocationID(building);
//        faculty.setName(userInputValueHolder.get(IFacultyServiceConstants.NAME));
//        faculty.setDescription(userInputValueHolder.get(IFacultyServiceConstants.DESCRIPTION));
//        faculty.setMainPhone(userInputValueHolder.get(IFacultyServiceConstants.MAIN_PHONE));
//        faculty.setDeanID(userInputValueHolder.get(IFacultyServiceConstants.DEAN_ID));
//        faculty.setMainContactID(userInputValueHolder.get(IFacultyServiceConstants.MAIN_CONTACT_ID));
    }
}