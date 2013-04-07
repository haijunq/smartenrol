package smartenrol.security;
import smartenrol.dao.*;
import smartenrol.model.*;

public class AuthenticateService
{
	
    private final UserDAO userDao;
    private final AuthenticateValidator authenticateValidator;
    	
    public AuthenticateService()
    {
        this.userDao = new UserDAO();
        this.authenticateValidator = new AuthenticateValidator();
    }
	
    public String authenticate(String userName, String password) throws InvalidAuthenticationException
    {
        String userRole = "INSTRUCTOR";
        this.authenticateValidator.validateUserName(userName);
        this.authenticateValidator.validatePassword(password);
        User userInfo = this.userDao.getUserInfo(userName, password);
        System.out.println("User Object retrieved from Data Base : " + userInfo);
                
        return userRole;
    }
}
