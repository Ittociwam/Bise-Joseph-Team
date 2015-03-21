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
        System.out.println("currentHealth: " + somePlayer.getHealth());
        System.out.println("characterHealth: " + someCharacter.getHealth());
        System.out.println("Would you like to attack again?");
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
                System.out.println(ex.getMessage());
            }
            //DISPLAY CURRENT HEALTH AND PROMPT USER IF THEY WANT TO ATTACK AGAIN
            switch (returnValue) {
                case 2:
                    System.out.println("Player has lost");
                    done = true;
                    break;
                case 1:
                    System.out.println("Enemy has lost");
                    done = true;
                    break;
                case 0:
                    System.out.println("Continue the fight");
                    done = false;
                    break;
                case -1:
                    System.out.println("Invalid enemy type");
                    done = true;
                    break;
                case -2:
                    System.out.println("Invalid player type");
                    done = true;
                    break;
                case -3:
                    System.out.println("Invalid enemy attack value");
                    done = true;
                    break;
                case -4:
                    System.out.println("Invalid player attack value");
                    done = true;
                    break;
                default:
                    System.out.println("Attack has returned an invalid value!");
                    done = true;
                    break;
            }
            if (done == true) {
                break;
            }

        }
    }
}