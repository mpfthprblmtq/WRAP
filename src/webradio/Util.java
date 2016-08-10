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
    
    /**
     * getPhone()
     * 
     * Converts a ten digit phone number into a formatted string
     * 
     * @param str
     * @return result of formatting
     */
    static String getPhone(String str) {
        String[] arr = str.split("");
        String s = "";
        s += "(";
        s += arr[0];
        s += arr[1];
        s += arr[2];
        s += ")";
        s += "-";
        s += arr[3];
        s += arr[4];
        s += arr[5];
        s += "-";
        s += arr[6];
        s += arr[7];
        s += arr[8];
        s += arr[9];
        return s;
    }
}
