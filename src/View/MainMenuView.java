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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
            + "          P - Print Error Report     \n"
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
        {
            try {
                this.startExistingGame();
            } catch (PlayerControlsException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            case "E":
                return;
            case "P":
        {
            try {
                this.printErrorReport();
            } catch (IOException ex) {
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            default:
                ErrorView.display(this.getClass().getName(),input + "is not a Invalid Input");
        }
    }

    private void startNewGame(String name) throws GameControlException, PlayerControlsException, ItemControlException {

        Game game = GameControls.createNewGame(name);

        // Make a player
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.openMenu(game.getPlayer());
        this.console.println("*** StartNewGame Function called ***");
    }

    private void startExistingGame() throws PlayerControlsException {
        // load a player
//        GameMenuView gameMenu = new GameMenuView();
        // gameMenu.displayGameMenu(player, playerControls);
        System.out.println("\nEnter the file path for file where the game is to be loaded.");
        
        String filePath = this.getInput();
        
        try {
            GameControls.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        System.out.println("Welcome back:" + BiseJosephTeam.game.getPerson().getName());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.openMenu(BiseJosephTeam.game.getPlayer());
        
    }

    private void saveGame() {
//        this.console.println("*** saveGame Function called ***");
        System.out.println("\nEnter the file path for file where the game is to be saved.");
        String filePath = this.getInput();
        
        try {
            GameControls.saveGame(BiseJosephTeam.game, filePath, BiseJosephTeam.game.getPerson());
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void printErrorReport() throws IOException {
        this.console.println("Where would you like the error report to be printed?\n");
        this.console.println("\t>");
        String filePath = this.keyboard.readLine();
        this.actuallyPrintReport(filePath);
    }

    private void actuallyPrintReport(String filePath) throws FileNotFoundException, IOException {
        ObjectOutputStream output = null;
        try(FileOutputStream fops = new FileOutputStream(filePath))
        {
            output = new ObjectOutputStream(fops);
            output.writeChars("***Error Report***\n");
            output.writeChars("***Start New Game   |   Start Existing Game   |   Help Menu   |   Save Game***\n");
            
        }
        catch(Throwable te)
        {
            output.writeChars(te.getMessage());
            ErrorView.display(this.getClass().getName(), te.getMessage());
            
        }
        this.console.println("Report printed\n");

        
    }



}
