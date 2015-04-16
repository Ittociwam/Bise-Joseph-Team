/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Control.PlayerControls;
import Model.Item;
import exceptions.PlayerControlsException;
import exceptions.ItemViewException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */

public class ItemView extends View {

    private final String INVENTORY = "\n Your current inventory: \n";

    public int openItemMenu(ArrayList<Item> items) throws ItemViewException {
        if (!display(items)) {
            throw new ItemViewException("Invalid Display");
        }
        int choice = validateInput(items.size());
        if (choice > 0) {
            doAction(items.get(choice));
            return 1;
        } else {
            throw new ItemViewException("Choice was not > 0");
        }
    }

    @Override
    public boolean display(Object object) {
        ArrayList<Item> items = new ArrayList<Item>();
        if (object instanceof ArrayList) {
            items = (ArrayList<Item>) object;
        }

        // if object is an array list
        if (items.isEmpty()) {
            ErrorView.display(this.getClass().getName(),"You have no items!\n");
            return false;
        }
        this.console.println("Please select the item you wish to equip or use"
                + "Or press 'E to exit.");
        for (int i = 0; i < items.size(); i++) {
            this.console.println(i + 1 + ". " + items.get(i).getDescription() + "\n");
        }
        return true;
    }

    private int validateInput(int size) {
        final String ERROR = "Invalid item! Please enter a number "
                + "between 1 and " + size + "\n";
        boolean valid = false;
        if (size <= 0) {
            this.console.println("Cannot select from an empty inventory!\n");
            return -1;
        }
        while (!valid) {

            String value = getInput(); // calling get input here

            if ("E".equals(value) || "e".equals(value)) {
                valid = false;
                break;

            }
            try {
                int index = Integer.parseInt(value);

                if (index < 1 || index > size) {
                    ErrorView.display(this.getClass().getName(),ERROR);
                    this.console.println("value: " + index);
                    valid = false; // input is less than one or greater than the size of array
                } else if (index <= size) {
                    return index - 1; // return array index
                } else {
                    valid = false; // anything other than this is bad
                }
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"Please enter a number");
                valid = false;
                continue;
            }
        }
        return 0;

    }

    public void doAction(Object obj) {

        Item item = (Item)obj;
        BiseJosephTeam.BiseJosephTeam.game.getPlayer().equip(item);
        console.println(item.getDescription() + " equiped. Attack is now " + item.getPoints());
    }

    void printItemList() {
        this.console.println("\n\nEnter the file path for file where report"
                + "will be saved.");
        String filePath = this.getInput();
        
        try {
            
        }
        catch (Exception ex) {
            ErrorView.display("ItemView", ex.getMessage());
        }
    }
}
