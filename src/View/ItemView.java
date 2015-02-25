/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import Model.Item;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class ItemView {

    private final String INVENTORY = "\n Your current inventory: \n";

    public int openItemMenu(ArrayList<Item> items, PlayerControls playerControls) {
        displayInventory(items);
        int choice = getInput(items.size());
        if (choice > 0) {
            doAction(items.get(choice), playerControls);
            return 1;
        } else {
            return -1;
        }
    }

    private void displayInventory(ArrayList<Item> items) {
        if (items.isEmpty()) {
            System.out.println("You have no items!\n");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i) + "\n");
        }
    }

    private int getInput(int size) {
        final String ERROR = "Invalid item! Please enter a number"
                + "between 1 and" + size + "\n";
        boolean valid = false;
        while (!valid) {
            System.out.println("\t>");
            Scanner keyboard = new Scanner(System.in);
            char value = keyboard.next().charAt(0);
            value = Character.toUpperCase(value);
            if (value == 'E' || value == 'e') {
                break;
            }
            int index = Character.getNumericValue(value);
            if (value < 1 || value > size) {
                System.out.println(ERROR);
                valid = false;
            }
            else if ((int) value <= size) {
                return value - 1;
            }
            else
            {
                valid = false;
            }
        }
        return 0;

    }

    private void doAction(Item item, PlayerControls playerControls) {
        playerControls.useItem(item);
    }
}
