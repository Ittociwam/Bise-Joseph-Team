/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import Model.Item;
import Model.Player;
import View.ClueView;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.util.ArrayList;


/**
 *
 * @author Robbie
 */
public class PlayerControls {

    public PlayerControls() {
    }

    public boolean isAlpha(String code) {
        return code.matches("[a-zA-Z\\s]+");
    }

    public String dicipherCode(String code) throws PlayerControlsException {

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
                int n = (int)c;
                n = ((n - 65) - 13);
                if (n < 0) 
                {
                    n += 26;
                }
                n = ((n % 26) + 65);
                c = (char)n;
                message += c;
            }

            return message;
        }
        return "!"; // INVALID INPUT ERROR flag
    }

    public int attack(Player player, Character enemy) throws PlayerControlsException {

        if (enemy.getType() != 'e') {
            throw new PlayerControlsException("Cannot fight this type of character");
        } // Invalid enemy

        if (player.getType() != 'p') {
            throw new PlayerControlsException("Cannot battle with this type of character"); // invalid player
        }

        if (enemy.getAttack() < 0) {
            throw new PlayerControlsException("Enemy attack cannot be below zero"); // invalid enemy attack value
        }

        if (player.getAttack() < 0) {
            throw new PlayerControlsException("Player attack cannot be below zero"); // invalid player attack value
        }

        enemy.setHealth(enemy.getHealth() - player.getAttack());

        player.setHealth(player.getHealth() - enemy.getAttack());

        if (enemy.getHealth() <= 0) {
            return 1; // Player has won the fight
        }

        if (player.getHealth() <= 0) {
            return 2; // enemy has won  the fight
        }

        return 0;
    }
    
    public int calcBMI(int fat, int tall)throws PlayerControlsException{
        if (fat < 0)
            throw new PlayerControlsException("Invalid weight input in calcBMI"); // throw error
        else if (tall < 0)
            throw new PlayerControlsException("Invalid height input in calcBMI"); // throw error
        else
        {
            int bmi = fat / tall;
           
            return bmi;
        }
    }
    
    public void move(String direction) throws PlayerControlsException
    {
        // move the character in the direction sent in
        System.out.print("You moved ");
        switch (direction){
            case "N":
                System.out.print("North.\n");
                break;
            case "E":
                System.out.print("East.\n");
                break;
            case "W":
                System.out.print("West.\n");
                break;
            case "S":
                System.out.print("South.\n");
                break;
            default:
                throw new PlayerControlsException("Cannot decode an empty string.");
        }
    }
    
    public void useItem(Item item) throws PlayerControlsException
    {
        System.out.println("use item called\n");
        
        if(item.getType() == 'Q')
        {
            //if item is of type Q it is equipable
        }
        
         else if(item.getType() == 'U')
        {
            // if item is of type U it is usable once
        }
         
         else if(item.getType() == 'C')
         {
             ClueView clueView = new ClueView();
             ItemControl itemControl = new ItemControl();
             clueView.openClueView(this, item.getDescription(), itemControl);
         }
        
        else
         {
             throw new PlayerControlsException("Cannot use item of type: " + item.getType());
         }
        
        
    }

    ArrayList<Item> createItemList(Player player) throws ItemControlException {
        ArrayList<Item> items = new ArrayList<>();
        

                
        ItemControl itemControl = new ItemControl();
        
        Item pistol = itemControl.newItem("A short range pistol", 3, 'w', player.getLocation()); // this will be a problem because 
                                                                                                // item will not follow player... set it to null? 
        items.add(pistol);
        
        return items;
        
    }
        
}
