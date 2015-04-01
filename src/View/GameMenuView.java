/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import Control.GameControls;
import java.util.Scanner;
import Control.PlayerControls;
import Model.Item;
import Model.Player;
import exceptions.GameControlException;
import exceptions.ItemViewException;
import exceptions.PlayerControlsException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
class Stuff {

    public ArrayList<Item> items;
    public String myValue;

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
            + "            F - Find Strongest Enemy      \n"
            + "              S - Sort Items              \n"
            + "             P - Print Report             \n"
            + "             E- Exit Menu                 \n"
            + "------------------------------------------\n";

    // i think displaygamemenu will have to take a player parameter so it can call openItemMenu
    void openMenu(Player player) throws PlayerControlsException {
        Stuff myStuff = new Stuff();
        myStuff.items = player.getItems();

        String value = " ";
        do {
            this.console.println(MENU);
            value = getInput();
            myStuff.myValue = value;
            this.doAction(myStuff);
        } while (!"E".equals(value));
    }

    public void doAction(Object obj) {

        Stuff myStuff = (Stuff) obj;
        String value = myStuff.myValue;
        ArrayList<Item> items = myStuff.items;
        

        PlayerView playerView = new PlayerView();

        switch (value) {
            case "H":
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.openMenu();
                break;
            case "M":
                moveView.openMenu();
                break;
            case "L":
                this.viewRoom();
                break;
            case "V":
                this.viewMap();
                break;
            case "I":
        {
            
            try {
                itemView.openItemMenu(items);
            } catch (ItemViewException ex) {
                ErrorView.display(this.getClass().getName(),ex.getMessage());
            }
                    
        }
                break;
            case "F": 
            {
                Model.Character tmp = null;
                try {
                    tmp = GameControls.findStrongestEnemy();
                } catch (GameControlException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
                this.console.println("The strongest enemy in this game is: " + tmp.toString() + "\n");
            }
            break;
            case "S":
                //GameControls.sortGameItems();
                break;
            case "P":
                this.printItemList();
            case "E":
                break;
            default:
                this.console.println("Invalid input, Try again\n");

        }
    }

    private void viewRoom() {
        RoomView roomView = new RoomView();
        roomView.display(BiseJosephTeam.BiseJosephTeam.game.getPlayer().getLocation().getRoom());
    }

    private void viewMap() {
        this.console.println("View Map function called");
    }

    private void printItemList() {
        System.out.println("\nEnter the file path for file where the report will be saved.");
        String filePath = this.getInput();
        
        try {
            GameControls.printItemList(BiseJosephTeam.game, filePath);
        } catch (Exception ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }

}
