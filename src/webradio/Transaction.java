/**
 * File: Transaction.java
 * Desc: Transaction object class
 *
 * Author: Pat Ripley
 */
package webradio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    String store;
    Date date;
    String name;
    double amount;
    String reason;
    String notes;
    int id;
    
    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    /**
     * Transaction()
     * 
     * Fully loaded constructor
     * 
     * @param store
     * @param date
     * @param name
     * @param amount
     * @param reason 
     * @param notes 
     * @param id 
     */
    public Transaction(int id, String store, Date date, String name, double amount, String reason, String notes) {
        
        this.date = date;
        this.store = store;
        this.name = name;
        this.amount = amount;
        this.reason = reason;
        this.notes = notes;
        this.id = id;
    }

    /**
     * @return the store
     */
    public String getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(String store) {
        this.store = store;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    /**
     * @return the id
     */
    public int getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(int id) {
        this.id = id;
    }
    
    /**
     * toString()
     * 
     * Returns the string that prints into the file
     * 
     * @return 
     */
    @Override
    public String toString() {
        return id + "///" 
                + store + "///"
                + df.format(date) + "///"
                + name + "///"
                + amount + "///"
                + reason + "///"
                + notes + "///";
    }
}
