package View;

import Control.PlayerControls;
import Model.Player;
import Model.Character;
import exceptions.PlayerControlsException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Travis
 */
public class AttackView extends View {

    boolean done = false;
    PlayerControls playerControls = new PlayerControls();
    Player somePlayer = new Player();
    Character someCharacter = new Character();

    void openMenu(PlayerControls playerControls) {
        Object object = null;
        String value = " ";
        this.console.println("currentHealth: " + somePlayer.getHealth());
        this.console.println("characterHealth: " + someCharacter.getHealth());
        this.console.println("Would you like to attack again?");
        value = getInput();
        object = value;
        this.doAction(object);
        if (value == "Y") {
            this.doAction(object);
        }
    }

    public void doAction(Object obj) {
        while (!done) {
            int returnValue = 0;
            try {
                returnValue = playerControls.attack(somePlayer, someCharacter);
            } catch (PlayerControlsException ex) {
                this.console.println(ex.getMessage());
            }
            //DISPLAY CURRENT HEALTH AND PROMPT USER IF THEY WANT TO ATTACK AGAIN
            switch (returnValue) {
                case 2:
                    this.console.println("Player has lost");
                    done = true;
                    break;
                case 1:
                    this.console.println("Enemy has lost");
                    done = true;
                    break;
                case 0:
                    this.console.println("Continue the fight");
                    done = false;
                    break;
                case -1:
                    ErrorView.display(this.getClass().getName(),"Invalid enemy type");
                    done = true;
                    break;
                case -2:
                    ErrorView.display(this.getClass().getName(),"Invalid player type");
                    done = true;
                    break;
                case -3:
                    ErrorView.display(this.getClass().getName(),"Invalid enemy attack value");
                    done = true;
                    break;
                case -4:
                    ErrorView.display(this.getClass().getName(),"Invalid player attack value");
                    done = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(),"Attack has returned an invalid value!");
                    done = true;
                    break;
            }
            if (done == true) {
                break;
            }

        }
    }
}