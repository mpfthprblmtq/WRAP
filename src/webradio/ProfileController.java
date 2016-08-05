/**
 * File: ProfileController.java
 * Desc: Takes input from ProfileGUI and sends it to IOController
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.util.Arrays;
import java.util.Comparator;

public class ProfileController implements Comparator<Profile> {
    
    /**
     * AddProfile()
     * 
     * Function to add a new Profile
     * Checks to see if there is a duplicate id
     * If there is no duplicate, add the new Profile
     * 
     * @param p
     * @return the result of the addition
     */
    public static boolean AddProfile(Profile p) {
        if (IOController.CheckForIDDupe(p.getId())) {
            return false;
        }
        return IOController.AddProfile(p);
    }
    
    /**
     * SearchProfile()
     * 
     * Sends IOController the id of the Profile to search for
     * 
     * @param id
     * @return the Profile found
     */
    public static Profile SearchProfile(String id) {
        return IOController.SearchProfile(id);
    }
    
    /**
     * DeleteProfile()
     * 
     * Sends IOController the id of the Profile to delete
     * 
     * @param id
     * @return the result of the deletion
     */
    public static boolean DeleteProfile(String id) {
        return IOController.DeleteProfile(id);
    }
    
    /**
     * getAllProfiles()
     * 
     * Returns an array of Profiles from IOController
     * Sorts the array as well
     * 
     * @return the sorted array of Profiles
     */
    public static Profile[] getAllProfiles() {
        Profile[] arr = IOController.getAllProfiles();
        arr = sort(arr);
        return arr;
    }

    /**
     * deleteProfilesShowsAsWell()
     * 
     * When deleting a profile while they have a show, this option lets you
     * delete their shows that they are hosts of
     * 
     * @param id 
     */
    public static void deleteProfilesShowsAsWell(String id) {
        IOController.deleteProfilesShowsAsWell(id);
    }
    
    /**
     * replaceProfileWithBlank()
     * 
     * When deleting a profile while they have a show, this option lets you
     * replace their name with a blank spot
     * 
     * @param id 
     */
    public static void replaceProfileWithBlank(String id) {
        IOController.replaceProfileWithBlank(id);
    }
    
    /**
     * sort()
     * 
     * Sorts the array of Profiles returned from IOController
     * Uses compare()
     * 
     * @param arr
     * @return the sorted array of Profiles
     */
    public static Profile[] sort(Profile[] arr) {
        Arrays.sort(arr, (Profile o1, Profile o2) -> 
                o1.getlName().compareToIgnoreCase(o2.getlName()) 
        );
        return arr;
    }
    
    /**
     * compare()
     * 
     * Compares the alphabetical elements of each Profile
     * Used for sorting the array of Profiles
     * 
     * @param o1
     * @param o2
     * @return the result of comparison
     */
    @Override
    public int compare(Profile o1, Profile o2) {
        return o1.getlName().compareToIgnoreCase(o2.getlName());
    }
} // end ProfileController
