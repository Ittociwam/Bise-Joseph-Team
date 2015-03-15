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
        System.out.println("Please select the item you wish to equip or use"
                + "Or press 'E to exit.");
        for (int i = 0; i < items.size(); i++)
        {
            System.out.println(i + 1 + ". " + items.get(i).getDescription() + "\n");
        }
         return true;   
    }

    private int validateInput(int size) {
        final String ERROR = "Invalid item! Please enter a number "
                + "between 1 and " + size + "\n";
        boolean valid = false;
        if(size <= 0)
        {
            System.out.println("Cannot select from an empty inventory!\n");
            return -1;
        }
        while (!valid) {

            char value = getInput(); // calling get input here

            if (value == 'E' || value == 'e') {
                valid = false;
                break;
                
            }
            int index = Character.getNumericValue(value);
            if (index < 1 || index > size) {
                System.out.println(ERROR);
                System.out.println("value: " + index);
                valid = false; // input is less than one or greater than the size of array
            }
            else if ( index <= size) {
                return index - 1; // return array index
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
