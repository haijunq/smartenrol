/*
 * Security is a singleton class that provides permissions 
 * structures and authentication for SmartEnrol
 */
package smartenrol.security;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;


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
    
    /**
     *
     * @param stringToConvert
     * @return
     */
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

}

