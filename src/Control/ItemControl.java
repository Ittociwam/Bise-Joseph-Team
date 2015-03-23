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
public class ItemControl {

    public boolean checkForItem(String item) {
        System.out.println("check for item called");
        return true;
    }

    public Item newItem(String description, int i, char c, Location l) throws ItemControlException {
        
        Item item = new Item();

        item.setLocation(l);
        
        if (item.description instanceof String)
        {
            item.setDescription(description);
        }
        else
            throw new ItemControlException("Incorrect description value:" + item.description + "Must be a string, description: ");
        
        if (item.points < 0)
        {
            throw new ItemControlException("Incorrect point value: " + item.points + "Must be > 0, points: ");
        }
        else if (item.points == (int)item.points)
        {
            item.setPoints(i);
        }
        else 
            throw new ItemControlException("Incorrect point value: " + item.points + "Must be an integer, points: ");
        
        if (item.type != 'w' || item.type != 'c')
            throw new ItemControlException("Incorrect item type: " + item.type + "Must be a c or a w, type: ");
        
               
        return item;
    }

}
