/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.AdministratorDAO;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.FacultyDAO;
import smartenrol.dao.InstructorDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.dao.StudentDAO;
import smartenrol.dao.UserDAO;
import smartenrol.model.Administrator;
import smartenrol.model.Department;
import smartenrol.model.Faculty;
import smartenrol.model.Instructor;
import smartenrol.model.Student;
import smartenrol.model.User;
import smartenrol.page.FormController;
import smartenrol.page.SmartEnrolController;
import smartenrol.page.search.SearchController;
import smartenrol.security.RegexHelper;
import smartenrol.security.RegexHelper.RegExPattern;

/**
 *
 * @author Jeremy
 */
public class UpdateProfileController extends SmartEnrolController {

    @FXML
    private TextField line1TextBox, line2TextBox, line3TextBox, line5TextBox, line10TextBox,
            line6TextBox, line7TextBox, line8TextBox, line9TextBox, line11TextBox, username;
    @FXML
    private ComboBox line4ComboBox, line8ComboBox;
    
    @FXML
    private Text line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11;
    
    @Autowired private FormController formController;
    
    boolean isEditor = false;
    
    UserDAO userdao = new UserDAO();
    User thisUser = new User();
    
    AdministratorDAO administratordao = new AdministratorDAO();
    DepartmentDAO departmentdao = new DepartmentDAO();
    InstructorDAO instructordao = new InstructorDAO();
    FacultyDAO facultydao = new FacultyDAO();
    StudentDAO studentdao = new StudentDAO();
    ProgramDAO programdao = new ProgramDAO();

    public void init() {
       formController.setFormName("Update Profile");
    }

    public void load(int idUser) {

        thisUser = userdao.getUserByID(idUser);
        User lastModBy = userdao.getUserByID(thisUser.getLastModBy());

        formController.setLastUpdated(thisUser.getLastModified().toString());
        formController.setDateCreated(thisUser.getDateCreated().toString());
        formController.setModBy(lastModBy.getFullName());

        username.setText(thisUser.getUsername());
        username.setDisable(true);

        line5.setText("Addr 1:");
        line5TextBox.setText(thisUser.getAddr1());

        line6.setText("Addr 2:");
        line6TextBox.setText(thisUser.getAddr2());

        line7.setText("City:");
        line7TextBox.setText(thisUser.getCity());

        line8.setText("Province:");
        line8TextBox.setText(thisUser.getProvince());

        line9.setText("Postal Code:");
        line9TextBox.setText(thisUser.getPostalCode());

        line10.setText("Country:");
        line10TextBox.setText(thisUser.getCountry());

        line2.setText("Email:");
        line2TextBox.setText(thisUser.getEmail());

        line11.setText("Phone:");
        line11TextBox.setText(thisUser.getPhone());

        if (thisUser.getUsertype() == User.Type.INSTRUCTOR) {
            initInstructor(idUser);
        } else if (thisUser.getUsertype() == User.Type.ADMINISTRATOR) {
            initAdministrator(idUser);
        } else {
            initStudent(idUser);
        }
        
        if (!(getUserSession().checkPermission("admin-user"))) {
            line1TextBox.setDisable(true);
            line4ComboBox.setDisable(true);
        } else {
            line1TextBox.setDisable(false);
            line4ComboBox.setDisable(false);
            isEditor = true;
        }
    }

    public void initInstructor(int idUser) {

        thisUser = instructordao.getInstructorByID(idUser);
        line3.setText("Office:");
        line3TextBox.setText(((Instructor) thisUser).getOffice());
        line1.setText("Job Title:");
        line1TextBox.setText(((Instructor) thisUser).getJobTitle());
        line4.setText("Faculty:");
        line4ComboBox.getItems().addAll(facultydao.getAllFacultyID());
        line4ComboBox.setValue(((Instructor) thisUser).getIdFaculty().getIdFaculty());

    }

    public void initStudent(int idUser) {


        thisUser = studentdao.getStudentByID(idUser);
        line3.setText("Apt:");
        line3TextBox.setText("");
        line1.setText("Type:");
        line1TextBox.setText(((Student) thisUser).getType());
        line4.setText("Program:");
        line4ComboBox.getItems().addAll(programdao.getAllProgramID());
        line4ComboBox.setValue(((Student) thisUser).getIdProgram());


    }

    public void initAdministrator(int idUser) {

        thisUser = administratordao.getAdministratorByID(idUser);
        line3.setText("Office:");
        line3TextBox.setText(((Administrator) thisUser).getOffice());
        line1.setText("Job Title:");
        line1TextBox.setText(((Administrator) thisUser).getJobTitle());
        line4.setText("Department:");
        line4ComboBox.getItems().addAll(departmentdao.getAllDeptID());
        line4ComboBox.setValue(((Administrator) thisUser).getIdDepartment().getIdDepartment());

    }

    public void resetErrors() {
        formController.resetErrors();
        line1.setFill(Color.BLACK);
        line2.setFill(Color.BLACK);
        line3.setFill(Color.BLACK);
        line4.setFill(Color.BLACK);
        line5.setFill(Color.BLACK);
        line6.setFill(Color.BLACK);
        line7.setFill(Color.BLACK);
        line8.setFill(Color.BLACK);
        line9.setFill(Color.BLACK);
        line10.setFill(Color.BLACK);
        line11.setFill(Color.BLACK);
    }

    public void submit(ActionEvent event) {
        boolean errors = false;
        resetErrors();

        String email = line2TextBox.getText(),
                addr1 = line5TextBox.getText(),
                addr2 = line6TextBox.getText(),
                city = line7TextBox.getText(),
                province = line8TextBox.getText(),
                postalcode = line9TextBox.getText(),
                country = line10TextBox.getText(),
                phone = line11TextBox.getText();

        thisUser.setAddr1(addr1);
        thisUser.setAddr2(addr2);
        thisUser.setCity(city);
        thisUser.setCountry(country);
        thisUser.setEmail(email);
        thisUser.setProvince((province.trim()));
        thisUser.setPostalCode(postalcode);
        thisUser.setPhone(phone);
        thisUser.setLastModBy(getUserSession().getCurrentUser().getIdUser());

        if (!(RegexHelper.validate(email, RegExPattern.EMAIL)) || email.isEmpty()) {
            line2.setFill(Color.RED);
            errors = true;
        }

        if (!(RegexHelper.validate(phone, RegExPattern.PHONE_NUMBER)) || phone.isEmpty()) {
            line11.setFill(Color.RED);
            errors = true;
        }

        if (addr1.isEmpty()) {
            line5.setFill(Color.RED);
            errors = true;
        }

        if (city.isEmpty()) {
            line7.setFill(Color.RED);
            errors = true;
        }

        if (province.isEmpty()) {
            line8.setFill(Color.RED);
            errors = true;
        }

        if (postalcode.isEmpty()) {
            line9.setFill(Color.RED);
            errors = true;
        }

        if (country.isEmpty()) {
            line10.setFill(Color.RED);
            errors = true;
        }

        if (thisUser.getUsertype() == User.Type.INSTRUCTOR) {
            String jobtitle = line1TextBox.getText(),
                    office = line3TextBox.getText();
            if (isEditor) {
                Faculty faculty = ((Faculty) line4ComboBox.getSelectionModel().getSelectedItem());

                if (jobtitle.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }

                ((Instructor) thisUser).setJobTitle(jobtitle);
                ((Instructor) thisUser).setIdFaculty(faculty);
            }

            ((Instructor) thisUser).setOffice(office);
            if (!errors) {
                instructordao.updateProfile((Instructor) thisUser);
                formController.confirmPost();
            } else {
                formController.showErrors();
            }

        } else if (thisUser.getUsertype() == User.Type.ADMINISTRATOR) {
            String jobtitle = line1TextBox.getText(),
                    office = line3TextBox.getText();
            if (isEditor) {
                Department dept = ((Department) line4ComboBox.getSelectionModel().getSelectedItem());

                if (jobtitle.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }
                ((Administrator) thisUser).setJobTitle(jobtitle);
                ((Administrator) thisUser).setIdDepartment(dept);
            }
            ((Administrator) thisUser).setOffice(office);

            if (!errors) {
                administratordao.updateProfile((Administrator) thisUser);
                formController.confirmPost();
            } else {
                formController.showErrors();
            }
        } else {
            if (isEditor) {
                String type = line1TextBox.getText();
                String program = ((String) line4ComboBox.getSelectionModel().getSelectedItem());

                if (type.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }

                ((Student) thisUser).setType(type);
                ((Student) thisUser).setProgramName(program);
            }
            if (!errors) {
                studentdao.updateProfile((Student) thisUser);
                formController.confirmPost();
            } else {
                formController.showErrors();
            }
    }
    }

}