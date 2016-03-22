/**
 * File: Profile.java
 * Desc: Profile object class
 *
 * Author: Pat Ripley
 */

package webradio;

public class Profile {
    
    // const
    public static final int DJ = 1;
    public static final int ADVISOR = 2;
    public static final int PROSPECT = 3;
    public static final int MEMBER = 4;
    
    // ivars
    private String fName;
    private String lName;
    private String id;
    private String phone;
    private String siueEmail;
    private String prefEmail;
    private int    type;
    private int    position;
    private String notes;
    
    private boolean duesPaid;
    private boolean trained;
    private boolean showDesc_Time;
    private boolean paperworkTurnedIn;
    
    /**
     * Profile()
     * Fully loaded constructor
     * 
     * @param fName
     * @param lName
     * @param id
     * @param phone
     * @param siueEmail
     * @param prefEmail
     * @param type
     * @param position
     * @param notes
     * @param duesPaid
     * @param trained
     * @param showDesc_Time
     * @param paperworkTurnedIn 
     */
    public Profile(String fName, String lName, String id, String phone, String siueEmail, String prefEmail, int type, int position, String notes,
                    boolean duesPaid, boolean trained, boolean showDesc_Time, boolean paperworkTurnedIn) {
    
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.phone = phone;
        this.siueEmail = siueEmail;
        this.prefEmail = prefEmail;
        this.type = type;
        this.position = position;
        this.notes = notes;
        this.duesPaid = duesPaid;
        this.trained = trained;
        this.showDesc_Time = showDesc_Time;
        this.paperworkTurnedIn = paperworkTurnedIn;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the siueEmail
     */
    public String getSiueEmail() {
        return siueEmail;
    }

    /**
     * @param siueEmail the siueEmail to set
     */
    public void setSiueEmail(String siueEmail) {
        this.siueEmail = siueEmail;
    }

    /**
     * @return the prefEmail
     */
    public String getPrefEmail() {
        return prefEmail;
    }

    /**
     * @param prefEmail the prefEmail to set
     */
    public void setPrefEmail(String prefEmail) {
        this.prefEmail = prefEmail;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
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
     * @return the duesPaid
     */
    public boolean isDuesPaid() {
        return duesPaid;
    }

    /**
     * @param duesPaid the duesPaid to set
     */
    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }

    /**
     * @return the trained
     */
    public boolean isTrained() {
        return trained;
    }

    /**
     * @param trained the trained to set
     */
    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    /**
     * @return the showDesc_Time
     */
    public boolean isShowDesc_Time() {
        return showDesc_Time;
    }

    /**
     * @param showDesc_Time the showDesc_Time to set
     */
    public void setShowDesc_Time(boolean showDesc_Time) {
        this.showDesc_Time = showDesc_Time;
    }

    /**
     * @return the paperworkTurnedIn
     */
    public boolean isPaperworkTurnedIn() {
        return paperworkTurnedIn;
    }

    /**
     * @param paperworkTurnedIn the paperworkTurnedIn to set
     */
    public void setPaperworkTurnedIn(boolean paperworkTurnedIn) {
        this.paperworkTurnedIn = paperworkTurnedIn;
    }

    /**
     * toString()
     * @return string representation of object
     */
    @Override
    public String toString() {
        return getfName() + "///" + 
                getlName() + "///" + 
                getId() + "///" + 
                getPhone() + "///" + 
                getSiueEmail() + "///" + 
                getPrefEmail() + "///" + 
                getType() + "///" + 
                getPosition() + "///" +
                getNotes() + "///" +
                isDuesPaid() + "///" +
                isTrained() + "///" +
                isShowDesc_Time() + "///" +
                isPaperworkTurnedIn();
    }
} // end Profile
