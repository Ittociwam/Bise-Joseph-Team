/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Item;
import Model.Location;

/**
 *
 * @author Robbie
 */
public class ItemControl {

    public boolean checkForItem(String item) {
        System.out.println("check for item called");
        return true;
    }

    public Item newItem(String description, int i, char c, Location l) {
        
        Item item = new Item();

        item.setDescription(description);
        item.setPoints(i);
        item.setType(c);
        item.setLocation(l);
        
        
        return item;
    }

}
