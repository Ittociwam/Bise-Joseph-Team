/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public abstract class View implements ViewInterface {

    private String MENU;

    public boolean display(Object object) {
        MENU = null;
        if (object instanceof String) {
            MENU = (String) object;
        } else {
            return false;
        }
        System.out.println(MENU);
        return true;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nf ) {
            return false;
        }
    }

    public String getInput() {

       
        
        String value = "";
        String firstLetter = "";
         while("".equals(value))
         {
             System.out.print("\t >");
        Scanner input = new Scanner(System.in);
        value=input.nextLine();
        try{
            
       firstLetter = String.valueOf(value.charAt(0));
        }
        catch(StringIndexOutOfBoundsException siobe){
            continue;
        }
         }
        
        if (isInteger(firstLetter)) {
            return value;
        }
        return value.toUpperCase();

    }
}
