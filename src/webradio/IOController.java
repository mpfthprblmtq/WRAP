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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class IOController {

    // global files
    static File config = new File("config.txt");
    static File accounts = new File("src\\app_ext\\uDistrib6.dll");
    static File profiles = new File("src\\app_ext\\rDistrib5.dll");
    static File shows = new File("src\\app_ext\\sDistrib4.dll");

    // date/time formatting
    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static DateFormat filedf = new SimpleDateFormat("MM.dd.yy HH.mm.ss");

    // globals
    static ArrayList<Profile> data;
    static String s = "///";

    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      LOGIN AND HASHING
    //
    ////////////////////////////////////////////////////////////////////////////
    
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
            return new Account("root", "admin", 0, "Pat");
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
                    } catch (NullPointerException e) {
                        System.err.println(e);
                    }
                }
                in.close();
            } catch (FileNotFoundException e) {
                System.err.println(e);
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

        } catch (FileNotFoundException e) {
            System.err.println(e);
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
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //
    //      USERS/ACCOUNTS
    //
    ////////////////////////////////////////////////////////////////////////////
    
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
                } catch (NullPointerException e) {
                    System.err.println(e);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (IOException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (IOException e) {
            System.err.println(e);
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
                if(str[0].equals(username) && str[2].equals(oldAccess)) {
                    // create a new account
                    Account a = new Account(str[0], str[1], Integer.valueOf(newAccess), str[3]);
                    // delete then add
                    DeleteUser(username);
                    AddUser(a);
                    
                    return true;
                }
             }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return false;
    }
    
    
    
    

    ////////////////////////////////////////////////////////////////////////////
    //
    //      PROFILES
    //
    ////////////////////////////////////////////////////////////////////////////
    
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
                } catch (NullPointerException e) {
                    System.err.println(e);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (IOException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (FileNotFoundException e) {
            System.err.println(e);
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
        } catch (IOException e) {
            System.err.println(e);
        }
        return true;
    }

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
        File bug = new File("src\\bugreports\\bugs\\" + filename + ".txt");

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
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                        e,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
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
        File bug = new File("src\\bugreports\\suggestions\\" + filename + ".txt");

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
        } catch (IOException e) {
            System.err.println(e);
        }
    }
} // end IOController
