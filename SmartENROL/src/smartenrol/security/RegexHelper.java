/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

/**
 * This is a singleton class for regex.
 */
public class RegexHelper {

	public enum Pattern {

		POSTAL_CODE, PHONE_NUMBER, EMAIL_ADDR,
		IS_FLOAT, IS_INT
	}
	
	
	private static RegexHelper regex = null;

	protected RegexHelper() { }	// empty 

	/**
	 * Static method returning a single instance of RegexHelper
	 * @return 	a single instance of RegexHelper
	 */
	public static RegexHelper getInstance() {

		if (regex == null)
			regex = new RegexHelper();

		return regex;
	}

}
