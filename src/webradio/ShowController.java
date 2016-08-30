/**
 * File: ShowController.java
 * Desc: Takes input from ShowGUI and sends it to IOController
 *
 * Author: Pat Ripley
 */

package webradio;

// imports
import java.util.Arrays;

public class ShowController {
    
    /**
     * addShow()
     * 
     * Adds the show
     * Checks for duplication first
     * 
     * @param show
     * @return boolean case of success
     */
    public static boolean addShow(Show show) {
        if(IOController.CheckForShowDupe(show.getShowName())) {
            return false;
        }
        return IOController.addShow(show);
    }
    
    /**
     * searchShow()
     * 
     * Searches for the show based on the show name
     * 
     * @param showName
     * @return the found show
     */
    public static Show searchShow(String showName) {
        return IOController.searchShow(showName);
    }
    
    /**
     * deleteShow()
     * 
     * Deletes a specified show based on the name
     * 
     * @param showName
     * @return the boolean for success
     */
    public static boolean deleteShow(String showName) {
        return IOController.deleteShow(showName);
    }
    
    /**
     * getShows()
     * 
     * Returns the array of all shows
     * 
     * @return the array of all shows
     */
    public static Show[] getShows() {
        Show[] arr = IOController.getAllShows();
        arr = sort(arr);
        return arr;
    }
    
    /**
     * sort()
     * 
     * Sorts the array of Shows returned from IOController
     * Uses compare()
     * 
     * @param arr
     * @return the sorted array of Shows
     */
    public static Show[] sort(Show[] arr) {
        Arrays.sort(arr, (Show o1, Show o2) -> 
                o1.getShowName().compareToIgnoreCase(o2.getShowName()) 
        );
        return arr;
    }
    
    /**
     * compare()
     * 
     * Compares the alphabetical elements of each Show
     * Used for sorting the array of Shows
     * 
     * @param o1
     * @param o2
     * @return the result of comparison
     */
    public int compare(Show o1, Show o2) {
        return o1.getShowName().compareToIgnoreCase(o2.getShowName());
    }
}
