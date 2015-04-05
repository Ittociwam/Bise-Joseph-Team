/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import Model.Element;
import Model.Item;
import Model.Location;
import Model.Player;
import Model.Room;
import View.AttackView;
import View.ClueView;
import View.PickupView;
import View.RoomView;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Robbie
 */
public final class PlayerControls {

    private PlayerControls() {
    }



    public static int attack(Player player, Character enemy) throws PlayerControlsException {

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
        
        if(enemy.getHealth() <= 0 && player.getHealth() <=0)
        {
            player.setHealth(1); // player won but blacked out
               return 3; 
        }

        if (enemy.getHealth() <= 0) {

            return 1; // Player has won the fight
        }

        if (player.getHealth() <= 0) {
            return 2; // enemy has won  the fight
        }

        return 0;
    }

    public static int calcBMI(int fat, int tall) throws PlayerControlsException {
        if (fat < 0) {
            throw new PlayerControlsException("Invalid weight input in calcBMI"); // throw error
        } else if (tall < 0) {
            throw new PlayerControlsException("Invalid height input in calcBMI"); // throw error
        } else {
            int bmi = fat / tall;

            return bmi;
        }
    }


    public static void move(String direction) throws PlayerControlsException {
        // move the character in the direction sent in

        //******If we want this function to print where a character moved then we need it to return 
        // the string of where they moved and print out the string in the view class
        Location tempLocation = BiseJosephTeam.BiseJosephTeam.game.getPlayer().getLocation(); // assign player to a temp player to manipulate it
        Point roomPoint = tempLocation.getPoint();
        Room room = tempLocation.getRoom();
        Point mapPoint = room.getCoords();

        if (LocationControl.exceedsRoom(direction, tempLocation)) {
            if (LocationControl.exceedsMap(direction, tempLocation)); // do nothing
            else {
                LocationControl.removePastLocation(tempLocation);
                tempLocation = LocationControl.shiftInMap(direction, tempLocation);
            }

        } else {
            LocationControl.removePastLocation(tempLocation);
            tempLocation = LocationControl.shiftInRoom(direction, tempLocation);
        }

        checkForEnemies(tempLocation);
        checkForItems(tempLocation);
        BiseJosephTeam.BiseJosephTeam.game.getPlayer().setLocation(tempLocation);

    }

    public static void checkForEnemies(Location location) {

        ArrayList<Character> enemies = BiseJosephTeam.BiseJosephTeam.game.getEnemies();

        for (int i = 0; i < enemies.size(); i++) {
            if (location.equals(enemies.get(i).getLocation())) {
                AttackView attackView = new AttackView();
                attackView.openMenu(BiseJosephTeam.BiseJosephTeam.game.getPlayer(), enemies.get(i));
            }
        }
    }

    public static void checkForItems(Location location) {
               ArrayList<Item> items = BiseJosephTeam.BiseJosephTeam.game.getItemGameList();

        for (int i = 0; i < items.size(); i++) {
            if (location.equals(items.get(i).getLocation())) {
                PickupView pV = new PickupView();
                pV.openPickupMenu(items.get(i));
                
            }
        }
    }

    public static String useItem(Item item) throws PlayerControlsException {

        switch (item.type) {
            case 'w':
                BiseJosephTeam.BiseJosephTeam.game.getPlayer().getItems().add(item);
                return item.description + " added! Go to your inventory to equip ";
            case 'c':
                if (ItemControl.checkForItem("decoder")) {
                    return "The clue has beed deciphered!: " + ItemControl.dicipherCode(item.getDescription());
                } else {
                    return "You don't have the decoder yet! The clue reads: " + item.getDescription();
                }

            case 'h':
                BiseJosephTeam.BiseJosephTeam.game.getPlayer().setHealth(BiseJosephTeam.BiseJosephTeam.game.getPlayer().getHealth() + item.getPoints());
                return "Your health is now at:  " + BiseJosephTeam.BiseJosephTeam.game.getPlayer().getHealth();
            case 'd':
                BiseJosephTeam.BiseJosephTeam.game.getPlayer().getItems().add(item);
                return "You have the decoder!";
            default:
                throw new PlayerControlsException("Cannot use item of type: " + item.getType());

        }

    }

    public static ArrayList<Item> createItemList(Player player) throws ItemControlException {
        ArrayList<Item> items = new ArrayList<>();

        Location location = null;

        Item pistol = ItemControl.newItem("A short range pistol", 3, 'w', location); 
        items.add(pistol);
        player.equip(pistol);

        return items;

    }

}
