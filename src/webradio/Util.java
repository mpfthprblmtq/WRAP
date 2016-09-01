/**
 * File: Util.java
 * Desc: Utility interface
 *
 * Author: Pat Ripley
 */
package webradio;

import java.util.Random;
import javax.swing.JOptionPane;

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

    /**
     * generateID()
     *
     * creates a 9-digit unique ID
     *
     * @return
     */
    static int generateID() {
        Random rand = new Random();
        int num = rand.nextInt(999999999);
        if (IOController.checkAllIDsForDupe(num)) {
            return num;
        } else {
            return generateID();
        }
    }

    /**
     * error()
     *
     * Takes a string from an exception and shows an error dialog
     *
     * @param ex
     * @param exm
     */
    static void error(String ex, String exm) {

        // get the exception
        String[] ar = ex.split(":");
        String s = ar[0];
        String[] arr = s.split("\\.");
        String exception = arr[arr.length - 1];

        // get the message
        String message = exm;

        String str = "<html><font color=#a10c10>" + exception + "\n"
                + "<html><font color=#a10c10>" + message + "\n\n"
                + "Please report a bug if you are seeing this!";

        Object[] options = new Object[]{"Report Bug", "Dismiss"};
        int n = JOptionPane.showOptionDialog(null,
                str,
                "ERROR",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[1]);
        
        switch(n) {
            case 0:
                Main.LaunchBugReportGUI();
                break;
            case 1:
                break;
        }
        
        // log
                EventLog.add("ran into an error: " 
                        + exception + ": " + message);
    }

}
