package View;

import Control.PlayerControls;
import Model.Player;
import Model.Character;
import java.util.Scanner;

/**
 *
 * @author Travis
 */
public class AttackView {

    boolean done = false;
    PlayerControls playerControls = new PlayerControls();
    Player somePlayer = new Player();
    Character someCharacter = new Character();

    private void doAction() {
        while (!done) {
            int returnValue = playerControls.attack(somePlayer, someCharacter);
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

    private void getInput() {
        System.out.println("currentHealth: " + somePlayer.getHealth());
        System.out.println("characterHealth: " + someCharacter.getHealth());
        System.out.println("Would you like to attack again?");
        Scanner input = new Scanner(System.in);
        String response = input.next();

        // response = PLAYERS INPUT
        if ("no".equals(response.toLowerCase())) {
            done = true;

        }
    }
}
