/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.PlayerControls.isAlpha;
import Model.Item;
import Model.Location;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 */
public final class ItemControl {

    private ItemControl() {
    }

    public static String dicipherCode(String code) throws PlayerControlsException {

        if (code.isEmpty()) {
            throw new PlayerControlsException("Cannot decode an empty string."); // EMPTY ERROR FLAG
        }
        String message = "";
        if (isAlpha(code)) {
            code = code.toUpperCase();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (c == ' ') {
                    message += ' ';
                    continue;
                }
                int n = (int) c;
                n = ((n - 65) - 13);
                if (n < 0) {
                    n += 26;
                }
                n = ((n % 26) + 65);
                c = (char) n;
                message += c;
            }

            return message;
        }
        return "!"; // INVALID INPUT ERROR flag
    }

    public static boolean checkForItem(String item) {
        ArrayList<Item> items = BiseJosephTeam.BiseJosephTeam.game.getPlayer().getItems();
        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).description == null ? item == null : items.get(i).description.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static Item newItem(String description, int i, char c, Location l) throws ItemControlException {

        Item item = new Item();
        item.setLocation(l);

        if (description instanceof String) {
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


            item.setType(c);


        return item;
    }

}
