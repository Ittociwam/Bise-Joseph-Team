/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import java.io.PrintWriter;

/**
 *
 * @author Travis
 */
public class ErrorView {
    private static final PrintWriter errorFile = BiseJosephTeam.getOutFile();
    private static final PrintWriter logFile = BiseJosephTeam.getLogFile();
    
    public static void display(String className, String errorMessage) {
        errorFile.println(
        "-----------------------------------------------------"
       + "\n - ERROR - " + errorMessage
        + "\n-------------------------------------------------");
        
        logFile.println(className + " - " + errorMessage);
    }
    
}
