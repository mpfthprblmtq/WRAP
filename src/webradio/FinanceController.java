/**
 * File: ProfileGUI.java
 * Desc: Takes input from FinanceGUI and sends information to IOController to
 *       be written
 *
 * Author: Pat Ripley
 */
package webradio;

public class FinanceController {
    
    /**
     * addTransaction()
     * 
     * Function to add a new Transaction
     * 
     * @param t
     * @return the result of the addition
     */
    public static boolean addTransaction(Transaction t) {
        return IOController.addTransaction(t);
    }
    
    /**
     * getAllTransactions()
     * 
     * Returns an array of all Transactions
     * 
     * @return an array of all Transactions
     */
    public static Transaction[] getAllTransactions() {
        return IOController.getAllTransactions();
    }
    
    /**
     * searchTransaction()
     * 
     * Searches for a transaction based on the id
     * 
     * @param id
     * @return the found transaction
     */
    public static Transaction searchTransaction(String id) {
        return IOController.searchTransaction(id);
    }
    
    /**
     * deleteTransaction()
     * 
     * Deletes a transaction based on the id
     * 
     * @param id
     * @return the result of the deletion
     */
    public static boolean deleteTransaction(String id) {
        return IOController.deleteTransaction(id);
    }
    
    /**
     * getAccountTotals()
     * 
     * Returns the totals of each account
     * 
     * @return 
     */
    public static double[] getAccountTotals() {
        return IOController.getAccountTotals();
    }
    
    /**
     * updateAccountTotals()
     * 
     * Updates the account totals
     * 
     * @param d
     * @return 
     */
    public static boolean updateAccountTotals(double[] d) {
        return IOController.updateAccountTotals(d);
    }
    
}   // end FinanceController