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

class ContAndInput {
    public char value;
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
        
        
    void displayMoveMenu(PlayerControls playerControls){
        System.out.println("Which way would you like to move?\n");
        System.out.println("Press 'H' for help\n ");
        char choice = getInput();
        ContAndInput contAndInput = null;
        contAndInput.value = choice;
        contAndInput.myPlayerControls = playerControls;
        doAction(contAndInput);
        
    }



    public void doAction(Object obj) {
        ContAndInput myStuff = (ContAndInput)obj;
        char input = myStuff.value;
        PlayerControls playerControls = new PlayerControls();
        playerControls = myStuff.myPlayerControls;

        switch (input) {
            case 'N':
            case 'E':
            case 'S':
            case 'W':
                playerControls.move(input);
                break;
            case 'H':
                System.out.println(HELPMENU);
                break;
            default:
                System.out.println(input + "is not a Invalid Input");
        }
    }
    
}
