/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

/**
 *
 * @author Aishwarya
 */
public class InvalidAuthenticationException extends Exception
{
    public InvalidAuthenticationException(String message) 
    {
        super(message);
    }
}
