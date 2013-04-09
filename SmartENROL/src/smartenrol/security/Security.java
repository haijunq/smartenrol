/*
 * Security is a singleton class that provides permissions 
 * structures and authentication for SmartEnrol
 */
package smartenrol.security;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartenrol.SmartENROL;

/**
 *
 */
public class Security {
    
    private static Security security = null;
    
    private Security() {
        
    }
    
     /**
     * Static method returns a single instance of UserSession
     * @return	a single instance of UserSession
     */
    public static Security getInstance()  {
        if (security == null) {
            security = new Security(); 
        }
        return security;
    }
    
    public static String md5(String stringToConvert) {
         
        String md5 = null;
         
        if(stringToConvert.isEmpty()) 
            return null;
         
        try {
            
            MessageDigest mDigest = MessageDigest.getInstance("MD5");

            mDigest.update(stringToConvert.getBytes(), 0, stringToConvert.length());

            md5 = new BigInteger(1, mDigest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException ex) {
 
            ex.printStackTrace();
        }
        
        return md5;
    }
    
    public void restartApplication() {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar;
        try {
            
            currentJar = new File(SmartENROL.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar")) {
                return;
            }
            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            try {
                builder.start();
            } catch (IOException ex) {
                Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.exit(0);
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

