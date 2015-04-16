package View;

import Control.CharacterControl;
import Control.PlayerControls;
import Model.Player;
import Model.Character;
import exceptions.PlayerControlsException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Travis
 */
class MyStuff {

    Player tp = new Player();
    Character te = new Character();
}

public class AttackView extends View {

    public void openMenu(Player p, Character e) {
        MyStuff myStuff = new MyStuff();
        myStuff.te = e;
        myStuff.tp = p;
        this.doAction(myStuff); // initial attack
        console.println("You were attacked by " + e.getDescription());

        String value = " ";

        do {

            this.console.println("Your health: health: " + p.getHealth());
            this.console.println("Your enemies health: " + e.getHealth());
            if (p.getHealth() >= 0 && e.getHealth() >= 0) {
                this.doAction(myStuff);
                this.console.println("Would you like to attack back? Y/N");
                value = getInput();
                if ("Y".equals(value)) {
                    this.console.println("yes");
                    this.doAction(myStuff);
                    continue;
                } 
            }
            console.println("Enter 'c' to continue");
            value = getInput();

        } while (value == "C");
    }

    public void doAction(Object obj) {
        MyStuff myStuff = (MyStuff) obj;
        Player p = myStuff.tp;
        Character e = myStuff.te;
        boolean done = false;

        while (!done) {
            int returnValue = 0;
            try {
                returnValue = PlayerControls.attack(p, e);
            } catch (PlayerControlsException ex) {
                this.console.println(ex.getMessage());
            }
            switch (returnValue) {
                case 3:
                    this.console.println("After an intense battle you blacked out and woke up with low health");
                    done = true;
                    break;
                case 2:
                    this.console.println("You did not survive the attack");
                    done = true;
                    StartProgramView sPV = new StartProgramView();
                     {
                        try {
                            sPV.startProgram(); // if player dies restart program
                        } catch (IOException ex) {
                            Logger.getLogger(AttackView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 1:
                    this.console.println("You defeated " + e.getDescription());
                    done = true;
                    CharacterControl.killCharacter(e.getLocation());
                    break;
                case 0:
                    this.console.println("Continue the fight");
                    done = true;
                    break;
                case -1:
                    ErrorView.display(this.getClass().getName(), "Invalid enemy type");
                    done = true;
                    break;
                case -2:
                    ErrorView.display(this.getClass().getName(), "Invalid player type");
                    done = true;
                    break;
                case -3:
                    ErrorView.display(this.getClass().getName(), "Invalid enemy attack value");
                    done = true;
                    break;
                case -4:
                    ErrorView.display(this.getClass().getName(), "Invalid player attack value");
                    done = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "Attack has returned an invalid value!");
                    done = true;
                    break;
            }
            if (done == true) {
                break;
            }

        }
    }
}
