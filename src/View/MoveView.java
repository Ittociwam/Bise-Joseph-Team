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
public class MoveView {
    
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
    void displayMoveMenu(PlayerControls playerControls){
        System.out.println("Which way would you like to move?\n");
        System.out.println("Press 'H' for help\n ");
        char choice = getInput();
        doAction(choice, playerControls);
        
    }
    private char getInput() {

        boolean valid = false;
        while (!valid) {
            Scanner keyboard = new Scanner(System.in);
            char value = keyboard.next().charAt(0);
            value = Character.toUpperCase(value);
            switch (value) {
                case 'N':
                case 'E':
                case 'S':
                case 'W':
                case 'H':
                    return value;
                default:
                    System.out.println(value + " is not a valid input");
                    valid = false;
            }

        }
        return 0;
    }

    private void doAction(char input, PlayerControls playerControls) {
        switch (input) {
            case 'N':
            case 'E':
            case 'S':
            case 'W':
                playerControls.move(input);
                break;
            case 'H':
                System.out.println(HELPMENU);
            default:
                System.out.println(input + "is not a Invalid Input");
        }
    }
    
}
