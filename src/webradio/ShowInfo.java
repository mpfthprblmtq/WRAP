package webradio;

public class ShowInfo {
    
    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
    
    enum Time {
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
}
