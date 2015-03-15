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
class Stuff {

    public ArrayList<Item> items;
    public PlayerControls playerControls;
    public char myValue;
    
}

public class GameMenuView extends View {

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
            + "             E- Exit Menu                 \n"
            + "------------------------------------------\n";

    // i think displaygamemenu will have to take a player parameter so it can call openItemMenu
    void openMenu(Player player, PlayerControls playerControls) {
        Stuff myStuff = new Stuff();
        myStuff.items = player.getItems();
        myStuff.playerControls = playerControls;
        
        
        char value = ' ';
        do {
            System.out.println(MENU);
            value = getInput();
            myStuff.myValue = value;
            this.doAction(myStuff);
        } while (value != 'E');
    }

    public void doAction(Object obj) {
        
        Stuff myStuff = (Stuff) obj;
        char value = myStuff.myValue;
        
        ArrayList<Item> items = myStuff.items; 
        
        PlayerView playerView = new PlayerView();
        
        PlayerControls playerControls = myStuff.playerControls;

        switch (value) {
            case 'H':
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.openMenu();
                break;
            case 'M':
                moveView.openMenu(playerControls);
                break;
            case 'L':
                this.viewRoom();
                break;
            case 'V':
                this.viewMap();
                break;
            case 'I':
                itemView.openItemMenu(items, playerControls); 
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
