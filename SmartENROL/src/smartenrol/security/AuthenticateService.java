package smartenrol.security;

import smartenrol.dao.*;
import smartenrol.model.*;

public class AuthenticateService
{
	
    private final UserDAO userDao;
    
    private UserSession currentUserSession = UserSession.getInstance();
    
    private final AuthenticateValidator authenticateValidator;
    	
    public AuthenticateService()
    {
        this.userDao = new UserDAO();
        this.authenticateValidator = new AuthenticateValidator();
    }
	
    public void authenticate(String userName, String password) throws InvalidAuthenticationException
    {
        this.authenticateValidator.validateUserName(userName);
        this.authenticateValidator.validatePassword(password);
        User userInfo = this.userDao.getUserInfo(userName, password);
        currentUserSession.setCurrentUser(userInfo);
    }
}
