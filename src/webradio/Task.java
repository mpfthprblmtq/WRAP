
package webradio;

public class Task {
    
    private String fName;
    private String lName;
    private String id;
    
    private boolean duesPaid;
    private boolean paperworkTurnedIn;
    private boolean showtime_desc;
    private boolean trained;

    public Task(String fName, String lName, String id, boolean duesPaid, boolean paperworkTurnedIn, boolean showtime_desc, boolean trained) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.duesPaid = duesPaid;
        this.paperworkTurnedIn = paperworkTurnedIn;
        this.showtime_desc = showtime_desc;
        this.trained = trained;
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

    public boolean isDuesPaid() {
        return duesPaid;
    }

    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }

    public boolean isPaperworkTurnedIn() {
        return paperworkTurnedIn;
    }

    public void setPaperworkTurnedIn(boolean paperworkTurnedIn) {
        this.paperworkTurnedIn = paperworkTurnedIn;
    }

    public boolean isShowtime_desc() {
        return showtime_desc;
    }

    public void setShowtime_desc(boolean showtime_desc) {
        this.showtime_desc = showtime_desc;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
    
    @Override
    public String toString() {
        return fName + "///" +
                lName + "///" +
                id + "///" +
                duesPaid + "///" +
                paperworkTurnedIn + "///" +
                showtime_desc + "///" +
                trained;
    }
}
