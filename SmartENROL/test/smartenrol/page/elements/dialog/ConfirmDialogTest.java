/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.dialog;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Aishwarya
 */
public class ConfirmDialogTest {

    @Test
    public void testGetTitle() {
        ConfirmDialog instance = new ConfirmDialog();
        String expResult = "";
        String result = instance.getTitle();
        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testSetTitle() {
        String title = "Sample";
        ConfirmDialog instance = new ConfirmDialog();
        instance.setTitle(title);
        Assert.assertEquals("Sample", instance.getTitle());

    }

    @Test
    public void testGetMessage() {
        ConfirmDialog instance = new ConfirmDialog();
        String expResult = "";
        String result = instance.getMessage();
        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testSetMessage() {
        String message = "Message";
        ConfirmDialog instance = new ConfirmDialog();
        instance.setMessage(message);
        Assert.assertEquals("Message", instance.getMessage());
    }

    @Test
    public void testConfirm() {
        ConfirmDialog instance = new ConfirmDialog();
        boolean expResult = false;
        boolean result = instance.confirm();
        Assert.assertEquals(expResult, result);
    }
}