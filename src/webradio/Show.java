/**
 * File: Show.java
 * Desc: Show object class
 *
 * Author: Pat Ripley
 */

package webradio;

public class Show {

    // enum used for Day object
    public enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    // enum used for Time object
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
    private String smURL;

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
    public Show(String showName, String showDesc, Profile[] hosts, Day[] days, Time[] times, String smURL) {
        this.showName = showName;
        this.showDesc = showDesc;
        this.hosts = hosts;
        this.days = days;
        this.times = times;
        this.smURL = smURL;
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
    
    /**
     * @return the smURL
     */
    public String getSMURL() {
        return smURL;
    }

    /**
     * @param smURL the smURL to set
     */
    public void setSMURL(String smURL) {
        this.smURL = smURL;
    }

    /**
     * convertArrToString()
     * 
     * Utility function used to convert an object array into a String
     * 
     * @param <E>
     * @param arr
     * @return the string representation of the object array
     */
    public <E> String convertArrToString(E[] arr) {
        String ret = "";
        for (int i = 0; i < arr.length - 1; i++) {
            ret += arr[i] + ",";
        }
        ret += arr[arr.length - 1];
        return ret;
    }

    /**
     * convertProfileArrToString()
     * 
     * Utility function used to convert an Profile array into a String
     * 
     * @param arr
     * @return the string representation of the object array
     */
    public String convertProfileArrToString(Profile[] arr) {
        String ret = "";

        if (arr.length == 1 && arr[0] == null) {
            return "0";
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    ret += arr[i].getId() + ",";
                }
            }

            ret = ret.substring(0, ret.length() - 1);
        }
        
        return ret;
    }
    
    /**
     * getHostsString()
     * 
     * Utility function used to convert the hosts into a String
     * 
     * @return the string representation of hosts
     */
    public String getHostsString() {
        String ret = "";

        if (hosts.length == 1 && hosts[0] == null) {
            return "0";
        } else {
            for (int i = 0; i < hosts.length; i++) {
                if (hosts[i] != null) {
                    ret += hosts[i].getfName() + " " 
                            + hosts[i].getlName() + ", ";
                }
            }
            ret = ret.substring(0, ret.length() - 2);
        }
        return ret;
    }
    
    /**
     * getDays_Times()
     * 
     * Utility function used to convert the days and times into a String
     * @return 
     */
    public String getDays_Times() {
        String ret = "";
        switch(days.length) {
            case 1:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                break;
            case 2:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                break;
            case 3:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                ret += "\r\n              ";
                ret += getDay(days[2]) + " ";
                ret += getTime(times[4]) + "-" + getTime(times[5]);
                break;
            case 4:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                ret += "\r\n              ";
                ret += getDay(days[2]) + " ";
                ret += getTime(times[4]) + "-" + getTime(times[5]);
                ret += "\r\n              ";
                ret += getDay(days[3]) + " ";
                ret += getTime(times[6]) + "-" + getTime(times[7]);
                break;
            case 5:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                ret += "\r\n              ";
                ret += getDay(days[2]) + " ";
                ret += getTime(times[4]) + "-" + getTime(times[5]);
                ret += "\r\n              ";
                ret += getDay(days[3]) + " ";
                ret += getTime(times[6]) + "-" + getTime(times[7]);
                ret += "\r\n              ";
                ret += getDay(days[4]) + " ";
                ret += getTime(times[8]) + "-" + getTime(times[9]);
                break;
            case 6:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                ret += "\r\n              ";
                ret += getDay(days[2]) + " ";
                ret += getTime(times[4]) + "-" + getTime(times[5]);
                ret += "\r\n              ";
                ret += getDay(days[3]) + " ";
                ret += getTime(times[6]) + "-" + getTime(times[7]);
                ret += "\r\n              ";
                ret += getDay(days[4]) + " ";
                ret += getTime(times[8]) + "-" + getTime(times[9]);
                ret += "\r\n              ";
                ret += getDay(days[5]) + " ";
                ret += getTime(times[10]) + "-" + getTime(times[11]);
                break;
            case 7:
                ret += getDay(days[0]) + " ";
                ret += getTime(times[0]) + "-" + getTime(times[1]);
                ret += "\r\n              ";
                ret += getDay(days[1]) + " ";
                ret += getTime(times[2]) + "-" + getTime(times[3]);
                ret += "\r\n              ";
                ret += getDay(days[2]) + " ";
                ret += getTime(times[4]) + "-" + getTime(times[5]);
                ret += "\r\n              ";
                ret += getDay(days[3]) + " ";
                ret += getTime(times[6]) + "-" + getTime(times[7]);
                ret += "\r\n              ";
                ret += getDay(days[4]) + " ";
                ret += getTime(times[8]) + "-" + getTime(times[9]);
                ret += "\r\n              ";
                ret += getDay(days[5]) + " ";
                ret += getTime(times[10]) + "-" + getTime(times[11]);
                ret += "\r\n              ";
                ret += getDay(days[6]) + " ";
                ret += getTime(times[12]) + "-" + getTime(times[13]);
                break;
            default:
                ret += "null";
        }
        return ret;
    }
    
    /**
     * getDay()
     * 
     * Returns a String representation of a Day object
     * 
     * @param day
     * @return 
     */
    public String getDay(Day day) {
        switch(day) {
            case SUN:
                return "Sunday";
            case MON:
                return "Monday";
            case TUE:
                return "Tuesday";
            case WED:
                return "Wednesday";
            case THU:
                return "Thursday";
            case FRI:
                return "Friday";
            case SAT:
                return "Saturday";
            default:
                return "";
        }
    }
    
    /**
     * getTime()
     * 
     * Returns a String representation of a Time object
     * 
     * @param time
     * @return 
     */
    public String getTime(Time time) {
        switch (time) {
                case am0600:
                    return "6:00am";
                case am0630:
                    return "6:30am";
                case am0700:
                    return "7:00am";
                case am0730:
                    return "7:30am";
                case am0800:
                    return "8:00am";
                case am0830:
                    return "8:30am";
                case am0900:
                    return "9:00am";
                case am0930:
                    return "9:30am";
                case am1000:
                    return "10:00am";
                case am1030:
                    return "10:30am";
                case am1100:
                    return "11:00am";
                case am1130:
                    return "11:30am";
                case pm1200:
                    return "12:00pm";
                case pm1230:
                    return "12:30pm";
                case pm0100:
                    return "1:00pm";
                case pm0130:
                    return "1:30pm";
                case pm0200:
                    return "2:00pm";
                case pm0230:
                    return "2:30pm";
                case pm0300:
                    return "3:00pm";
                case pm0330:
                    return "3:30pm";
                case pm0400:
                    return "4:00pm";
                case pm0430:
                    return "4:30pm";
                case pm0500:
                    return "5:00pm";
                case pm0530:
                    return "5:30pm";
                case pm0600:
                    return "6:00pm";
                case pm0630:
                    return "6:30pm";
                case pm0700:
                    return "7:00pm";
                case pm0730:
                    return "7:30pm";
                case pm0800:
                    return "8:00pm";
                case pm0830:
                    return "8:30pm";
                case pm0900:
                    return "9:00pm";
                case pm0930:
                    return "9:30pm";
                case pm1000:
                    return "10:00pm";
                case pm1030:
                    return "10:30pm";
                case pm1100:
                    return "11:00pm";
                case pm1130:
                    return "11:30pm";
                case am1200:
                    return "12:00am";
                default:
                    return "";
            }
    }
    
    
    /**
     * toString()
     * 
     * Returns the String representation of the show for the text file
     * 
     * @return string
     */
    @Override
    public String toString() {
        if (!this.showName.equals("--")) {
            return showName + "///"
                    + showDesc + "///"
                    + convertProfileArrToString(hosts) + "///"
                    + convertArrToString(days) + "///"
                    + convertArrToString(times) + "///";
        } else {
            return "--";
        }
    }

}
