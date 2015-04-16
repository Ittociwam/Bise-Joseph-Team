/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
public abstract class View implements ViewInterface {

    //keyboard and console variables
    private String MENU;

    protected final BufferedReader keyboard;
    protected final PrintWriter console;

    public View() {

        keyboard = BiseJosephTeam.getInFile();
        console = BiseJosephTeam.getOutFile();
    }

    public boolean display(Object object) {
        MENU = null;
        if (object instanceof String) {
            MENU = (String) object;
        } else {
            return false;
        }
        this.console.println(MENU);
        return true;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nf) {
            return false;
        }
    }

    public String getInput() {

        String value = "";
        String firstLetter = "";
        while ("".equals(value)) {


            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                this.console.println(ex.getMessage());
            }
            try {

                firstLetter = String.valueOf(value.charAt(0));
            } catch (StringIndexOutOfBoundsException siobe) {
                continue;
            }
        }

        if (isInteger(firstLetter)) {
            return value;
        }
        return value.toUpperCase();

    }
}
