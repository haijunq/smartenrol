package smartenrol.security;

import smartenrol.dao.*;
import smartenrol.model.*;

public class AuthenticateService
{
    
    protected final String ERROR_MESSAGE = "Invalid Credentials. Please try again.";
    
    private final UserDAO userDao;
    private UserSession currentUserSession = UserSession.getInstance();
    
    private final AuthenticateValidator authenticateValidator;
    	
    public AuthenticateService()
    {
        this.userDao = new UserDAO();
        this.authenticateValidator = new AuthenticateValidator();
    }
	
    public void authenticate(String username, String password) throws InvalidAuthenticationException
    {
        this.authenticateValidator.validateUserName(username);
        this.authenticateValidator.validatePassword(Security.md5(password));
        
        System.out.println(username+" "+Security.md5(password));
        User userInfo = this.userDao.getUserInfo(username, Security.md5(password));
        
        if (userInfo!=null) {
            if (userInfo.getIdUser()==null||userInfo.getIdUser()==0) {
                throw new InvalidAuthenticationException(ERROR_MESSAGE);
            } else {
                currentUserSession.setCurrentUser(userInfo);
            }
        } else {
            throw new InvalidAuthenticationException("Could not connect to server.");
        }
        
    }
    
}
