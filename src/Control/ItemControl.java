/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Item;
import Model.Location;
import exceptions.ItemControlException;

/**
 *
 * @author Robbie
 */
public final class ItemControl {

    private ItemControl() {
    }

    public static boolean checkForItem(String item) {
        // if item exists return true
        return true;
    }

    public static Item newItem(String description, int i, char c, Location l) throws ItemControlException {

        Item item = new Item();
        item.setLocation(l);
        
        if (description instanceof String)
        {
            item.setDescription(description);
        } else {
            throw new ItemControlException("Incorrect item description value: " + description + "Must be a string, description: ");
        }

        if (i < 0) {
            throw new ItemControlException("Incorrect point value: " + i + "Must be > 0, points: ");
        } else if (i == (int) i) {
            item.setPoints(i);
        } else {
            throw new ItemControlException("Incorrect point value: " + i + "Must be an integer, points: ");
        }

        if (c == 'w') {
            item.setType(c);
        } else if (c == 'c') {
            item.setType(c);
        } else {
            throw new ItemControlException("Incorrect item type: " + c + " Must be a c or a w");
        }

        return item;
    }

}
