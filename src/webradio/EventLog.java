/**
 * File: EventLog.java
 * Desc: Handles creating and editing event logs
 *
 * Author: Pat Ripley
 */
package webradio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventLog {
    
    static DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm");
    static File log = new File("src\\logs\\eventLog.txt");
    
    public static void add(String s) {
        Date date = new Date();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(log, true)))) {
            out.println(IOController.getHeader());
            out.println();
            out.println("[" + df.format(date) + "] user " + Main.p.getUsername() + " "
            + s);
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
