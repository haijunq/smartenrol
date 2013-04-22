/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;

/**
 *
 * @author Aishwarya
 */
public class SecurityTest {

    public SecurityTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void md5WithNull() {
        try {
            Security.md5(null);
            Assert.fail();
        } catch (NullPointerException exception) {
            Assert.assertNull(exception.getMessage());
        }
    }

    @Test
    public void md5WithEmpty() {
        Assert.assertNull(Security.md5(""));
    }

    @Test
    public void md5WithSpace() {
        Assert.assertEquals("628631f07321b22d8c176c200c855e1b", Security.md5("   "));
    }

    @Test
    public void md5WithSpecialCharacters() {
        Assert.assertEquals("7ce385876b9d27babc2aead40a7f7c47", Security.md5("~!@#$%^&*()_+"));
    }

    @Test
    public void md5WithUpperCase() {
        Assert.assertEquals("6daab063d10f4498a2b89dedd0e909f4", Security.md5("SAMPLE_TEST"));
    }

    @Test
    public void md5WithLowerCase() {
        Assert.assertEquals("c4f718c102166ec1ff48ea12bd94972f", Security.md5("sample_test"));
    }

    @Test
    public void md5WithInitCaps() {
        Assert.assertEquals("9b07eb333de77ee290b13b2e5d1e2aa8", Security.md5("Sample_test"));
    }

    @Test
    public void md5WithCamelCase() {
        Assert.assertEquals("fad0ea92e0a2a5d7640e1737bad66f57", Security.md5("sampleTest"));
    }

    @Test
    public void md5WithNumbers() {
        Assert.assertEquals("e807f1fcf82d132f9bb018ca6738a19f", Security.md5("1234567890"));
    }

    @Test
    public void md5WithAlphaNumeric() {
        Assert.assertEquals("86c8148718b55269a336f9e2c57b4117", Security.md5("Sample1234"));
    }

    @Test
    public void md5WithAlphaNumeric1() {
        Assert.assertEquals("dead87a7d12bd8182035e276f5437f94", Security.md5("1234Sample"));
    }
    
    @Test
    public void md5WithAlphaNumeric2() {
        Assert.assertEquals("f5c4f14ff5eb2007c8f315693f218ee6", Security.md5("12Sam124"));
    }
    
    @Test
    public void md5WithAlphaNumeric3() {
        Assert.assertEquals("bd70e1c9b3f105e847b71b515ba82892", Security.md5("same14same"));
    }
    
    @Test
    public void md5WithMixedChars() {
        Assert.assertEquals("12288aa98ec2121215a5984a90e79e70", Security.md5("sam123@#sa"));
    }
}