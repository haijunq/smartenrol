package smartenrol;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import smartenrol.dao.BuildingDAOTest;
import smartenrol.dao.DepartmentDAOTest;
import smartenrol.dao.FacultyDAOTest;
import smartenrol.dao.ProgramDAOTest;
import smartenrol.dao.StudentDAOTest;
import smartenrol.dao.UserDAOTest;
import smartenrol.model.AdministratorTest;
import smartenrol.model.BuildingTest;
import smartenrol.model.ClassListTest;
import smartenrol.model.CorequisiteTest;
import smartenrol.model.CourseGradeRecordTest;
import smartenrol.model.CourseTest;
import smartenrol.model.DepartmentTest;
import smartenrol.model.FacultyTest;
import smartenrol.model.InstructorTest;
import smartenrol.model.MessageTemplateTest;
import smartenrol.model.PrerequisiteTest;
import smartenrol.model.ProgramTest;
import smartenrol.model.SectionTest;
import smartenrol.model.StudentGradeRecordTest;
import smartenrol.model.StudentSectionTest;
import smartenrol.model.StudentTest;
import smartenrol.model.UserTest;
import smartenrol.page.administration.building.BuildingServiceTest;
import smartenrol.page.administration.building.BuildingValidatorTest;
import smartenrol.page.administration.course.CourseServiceTest;
import smartenrol.page.administration.course.CourseValidatorTest;
import smartenrol.page.administration.department.DepartmentServiceTest;
import smartenrol.page.administration.department.DepartmentValidatorTest;
import smartenrol.page.administration.faculty.FacultyServiceTest;
import smartenrol.page.administration.faculty.FacultyValidatorTest;
import smartenrol.page.administration.program.ProgramServiceTest;
import smartenrol.page.administration.program.ProgramValidatorTest;
import smartenrol.security.AuthenticateServiceTest;
import smartenrol.security.AuthenticateValidatorTest;
import smartenrol.security.SecurityTest;
import smartenrol.security.UserSessionTest;

public class SmartEnrolTestSuite extends TestSuite {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new JUnit4TestAdapter(BuildingValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(CourseValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(DepartmentValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(FacultyValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(ProgramValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(AuthenticateValidatorTest.class));
        suite.addTest(new JUnit4TestAdapter(SecurityTest.class));
        suite.addTest(new JUnit4TestAdapter(UserSessionTest.class));
        
        suite.addTest(new JUnit4TestAdapter(AdministratorTest.class));
        suite.addTest(new JUnit4TestAdapter(BuildingTest.class));
        suite.addTest(new JUnit4TestAdapter(ClassListTest.class));
        suite.addTest(new JUnit4TestAdapter(CourseGradeRecordTest.class));
        suite.addTest(new JUnit4TestAdapter(CorequisiteTest.class));
        suite.addTest(new JUnit4TestAdapter(ProgramTest.class));
        suite.addTest(new JUnit4TestAdapter(CourseTest.class));
        suite.addTest(new JUnit4TestAdapter(MessageTemplateTest.class));
        suite.addTest(new JUnit4TestAdapter(PrerequisiteTest.class));
        suite.addTest(new JUnit4TestAdapter(StudentGradeRecordTest.class));
        suite.addTest(new JUnit4TestAdapter(DepartmentTest.class));
        suite.addTest(new JUnit4TestAdapter(FacultyTest.class));
        
        suite.addTest(new JUnit4TestAdapter(UserTest.class));
        suite.addTest(new JUnit4TestAdapter(StudentTest.class));
        suite.addTest(new JUnit4TestAdapter(StudentSectionTest.class));
        suite.addTest(new JUnit4TestAdapter(SectionTest.class));
        suite.addTest(new JUnit4TestAdapter(InstructorTest.class));
       
        suite.addTest(new JUnit4TestAdapter(DepartmentDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(BuildingDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(FacultyDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(ProgramDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(UserDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(StudentDAOTest.class));
        
        suite.addTest(new JUnit4TestAdapter(BuildingServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(CourseServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(DepartmentServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(FacultyServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(ProgramServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(AuthenticateServiceTest.class));
       
        return suite;
    }
}
