/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ItemControl;
import Control.PlayerControls;

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
            System.out.println("Would you like to decode this clue?");
            if(getInput() == "Y")
            doAction(code);
        }
        
        else
        {
            System.out.println("Your code cannot be read.");
        }
        
        
    }
    @Override
    public void doAction(Object obj) {
        String code = (String) obj;
        if (itemControl.checkForItem("decoder")) {
            playerControls.dicipherCode(code);
        } else {
            System.out.println("You don't have a decoder");
        }
    }

}
