/**
 * File: ReportsController.java
 * Desc: Takes input from ReportsGUI and sends it to IOController
 *
 * Author: Pat Ripley
 */
package webradio;

import java.util.Arrays;

public class ReportsController {

    public static final int PROFILE_SIMPLE = 1;
    public static final int PROFILE_CONTACT = 2;
    public static final int PROFILE_FULL = 3;
    public static final int ACCOUNTS_SIMPLE = 1;
    public static final int ACCOUNTS_FULL = 2;
    public static final int TASKS_DUES = 1;
    public static final int TASKS_TRAINED = 2;
    public static final int TASKS_PAPERWORK = 3;
    public static final int TASKS_SHOWDESCTIME = 4;
    public static final int TASKS_FULL = 5;
    public static final int SHOWS_SIMPLE = 1;
    public static final int SHOWS_FULL = 2;
    public static final int FINANCES_TRANSACTIONS = 1;
    public static final int FINANCES_FULL = 2;

    public static final int PROFILES_SORTBY_LASTNAME = 1;
    public static final int PROFILES_SORTBY_FIRSTNAME = 2;
    public static final int PROFILES_SORTBY_TYPE = 3;
    public static final int PROFILES_SORTBY_POSITION = 4;
    public static final int ACCOUNTS_SORTBY_USERNAME = 1;
    public static final int ACCOUNTS_SORTBY_ACCESS = 2;
    public static final int TASKS_SORTBY_LASTNAME = 1;
    public static final int TASKS_SORTBY_DUES = 2;
    public static final int TASKS_SORTBY_TRAINED = 3;
    public static final int TASKS_SORTBY_PAPERWORK = 4;
    public static final int TASKS_SORTBY_SHOWDESCTIME = 5;
    public static final int SHOWS_SORTBY_SHOWNAME = 1;
    public static final int SHOWS_SORTBY_DAY = 2;
    public static final int FINANCES_SORTBY_DATE = 1;
    public static final int FINANCES_SORTBY_PROFILE = 2;

    /**
     * profiles()
     * Sends signal to IOController
     *
     * @param type
     * @param sortby
     * @return result of the file generation
     */
    public static boolean profiles(int type, int sortby) {
        Profile[] p = sort(IOController.getAllProfiles(), sortby);
        switch(type) {
            case PROFILE_SIMPLE:
                return IOController.profileSimple(p);
            case PROFILE_CONTACT:
                return IOController.profileContact(p);
            case PROFILE_FULL:
                return IOController.profileFull(p);
        }
        return true;
    }

    /**
     * sort()
     *
     * Sorts the array of Profiles returned from IOController
     * Uses compare()
     *
     * @param arr
     * @param sortby
     * @return the sorted array of Profiles
     */
    public static Profile[] sort(Profile[] arr, int sortby) {
        switch (sortby) {
            case PROFILES_SORTBY_LASTNAME:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> o1.getlName().compareToIgnoreCase(o2.getlName())
                );
                break;
            case PROFILES_SORTBY_FIRSTNAME:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> o1.getfName().compareToIgnoreCase(o2.getfName())
                );
                break;
            case PROFILES_SORTBY_TYPE:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.getType()).compareToIgnoreCase(String.valueOf(o2.getType()))
                );
                break;
            case PROFILES_SORTBY_POSITION:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.getPosition()).compareToIgnoreCase(String.valueOf(o2.getPosition()))
                );
        }
        return arr;
    }

    /**
     * accounts()
     * Sends signal to IOController
     *
     * @param type
     * @param sortby
     * @return result of the file generation
     */
    public static boolean accounts(int type, int sortby) {
        Account[] a = sort(IOController.getAllUsers(), sortby);
        switch(type) {
            case ACCOUNTS_SIMPLE:
                return IOController.accountSimple(a);
            case ACCOUNTS_FULL:
                return IOController.accountFull(a);
        }
        return true;
    }
    
    /**
     * sort()
     *
     * Sorts the array of Accounts returned from IOController
     * Uses compare()
     *
     * @param arr
     * @param sortby
     * @return the sorted array of Accounts
     */
    public static Account[] sort(Account[] arr, int sortby) {
        switch(sortby) {
            case ACCOUNTS_SORTBY_USERNAME:
                Arrays.sort(arr, (Account o1, Account o2)
                        -> o1.getUsername().compareToIgnoreCase(o2.getUsername())
                );
                break;
            case ACCOUNTS_SORTBY_ACCESS:
                Arrays.sort(arr, (Account o1, Account o2)
                        -> String.valueOf(o1.getAccess()).compareToIgnoreCase(String.valueOf(o2.getAccess()))
                );
                break;
        }
        return arr;
    }

    /**
     * tasks()
     * Sends signal to IOController
     *
     * @param type
     * @param sortby
     * @return result of the file generation
     */
    public static boolean tasks(int type, int sortby) {
        Profile[] p = sortTasks(IOController.getAllProfiles(), sortby);
        switch(type) {
            case TASKS_DUES:
                return IOController.taskDues(p);
            case TASKS_TRAINED:
                return IOController.taskTrained(p);
            case TASKS_PAPERWORK:
                return IOController.taskPaperwork(p);
            case TASKS_SHOWDESCTIME:
                return IOController.taskShowDescTime(p);
            case TASKS_FULL:
                return IOController.taskFull(p);
        }
        return true;
    }
    
    /**
     * sortTasks()
     *
     * Sorts the array of Profiles returned from IOController
     * Uses compare()
     *
     * @param arr
     * @param sortby
     * @return the sorted array of Profiles
     */
    public static Profile[] sortTasks(Profile[] arr, int sortby) {
        switch (sortby) {
            case TASKS_SORTBY_LASTNAME:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> o1.getlName().compareToIgnoreCase(o2.getlName())
                );
                break;
            case TASKS_SORTBY_DUES:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.isDuesPaid()).compareToIgnoreCase(String.valueOf(o2.isDuesPaid()))
                );
                break;
            case TASKS_SORTBY_TRAINED:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.isTrained()).compareToIgnoreCase(String.valueOf(o2.isTrained()))
                );
                break;
            case TASKS_SORTBY_PAPERWORK:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.isPaperworkTurnedIn()).compareToIgnoreCase(String.valueOf(o2.isPaperworkTurnedIn()))
                );
                break;
            case TASKS_SORTBY_SHOWDESCTIME:
                Arrays.sort(arr, (Profile o1, Profile o2)
                        -> String.valueOf(o1.isShowDesc_Time()).compareToIgnoreCase(String.valueOf(o2.isShowDesc_Time()))
                );
                break;
        }
        return arr;
    }
    
    /**
     * shows()
     * 
     * Sends signal to IOController
     *
     * @param type
     * @param sortby
     * @return result of the file generation
     */
    public static boolean shows(int type, int sortby) {
        Show[] s = sort(IOController.getAllShows(), sortby);
        switch(type) {
            case SHOWS_SIMPLE:
                return IOController.showSimple(s);
            case SHOWS_FULL:
                return IOController.showFull(s);
        }
        return true;
    }

    /**
     * sort()
     *
     * Sorts the array of Profiles returned from IOController
     * Uses compare()
     *
     * @param arr
     * @param sortby
     * @return the sorted array of Profiles
     */
    public static Show[] sort(Show[] arr, int sortby) {
        switch (sortby) {
            case SHOWS_SORTBY_SHOWNAME:
                Arrays.sort(arr, (Show o1, Show o2)
                        -> o1.getShowName().compareToIgnoreCase(o2.getShowName())
                );
                break;
            case SHOWS_SORTBY_DAY:
                Arrays.sort(arr, (Show o1, Show o2)
                        -> String.valueOf(o1.getDays()[0]).compareToIgnoreCase(String.valueOf(o2.getDays()[0]))
                );
                break;
        }
        return arr;
    }
}
