/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import exceptions.PlayerControlsException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
class ContAndInput {

    public String value;
    public PlayerControls myPlayerControls;
}

public class MoveView extends View {

    private final String HELPMENU = "\n"
            + "-------------------------------------\n"
            + "            Move Menu                \n"
            + "-------------------------------------\n"
            + "          N - Move North             \n"
            + "          E - Move East              \n"
            + "          S - Move South             \n"
            + "          W - Move West              \n"
            + "          H - Display this menu      \n"
            + "-------------------------------------\n";

    public MoveView() {
    }

    void openMenu(PlayerControls playerControls) {
        this.console.println("Which way would you like to move?\n");
        this.console.println("Press 'H' for help\n ");
        String choice = getInput();
        ContAndInput contAndInput = new ContAndInput();
        contAndInput.value = choice;
        contAndInput.myPlayerControls = playerControls;
        doAction(contAndInput);

    }

    public void doAction(Object obj) {
        ContAndInput myStuff = (ContAndInput) obj;
        String input = myStuff.value;
        PlayerControls playerControls = new PlayerControls();
        playerControls = myStuff.myPlayerControls;

        switch (input) {
            case "N":
            case "E":
            case "S":
            case "W": {
                try {
                    playerControls.move(input);
                } catch (PlayerControlsException ex) {
                    Logger.getLogger(MoveView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "H":
                this.console.println(HELPMENU);
                break;
            default:
                ErrorView.display(this.getClass().getName(),input + "is not a Invalid Input");
        }
    }

}
