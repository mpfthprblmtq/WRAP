/**
 * File: IOController.java
 * Desc: Handles all things relating to IO
 * Might be split up into individual classes with relation to each function
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import webradio.Show.Day;
import webradio.Show.Time;

public class IOController {

    // global files
    static File config = new File("config.txt");
    static File accounts = new File("src/app_ext/uDistrib6.txt");
    static File profiles = new File("src/app_ext/rDistrib5.txt");
    static File shows = new File("src/app_ext/sDistrib4.txt");
    static File finances = new File("src/app_ext/fDistrib7.txt");
    static File totals = new File("src/app_ext/fDistrib8.txt");

    // date/time formatting
    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static DateFormat simpledf = new SimpleDateFormat("MM/dd/yyyy");
    static DateFormat filedf = new SimpleDateFormat("MM.dd.yy HH.mm.ss");
    
    // money formatting
    static DecimalFormat money = new DecimalFormat("0.00");

    // globals
    static ArrayList<Profile> data;
    static String s = "///";
    static Profile blankProfile = new Profile("<blank>", "<blank>", "000000000", "0000000000", "<blank>", "<blank>", -1, -1, "<blank>", false, false, false, false);

    /**
     * checkAllIDsForDupe()
     *
     * Checks all assets that have id's for duplication
     *
     * @param id
     * @return
     */
    public static boolean checkAllIDsForDupe(int id) {
        // check profiles
        try (Scanner b_in = new Scanner(new FileReader(profiles))) {
            while (b_in.hasNext()) {

                //read the line and split it into array
                String line = b_in.nextLine();
                String[] str = line.split(s);

                // create the array with new account objects
                if (str[2].equals(id)) {
                    return false;
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        // check finances
        try (Scanner b_in = new Scanner(new FileReader(profiles))) {
            while (b_in.hasNext()) {

                //read the line and split it into array
                String line = b_in.nextLine();
                String[] str = line.split(s);

                // create the array with new account objects
                if (str[0].equals(id)) {
                    return false;
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////
    //
    //      LOGIN AND HASHING
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="LOGIN AND HASHING">
    /**
     * Login()
     *
     * Takes a String username and String password as parameters
     * Generalize root login
     * Create an encrypted version of the password given
     * Read the users file line by line to see if you find a match based
     * on the username and encrypted password
     * If a match is found, return the account
     * If no match is found, return a null account
     *
     * @param username
     * @param password
     * @return a, a new account, result of a successful login
     */
    public static Account Login(String username, String password) {
        if (username.equals("root") && password.equals("admin")) {
            return new Account("root", "admin", 0, "root");
        } else {

            // instantiate the account to null, return if no match found
            Account a = null;
            try (Scanner in = new Scanner(new FileReader(accounts))) {
                while (in.hasNext()) {
                    String line = in.nextLine();
                    String[] str = line.split(s);
                    try {
                        // if the username and password match
                        if (str[0].equals(username) && checkPassword(password, str[1])) {
                            // create a new account from info in file
                            a = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                            // return the new account
                            return a;
                        }
                    } catch (NullPointerException ex) {
                        Util.error(ex.toString(), ex.getMessage());
                    }
                }
                in.close();
            } catch (FileNotFoundException ex) {
                Util.error(ex.toString(), ex.getMessage());
            }
            // return the null profile
            return a;
        }
    } // end Login()

    /**
     * checkPasswordForConfirmation()
     *
     * Basically just takes a username and password parameter and checks in the file
     * against the hashed versions of the passwords and checks for a match
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean checkPasswordForConfirmation(String username, String password) {
        try (Scanner in = new Scanner(new FileReader(accounts))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);

                if (str[0].equals(username) && checkPassword(password, str[1])) {
                    return true;
                }
            }

        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return false;
    }

    /**
     * hashPassword()
     *
     * Takes a plaintext password and hashes it using BCrypt
     *
     * @param password_plaintext
     * @return
     */
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return (hashed_password);
    }

    /**
     * checkPassword()
     *
     * Takes plaintext password and stored hashed password and compares them
     * Returns true for a match, false otherwise
     *
     * @param password_plaintext
     * @param stored_hash
     * @return
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {

        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
            //throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
            Util.error(new java.lang.IllegalArgumentException("Invalid hash provided for comparison").toString(), "Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      USERS/ACCOUNTS
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="USERS/ACCOUNTS">
    /**
     * getAllUsers()
     *
     * Goes through the users file and creates an array of accounts based on the
     * contents of the file
     *
     * @return an array of Accounts
     */
    public static Account[] getAllUsers() {

        // get the total amount of users and make an array from that size
        int total = getTotalUsers();
        Account[] pro = new Account[total];

        // read the file
        int count = 0;
        try (Scanner b_in = new Scanner(new FileReader(accounts))) {
            while (b_in.hasNext()) {

                //read the line and split it into array
                String line = b_in.nextLine();
                String[] str = line.split(s);

                // create the array with new account objects
                if (line != null) {
                    pro[count] = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                    count++;
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return pro;
    }

    /**
     * getTotalUsers()
     *
     * Scans the users text file and counts the number of users
     *
     * @return a count of all users
     */
    public static int getTotalUsers() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(accounts))) {
            while (a_in.hasNextLine()) {
                String not_used_but_necessary_for_some_reason = a_in.nextLine();
                total++;
            }
            a_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return total;
    }

    /**
     * CheckForUsernameDupe()
     *
     * Checks for a username duplication, needed for adding a new user
     * If while scanning the file, it encounters a match, return true
     * Else return false
     *
     * @param u, the username to search
     * @return the result of the search
     */
    public static boolean CheckForUsernameDupe(String u) {

        // read file
        try (Scanner in = new Scanner(new FileReader(accounts))) {
            while (in.hasNext()) {

                // read the line and split it
                String line = in.nextLine();
                String[] str = line.split(s);

                // check if username matches, return true if it does
                try {
                    if (str[0].equals(u)) {
                        return true;
                    }
                } catch (NullPointerException ex) {
                    Util.error(ex.toString(), ex.getMessage());
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // no match found, return false
        return false;
    }

    /**
     * AddUser()
     *
     * Writes a new Account object to the users file at the end Password is
     * encrypted
     *
     * @param p, the account to add
     * @return the result of the addition
     */
    public static boolean AddUser(Account p) {

        // open file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(accounts, true)))) {
            out.println(p.getUsername() + s + hashPassword(p.getPassword()) + s + p.getAccess() + s + p.getName());
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * SearchUser()
     *
     * Searches for a user based on the username given in the users file
     * While scanning the users file, if a match is found, return a new account
     * If no match, return a null account
     *
     * @param username, the account to search
     * @return the account found
     */
    public static Account SearchUser(String username) {
        Account a = null;

        // read the file
        try (Scanner in = new Scanner(new FileReader(accounts))) {
            while (in.hasNext()) {
                // read the line and split it
                String line = in.nextLine();
                String[] str = line.split(s);

                // check if the username matches
                if (str[0].equals(username)) {
                    a = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return a;
    }

    /**
     * DeleteUser()
     *
     * Basically just rewrites the users file, and excludes the account that was
     * passed as a parameter
     *
     * @param username, the account to search
     * @return the result of the deletion
     */
    public static boolean DeleteUser(String username) {

        int total = getTotalUsers();    // for array size
        int count = 0;                  // counter

        // main array of users
        Account[] arr = new Account[total];

        // filling array with all elements that are not the profile to delete
        try (Scanner b_in = new Scanner(new FileReader(accounts))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on / symbol

                // if the profile is not the profile to delete, put it in the array
                if (!str[0].equals(username)) {
                    arr[count] = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                }
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(accounts, false)))) {

            // essentially just skips any null value
            for (int i = 0; i < total; i++) {
                if (arr[i] != null) {
                    out.println(arr[i].toString());
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return true;
    }

    /**
     * changeAccountAccess()
     *
     * Mainly for the root account to change the access of any account
     * Just reads in the file and replaces the account with a new one with the
     * desired access level
     *
     * @param username
     * @param oldAccess
     * @param newAccess
     * @return
     */
    public static boolean changeAccountAccess(String username, String oldAccess, String newAccess) {

        // read the file
        try (Scanner b_in = new Scanner(new FileReader(accounts))) {
            while (b_in.hasNext()) {
                // read the line and split it
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);

                // if the username and access match the parameters
                if (str[0].equals(username) && str[2].equals(oldAccess)) {
                    // create a new account
                    Account a = new Account(str[0], str[1], Integer.valueOf(newAccess), str[3]);
                    // delete then add
                    DeleteUser(username);
                    AddUser(a);

                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return false;
    }

    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      PROFILES
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="PROFILES">
    /**
     * getAllProfiles()
     *
     * Goes through the roster file and creates an array of profiles based on
     * the contents of the file
     *
     * @return an array of Profiles
     */
    public static Profile[] getAllProfiles() {
        // get the size and make array of that size
        int total = getTotalProfiles();
        Profile[] pro = new Profile[total];

        int count = 0;

        // read the file
        try (Scanner b_in = new Scanner(new FileReader(profiles))) {
            while (b_in.hasNext()) {
                // read the line and split it
                String line = b_in.nextLine();
                String[] str = line.split(s);

                // create new Profile objects and increment count
                pro[count] = new Profile(str[0], str[1], str[2], str[3], str[4], str[5], Integer.valueOf(str[6]), Integer.valueOf(str[7]), str[8],
                        Util.toBool(str[9]), Util.toBool(str[10]), Util.toBool(str[11]), Util.toBool(str[12]));
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return pro;
    }

    /**
     * getTotalProfiles()
     *
     * Scans the roster text file and counts the number of profiles
     *
     * @return a count of all profiles
     */
    public static int getTotalProfiles() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(profiles))) {
            while (a_in.hasNextLine()) {
                String not_used_but_necessary_for_some_reason = a_in.nextLine();
                total++;
            }
            a_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return total;
    }

    /**
     * CheckForIDDupe()
     *
     * Checks for a id duplication, needed for adding a new profile If while
     * scanning the file, it encounters a match, return true Else return false
     *
     * @param id, the id to search
     * @return the result of the search
     */
    public static boolean CheckForIDDupe(String id) {
        // read the file
        try (Scanner in = new Scanner(new FileReader(profiles))) {
            while (in.hasNext()) {
                // read the line and split it
                String line = in.nextLine();
                String[] str = line.split(s);

                try {
                    // if the id in the file matches the parameter
                    if (str[2].equals(id)) {
                        // return true if match found
                        return true;
                    }
                } catch (NullPointerException ex) {
                    Util.error(ex.toString(), ex.getMessage());
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // return false if no match found
        return false;
    }

    /**
     * AddProfile()
     *
     * Writes a new Profile object to the roster file at the end
     *
     * @param p, the profile to add
     * @return the result of the addition
     */
    public static boolean AddProfile(Profile p) {

        // open the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(profiles, true)))) {
            out.println(p.toString());
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return false;
        }

        return true;
    }

    /**
     * SearchProfile()
     *
     * Searches for a profile based on the id given in the roster file While
     * scanning the roster file, if a match is found, return a new profile If no
     * match, return a null profile
     *
     * @param id, the id to search
     * @return the profile found
     */
    public static Profile SearchProfile(String id) {
        Profile p = null;

        // read the file
        try (Scanner in = new Scanner(new FileReader(profiles))) {
            while (in.hasNext()) {
                // read the line then split it
                String line = in.nextLine();
                String[] str = line.split(s);

                // if match is found, create new profile 
                if (str[2].equals(id)) {
                    p = new Profile(str[0], str[1], str[2], str[3], str[4], str[5], Integer.valueOf(str[6]), Integer.valueOf(str[7]), str[8],
                            Util.toBool(str[9]), Util.toBool(str[10]), Util.toBool(str[11]), Util.toBool(str[12]));
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // if no match found, return the null profile
        return p;
    }

    /**
     * DeleteProfile()
     *
     * Basically just rewrites the roster file, and excludes the profile that
     * was passed as a parameter
     *
     * @param id, the id to search
     * @return the result of the deletion
     */
    public static boolean DeleteProfile(String id) {
        int total = getTotalProfiles();    // for array size
        int count = 0;                      // counter

        // main array of profiles
        Profile[] arr = new Profile[total];

        // filling array with all elements that are not the profile to delete
        try (Scanner b_in = new Scanner(new FileReader(profiles))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                // if the current person is NOT the person to delete, put it in the array
                if (!str[2].equals(id)) {
                    arr[count] = new Profile(str[0], str[1], str[2], str[3], str[4], str[5], Integer.valueOf(str[6]), Integer.valueOf(str[7]), str[8],
                            Util.toBool(str[9]), Util.toBool(str[10]), Util.toBool(str[11]), Util.toBool(str[12]));
                }
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(profiles, false)))) {

            // essentially just skips any null value
            for (int i = 0; i < total; i++) {
                if (arr[i] != null) {
                    out.println(arr[i].toString());
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return true;
    }

    /**
     * deleteProfilesShowsAsWell()
     *
     * When deleting a profile while they have a show, this option lets you
     * delete their shows that they are hosts of
     *
     * @param id
     */
    static void deleteProfilesShowsAsWell(String id) {
        try (Scanner b_in = new Scanner(new FileReader(shows))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                String[] str2 = str[2].split(",");
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i].equals(id)) {
                        deleteShow(str[0]);
                    }
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }

    /**
     * replaceProfileWithBlank()
     *
     * When deleting a profile while they have a show, this option lets you
     * replace their name with a blank spot
     *
     * @param id
     */
    static void replaceProfileWithBlank(String id) {
        try (Scanner b_in = new Scanner(new FileReader(shows))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                String[] str2 = str[2].split(",");
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i].equals(id)) {

                        // set that host's id to blank
                        str2[i] = "000000000";

                        // delete that old show
                        Show s1 = searchShow(str[0]);
                        deleteShow(s1.getShowName());

                        // make new show and replace the host array
                        Show s2 = s1;
                        s2.setHosts(convertProfileArray(str2));

                        // add the new show
                        addShow(s2);
                    }
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }

    /**
     * checkIfProfileHasAShow()
     *
     * Checks if the profile has a show
     * Yeah, the name is pretty self explanatory
     * Searches the show file, if the id matches any of the hosts, returns true
     *
     * @param id
     * @return the case of if the profile has a show or not
     */
    public static boolean checkIfProfileHasAShow(String id) {
        try (Scanner b_in = new Scanner(new FileReader(shows))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                String[] str2 = str[2].split(",");
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i].equals(id)) {
                        return true;
                    }
                }
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return false;
    }

    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      SHOWS
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="SHOWS">
    /**
     * getAllShows()
     *
     * Reads the shows file and returns an array of show objects
     *
     * @return the array of shows
     */
    public static Show[] getAllShows() {
        // get the size and make array of that size
        int total = getTotalShows();
        Show[] show = new Show[total];

        int count = 0;

        // read the file
        try (Scanner b_in = new Scanner(new FileReader(shows))) {
            while (b_in.hasNext()) {

                // read the line and split it
                String line = b_in.nextLine();
                String[] str = line.split(s);

                String showName = str[0];
                String showDesc = str[1];
                String url = str[5];

                String[] strHostArr = str[2].split(",");
                String[] strDaysArr = str[3].split(",");
                String[] strTimeArr = str[4].split(",");

                Profile[] hostArr = convertProfileArray(strHostArr);
                Day[] daysArr = convertDayArray(strDaysArr);
                Time[] timeArr = convertTimeArray(strTimeArr);

                // create new Show objects and increment count
                show[count] = new Show(showName, showDesc, hostArr, daysArr, timeArr, url);
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return show;
    }

    /**
     * getTotalShows()
     *
     * Scans the shows file and counts the shows
     *
     * @return the number of shows
     */
    public static int getTotalShows() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(shows))) {
            while (a_in.hasNextLine()) {
                String not_used_but_necessary_for_some_reason = a_in.nextLine();
                total++;
            }
            a_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return total;
    }

    /**
     * checkForShowDupe()
     *
     * Scans the file, and compares each name of the show with the given String
     * parameter
     * If it matches, return true (match found)
     * If it parses through the file with no matches, return false (no match found)
     *
     * @param showName
     * @return false for no dupe, true for dupe
     */
    public static boolean CheckForShowDupe(String showName) {
        // read the file
        try (Scanner in = new Scanner(new FileReader(shows))) {
            while (in.hasNext()) {
                // read the line and split it
                String line = in.nextLine();
                String[] str = line.split(s);

                try {
                    // if the name in the file matches the parameter
                    if (str[0].equals(showName)) {
                        // return true if match found
                        return true;
                    }
                } catch (NullPointerException ex) {
                    Util.error(ex.toString(), ex.getMessage());
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // return false if no match found
        return false;
    }

    /**
     * addShow()
     *
     * Adds the show object to the end of the shows file
     *
     * @param show
     * @return the boolean result of the addition
     */
    public static boolean addShow(Show show) {

        // open the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(shows, true)))) {
            out.println(show.toString());
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return false;
        }

        return true;
    }

    /**
     * searchShow()
     *
     * Scans the shows file searching for the name parameter
     * If it finds a match, return the show with that name
     *
     * @param name
     * @return the found show
     */
    public static Show searchShow(String name) {

        // read the file
        try (Scanner in = new Scanner(new FileReader(shows))) {
            while (in.hasNext()) {
                // read the line then split it
                String line = in.nextLine();
                String[] str = line.split(s);

                // if match is found, create new show 
                if (str[0].equals(name)) {
                    String showName = str[0];
                    String showDesc = str[1];
                    String url = str[5];

                    String[] strHostArr = str[2].split(",");
                    String[] strDaysArr = str[3].split(",");
                    String[] strTimeArr = str[4].split(",");

                    // use utility functions to create the right type of array
                    Profile[] hostArr = convertProfileArray(strHostArr);
                    Day[] daysArr = convertDayArray(strDaysArr);
                    Time[] timeArr = convertTimeArray(strTimeArr);

                    // return that new show
                    return new Show(showName, showDesc, hostArr, daysArr, timeArr, url);
                }
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // if no match found, return the null show
        return null;
    }

    /**
     * deleteShow()
     *
     * Scans the shows file, finds the show with the name given
     * When it finds a match, makes that line null
     * It then recreates another array of shows, skipping the now null show
     * Prints that new show array to the output file again
     *
     * @param name
     * @return
     */
    public static boolean deleteShow(String name) {
        int total = getTotalShows();        // for array size
        int count = 0;                      // counter

        // main array of shows
        Show[] arr = new Show[total];

        // filling array with all elements that are not the show to delete
        try (Scanner b_in = new Scanner(new FileReader(shows))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                // if the current show is NOT the show to delete, put it in the array
                if (!str[0].equals(name)) {
                    String showName = str[0];
                    String showDesc = str[1];
                    String url = str[5];

                    String[] strHostArr = str[2].split(",");
                    String[] strDaysArr = str[3].split(",");
                    String[] strTimeArr = str[4].split(",");

                    Profile[] hostArr = convertProfileArray(strHostArr);
                    Day[] daysArr = convertDayArray(strDaysArr);
                    Time[] timeArr = convertTimeArray(strTimeArr);

                    arr[count] = new Show(showName, showDesc, hostArr, daysArr, timeArr, url);
                }
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(shows, false)))) {

            // essentially just skips any null value
            for (int i = 0; i < total; i++) {
                if (arr[i] != null) {
                    out.println(arr[i].toString());
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return true;
    }

    /**
     * convertProfileArray()
     *
     * Utility function to create an array of Profiles from a String array
     *
     * @param arr
     * @return the array of profiles
     */
    public static Profile[] convertProfileArray(String[] arr) {
        Profile[] hostArr = new Profile[arr.length];
        for (int i = 0; i < arr.length; i++) {
            hostArr[i] = SearchProfile(arr[i]);
        }
        return hostArr;
    }

    /**
     * convertDayArray()
     *
     * Utility function to create an array of Days from a String array
     *
     * @param arr
     * @return the array of days
     */
    public static Show.Day[] convertDayArray(String[] arr) {
        Show.Day[] daysArr = new Show.Day[arr.length];
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "SUN":
                    daysArr[i] = Day.SUN;
                    break;
                case "MON":
                    daysArr[i] = Day.MON;
                    break;
                case "TUE":
                    daysArr[i] = Day.TUE;
                    break;
                case "WED":
                    daysArr[i] = Day.WED;
                    break;
                case "THU":
                    daysArr[i] = Day.THU;
                    break;
                case "FRI":
                    daysArr[i] = Day.FRI;
                    break;
                case "SAT":
                    daysArr[i] = Day.SAT;
                    break;
                default:
                    break;
            }
        }
        return daysArr;
    }

    /**
     * convertTimeArray()
     *
     * Utility function to create an array of Times from a String array
     *
     * @param arr
     * @return the array of times
     */
    public static Show.Time[] convertTimeArray(String[] arr) {
        Show.Time[] timeArr = new Show.Time[arr.length];
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "am1200":
                    timeArr[i] = Time.am1200;
                    break;
                case "am1230":
                    timeArr[i] = Time.am1230;
                    break;
                case "am0100":
                    timeArr[i] = Time.am0100;
                    break;
                case "am0130":
                    timeArr[i] = Time.am0130;
                    break;
                case "am0200":
                    timeArr[i] = Time.am0200;
                    break;
                case "am0230":
                    timeArr[i] = Time.am0230;
                    break;
                case "am0300":
                    timeArr[i] = Time.am0300;
                    break;
                case "am0330":
                    timeArr[i] = Time.am0330;
                    break;
                case "am0400":
                    timeArr[i] = Time.am0400;
                    break;
                case "am0430":
                    timeArr[i] = Time.am0430;
                    break;
                case "am0500":
                    timeArr[i] = Time.am0500;
                    break;
                case "am0530":
                    timeArr[i] = Time.am0530;
                    break;
                case "am0600":
                    timeArr[i] = Time.am0600;
                    break;
                case "am0630":
                    timeArr[i] = Time.am0630;
                    break;
                case "am0700":
                    timeArr[i] = Time.am0700;
                    break;
                case "am0730":
                    timeArr[i] = Time.am0730;
                    break;
                case "am0800":
                    timeArr[i] = Time.am0800;
                    break;
                case "am0830":
                    timeArr[i] = Time.am0830;
                    break;
                case "am0900":
                    timeArr[i] = Time.am0900;
                    break;
                case "am0930":
                    timeArr[i] = Time.am0930;
                    break;
                case "am1000":
                    timeArr[i] = Time.am1000;
                    break;
                case "am1030":
                    timeArr[i] = Time.am1030;
                    break;
                case "am1100":
                    timeArr[i] = Time.am1100;
                    break;
                case "am1130":
                    timeArr[i] = Time.am1130;
                    break;
                case "pm1200":
                    timeArr[i] = Time.pm1200;
                    break;
                case "pm1230":
                    timeArr[i] = Time.pm1230;
                    break;
                case "pm0100":
                    timeArr[i] = Time.pm0100;
                    break;
                case "pm0130":
                    timeArr[i] = Time.pm0130;
                    break;
                case "pm0200":
                    timeArr[i] = Time.pm0200;
                    break;
                case "pm0230":
                    timeArr[i] = Time.pm0230;
                    break;
                case "pm0300":
                    timeArr[i] = Time.pm0300;
                    break;
                case "pm0330":
                    timeArr[i] = Time.pm0330;
                    break;
                case "pm0400":
                    timeArr[i] = Time.pm0400;
                    break;
                case "pm0430":
                    timeArr[i] = Time.pm0430;
                    break;
                case "pm0500":
                    timeArr[i] = Time.pm0500;
                    break;
                case "pm0530":
                    timeArr[i] = Time.pm0530;
                    break;
                case "pm0600":
                    timeArr[i] = Time.pm0600;
                    break;
                case "pm0630":
                    timeArr[i] = Time.pm0630;
                    break;
                case "pm0700":
                    timeArr[i] = Time.pm0700;
                    break;
                case "pm0730":
                    timeArr[i] = Time.pm0730;
                    break;
                case "pm0800":
                    timeArr[i] = Time.pm0800;
                    break;
                case "pm0830":
                    timeArr[i] = Time.pm0830;
                    break;
                case "pm0900":
                    timeArr[i] = Time.pm0900;
                    break;
                case "pm0930":
                    timeArr[i] = Time.pm0930;
                    break;
                case "pm1000":
                    timeArr[i] = Time.pm1000;
                    break;
                case "pm1030":
                    timeArr[i] = Time.pm1030;
                    break;
                case "pm1100":
                    timeArr[i] = Time.pm1100;
                    break;
                case "pm1130":
                    timeArr[i] = Time.pm1130;
                    break;
                default:
                    break;
            }
        }
        return timeArr;
    }

    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      FINANCES
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="FINANCES">
    /**
     * getAllTransactions()
     *
     * Goes through the roster file and creates an array of transactions based on
     * the contents of the file
     *
     * @return an array of transactions
     */
    public static Transaction[] getAllTransactions() {
        // get the size and make array of that size
        int total = getTotalTransactions();
        Transaction[] t = new Transaction[total];

        int count = 0;

        // read the file
        try (Scanner b_in = new Scanner(new FileReader(finances))) {
            while (b_in.hasNext()) {
                // read the line and split it
                String line = b_in.nextLine();
                String[] str = line.split(s);

                // create new Transaction objects and increment count
                if (total > 0) {
                    t[count] = new Transaction(Integer.valueOf(str[0]),
                            str[1],
                            simpledf.parse(str[2]),
                            str[3],
                            Double.valueOf(str[4]),
                            str[5],
                            str[6]);
                    count++;
                }
            }
            b_in.close();
        } catch (FileNotFoundException | ParseException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return t;
    }

    /**
     * getTotalTransactions()
     *
     * Scans the finances text file and counts the number of transactions
     *
     * @return a count of all transactions
     */
    public static int getTotalTransactions() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(finances))) {
            while (a_in.hasNextLine()) {
                String not_used_but_necessary_for_some_reason = a_in.nextLine();
                total++;
            }
            a_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return total;
    }

    /**
     * addTransaction()
     *
     * Writes a new Profile object to the roster file at the end
     *
     * @param t, the transaction to add
     * @return the result of the addition
     */
    public static boolean addTransaction(Transaction t) {
        // open the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(finances, true)))) {
            out.println(t.toString());
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return false;
        }

        return true;
    }

    /**
     * SearchTransaction()
     *
     * Searches for a transaction based on the id given in the transaction file 
     * While scanning the roster file, if a match is found, return a new transaction 
     * If no match, return a null transaction
     *
     * @param id, the id to search
     * @return the transaction found
     */
    public static Transaction searchTransaction(String id) {
        Transaction t = null;

        // read the file
        try (Scanner in = new Scanner(new FileReader(finances))) {
            while (in.hasNext()) {
                // read the line then split it
                String line = in.nextLine();
                String[] str = line.split(s);

                // if match is found, create new profile 
                if (str[0].equals(id)) {
                    t = new Transaction(Integer.valueOf(str[0]),
                            str[1],
                            simpledf.parse(str[2]),
                            str[3],
                            Double.valueOf(str[4]),
                            str[5],
                            str[6]);
                }
            }
            in.close();
        } catch (FileNotFoundException | ParseException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        // if no match found, return the null profile
        return t;
    }
    
    /**
     * deleteTransaction()
     *
     * Basically just rewrites the transaction file, and excludes the transaction that
     * was passed as a parameter
     *
     * @param id, the id to search
     * @return the result of the deletion
     */
    public static boolean deleteTransaction(String id) {
        int total = getTotalTransactions();    // for array size
        int count = 0;                      // counter

        // main array of transactions
        Transaction[] arr = new Transaction[total];

        // filling array with all elements that are not the transaction to delete
        try (Scanner b_in = new Scanner(new FileReader(finances))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on /// symbol

                // if the current transaction is NOT the transaction to delete, put it in the array
                if (!str[0].equals(id)) {
                    arr[count] = new Transaction(Integer.valueOf(str[0]),
                            str[1],
                            simpledf.parse(str[2]),
                            str[3],
                            Double.valueOf(str[4]),
                            str[5],
                            str[6]);
                }
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException | ParseException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(finances, false)))) {

            // essentially just skips any null value
            for (int i = 0; i < total; i++) {
                if (arr[i] != null) {
                    out.println(arr[i].toString());
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return true;
    }
    
    /**
     * getAccountTotals()
     * 
     * Returns the totals in each account
     * @return 
     */
    public static double[] getAccountTotals() {
        double[] d = new double[3];
        
        try (Scanner b_in = new Scanner(new FileReader(totals))) {
            int n = 0;
            while (b_in.hasNext()) {
                d[n] = b_in.nextDouble();
                n++;
            }
            b_in.close();
        } catch (FileNotFoundException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
        return d;
    }
    
    public static boolean updateAccountTotals(double[] d) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(totals, false)))) {
            out.println(d[0]);
            out.println(d[1]);
            out.println(d[2]);
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      REPORTS
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="REPORTS">
    /**
     * getHeader()
     *
     * Returns the header for each report
     *
     * @return
     */
    public static String getHeader() {
        return " __          _______            _____      ####################################################################\r\n"
                + " \\ \\        / /  __ \\     /\\   |  __ \\     #                                                                  #\r\n"
                + "  \\ \\  /\\  / /| |__) |   /  \\  | |__) |    #    Report generated by W.R.A.P. - Web Radio Assistant Program    #\r\n"
                + "   \\ \\/  \\/ / |  _  /   / /\\ \\ |  ___/     #    For best viewing in Notepad, go to Format -> Font... and      #\r\n"
                + "    \\  /\\  /  | | \\ \\  / ____ \\| |         #    set your Font to Consolas, and your font size to 12.          #\r\n"
                + "     \\/  \\/   |_|  \\_\\/_/    \\_\\_|         #                                                                  #\r\n"
                + "                                           ####################################################################";
    }

    /**
     * profileSimple()
     *
     * Generates a simple report that includes just the name and id
     *
     * @param p
     * @return
     */
    public static File profileSimple(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Profiles (Simple) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Profiles (Simple)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %n", "#", "Last Name", "First Name", "SIUe ID");
            out.println("------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %n", i, p[i].getlName(), p[i].getfName(), p[i].getId());
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * profileContact()
     *
     * Generates a report for contact information, including
     * Last name, First name, ID, phone, and emails
     *
     * @param p
     * @return
     */
    public static File profileContact(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Profiles (Contact) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Profiles (Contact)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-18s %-20s %-30s %n", "#", "Last Name", "First Name", "SIUe ID", "Phone", "SIUe Email", "Preferred Email");
            out.println("-------------------------------------------------------"
                    + "-------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-18s %-20s %-30s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), Util.getPhone(p[i].getPhone()),
                            p[i].getSiueEmail(), p[i].getPrefEmail());
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * profileFull()
     *
     * Generates a full report of all profiles
     *
     * @param p
     * @return
     */
    public static File profileFull(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Profiles (Full) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {

            out.println(getHeader());
            out.println("Profiles (Full)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-18s %-20s %-30s %-10s %-15s %-20s %n",
                    "#", "Last Name", "First Name", "SIUe ID", "Phone", "SIUe Email", "Preferred Email",
                    "Type", "Position", "Notes");
            out.println("-------------------------------------------------------"
                    + "-------------------------------------------------------"
                    + "-------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-18s %-20s %-30s %-10s %-15s %-20s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), Util.getPhone(p[i].getPhone()),
                            p[i].getSiueEmail(), p[i].getPrefEmail(), getType(p[i].getType()),
                            getPosition(p[i].getPosition()), p[i].getNotes());
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * accountSimple()
     *
     * Generates a simple report that includes just the username and access
     *
     * @param a
     * @return
     */
    public static File accountSimple(Account[] a) {

        // creating the file name
        Date date = new Date();
        String filename = "Accounts (Simple) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Accounts (Simple)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-6s %n", "#", "Username", "Access");
            out.println("------------------------------------------------");
            for (int i = 0; i < a.length; i++) {
                out.printf("%-3s %-15s %-6s %n", i + 1, a[i].getUsername(), a[i].getAccess());
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * accountsFull()
     *
     * Generates a report of accounts that includes the username, access and name
     *
     * @param a
     * @return
     */
    public static File accountFull(Account[] a) {

        // creating the file name
        Date date = new Date();
        String filename = "Accounts (Full) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Accounts (Full)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-6s %n", "#", "Username", "Name", "Access");
            out.println("------------------------------------------------");
            for (int i = 0; i < a.length; i++) {
                out.printf("%-3s %-15s %-15s %-6s %n", i + 1, a[i].getUsername(), a[i].getName(), a[i].getAccess());
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * taskDues()
     *
     * Generates the report for dues paid
     *
     * @param p
     * @return
     */
    public static File taskDues(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Tasks (Dues) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Tasks (Dues)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-5s %n", "#", "Last Name", "First Name", "SIUe ID", "Dues Paid");
            out.println("------------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-5s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), getTask(p[i].isDuesPaid()));
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * taskTrained()
     *
     * Generates the report for being board trained
     *
     * @param p
     * @return
     */
    public static File taskTrained(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Tasks (Trained) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Tasks (Trained)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-5s %n", "#", "Last Name", "First Name", "SIUe ID", "Trained");
            out.println("------------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-5s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), getTask(p[i].isTrained()));
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * taskDues()
     *
     * Generates the report for paperwork turned in
     *
     * @param p
     * @return
     */
    public static File taskPaperwork(Profile[] p) {

        // creating the file name
        Date date = new Date();
        String filename = "Tasks (Paperwork) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Tasks (Paperwork)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-5s %n", "#", "Last Name", "First Name", "SIUe ID", "Paperwork");
            out.println("------------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-5s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), getTask(p[i].isPaperworkTurnedIn()));
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * taskDues()
     *
     * Generates the report for a show description and time
     * turned in
     *
     * @param p
     * @return
     */
    public static File taskShowDescTime(Profile[] p) {
        // creating the file name
        Date date = new Date();
        String filename = "Tasks (Show Desc_Time) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Tasks (Show Desc/Time)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-5s %n", "#", "Last Name", "First Name", "SIUe ID", "Show Desc/Time");
            out.println("------------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-5s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(), getTask(p[i].isShowDesc_Time()));
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * taskDues()
     *
     * Generates the full report for tasks
     *
     * @param p
     * @return
     */
    public static File taskFull(Profile[] p) {

// creating the file name
        Date date = new Date();
        String filename = "Tasks (Full) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Tasks (Full)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-15s %-15s %-12s %-5s %-8s %-10s %-15s %n",
                    "#", "Last Name", "First Name", "SIUe ID", "Dues", "Trained", "Paperwork", "Show Desc/Time");
            out.println("------------------------------------------------------------------------------");
            for (int i = 0; i < p.length; i++) {
                if (!p[i].getId().equals("000000000")) {
                    out.printf("%-3s %-15s %-15s %-12s %-5s %-8s %-10s %-15s %n",
                            i, p[i].getlName(), p[i].getfName(), p[i].getId(),
                            getTask(p[i].isDuesPaid()), getTask(p[i].isTrained()),
                            getTask(p[i].isPaperworkTurnedIn()), getTask(p[i].isShowDesc_Time()));
                }
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * showSimple()
     *
     * Generates a simple report of all shows
     *
     * @param s
     * @return
     */
    public static File showSimple(Show[] s) {

        // creating the file name
        Date date = new Date();
        String filename = "Shows (Simple) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Shows (Simple)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            out.println();
            out.printf("%-3s %-30s %n", "#", "Show Name");
            out.println("---------------------------------------");
            for (int i = 0; i < s.length; i++) {
                out.printf("%-3s %-30s %n", i + 1, s[i].getShowName());
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * showFull()
     *
     * Generates a full report of all shows
     *
     * @param s
     * @return
     */
    public static File showFull(Show[] s) {

        // creating the file name
        Date date = new Date();
        String filename = "Shows (Full) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Shows (Full)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());

            for (int i = 0; i < s.length; i++) {
                out.println();
                out.println("-------------------------------------------------------");
                out.println();
                out.println("Show Name:    " + s[i].getShowName());
                out.println("Host(s):      " + s[i].getHostsString());
                out.println();
                out.println("Show time(s): " + s[i].getDays_Times());
                out.println();
                out.println("Description:\n");
                String desc = s[i].getShowDesc();
                String[] str = desc.split(" ");
                for (int j = 0; j < str.length; j++) {
                    out.print(str[j] + " ");
                    if (j % 10 == 0 && j != 0) {
                        out.print("\r\n");
                    }
                }
                out.println();
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }

    /**
     * financesTransactions()
     *
     * Generates a full report of all shows
     *
     * @param t
     * @return
     */
    public static File financeTransactions(Transaction[] t) {

        // creating the file name
        Date date = new Date();
        String filename = "Finances (Transactions) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Finances (Transactions)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());

            for (int i = 0; i < t.length; i++) {
                out.println();
                out.println("-------------------------------------------------------");
                out.println();
                out.println("ID:         " + t[i].getID());
                out.println("Store:      " + t[i].getStore());
                out.println("Date:       " + simpledf.format(t[i].getDate()));
                out.println("Purchaser:  " + t[i].getName());
                out.println("Amount:     $" + money.format(t[i].getAmount()));
                out.println();
                out.println("Reason:     ");
                String reason = t[i].getReason();
                String[] str = reason.split(" ");
                for (int j = 0; j < str.length; j++) {
                    out.print(str[j] + " ");
                    if (j % 10 == 0 && j != 0) {
                        out.print("\r\n            ");
                    }
                }
                out.println();
                out.println();
                out.println("Notes:      ");
                String notes = t[i].getNotes();
                String[] str2 = notes.split(" ");
                for (int j = 0; j < str2.length; j++) {
                    out.print(str2[j] + " ");
                    if (j % 10 == 0 && j != 0) {
                        out.print("\r\n            ");
                    }
                }
                out.println();
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }
    
    /**
     * financeFull()
     *
     * Generates a full report of all shows
     *
     * @param t
     * @return
     */
    public static File financeFull(Transaction[] t) {

        // creating the file name
        Date date = new Date();
        String filename = "Finances (Full) " + filedf.format(date);
        File report = new File("Reports/" + filename + ".txt");

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(report, false)))) {
            out.println(getHeader());
            out.println("Finances (Full)");
            out.println("Date: " + df.format(date));
            out.println("Generated by: " + Main.p.getUsername());
            
            double[] d = getAccountTotals();
            
            out.println();
            out.println("ACCOUNTS:");
            out.println("   Bank Account:   $" + money.format(d[0]));
            out.println("   8-Account:      $" + money.format(d[1]));
            out.println("   Cash:           $" + money.format(d[2]));
            out.println();
            
            
            for (int i = 0; i < t.length; i++) {
                out.println();
                out.println("-------------------------------------------------------");
                out.println();
                out.println("ID:         " + t[i].getID());
                out.println("Store:      " + t[i].getStore());
                out.println("Date:       " + simpledf.format(t[i].getDate()));
                out.println("Purchaser:  " + t[i].getName());
                out.println("Amount:     $" + money.format(t[i].getAmount()));
                out.println();
                out.println("Reason:     ");
                String reason = t[i].getReason();
                String[] str = reason.split(" ");
                for (int j = 0; j < str.length; j++) {
                    out.print(str[j] + " ");
                    if (j % 10 == 0 && j != 0) {
                        out.print("\r\n            ");
                    }
                }
                out.println();
                out.println();
                out.println("Notes:      ");
                String notes = t[i].getNotes();
                String[] str2 = notes.split(" ");
                for (int j = 0; j < str2.length; j++) {
                    out.print(str2[j] + " ");
                    if (j % 10 == 0 && j != 0) {
                        out.print("\r\n            ");
                    }
                }
                out.println();
                out.println();
            }
            out.close();
            return report;
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            return null;
        }
    }
    
    /**
     * getType()
     *
     * returns the type of profile based on a number
     *
     * @param type
     * @return
     */
    public static String getType(int type) {
        switch (type) {
            case 0:
                return "DJ";
            case 1:
                return "Member";
            case 2:
                return "Prospect";
            case 3:
                return "Advisor";
            default:
                return "";
        }
    }

    /**
     * getPosition()
     *
     * Returns the position of a profile based on a number
     *
     * @param position
     * @return
     */
    public static String getPosition(int position) {
        switch (position) {
            case 0:
                return "President";
            case 1:
                return "Vice President";
            case 2:
                return "Treasurer";
            case 3:
                return "SM Manager";
            case 4:
                return "Secretary";
            case 5:
                return "Tech Officer";
            default:
                return "";
        }
    }

    /**
     * getTask()
     *
     * returns an "X" if the task is true
     *
     * @param b
     * @return
     */
    public static String getTask(boolean b) {
        if (b) {
            return "X";
        } else {
            return "";
        }
    }
    // </editor-fold>
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      BUGS AND SUGGESTION REPORTING
    //
    ////////////////////////////////////////////////////////////////////////////
    // <editor-fold defaultstate="collapsed" desc="BUGS AND SUGGESTION REPORTING">
    /**
     * reportBug()
     *
     * Creates a new file based on date and time
     * Includes the name, date/time, and description of the bug
     * Since word wrapping is super not easy to hardcode, I did it a fun way
     *
     * @param name
     * @param report
     */
    public static void reportBug(String name, String report) {
        // creating the file name
        Date date = new Date();
        String filename = filedf.format(date);
        File bug = new File("src/bugreports/bugs/" + filename + ".txt");

        // creating the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(bug, false)))) {
            // header with name and date
            out.println("Name:         " + name);
            out.println("Date:         " + df.format(date));
            out.println("Reported by:  " + Main.p.getUsername());
            out.println("");

            // description
            // basically just splits the string as an array and split on space character
            // every 10 elements in the new String array, print a newline
            out.println("Description:\n");
            String[] str = report.split(" ");
            for (int i = 0; i < str.length; i++) {
                out.print(str[i] + " ");
                if (i % 10 == 0 && i != 0) {
                    out.print("\r\n");
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }

    /**
     * makeSuggestion()
     *
     * Creates a new file based on date and time
     * Includes the name, date/time, and description of the suggestion
     * Since word wrapping is super not easy to hardcode, I did it a fun way
     *
     * @param name
     * @param report
     */
    public static void makeSuggestion(String name, String report) {
        // creating the file name
        Date date = new Date();
        String filename = filedf.format(date);
        File bug = new File("src/bugreports/suggestions/" + filename + ".txt");

        // creating the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(bug, false)))) {
            // header with name and date
            out.println("Name:         " + name);
            out.println("Date:         " + df.format(date));
            out.println("Reported by:  " + Main.p.getUsername());
            out.println("");

            // description
            // basically just splits the string as an array and split on space character
            // every 10 elements in the new String array, print a newline
            out.println("Description:\n");
            String[] str = report.split(" ");
            for (int i = 0; i < str.length; i++) {
                out.print(str[i] + " ");
                if (i % 10 == 0 && i != 0) {
                    out.print("\r\n");
                }
            }
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }

    // </editor-fold>
    
} // end IOController
