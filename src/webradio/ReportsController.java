/**
 * File: ReportsController.java
 * Desc: Takes input from ReportsGUI and sends it to IOController
 *
 * Author: Pat Ripley
 */
package webradio;

public class ReportsController {
    
    /**
     * profileSimple()
     * Sends signal to IOController
     * @return result of the file generation
     */
    public static boolean profileSimple() {
        return IOController.profileSimple();
    }
    
    /**
     * profileContact()
     * Sends signal to IOController
     */
    public static boolean profileContact() {
        return IOController.profileContact();
    }
    
    /**
     * profileFull()
     * Sends signal to IOController
     */
    public static boolean profileFull() {
        return IOController.profileFull();
    }
    
    /**
     * accounts()
     * Sends signal to IOController
     */
    public static void accounts() {
        IOController.accounts();
    }
    
    /**
     * shows()
     * Sends signal to IOController
     */
    public static void shows() {
        IOController.shows();
    }
    
    /**
     * tasksDues()
     * Sends signal to IOController
     */
    public static void tasksDues() {
        IOController.tasksDues();
    }
    
    /**
     * tasksTrained()
     * Sends signal to IOController
     */
    public static void tasksTrained() {
        IOController.tasksTrained();
    }
    
    /**
     * tasksPaperwork()
     * Sends signal to IOController
     */
    public static void tasksPaperwork() {
        IOController.tasksPaperwork();
    }
    
    /**
     * tasksShowDescTime()
     * Sends signal to IOController
     */
    public static void tasksShowDescTime() {
        IOController.tasksShowDescTime();
    }
    
    /**
     * tasksFull()
     * Sends signal to IOController
     */
    public static void tasksFull() {
        IOController.tasksFull();
    }
    
    /**
     * financesTransactions()
     * Sends signal to IOController
     */
    public static void financesTransactions() {
        IOController.financesTransactions();
    }
    
    /**
     * financesFull()
     * Sends signal to IOController
     */
    public static void financesFull() {
        IOController.financesFull();
    }
    
    
}
