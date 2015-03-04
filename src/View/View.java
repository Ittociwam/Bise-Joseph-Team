/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public abstract class View implements ViewInterface {
    Object menu = new Object();
    
    public int openMenu(Object object) {
        display(menu);
        char choice = getInput();
        doAction(choice, object);
        return 1;
    }

    public void display(Object object) {
        System.out.println(object);
    }

    public char getInput() {
        char value = ' ';
        Scanner keyboard = new Scanner(System.in);
        value = keyboard.next().charAt(0);
        return Character.toUpperCase(value);
    }
}
