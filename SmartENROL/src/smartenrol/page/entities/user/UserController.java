/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.AdministratorDAO;
import smartenrol.dao.InstructorDAO;
import smartenrol.dao.StudentDAO;
import smartenrol.dao.UserDAO;
import smartenrol.model.Administrator;
import smartenrol.model.Instructor;
import smartenrol.model.Student;
import smartenrol.model.User;
import smartenrol.page.Navigator;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy
 */

public class UserController extends SmartEnrolController {
    
    UserDAO userdao = new UserDAO();
    
    User thisUser = new User();
    
    
    @FXML private Text name;
    @FXML private Text title1,title2,title3,title4,title5,title6;
    @FXML private Text text1,text2,text3,text4,text5,text6,text7;
    @FXML private Text username;
    
    @FXML private Button updateBtn;
    @Autowired private Navigator navigator;
    
    @Override
    public void init() {
        setSidebarEnabled(true);
    }
    
    public void initInstructor(int idUser) {
        InstructorDAO instructordao = new InstructorDAO();
        thisUser = instructordao.getInstructorByID(idUser);
        title1.setText("Faculty:");
        text1.setText(((Instructor)thisUser).getIdFaculty().getName());
        title3.setText("Job Title:");
        title4.setText("Office:");
        text4.setText(((Instructor)thisUser).getJobTitle());
        text5.setText(((Instructor)thisUser).getOffice());
    }
    
    public void initStudent(int idUser) {
        StudentDAO studentdao = new StudentDAO();
        thisUser = studentdao.getStudentByID(idUser);
        title1.setText("Program:");
        text1.setText(((Student)thisUser).getIdProgram());
        text4.setText(((Student)thisUser).getType());
        title3.setText("Type:");
        title4.setText("Status:");
        text5.setText(((Student)thisUser).getStatus());
        
    }
    
    public void initAdministrator(int idUser) {
        AdministratorDAO administratordao = new AdministratorDAO();
        thisUser = administratordao.getAdministratorByID(idUser);
        title1.setText("Department:");
        text1.setText(((Administrator)thisUser).getIdDepartment().getIdDepartment());
        title3.setText("Job Title:");
        title4.setText("Office:");
        text4.setText(((Administrator)thisUser).getJobTitle());
        text5.setText(((Administrator)thisUser).getOffice());
    }
    
    public void load(int idUser) {
            
            thisUser = userdao.getUserByID(idUser);
 
            name.setText(thisUser.getFullName());

            title2.setText("Address:");
            text2.setText(thisUser.getAddr1());
            text3.setText(thisUser.getCity()+", "+thisUser.getCountry());
            
            username.setText(thisUser.getUsername());
            title5.setText("Email:");
            text6.setText(thisUser.getEmail());
            
            title6.setText("Phone:");
            text7.setText(thisUser.getPhone());           
            
            if (thisUser.getUsertype()==User.Type.INSTRUCTOR) {
                initInstructor(idUser);
            } else if (thisUser.getUsertype()==User.Type.ADMINISTRATOR) {
                updateBtn.setVisible(true);
                initAdministrator(idUser);
            } else {
                initStudent(idUser);
            }
            
            if (idUser==getUserSession().getCurrentUser().getIdUser())
                updateBtn.setVisible(true);
 
    }

    
    @FXML
    public void updateProfile(ActionEvent event)
    {
        navigator.navigate(Page.UPDATE_PROFILE);
    }
}
    
