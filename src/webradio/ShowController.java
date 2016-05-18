
package webradio;

import java.util.Arrays;

public class ShowController {
    
    public static boolean addShow(Show show) {
        if(IOController.CheckForShowDupe(show.getShowName())) {
            return false;
        }
        return IOController.addShow(show);
    }
    
    public static Show searchShow(String showName) {
        return IOController.searchShow(showName);
    }
    
    public static boolean deleteShow(String showName) {
        return IOController.deleteShow(showName);
    }
    
    public static Show[] getShows() {
        Show[] arr = IOController.getAllShows();
        arr = sort(arr);
        return arr;
    }
    
    public static Show[] sort(Show[] arr) {
        Arrays.sort(arr, (Show o1, Show o2) -> 
                o1.getShowName().compareToIgnoreCase(o2.getShowName()) 
        );
        return arr;
    }
    
    public int compare(Show o1, Show o2) {
        return o1.getShowName().compareToIgnoreCase(o2.getShowName());
    }
}
