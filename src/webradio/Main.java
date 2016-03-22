/**
 * File: Main.java
 * Desc: Controls all of the GUIs, having them dispose instead of close
 *       Has the global user account stored here
 *       Starts the code off by showing the LoginGUI
 *
 * Author: Pat Ripley
 */

package webradio;

public class Main {

    // global account
    public static Account p;

    // All of these are the actual GUI, and a boolean to see if they are open or not
    
    // mainGUI
    static MainGUI mainGUI;

    // accountGUI
    static AccountGUI accountGUI;
    static boolean accountGUIVisible = false;

    // profileGUI
    static ProfileGUI profileGUI;
    static boolean profileGUIVisible = false;
    
    // taskGUI
    static TaskGUI taskGUI;
    static boolean taskGUIVisible = false;

    // financeGUI
    static FinanceGUI financeGUI;
    static boolean financeGUIVisible = false;

    // linkGUI
    static LinkGUI linkGUI;
    static boolean linkGUIVisible = false;

    // reportsGUI
    static ReportsGUI reportsGUI;
    static boolean reportsGUIVisible = false;
    
    // bugReportGUI
    static BugReportGUI bugreportGUI;
    static boolean bugreportGUIVisible = false;

    /**
     * main()
     * 
     * Sets a LoginGUI visible
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
    }

    /**
     * SetUser()
     * Set the global user
     * @param p 
     */
    public static void SetUser(Account p) {
        Main.p = p;
    }
    
    /**
     * getUser()
     * Return the global user
     * @return 
     */
    public static Account getUser() {
        return p;
    }

    /**
     * Logout()
     * 
     * Clears the global account, then creates a new LoginGUI
     */
    public static void Logout() {
        Main.p = null;
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
    }

    /**
     * MainGUI
     * Controls the MainGUI opening and closing
     */
    public static void LaunchMainGUI() {
        mainGUI = new MainGUI();
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setVisible(true);
    }

    public static void CloseMainGUI() {
        mainGUI.dispose();
    }

    /**
     * AccountGUI
     * Controls the AccountGUI opening and closing
     */
    public static void LaunchAccountGUI() {
        if (!accountGUIVisible) {
            accountGUI = new AccountGUI();
            accountGUI.setLocationRelativeTo(null);
            accountGUI.setVisible(true);
            accountGUIVisible = true;
        }
    }

    public static void CloseAccountGUI() {
        accountGUI.dispose();
        accountGUIVisible = false;
    }

    /**
     * ProfileGUI
     * Controls the ProfileGUI opening and closing
     */
    public static void LaunchProfileGUI() {
        if (!profileGUIVisible) {
            profileGUI = new ProfileGUI();
            profileGUI.setLocationRelativeTo(null);
            profileGUI.setVisible(true);
            profileGUIVisible = true;
        }
    }

    public static void CloseProfileGUI() {
        profileGUI.dispose();
        profileGUIVisible = false;
    }
    
    /**
     * TaskGUI
     * Controls the TaskGUI opening and closing
     */
    public static void LaunchTaskGUI() {
        if (!taskGUIVisible) {
            taskGUI = new TaskGUI();
            taskGUI.setLocationRelativeTo(null);
            taskGUI.setVisible(true);
            taskGUIVisible = true;
        }
    }

    public static void CloseTaskGUI() {
        taskGUI.dispose();
        taskGUIVisible = false;
    }

    /**
     * FinanceGUI
     * Controls the FinanceGUI opening and closing
     */
    public static void LaunchFinanceGUI() {
        if (!financeGUIVisible) {
            financeGUI = new FinanceGUI();
            financeGUI.setLocationRelativeTo(null);
            financeGUI.setVisible(true);
            financeGUIVisible = true;
        }
    }

    public static void CloseFinanceGUI() {
        financeGUI.dispose();
        financeGUIVisible = false;
    }

    /**
     * LinkGUI
     * Controls the LinkGUI opening and closing
     */
    public static void LaunchLinkGUI() {
        if (!linkGUIVisible) {
            linkGUI = new LinkGUI();
            linkGUI.setLocationRelativeTo(null);
            linkGUI.setVisible(true);
            linkGUIVisible = true;
        }
    }

    public static void CloseLinkGUI() {
        linkGUI.dispose();
        linkGUIVisible = false;
    }

    /**
     * ReportsGUI
     * Controls the ReportsGUI opening and closing
     */
    public static void LaunchReportsGUI() {
        if (!reportsGUIVisible) {
            reportsGUI = new ReportsGUI();
            reportsGUI.setLocationRelativeTo(null);
            reportsGUI.setVisible(true);
            reportsGUIVisible = true;
        }
    }

    public static void CloseReportsGUI() {
        reportsGUI.dispose();
        reportsGUIVisible = false;
    }
    
    /**
     * BugReportGUI
     * Controls the BugReportGUI opening and closing
     */
    public static void LaunchBugReportGUI() {
        if (!bugreportGUIVisible) {
            bugreportGUI = new BugReportGUI();
            bugreportGUI.setLocationRelativeTo(null);
            bugreportGUI.setVisible(true);
            bugreportGUIVisible = true;
        }
    }

    public static void CloseBugReportGUI() {
        bugreportGUIVisible = false;
    }
} // end Main
