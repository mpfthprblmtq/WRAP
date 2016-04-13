/**
 * File: IOController.java
 * Desc: Handles all things relating to IO
 *       Might be split up into individual classes with relation to each function
 *
 * Author: Pat Ripley
 */

package webradio;

// imports
import java.io.*;
import java.util.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class IOController {

    // global files
    static File config   = new File("config.txt");
    static File accounts = new File("src\\app_ext\\uDistrib6.dll");
    static File profiles = new File("src\\app_ext\\rDistrib5.dll");
    static File shows    = new File("src\\app_ext\\sDistrib4.dll");

    // date/time formatting
    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static DateFormat filedf = new SimpleDateFormat("MM.dd.yy HH.mm.ss");

    // globals
    static ArrayList<Profile> data;
    static String s = "///";

    // encryption/decryption variables
    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,};

    /*
     *   _                 _       
     *  | |               (_)      
     *  | |     ___   __ _ _ _ __  
     *  | |    / _ \ / _` | | '_ \ 
     *  | |___| (_) | (_| | | | | |
     *  |______\___/ \__, |_|_| |_|
     *                __/ |        
     *               |___/         
     */
    
    /**
     * Login()
     * 
     * Takes a String username and String password as parameters
     * Generalize root login
     * Create an encrypted version of the password given
     * Read the users file line by line to see if you find a match based
     *  on the username and encrypted password
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
            // encrypted password
            String ePass = "";

            try {
                // store the encrypted password in ePass
                ePass = encrypt(password);
            } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
                System.err.println(ex);
            }

            // instantiate the account to null, return if no match found
            Account a = null;
            try (Scanner in = new Scanner(new FileReader(accounts))) {
                while (in.hasNext()) {
                    String line = in.nextLine();
                    String[] str = line.split(s);
                    try {
                        // if the username and password match
                        if (str[0].equals(username) && str[1].equals(ePass)) {
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

    /*
     *   _    _                   
     *  | |  | |                  
     *  | |  | |___  ___ _ __ ___ 
     *  | |  | / __|/ _ \ '__/ __|
     *  | |__| \__ \  __/ |  \__ \
     *   \____/|___/\___|_|  |___/
     */
    
    /**
     * getAllUsers()
     * 
     * Goes through the users file and creates an array of accounts based
     *  on the contents of the file
     * 
     * @return an array of Accounts
     */
    public static Account[] getAllUsers() {

        int total = getTotalUsers();
        Account[] pro = new Account[total];

        int count = 0;
        try (Scanner b_in = new Scanner(new FileReader(accounts))) {
            while (b_in.hasNextLine()) {
                String line = b_in.nextLine();
                String[] str = line.split(s);

                pro[count] = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                count++;
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
                String line = a_in.nextLine();
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
        try (Scanner in = new Scanner(new FileReader(accounts))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);
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
        return false;
    }

    /**
     * AddUser()
     * 
     * Writes a new Account object to the users file at the end
     * Password is encrypted
     * 
     * @param p, the account to add
     * @return the result of the addition
     */
    public static boolean AddUser(Account p) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(accounts, true)))) {
            out.println(p.getUsername() + s + encrypt(p.getPassword()) + s + p.getAccess() + s + p.getName());
            out.close();
        } catch (IOException e) {
            System.err.println(e);
            return false;
        } catch (GeneralSecurityException ex) {
            System.err.println(ex);
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

        try (Scanner in = new Scanner(new FileReader(accounts))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);

                if (str[0].equals(username)) {
                    a = new Account(str[0], decrypt(str[1]), Integer.valueOf(str[2]), str[3]);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (GeneralSecurityException | IOException ex) {
            System.err.println(ex);
        }
        return a;
    }

    /**
     * DeleteUser()
     * 
     * Basically just rewrites the users file, and excludes the account that 
     * was passed as a parameter
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

    /*
     *   _____            __ _ _           
     *  |  __ \          / _(_) |          
     *  | |__) | __ ___ | |_ _| | ___  ___ 
     *  |  ___/ '__/ _ \|  _| | |/ _ \/ __|
     *  | |   | | | (_) | | | | |  __/\__ \
     *  |_|   |_|  \___/|_| |_|_|\___||___/
     */
    
    /**
     * getAllProfiles()
     * 
     * Goes through the roster file and creates an array of profiles based
     *  on the contents of the file
     * 
     * @return an array of Profiles
     */
    public static Profile[] getAllProfiles() {
        int total = getTotalProfiles();
        Profile[] profiles = new Profile[total];

        int count = 0;

        try (Scanner b_in = new Scanner(new FileReader(IOController.profiles))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();
                String[] str = line.split(s);
                profiles[count] = new Profile(str[0], str[1], str[2], str[3], str[4], str[5], Integer.valueOf(str[6]), Integer.valueOf(str[7]), str[8],
                        Util.toBool(str[9]), Util.toBool(str[10]), Util.toBool(str[11]), Util.toBool(str[12]));
                count++;
            }

            b_in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        return profiles;
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
                String line = a_in.nextLine();
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
     * Checks for a id duplication, needed for adding a new profile
     * If while scanning the file, it encounters a match, return true
     * Else return false
     * 
     * @param id, the id to search
     * @return the result of the search
     */
    public static boolean CheckForIDDupe(String id) {
        try (Scanner in = new Scanner(new FileReader(profiles))) {
            while (in.hasNext()) {
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
     * Searches for a profile based on the id given in the roster file
     * While scanning the roster file, if a match is found, return a new profile
     * If no match, return a null profile
     * 
     * @param id, the id to search
     * @return the profile found
     */
    public static Profile SearchProfile(String id) {
        Profile p = null;

        try (Scanner in = new Scanner(new FileReader(profiles))) {
            while (in.hasNext()) {
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
     * Since word wrapping is super fun to hardcode, I did it a fun way
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
            System.err.println(e);
        }
    }
    
    /**
     * makeSuggestion()
     * 
     * Creates a new file based on date and time
     * Includes the name, date/time, and description of the suggestion
     * Since word wrapping is super fun to hardcode, I did it a fun way
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

    /*
     *   ______                             _   _             
     *  |  ____|                           | | (_)            
     *  | |__   _ __   ___ _ __ _   _ _ __ | |_ _  ___  _ __  
     *  |  __| | '_ \ / __| '__| | | | '_ \| __| |/ _ \| '_ \ 
     *  | |____| | | | (__| |  | |_| | |_) | |_| | (_) | | | |
     *  |______|_| |_|\___|_|   \__, | .__/ \__|_|\___/|_| |_|
     *                           __/ | |                      
     *                          |___/|_|                      
     *
     */
    private static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // This class is internal
        // should probably use a different implementation
        return new BASE64Encoder().encode(bytes);
    }

    private static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private static byte[] base64Decode(String property) throws IOException {
        // This class is internal
        // should probably use a different implemtation
        return new BASE64Decoder().decodeBuffer(property);
    }
} // end IOController
