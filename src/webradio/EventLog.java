/**
 * File: EventLog.java
 * Desc: Handles creating and editing event logs
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventLog {

    // global date formatting and file objects
    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static File log = new File("src/logs/eventLog.txt");

    /**
     * add()
     *
     * Adds a line to the event log
     * Opens the file, prints a date, user, and the action
     *
     * @param s
     */
    public static void add(String s) {
        Date date = new Date();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(log, true)))) {
            out.println("[" + df.format(date) + "] user " + Main.p.getUsername() + " "
                    + s);
            out.close();
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());
            
            // if the program is starting
        } catch (NullPointerException ex) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(log, true)))) {
                out.println("[" + df.format(date) + "] WRAP started");
                out.close();
            } catch (IOException ex2) {
                Util.error(ex2.toString(), ex2.getMessage());
            }
        }
    }
}
