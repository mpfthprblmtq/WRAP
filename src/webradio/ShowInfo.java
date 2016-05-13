package webradio;

public class ShowInfo {

    public enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
    
    public enum Time {
        am1200, am1230, am0100, am0130, am0200, am0230, am0300, am0330, 
        am0400, am0430, am0500, am0530, am0600, am0630, am0700, am0730, 
        am0800, am0830, am0900, am0930, am1000, am1030, am1100, am1130,
        pm1200, pm1230, pm0100, pm0130, pm0200, pm0230, pm0300, pm0330, 
        pm0400, pm0430, pm0500, pm0530, pm0600, pm0630, pm0700, pm0730, 
        pm0800, pm0830, pm0900, pm0930, pm1000, pm1030, pm1100, pm1130
    }
    
    // ivars
    private String showName;
    private String showDesc;
    private Profile[] hosts;
    private Day[] days;
    private Time[] times;

    /**
     * ShowInfo()
     * Fully loaded constructor
     * 
     * @param showName
     * @param showDesc
     * @param hosts
     * @param days
     * @param times 
     */
    public ShowInfo(String showName, String showDesc, Profile[] hosts, Day[] days, Time[] times) {
        this.showName = showName;
        this.showDesc = showDesc;
        this.hosts = hosts;
        this.days = days;
        this.times = times;
    }
    
    /**
     * @return the showName
     */
    public String getShowName() {
        return showName;
    }

    /**
     * @param showName the showName to set
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * @return the showDesc
     */
    public String getShowDesc() {
        return showDesc;
    }

    /**
     * @param showDesc the showDesc to set
     */
    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    /**
     * @return the hosts
     */
    public Profile[] getHosts() {
        return hosts;
    }

    /**
     * @param hosts the hosts to set
     */
    public void setHosts(Profile[] hosts) {
        this.hosts = hosts;
    }

    /**
     * @return the days
     */
    public Day[] getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Day[] days) {
        this.days = days;
    }

    /**
     * @return the times
     */
    public Time[] getTimes() {
        return times;
    }

    /**
     * @param times the times to set
     */
    public void setTimes(Time[] times) {
        this.times = times;
    }

    public <E> String convertArrToString(E[] arr) {
        String ret = "";
        for (int i = 0; i < arr.length-1; i++) {
            ret += arr[i] + ",";
        }
        ret += arr[arr.length];
        return ret;
    }
    
    @Override
    public String toString() {
        return showName + "///" + 
                showDesc + "///" + 
                convertArrToString(hosts)  + "///" +  
                convertArrToString(days)  + "///" +
                convertArrToString(times);
    }
    
    
}
