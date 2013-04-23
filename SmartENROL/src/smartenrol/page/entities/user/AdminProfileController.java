/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
import smartenrol.security.RegexHelper;
import smartenrol.security.RegexHelper.RegExPattern;
import smartenrol.security.Security;

/**
 *
 * @author Jeremy
 */
public class AdminProfileController extends SmartEnrolController {

    private FormType type;
    @FXML
    private PasswordField newPassword, rePassword;
    @FXML
    private TextField line1TextBox, line2TextBox, line3TextBox, line5TextBox, line10TextBox,
            line6TextBox, line7TextBox, line8TextBox, line9TextBox, line11TextBox, username,
            fxGivenName, fxSurname;
    @FXML
    private ComboBox line4ComboBox, line8ComboBox;
    @FXML
    private Text usernameText, lineGivenName, lineSurname, line1, line2, line3, line4, 
                 line5, line6, line7, line8, line9, line10, line11, rePass, newPass;
    @FXML
    private Button submitBtn;
    @Autowired
    private FormController formController;
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
    }

    public void load(int idUser, FormType ftype) {
        clear();
        this.type = ftype;
        
        formController.setSubTitleText("Please fill out the form below.");

        line6.setText("Addr 2:");
        line7.setText("City:");
        line8.setText("Province:");
        line9.setText("Postal Code:");
        line10.setText("Country:");
        line2.setText("Email:");
        line11.setText("Phone:");        
        
        if (type == FormType.ADD_STUDENT) {
            formController.setFormName("Add Student");
            submitBtn.setText("Add Student");
            thisUser = new Student();
            thisUser.setUsertype("Student");
            thisUser.setIdUser(0);
        } else if (type == FormType.ADD_ADMINISTRATOR) {
            formController.setFormName("Add Administrator");
            submitBtn.setText("Add Administrator");
            thisUser = new Administrator();
            thisUser.setUsertype("Administrator");
            thisUser.setIdUser(0);
        } else if (type == FormType.ADD_INSTRUCTOR) {
            formController.setFormName("Add Instructor");
            submitBtn.setText("Add Instructor");
            thisUser = new Instructor();
            thisUser.setUsertype("Instructor");
            thisUser.setIdUser(0);
        } else {
            formController.setFormName("Update Profile");
            submitBtn.setText("Update User");
            thisUser = userdao.getUserByID(idUser);
            User lastModBy = userdao.getUserByID(thisUser.getLastModBy());
            formController.setDateCreated(thisUser.getLastModified().toString());
            formController.setLastUpdated(thisUser.getLastModified().toString());
            formController.setModBy(lastModBy.getFullName());
            username.setText(thisUser.getUsername());
            username.setDisable(true);
            
            line5TextBox.setText(thisUser.getAddr1());
            fxGivenName.setText(thisUser.getGivenName());
            fxSurname.setText(thisUser.getSurname());
            line6TextBox.setText(thisUser.getAddr2());
            line7TextBox.setText(thisUser.getCity());
            line8TextBox.setText(thisUser.getProvince());
            line9TextBox.setText(thisUser.getPostalCode());
            line10TextBox.setText(thisUser.getCountry());
            line2TextBox.setText(thisUser.getEmail());
            line11TextBox.setText(thisUser.getPhone());
            
            if (!(getUserSession().checkPermission("admin-user"))) {
                line1TextBox.setDisable(true);
                line4ComboBox.setDisable(true);
            } else {
                line1TextBox.setDisable(false);
                line4ComboBox.setDisable(false);
                isEditor = true;
            }

        }
            if (thisUser.getUsertype() == User.Type.INSTRUCTOR) {
                initInstructor(idUser);
            } else if (thisUser.getUsertype() == User.Type.ADMINISTRATOR) {
                initAdministrator(idUser);
            } else {
                initStudent(idUser);
            }   
    }

    public void initInstructor(int idUser) {
        if (thisUser.getIdUser()!=0)
        thisUser = instructordao.getInstructorByID(idUser);
        
        line3.setText("Office:");
        line3TextBox.setText(((Instructor) thisUser).getOffice());
        line1.setText("Job Title:");
        line1TextBox.setText(((Instructor) thisUser).getJobTitle());
        line4.setText("Faculty:");
        line4ComboBox.getItems().addAll(facultydao.getAllFacultyID());
        if (((Instructor) thisUser).getIdFaculty() != null) {
            line4ComboBox.setValue(((Instructor) thisUser).getIdFaculty().getIdFaculty());
        }

    }

    public void initStudent(int idUser) {
        if (thisUser.getIdUser()!=0)
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
        if (thisUser.getIdUser()!=0)
        thisUser = administratordao.getAdministratorByID(idUser);
        
        line3.setText("Office:");
        line3TextBox.setText(((Administrator) thisUser).getOffice());
        line1.setText("Job Title:");
        line1TextBox.setText(((Administrator) thisUser).getJobTitle());
        line4.setText("Department:");
        line4ComboBox.getItems().addAll(departmentdao.getAllDeptID());
        if (((Administrator) thisUser).getIdDepartment() != null) {
            line4ComboBox.setValue(((Administrator) thisUser).getIdDepartment());
        }

    }

    public void resetErrors() {
        formController.resetErrors();
        usernameText.setFill(Color.BLACK);
        lineGivenName.setFill(Color.BLACK);
        lineSurname.setFill(Color.BLACK);
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
        rePass.setFill(Color.BLACK);
        newPass.setFill(Color.BLACK);
        usernameText.setFill(Color.BLACK);
    }

    public void submit(ActionEvent event) {
        boolean errors = false;
        boolean changePassword = false;
        String errorMsg = "Please fill in all bolded fields. \n";
        resetErrors();

        String email = line2TextBox.getText(),
                addr1 = line5TextBox.getText(),
                addr2 = line6TextBox.getText(),
                city = line7TextBox.getText(),
                province = line8TextBox.getText(),
                postalcode = line9TextBox.getText(),
                country = line10TextBox.getText(),
                phone = line11TextBox.getText(),
                givenName = fxGivenName.getText(),
                surname = fxSurname.getText(),
                uname = username.getText();

        thisUser.setGivenName(givenName);
        thisUser.setUsername(uname);
        thisUser.setSurname(surname);
        thisUser.setAddr1(addr1);
        thisUser.setAddr2(addr2);
        thisUser.setCity(city);
        thisUser.setCountry(country);
        thisUser.setEmail(email);
        thisUser.setProvince(province);
        thisUser.setPostalCode(postalcode);
        thisUser.setPhone(phone);
        thisUser.setLastModBy(getUserSession().getCurrentUser().getIdUser());

        if (type != FormType.MODIFY) {
            if (userdao.usernameTaken(uname)) {
                errors = true;
                usernameText.setFill(Color.RED);
                errorMsg += "Username already taken \n";
            }
        }

        if (email == null || email.isEmpty() || !(RegexHelper.validate(email, RegExPattern.EMAIL))) {
            line2.setFill(Color.RED);
            errors = true;
            errorMsg += "Valid email address is required. \n";
        }

        if (phone == null || phone.isEmpty() || !(RegexHelper.validate(phone, RegExPattern.PHONE_NUMBER))) {
            line11.setFill(Color.RED);
            errors = true;
            errorMsg += "Valid phone number is required. \n";
        }

        if (uname== null || uname.isEmpty() || !(RegexHelper.validate(uname, RegExPattern.USERNAME))) {
            usernameText.setFill(Color.RED);
            errors = true;
            errorMsg += "Username must be alphanumeric. \n";
        }     
        
        if (addr1 == null || addr1.isEmpty()) {
            line5.setFill(Color.RED);
            errors = true;
        }

        if (givenName == null || givenName.isEmpty()) {
            lineGivenName.setFill(Color.RED);
            errors = true;
        }

        if (surname == null || surname.isEmpty()) {
            lineSurname.setFill(Color.RED);
            errors = true;
        }

        if (city == null || city.isEmpty()) {
            line7.setFill(Color.RED);
            errors = true;
        }

        if (province == null || province.isEmpty()) {
            line8.setFill(Color.RED);
            errors = true;
        }

        if (postalcode == null || postalcode.isEmpty()) {
            line9.setFill(Color.RED);
            errors = true;
        }

        if (country == null || country.isEmpty()) {
            line10.setFill(Color.RED);
            errors = true;
        }

        if (!(newPassword.getText()).isEmpty() || type != FormType.MODIFY) {
            if (!(newPassword.getText().equals(rePassword.getText()))){
                errorMsg += "Passwords did not match. \n";
                errors = true;
                rePass.setFill(Color.RED);
            } else if (!(newPassword.getText().length() > 7)) {
                errorMsg += "Passwords must be at least 8 characters. \n";
                errors = true;
                newPass.setFill(Color.RED);
                rePass.setFill(Color.RED);
            } else {
                thisUser.setPassword(Security.md5(newPassword.getText()));
            }
        }

        if (thisUser instanceof Instructor) {
            String jobtitle = line1TextBox.getText(),
                    office = line3TextBox.getText();
            if (isEditor) {
                String facultyID = "";
                if (line4ComboBox.getSelectionModel().getSelectedItem()!=null) {
                    facultyID = line4ComboBox.getSelectionModel().getSelectedItem().toString();
                }

                if (jobtitle==null || jobtitle.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }
                thisUser.setUsertype("Instructor");
                System.out.println(thisUser.getUsertype().name());
                ((Instructor) thisUser).setJobTitle(jobtitle);
                ((Instructor) thisUser).setIdFaculty(facultydao.getFacultyById(facultyID));
            }

            ((Instructor) thisUser).setOffice(office);
            if (!errors) {
                if (type == FormType.MODIFY) {
                    instructordao.updateProfile((Instructor) thisUser);
                    formController.confirmPost("Record updated.");
                } else {
                    instructordao.addInstructor((Instructor) thisUser);
                    formController.setConfirmTitleText("Instructor \""+thisUser.getGivenName()+" "+thisUser.getSurname()+"\" created.");
                }
                
                clear();
            } else {
                formController.showErrors(errorMsg);
            }

        } else if (thisUser instanceof Administrator) {
            String jobtitle = line1TextBox.getText(),
                    office = line3TextBox.getText();
            if (isEditor) {
                String deptID = "";
                if (line4ComboBox.getSelectionModel().getSelectedItem()!=null) {
                    deptID = line4ComboBox.getSelectionModel().getSelectedItem().toString();
                }
                System.out.println(deptID);

                if (jobtitle == null || jobtitle.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }
                thisUser.setUsertype("Administrator");
                System.out.println(thisUser.getUsertype().name());
                ((Administrator) thisUser).setJobTitle(jobtitle);
                ((Administrator) thisUser).setIdDepartment(deptID);
            }
            ((Administrator) thisUser).setOffice(office);

            if (!errors) {

                if (type == FormType.MODIFY) {
                    administratordao.updateProfile((Administrator) thisUser);
                    formController.confirmPost("Record updated.");
                } else {
                    administratordao.addAdministrator((Administrator) thisUser);
                    formController.setConfirmTitleText("Administrator \""+thisUser.getGivenName()+" "+thisUser.getSurname()+"\" created.");

                }
                
                clear();
            } else {
                formController.showErrors(errorMsg);
            }
        } else {
            if (isEditor) {
                String type = line1TextBox.getText();
                String program = ((String) line4ComboBox.getSelectionModel().getSelectedItem());

                if (type == null || type.isEmpty()) {
                    line1.setFill(Color.RED);
                    errors = true;
                }

                ((Student) thisUser).setType(type);
                ((Student) thisUser).setIdProgram(program);
            }
            if (!errors) {
                if (type == FormType.MODIFY) {
                    studentdao.updateProfile((Student) thisUser);
                    formController.confirmPost("Record updated.");
                } else {
                    studentdao.addStudent((Student) thisUser);
                    formController.setConfirmTitleText("Student \""+thisUser.getGivenName()+" "+thisUser.getSurname()+"\" created.");

                }
                
                clear();
            } else {
                formController.showErrors(errorMsg);
            }
        }
    }
    
    public void clear() {
        resetErrors();
        line1TextBox.clear();
        line2TextBox.clear();
        line3TextBox.clear();
        line4ComboBox.getItems().clear();
        line5TextBox.clear();
        line6TextBox.clear();
        line7TextBox.clear();
        line8TextBox.clear();
        line9TextBox.clear();
        line10TextBox.clear();
        line11TextBox.clear();
        newPassword.clear();
        rePassword.clear();
        username.clear();
        fxGivenName.clear();
        fxSurname.clear();
        thisUser = null;
    }
}