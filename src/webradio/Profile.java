package webradio;

public class Profile {
    public static final int DJ = 1;
    public static final int ADVISOR = 2;
    public static final int PROSPECT = 3;
    public static final int MEMBER = 4;
    
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
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSiueEmail() {
        return siueEmail;
    }

    public void setSiueEmail(String siueEmail) {
        this.siueEmail = siueEmail;
    }

    public String getPrefEmail() {
        return prefEmail;
    }

    public void setPrefEmail(String prefEmail) {
        this.prefEmail = prefEmail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isDuesPaid() {
        return duesPaid;
    }

    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public boolean isShowDesc() {
        return showDesc_Time;
    }

    public void setShowDesc(boolean showDesc_Time) {
        this.showDesc_Time = showDesc_Time;
    }

    public boolean isPaperworkTurnedIn() {
        return paperworkTurnedIn;
    }

    public void setPaperworkTurnedIn(boolean paperworkTurnedIn) {
        this.paperworkTurnedIn = paperworkTurnedIn;
    }
    
    public String getNotes () {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return fName + "///" + 
                lName + "///" + 
                id + "///" + 
                phone + "///" + 
                siueEmail + "///" + 
                prefEmail + "///" + 
                type + "///" + 
                position + "///" +
                notes + "///" +
                duesPaid + "///" +
                trained + "///" +
                showDesc_Time + "///" +
                paperworkTurnedIn;
    }
    
}
