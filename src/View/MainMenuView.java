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
import exceptions.GameControlException;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
class OtherStuff {

    String name;
    String input;
}

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

    void openMenu(String name) {
        OtherStuff stuff = new OtherStuff();

        stuff.name = name;

        String selection = "";
        do {
            display(MENU);

            selection = getInput();
            stuff.input = selection;
            this.doAction(stuff);

        } while (!"E".equals(selection));
    }

    void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.openMenu();
    }

    public void doAction(Object obj) {

        OtherStuff stuff = (OtherStuff) obj;

        String input = stuff.input;
        String name = stuff.name;

        switch (input) {
            case "N": {
                try {
                    this.startNewGame(name);
                } catch (GameControlException | PlayerControlsException | ItemControlException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
            }
            break;
            case "G":
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            case "E":
                return;
            default:
                ErrorView.display(this.getClass().getName(),input + "is not a Invalid Input");
        }
    }

    private void startNewGame(String name) throws GameControlException, PlayerControlsException, ItemControlException {

        Game game = GameControls.createNewGame(name);

        // Make a player
        PlayerControls playerControls = new PlayerControls();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.openMenu(game.getPlayer(), playerControls);
        this.console.println("*** StartNewGame Function called ***");
    }

    private void startExistingGame() {
        // load a player
        GameMenuView gameMenu = new GameMenuView();
        // gameMenu.displayGameMenu(player, playerControls);
        this.console.println("*** StartExistingGame Function called ***");
    }

    private void saveGame() {
        this.console.println("*** saveGame Function called ***");
    }

}
