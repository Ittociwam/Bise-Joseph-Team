/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import Control.PlayerControls;
import Model.Item;
import Model.Player;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 */
public class GameMenuView {

    ItemView itemView = new ItemView();
    MoveView moveView = new MoveView();
    private final String GAMEMENU = "\n"
            + "------------------------------------------\n"
            + "                 Game Menu                \n"
            + "------------------------------------------\n"
            + "          H - Get Help/Display Menu       \n"
            + "M -  Move Menu (N-north, E-east, S-south, W-west)\n"
            + "         L - Look around the room         \n"
            + "             V - View Room                \n"
            + "            I - View Inventory            \n"
            + "   Each Item will have a unique letter    \n"
            + "             E- Exit Menu                 \n"
            + "------------------------------------------\n";

    public void getInput() {
        char value = ' '
        Scanner keyboard = new Scanner(System.in);
        value = keyboard.next().charAt(0);
        value = Character.toUpperCase(value);
    }

    // i think displaygamemenu will have to take a player parameter so it can call openItemMenu
    void displayGameMenu(Player player, PlayerControls playerControls) {
        System.out.println(GAMEMENU);
    }
        
        public char getInput()
        {
            char value = ' ';
                    Scanner keyboard = new Scanner(System.in);
            value = keyboard.next().charAt(0);
            return Character.toUpperCase(value);
        }
        
        void doAction(){
            
        
        do {

            switch (value) {

                case 'H':
                    System.out.println(GAMEMENU);
                    break;
                case 'M':
                    moveView.displayMoveMenu(playerControls);
                    break;
                case 'L':
                    this.viewRoom();
                    break;
                case 'V':
                    this.viewMap();
                    break;
                case 'I':
                    itemView.openItemMenu(player.getItems(), playerControls); // Needs parameters
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Invalid input, Try again\n");

            }
        } while (value != 'E');
    }

    private void viewRoom() {
        System.out.println("View Room function called");
    }

    private void viewMap() {
        System.out.println("View Map function called");
    }

}
