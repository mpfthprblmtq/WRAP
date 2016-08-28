/**
 * File: ProfileGUI.java
 * Desc: Takes input from FinanceGUI and sends information to IOController to
 *       be written.
 *
 * Author: Pat Ripley
 */
package webradio;

public class FinanceController {
    
    public static boolean addTransaction(Transaction t) {
        return IOController.addTransaction(t);
    }
    
    public static Transaction[] getAllTransactions() {
        return IOController.getAllTransactions();
    }
    
    public static Transaction searchTransaction(String id) {
        return IOController.searchTransaction(id);
    }
    
    public static boolean deleteTransaction(String id) {
        return IOController.deleteTransaction(id);
    }
    
    public static double[] getAccountTotals() {
        return IOController.getAccountTotals();
    }
    
    public static boolean updateAccountTotals(double[] d) {
        return IOController.updateAccountTotals(d);
    }
    
}
