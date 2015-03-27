/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ItemControl;
import Control.PlayerControls;
import exceptions.PlayerControlsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
class myStuff {
}

public class ClueView extends View {

    private ItemControl itemControl;
    private PlayerControls playerControls;

    public void openClueView(PlayerControls playerControls, String code, ItemControl itemControl) {
        if (display(code)) {
            this.console.println("Would you like to decode this clue?");
            if (getInput() == "Y") {
                doAction(code);
            }
        } else {
            ErrorView.display(this.getClass().getName(),"Your code cannot be read.");
        }

    }

    @Override
    public void doAction(Object obj) {
        String code = (String) obj;
        if (itemControl.checkForItem("decoder")) {
            try {
                playerControls.dicipherCode(code);
            } catch (PlayerControlsException ex) {
                Logger.getLogger(ClueView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ErrorView.display(this.getClass().getName(),"You don't have a decoder");
        }
    }

}
