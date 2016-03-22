/**
 * File: Util.java
 * Desc: Utility interface
 *
 * Author: Pat Ripley
 */
package webradio;

public interface Util {
    
    /**
     * sepCheck()
     * 
     * Checks the input string for the separation character ///
     * 
     * @param str
     * @return result of search
     */
    static boolean sepCheck(String str) {
        return !str.contains("///");
    }
    
    /**
     * toBool()
     * 
     * Converts string input to boolean
     * 
     * @param str
     * @return the boolean value of the string
     */
    static boolean toBool(String str) {
        return str.equals("true");
    }
    
}
