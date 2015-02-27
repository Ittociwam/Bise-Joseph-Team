/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import Control.PlayerControls;
import Model.Item;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 */
public class GameMenuView {

    ItemView itemView = new ItemView();
    private final String GAMEMENU = "\n"
            + "------------------------------------------\n"
            + "            Game Menu                     \n"
            + "------------------------------------------\n"
            + "          H - Get Help/Display Menu       \n"
            + "M -  Move Menu (N-north, E-east, S-south, W-west)\n"
            + "         L - Look around the room         \n"
            + "             V - View Room                \n"
            + "            I - View Inventory            \n"
            + "   Each Item will have a unique letter    \n"
            + "             E- Exit Menu                 \n"
            + "------------------------------------------\n";

    // i think displaygamemenu will have to take a player parameter so it can call openItemMenu
    void displayGameMenu() {
        
        char value = ' ';
        do {
            System.out.println(GAMEMENU);

            Scanner keyboard = new Scanner(System.in);
            value = keyboard.next().charAt(0);
            value = Character.toUpperCase(value);

            switch (value) {

                case 'H':
                    System.out.println(GAMEMENU);
                    break;
                case 'M':
                    this.move();
                    break;
                case 'L':
                    this.viewRoom();
                    break;
                case 'V':
                    this.viewMap();
                    break;
                case 'I':
                    ItemView.openItemMenu(); // Needs parameters
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Invalid input, Try again\n");

            }
        } while (value != 'E');
    }

    private void move() {
        // this will make a new move view item and call display move menu.
    }

    private void viewRoom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
