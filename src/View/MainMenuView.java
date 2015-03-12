/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import Control.GameControls;
import Control.PlayerControls;
import Model.Game;
import Model.Person;
import Model.Player;

/**
 *
 * @author Robbie
 */
public class MainMenuView extends View {

    private final String MENU = "\n"
            + "-------------------------------------\n"
            + "            MAIN MENU                \n"
            + "-------------------------------------\n"
            + "          G - Start Existing Game    \n"
            + "          N - Start New Game         \n"
            + "          H - Help                   \n"
            + "          S - Save Game              \n"
            + "          E - Exit                   \n"
            + "-------------------------------------\n";

    private Person myPerson;

    void openMenu(Person person) {
        
        myPerson = person;
        Object object = null;
        char selection = ' ';
        do {
            display(MENU);

            
            selection = getInput();
            object = selection;

            this.doAction(object);
        } while (selection != 'E');
    }

    void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.openMenu();
    }


    public void doAction(Object obj) {
        char input = (char)obj;
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
        
        
        
        Game game = GameControls.createNewGame(myPerson);

        // Make a player
        
        PlayerControls playerControls = new PlayerControls();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.openMenu(game.getPlayer(), playerControls);
        System.out.println("*** StartNewGame Function called ***");
    }

    private void startExistingGame() {
        // load a player
        GameMenuView gameMenu = new GameMenuView();
       // gameMenu.displayGameMenu(player, playerControls);
        System.out.println("*** StartExistingGame Function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame Function called ***");
    }

}
