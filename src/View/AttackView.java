package View;

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

    boolean done = false;

    public void openMenu(Player p, Character e) {
        MyStuff myStuff = new MyStuff();
        myStuff.te = e;
        myStuff.tp = p;

        String value = " ";

        do {
            this.doAction(myStuff);
            this.console.println("currentHealth: " + p.getHealth());
            this.console.println("characterHealth: " + e.getHealth());
            this.console.println("Would you like to attack again? Y/N");
            value = getInput();
        } while (value == "Y");
    }

    public void doAction(Object obj) {
        MyStuff myStuff = (MyStuff) obj;
        Player p = myStuff.tp;
        Character e = myStuff.te;
        while (!done) {
            int returnValue = 0;
            try {
                returnValue = PlayerControls.attack(p, e);
            } catch (PlayerControlsException ex) {
                this.console.println(ex.getMessage());
            }
            switch (returnValue) {
                case 2:
                    this.console.println("Player has lost");
                    done = true;
                    break;
                case 1:
                    this.console.println("Enemy has lost");
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
                case 0:
                    this.console.println("Continue the fight");
                    done = false;
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
