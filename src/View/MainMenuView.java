/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import Control.GameControls;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class MainMenuView {

    private final String MENU = "\n"
            + "-------------------------------------\n"
            + "            MAIN MENU                \n"
            + "-------------------------------------\n"
            + "          G - Start Existing Game    \n"
            + "          N - Start New Ga           \n"
            + "          H - Help                   \n"
            + "          S - Save Game              \n"
            + "          E - Exit                   \n"
            + "-------------------------------------\n";



    void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU);

            selection = this.getInput();

            this.doAction(selection);
        } while (selection != 'E');
    }

    void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private char getInput() {

        boolean valid = false;
        while (!valid) {
            Scanner keyboard = new Scanner(System.in);
            char value = keyboard.next().charAt(0);
            value = Character.toUpperCase(value);
            switch (value) {
                case 'G':
                case 'N':
                case 'H':
                case 'S':
                case 'E':
                    return value;
                default:
                    System.out.println(value + " is not a valid input");
                    valid = false;
            }

        }
        return 0;

    }

    private void doAction(char input) {
        switch (input) {
            case 'N':
                this.startNewGame();
                break;
            case 'G':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':
                return;
            default:
                System.out.println(input + "is not a Invalid Input");
        }
    }

    private void startNewGame() {
        GameControls.createNewGame(BiseJosephTeam.getPerson());

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
        System.out.println("*** StartNewGame Function called ***");
    }

    private void startExistingGame() {
        System.out.println("*** StartExistingGame Function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGamerob Function called ***");
    }

}
