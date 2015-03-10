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

    
    public boolean display(Object object) 
    {
         MENU = null;
        if(object instanceof String)
        {
             MENU = (String) object;
        }
        else
            return false;
       System.out.println(MENU);
        return true;
    }

    public char getInput() {  
        
        System.out.print("\t >");
        char value = ' ';
        Scanner keyboard = new Scanner(System.in);
        value = keyboard.next().charAt(0);
        if(Character.isLetter(value))
            return Character.toUpperCase(value);
        else if (Character.isDigit(value))
            return value;
        else
        {
            return '!';
        }
            
    }
}
