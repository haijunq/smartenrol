/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.security;

import java.util.regex.*;

/**
 * This is a singleton class for regex.
 */
public class RegexHelper {

    public enum RegExPattern {

        POSTAL_CODE, PHONE_NUMBER, EMAIL, FLOAT, INT, USERNAME
    }
    private static final String RGX_USERNAME = "^[a-z0-9_-]{3,16}$";
    private static final String RGX_EMAIL = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    private static final String RGX_POSTAL_CODE = "^[ABCEGHJKLMNPRSTVXY]{1}\\d{1}[A-Z]{1} *\\d{1}[A-Z]{1}\\d{1}$";
    private static final String RGX_FLOAT = "^(?=.+)(?:[1-9]\\d*|0)?(?:\\.\\d+)?$";
    private static final String RGX_INT = "^[1-9]\\d*$";
    private static final String RGX_PHONE_NUMBER = "^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";
    private static RegexHelper regex = null;

    protected RegexHelper() {
    }	// empty 

    /**
     * Static method returning a single instance of RegexHelper
     *
     * @return a single instance of RegexHelper
     */
    public static RegexHelper getInstance() {

        if (regex == null) {
            regex = new RegexHelper();
        }

        return regex;
    }

    public static Boolean validate(String input, RegExPattern regEx) {

        String patternToUse;

        if (input == null || input.isEmpty() || regex == null) {
            return true;
        }

        switch (regEx) {
            case USERNAME:
                patternToUse = RGX_USERNAME;
                break;
            case POSTAL_CODE:
                patternToUse = RGX_POSTAL_CODE;
                break;
            case PHONE_NUMBER:
                patternToUse = RGX_PHONE_NUMBER;
                break;
            case FLOAT:
                patternToUse = RGX_FLOAT;
                break;
            case INT:
                patternToUse = RGX_INT;
                break;
            case EMAIL:
                patternToUse = RGX_EMAIL;
                break;
            default:
                patternToUse = null;
                break;
        }

        if (patternToUse != null) {

            System.out.println(input);

            Pattern rPattern = Pattern.compile(patternToUse);
            Matcher matcher = rPattern.matcher(input);

            if (matcher.find()) {
                return true;
            } else {
                return false;
            }
        } else {
            System.err.println("No regular expression could be found.");
            return true;
        }
    }
}
