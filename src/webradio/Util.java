/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webradio;

/**
 *
 * @author Pat
 */
public interface Util {
    
    static boolean sepCheck(String str) {
        return !str.contains("///");
    }
    
    static boolean toBool(String str) {
        return str.equals("true");
    }
    
}
