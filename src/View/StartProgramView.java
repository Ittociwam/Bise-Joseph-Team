/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BiseJosephTeam.BiseJosephTeam;
import Control.GameControls;
import Model.Game;
import Model.Person;
import Model.Player;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class StartProgramView {
    
    public StartProgramView() {
    }

    public void startProgram() {
        this.displayBanner();

        String playersName = this.getPlayersName();

      

        this.displayWelcomMessage(playersName);
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.openMenu(playersName);
        
        

    }

    private void displayBanner() {
        System.out.println("\n\n************************************************\n");

        System.out.println("*                                                  *\n"
                + "*         ALL QUIET ON THE PACIFIC THEATER         *\n"
                + "*               Add game banner here!              *\n");

        System.out.println("****************************************************\n");

    }

    private String getPlayersName() {
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter your name: ");
            playersName = keyboard.nextLine();
            playersName = playersName.trim();

            if (playersName.length() < 2) {
                System.out.println("Invalid name input, Please try again");
                continue;
            }
            break;

        }
        return playersName;

    }

    private void displayWelcomMessage(String name) {
        System.out.println("\n\n================================\n"
                              +"Welcome to the game, " + name + "\n"
                              +"We hope you make it out alive!\n"
                              +"================================");
    }

   
}
