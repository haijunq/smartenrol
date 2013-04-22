/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class SectionTest {

    @Test
    public void testIsSectionFull() {
        int currentEnrol = 0;
        Section instance = new Section();
        boolean expResult = true;
        boolean result = instance.isSectionFull(currentEnrol);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdSection() {
        Section instance = new Section();
        assertNull(instance.getIdSection());
    }

    @Test
    public void testSetIdSection() {
        String idSection = "123456576";
        Section instance = new Section();
        instance.setIdSection(idSection);
        assertEquals(idSection, instance.getIdSection());
    }

    @Test
    public void testGetYear() {
        Section instance = new Section();
        assertNotNull(instance.getYear());
    }

    @Test
    public void testSetYear() {
        int year = 0;
        Section instance = new Section();
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    @Test
    public void testGetTerm() {
        Section instance = new Section();
        assertNotNull(instance.getYearTerm());
    }

    @Test
    public void testSetTerm() {
        String term = "124545";
        Section instance = new Section();
        instance.setTerm(term);
        assertEquals(term, instance.getTerm());
    }

    @Test
    public void testGetNotes() {
        Section instance = new Section();
        assertNull(instance.getNotes());
    }

    @Test
    public void testSetNotes() {
        String notes = "sample test";
        Section instance = new Section();
        instance.setNotes(notes);
        assertEquals(notes, instance.getNotes());
    }

    @Test
    public void testGetType() {
        Section instance = new Section();
        assertNull(instance.getType());
    }

    @Test
    public void testSetType() {
        String type = "type";
        Section instance = new Section();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    @Test
    public void testGetMaxClassSize() {
        Section instance = new Section();
        assertNotNull(instance.getMaxClassSize());
    }

    @Test
    public void testSetMaxClassSize() {
        int maxClassSize = 0;
        Section instance = new Section();
        instance.setMaxClassSize(maxClassSize);
        assertEquals(maxClassSize, instance.getMaxClassSize());
    }
}