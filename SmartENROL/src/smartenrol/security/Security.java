/*
 * Security is a singleton class that provides permissions 
 * structures and authentication for SmartEnrol
 */
package smartenrol.security;

import java.util.HashMap;

/**
 *
 */
public class Security {

    HashMap permissions; 
    
    private Security() {
        
    }
    
    /**
     * Is allowed checks if the current user has the given permission.
     * @param permission Permission to check.
     */
    public void isAllowed(String permission) {
        
        
    }
    
}

