/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ItemControl;
import Control.PlayerControls;
import Model.Item;
import exceptions.PlayerControlsException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
public class PickupView extends View {

    public void openPickupMenu(Item item) {

        String message = "You have stumbled across: ";
        if (item.getType() == 'c') {
            message += "a clue. Would you like to view it? Y/N";
        } else {
            message += item.getDescription() + " Would you like to pick it up? Y/N";
        }

        display(message);
        String input = getInput();
        if ("Y".equals(input)) {
            doAction(item);
        }
        console.println("Enter 'c' to continue");
        String cont = getInput();
        

    }

    public void doAction(Object obj) {

        Item i = (Item) obj;
        try {
            console.println(PlayerControls.useItem(i));
        } catch (PlayerControlsException ex) {
            Logger.getLogger(PickupView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
