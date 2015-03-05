/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import Model.Item;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 */
class ContAndItem {
    public Item myItem;
    public PlayerControls myPlayerControls;
}
public class ItemView extends View{

    private final String INVENTORY = "\n Your current inventory: \n";

    public int openItemMenu(ArrayList<Item> items, PlayerControls playerControls) {
        if(!display(items))
            return -1;
        int choice = validateInput(items.size());
        if (choice > 0) {
            ContAndItem myStuff = null;
            myStuff.myItem = items.get(choice);
            myStuff.myPlayerControls = playerControls;
            doAction(myStuff);
            return 1;
        } else {
            return -1;
        }
    }
    
   
    @Override
    public boolean display(Object object) 
    {
        ArrayList<Item> items = new ArrayList<Item>();
        if(object instanceof ArrayList)
        {
             items = (ArrayList<Item>) object;
        }
  
        // if object is an array list
        if (items.isEmpty())
        {
            System.out.println("You have no items!\n");
            return false;
        }
        for (int i = 0; i < items.size(); i++)
        {
            System.out.println(i + ". " + items.get(i) + "\n");
        }
         return true;   
    }

    private int validateInput(int size) {
        final String ERROR = "Invalid item! Please enter a number"
                + "between 1 and" + size + "\n";
        boolean valid = false;
        if(size <= 0)
        {
            System.out.println("Cannot select from an empty inventory!\n");
            return -1;
        }
        while (!valid) {
            
        
            System.out.println("\t>");
            char value = getInput(); // calling get input here

            if (value == 'E' || value == 'e') {
                break;
                
            }
            int index = Character.getNumericValue(value);
            if (value < 1 || value > size) {
                System.out.println(ERROR);
                valid = false; // input is less than one or greater than the size of array
            }
            else if ((int) value <= size) {
                return value - 1; // return array index
            }
            else
            {
                valid = false; // anything other than this is bad
            }
        }
        return 0;

    }

    public void doAction(Object obj) {
        
        ContAndItem myStuff = (ContAndItem)obj;
        Item item = myStuff.myItem;
        PlayerControls playerControls = myStuff.myPlayerControls;
        playerControls.useItem(item);
    }
}
