/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class ClassListTest {

    public ClassListTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetInstructorName() {
        ClassList instance = new ClassList();
        assertNotNull(instance.getInstructorName());
    }

    @Test
    public void testGetInstructorGivenName() {
        ClassList instance = new ClassList();
        assertNull(instance.getInstructorGivenName());
    }

    @Test
    public void testSetInstructorGivenName() {
        String instructorGivenName = "Sample";
        ClassList instance = new ClassList();
        instance.setInstructorGivenName(instructorGivenName);
        assertEquals(instructorGivenName, instance.getInstructorGivenName());
    }

    @Test
    public void testGetInstructorSurname() {
        ClassList instance = new ClassList();
        assertNull(instance.getInstructorSurname());
    }

    @Test
    public void testSetInstructorSurname() {
        String instructorSurname = "sample test";
        ClassList instance = new ClassList();
        instance.setInstructorSurname(instructorSurname);
        assertEquals(instructorSurname, instance.getInstructorSurname());
    }

    @Test
    public void testSetStuRecordList() {
        ArrayList<StudentGradeRecord> stuRecordList = new ArrayList<>();
        ClassList instance = new ClassList();
        instance.setStuRecordList(stuRecordList);
        assertNotNull(instance.getStuRecordList());
    }
}