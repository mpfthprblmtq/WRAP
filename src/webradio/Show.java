/**
 * File: Show.java
 * Desc: Show object class
 *
 * Author: Pat Ripley
 */

package webradio;

import java.util.Arrays;

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
    public Show(String showName, String showDesc, Profile[] hosts, Day[] days, Time[] times) {
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
                    + convertArrToString(times);
        } else {
            return "--";
        }
    }

}
