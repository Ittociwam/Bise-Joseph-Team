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

    public String dicipherCode(String code) {

        if (code.isEmpty()) {
            return "*"; // EMPTY ERROR FLAG
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

    public int attack(Player player, Character enemy) {

        if (enemy.getType() != 'e') {
            return -1;
        } // Invalid enemy

        if (player.getType() != 'p') {
            return -2; // invalid player
        }

        if (enemy.getAttack() < 0) {
            return -3; // invalid enemy attack value
        }

        if (player.getAttack() < 0) {
            return -4; // invalid player attack value
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
    
    public int calcBMI(Player player, int fat, int tall){
        int bmi = fat / tall;
        player.setHealth(player.getHealth() + bmi);
        if (fat < 0)
            return -2; // throw error
        else if (tall < 0)
            return -1; // throw error
        else
            return player.getHealth();
    }
    
    public void move(String direction)
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
        }
    }
    
    public void useItem(Item item)
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
             //is not an item!
         }
        
        
    }

    ArrayList<Item> createItemList(Player player) throws ItemControlException {
        ArrayList<Item> items = new ArrayList<>();
        

                
        ItemControl itemControl = new ItemControl();
        
        Item pistol = itemControl.newItem("A short range pistol", 3, 'w', player.getLocation()); // this will be a problem because 
//        Item rifle = itemControl.newItem("A Rusty Rifle", 4, 'w', player.getLocation()); // item will not follow player... set it to null?
//        Item sword = itemControl.newItem("A sharp sword", 5, 'w', player.getLocation());
//        Item bazooka = itemControl.newItem("A boomin boomer", 10, 'w', player.getLocation());
//        Item flameThrower = itemControl.newItem("A flamin' flamer", 12, 'w', player.getLocation());
//        
        items.add(pistol);
//        items.add(rifle);
//        items.add(sword);
//        items.add(bazooka);
//        items.add(flameThrower);
        
        return items;
        
    }
        
}
