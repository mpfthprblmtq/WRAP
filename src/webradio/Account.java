/**
 * File:    Account.java
 * Desc:    Account object class
 * 
 * Author:  Pat Ripley
 */

package webradio;

public class Account {

    // ivars
    private String username;
    private String password;
    private int access;
    private String name;

    /**
     * Account()
     * Constructor for Account
     * 
     * @param username
     * @param password
     * @param access
     * @param name
     */
    public Account(String username, String password, int access, String name) {
        this.username = username;
        this.password = password;
        this.access = access;
        this.name = name;
    }
    
    /** 
     * getUsername()
     * Accessor method for String username
     * 
     * @return the String username
     */
    public String getUsername() {
        return username;
    }

    /** 
     * setUsername()
     * Accessor method for String username
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
     * getPassword()
     * Accessor method for String password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * setPassword()
     * Accessor method for String password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * getAccess()
     * Accessor method for int access
     * 
     * @return access
     */
    public int getAccess() {
        return access;
    }

    /** 
     * setAccess()
     * Accessor method for int access
     * 
     * @param access
     */
    public void setAccess(int access) {
        this.access = access;
    }
    
    /** 
     * getName()
     * Accessor method for String name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /** 
     * setName()
     * Accessor method for String name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * toString()
     * Returns the string to be put in the text file
     * 
     * @return attributes of Account
     */
    @Override
    public String toString() {
        return getUsername() + "///" + getPassword() + "///" + getAccess() + "///" + getName() + "///";
    }
    
} // end Account