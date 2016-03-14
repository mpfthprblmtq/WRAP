package webradio;

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

    static File config = new File("config.txt");
    static File passwords = new File("src\\files\\users.txt");
    static File rawroster = new File("src\\files\\rawroster.txt");

    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static DateFormat filedf = new SimpleDateFormat("MM.dd.yy");

    static ArrayList<Profile> data;
    static String s = "///";

    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,};

    public static Account Login(String username, String password) {
        if (username.equals("root") && password.equals("admin")) {
            return new Account("root", "admin", 0, "Pat");
        } else {
            String ePass = "";

            try {
                ePass = encrypt(password);
            } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
                System.err.println(ex);
            }

            Account a = null;
            try (Scanner in = new Scanner(new FileReader(passwords))) {
                while (in.hasNext()) {
                    String line = in.nextLine();
                    String[] str = line.split(s);
                    try {
                        if (str[0].equals(username) && str[1].equals(ePass)) {
                            a = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                            break;
                        } else {
                            a = new Account("///", "///", -1, "///");
                        }
                    } catch (NullPointerException e) {
                        System.err.println(e);
                    }
                }
                in.close();
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
            // Returns either null or a good profile
            return a;
        }
    }

    public static Account[] getAllUsers() {

        int total = getTotalUsers();
        Account[] pro = new Account[total];

        int count = 0;
        try (Scanner b_in = new Scanner(new FileReader(passwords))) {
            while (b_in.hasNextLine()) {
                String line = b_in.nextLine();
                String[] str = line.split(s);

                //In order for this to work there has to be at least one user
                pro[count] = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        return pro;
    }

    public static int getTotalUsers() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(passwords))) {
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

    public static boolean CheckForUsernameDupe(String u) {
        try (Scanner in = new Scanner(new FileReader(passwords))) {
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

    public static boolean AddUser(Account p) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(passwords, true)))) {
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

    public static Account SearchUser(String username) {
        Account p = null;

        try (Scanner in = new Scanner(new FileReader(passwords))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);

                if (str[0].equals(username)) {
                    p = new Account(str[0], decrypt(str[1]), Integer.valueOf(str[2]), str[3]);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (GeneralSecurityException | IOException ex) {
            System.err.println(ex);
        }
        return p;
    }

    public static boolean DeleteUser(Account p) {

        int total = getTotalUsers();    // for array size
        int count = 0;                  // counter

        // main array of users
        Account[] arr = new Account[total];

        // filling array with all elements that are not the profile to delete
        try (Scanner b_in = new Scanner(new FileReader(passwords))) {
            while (b_in.hasNext()) {
                String line = b_in.nextLine();      // create array from each line
                String[] str = line.split(s);       // split it on / symbol

                // if the profile is not the profile to delete, put it in the array
                if (!str[0].equals(p.getUsername())) {
                    arr[count] = new Account(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                }
                count++;
            }
            b_in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        // refilling the text file with new array
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(passwords, false)))) {

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

    
    
    
    
    
    
    
    public static Profile[] getAllProfiles() {
        int total = getTotalProfiles();
        Profile[] profiles = new Profile[total];

        int count = 0;

        try (Scanner b_in = new Scanner(new FileReader(rawroster))) {
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

    public static int getTotalProfiles() {
        int total = 0;
        try (Scanner a_in = new Scanner(new FileReader(rawroster))) {
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

    public static boolean CheckForIDDupe(String id) {
        try (Scanner in = new Scanner(new FileReader(rawroster))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);
                try {
                    if (str[2].equals(id)) {
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

    public static boolean AddProfile(Profile p) {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(rawroster, true)))) {
            out.println(p.toString());
            out.close();
        } catch (IOException e) {
            System.err.println(e);
            return false;
        }

        return true;
    }

    public static Profile SearchProfile(String id) {
        Profile p = null;

        try (Scanner in = new Scanner(new FileReader(rawroster))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] str = line.split(s);

                if (str[2].equals(id)) {
                    p = new Profile(str[0], str[1], str[2], str[3], str[4], str[5], Integer.valueOf(str[6]), Integer.valueOf(str[7]), str[8],
                            Util.toBool(str[9]), Util.toBool(str[10]), Util.toBool(str[11]), Util.toBool(str[12]));
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return p;
    }

    public static boolean DeletePerson(String id) {
        int total = getTotalProfiles();    // for array size
        int count = 0;                  // counter

        // main array of users
        Profile[] arr = new Profile[total];

        // filling array with all elements that are not the profile to delete
        try (Scanner b_in = new Scanner(new FileReader(rawroster))) {
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
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(rawroster, false)))) {

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

    public static void reportBug(String name, String report) {
        Date date = new Date();
        String filename = filedf.format(date);
        File bug = new File("src\\bugreports\\" + filename + ".txt");

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(bug, false)))) {

            out.println("Name:  " + name);
            out.println("Date:  " + df.format(date));
            out.println("");
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
        // NB: This class is internal, and you probably should use another impl
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
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Decoder().decodeBuffer(property);
    }
}
