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

        if (userInfo.getIdUser()==null) {
            throw new InvalidAuthenticationException(ERROR_MESSAGE);
        } else {
            currentUserSession.setCurrentUser(userInfo);
        }
        
    }
}
