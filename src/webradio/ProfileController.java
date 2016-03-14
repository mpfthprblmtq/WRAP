/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webradio;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Pat
 */
public class ProfileController implements Comparator<Profile> {
    
    public static boolean AddProfile(Profile p) {
        boolean dupeID = IOController.CheckForIDDupe(p.getId());
        if (dupeID) {
            return false;
        }
        return IOController.AddProfile(p);
    }
    
    public static Profile SearchPerson(String id) {
        return IOController.SearchProfile(id);
    }
    
    public static boolean DeletePerson(String id) {
        return IOController.DeletePerson(id);
    }
    
    public static Profile[] getAllPeople() {
        Profile[] arr = IOController.getAllProfiles();
        arr = sort(arr);
        return arr;
    }

    public static Profile[] sort(Profile[] arr) {
        Arrays.sort(arr, (Profile o1, Profile o2) -> 
                o1.getlName().compareToIgnoreCase(o2.getlName()) 
        );
        
        return arr;
    }
    
    @Override
    public int compare(Profile o1, Profile o2) {
        return o1.getlName().compareToIgnoreCase(o2.getlName());
    }
    
}
