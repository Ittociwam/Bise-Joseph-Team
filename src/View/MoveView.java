/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import Model.Player;
import exceptions.PlayerControlsException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
public class MoveView extends View {

    private final String HELPMENU = "\n"
            + "-------------------------------------\n"
            + "            Move Menu                \n"
            + "-------------------------------------\n"
            + "          N - Move North             \n"
            + "          E - Move East              \n"
            + "          S - Move South             \n"
            + "          W - Move West              \n"
            + "          Q - Quit moving            \n"
            + "          H - Display this menu      \n"
            + "-------------------------------------\n";

    public MoveView() {
    }

    void openMenu() {
        Player thisPlayer = BiseJosephTeam.BiseJosephTeam.game.getPlayer();
        this.console.println("\n");
        this.console.println("Which way would you like to move?\n");
        this.console.println("Press 'H' for help\n ");
        String choice = null;
        while (!"Q".equals(choice))
        {
        RoomView roomView = new RoomView();
        MapView mapView = new MapView();
        mapView.display(BiseJosephTeam.BiseJosephTeam.game.getMap());
        roomView.display(thisPlayer.getLocation().getRoom());
        console.print(choice);
        console.println("current Location: " + thisPlayer.getLocation());
        choice = getInput();
        doAction(choice);
        }

    }

    public void doAction(Object obj) {
        String input = (String) obj;

        switch (input) {
            case "N":
            case "E":
            case "S":
            case "W": {
                try {
                    PlayerControls.move(input);
                } catch (PlayerControlsException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
            }
            break;
            case "H":
                this.console.println(HELPMENU);
                break;
            case "Q":
                break;
            default:
                ErrorView.display(this.getClass().getName(), input + "is not a Invalid Input");
        }
    }

}
