/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class MessageTemplateTest {

    public MessageTemplateTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetType() {
        MessageTemplate instance = new MessageTemplate();
        assertNull(instance.getType());
    }

    @Test
    public void testSetType() {
        String type = "ADMIN";
        MessageTemplate instance = new MessageTemplate();
        instance.setType(type);
        assertEquals(type, instance.getType());
    }

    @Test
    public void testGetStringPattern() {
        MessageTemplate instance = new MessageTemplate();
        assertNull(instance.getStringPattern());
    }

    @Test
    public void testSetStringPattern() {
        String stringPattern = "sample Pattern";
        MessageTemplate instance = new MessageTemplate();
        instance.setStringPattern(stringPattern);
        assertEquals(stringPattern, instance.getStringPattern());
    }

    @Test
    public void testGetMessageCollection() {
        MessageTemplate instance = new MessageTemplate();
        assertNull(instance.getMessageCollection());
    }

    @Test
    public void testSetMessageCollection() {
        Collection<Message> messageCollection = new ArrayList<>();
        MessageTemplate instance = new MessageTemplate();
        instance.setMessageCollection(messageCollection);
        assertNotNull(instance.getMessageCollection());
    }

    @Test
    public void testHashCode() {
        MessageTemplate instance = new MessageTemplate();
        assertNotNull(instance.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        MessageTemplate instance = new MessageTemplate();
        instance.setType("ADMIN");
        String expResult = "smartenrol.model.MessageTemplate[ type=ADMIN ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}