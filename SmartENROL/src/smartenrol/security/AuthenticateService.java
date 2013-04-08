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
	
    public boolean authenticate(String username, String password) throws InvalidAuthenticationException
    {
        this.authenticateValidator.validateUserName(username);
        this.authenticateValidator.validatePassword(Security.md5(password));
        System.out.println(username+" "+Security.md5(password));
        User userInfo = this.userDao.getUserInfo(username, Security.md5(password));
        
        System.out.println(userInfo);
        if (userInfo.getIdUser()==null) {
            return false;
        } else {
            currentUserSession.setCurrentUser(userInfo);
            return true;
        }
        
    }
}
