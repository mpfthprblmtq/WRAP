/**
 * File:    TaskController.java
 * Desc:    Takes input from TaskGUI and communicates with IOController to read
 *          and write to files
 * 
 * Author:  Pat Ripley
 */

package webradio;

// imports
import java.util.Arrays;
import java.util.Comparator;

public class TaskController implements Comparator<Profile> {
    
    /**
     * getAllPeople()
     * Gets an array of Profiles from IOController, sorts it, and returns it
     * 
     * @return sorted array of Profiles
     */
    public static Profile[] getAllPeople() {
        Profile[] arr = IOController.getAllPeople();
        arr = sort(arr);
        return arr;
    }

    /**
     * sort()
     * Uses comparater interface to compare strings
     * 
     * @param arr, the array to sort
     * @return arr, the sorted array
     */
    public static Profile[] sort(Profile[] arr) {
        Arrays.sort(arr, (Profile o1, Profile o2) -> 
                o1.getlName().compareToIgnoreCase(o2.getlName()) 
        );
        return arr;
    }
    
    /**
     * compare()
     * From Comparator interface, compares two strings
     * 
     * @param o1, the first element
     * @param o2, the second element
     * @return the int result of the comparison
     */
    @Override
    public int compare(Profile o1, Profile o2) {
        return o1.getlName().compareToIgnoreCase(o2.getlName());
    }
    
} // end TaskController