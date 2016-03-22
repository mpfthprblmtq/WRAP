/**
 * File: AccountController.java
 * Desc: Takes input from AccountGUI and communicates with IOController to read
 * and write to files
 *
 * Author: Pat Ripley
 */
package webradio;

public class AccountController {

    /**
     * Login()
     * Sends username and password combination in String form to IOController
     * to be checked through users on record
     * If there is no match, recieves a null Account, invalid
     * Else it returns an Account
     *
     * @param username
     * @param password
     * @return pro, the String[] with Account info
     */
    public static Account Login(String username, String password) {
        return IOController.Login(username, password);
    }

    /**
     * AddUser()
     * Checks the username for any duplicated usernames, returns false if the
     * username is already taken
     *
     * @param p, the Account object
     * @return boolean result of the addition
     */
    public static boolean AddUser(Account p) {
        boolean dupeUsername = IOController.CheckForUsernameDupe(p.getUsername());
        if (dupeUsername) {
            return false;
        }
        return IOController.AddUser(p);
    }

    /**
     * SearchUser()
     * Searches for an Account object based on username
     *
     * @param username to search by
     * @return an Account object
     */
    public static Account SearchUser(String username) {
        return IOController.SearchUser(username);
    }

    /**
     * DeleteUser()
     * Deletes an Account
     *
     * @param username, the Account to delete
     * @return boolean result of the deletion
     */
    public static boolean DeleteUser(String username) {
        return IOController.DeleteUser(username);
    }

} // end AccountController
