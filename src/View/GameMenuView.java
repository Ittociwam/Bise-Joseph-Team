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
public class GameMenuView extends View {
    PlayerControls playerControls = new PlayerControls();
    ItemView itemView = new ItemView();
    MoveView moveView = new MoveView();
    private final String MENU = "\n"
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

    // i think displaygamemenu will have to take a player parameter so it can call openItemMenu
    void displayGameMenu() {
        Object object = null;
        char value = ' ';
        do {
            System.out.println(MENU);

            value = getInput();
            object = value;

            this.doAction(object);
        } while (value != 'E');
    }

    public void doAction(Object obj) {
        char value = (char)obj;
            switch (value) {
                case 'H':
                    System.out.println(MENU);
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
    }

    private void viewRoom() {
        System.out.println("View Room function called");
    }

    private void viewMap() {
        System.out.println("View Map function called");
    }

}
