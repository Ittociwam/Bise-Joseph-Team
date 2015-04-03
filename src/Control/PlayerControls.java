/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import Model.Item;
import Model.Location;
import Model.Player;
import Model.Room;
import View.AttackView;
import View.ClueView;
import View.RoomView;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author Robbie
 */
public final class PlayerControls {

    private PlayerControls() {
    }

    public static boolean isAlpha(String code) {
        return code.matches("[a-zA-Z\\s]+");
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

        if (enemy.getHealth() <= 0) {
            return 1; // Player has won the fight
        }

        if (player.getHealth() <= 0) {
            return 2; // enemy has won  the fight
        }

        return 0;
    }
    
    public static int calcBMI(int fat, int tall)throws PlayerControlsException{
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
    
    public static void move(String direction) throws PlayerControlsException
    {
        // move the character in the direction sent in
        
        //******If we want this function to print where a character moved then we need it to return 
        // the string of where they moved and print out the string in the view class
        Player tempPlayer = BiseJosephTeam.BiseJosephTeam.game.getPlayer();
        Point point = tempPlayer.getLocation().getPoint();
        Location location = tempPlayer.getLocation();
        Room room = tempPlayer.getLocation().getRoom();
        switch (direction){
            case "N":
                point.y--;
                break;
            case "E":
                point.x++;
                break;
            case "W":
                point.x--;
                break;
            case "S":
                point.y++;
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");
        }
        Point mapPoint = room.getCoords();
        if (point.x == -1 || point.x == 5 || point.y == -1 || point.y == 5) {
            if (mapPoint.x == 5 || mapPoint.x == 0 || mapPoint.y == 5 || mapPoint.x == 0) {
                System.out.println("map about to be out of bounds\n");
                // do nothing because we are at the edge of the map. 
            } else if (point.x == -1) {
                System.out.println("point.x = -1 and mapPoint.x = " + mapPoint.x + "\n");
                mapPoint.x--;
                point.x = 4;
            } else if (point.x == 5) {
                System.out.println("point.x = 5 and mapPoint.x = " + mapPoint.x + "\n");
                mapPoint.x++;
                point.x = 0;
            } else if (point.y == -1) {
                System.out.println("point.y = -1 and mapPoint.x = " + mapPoint.y + "\n");
                mapPoint.y++;
                point.y = 4;
            } else if (point.y == 5) {
                System.out.println("point.y = 5 and mapPoint.y = " + mapPoint.y + "\n");
                mapPoint.y--;
                point.y = 0;
            }
        }
       room = BiseJosephTeam.BiseJosephTeam.game.getMap().getRooms()[mapPoint.x][mapPoint.y];
       location.setRoom(room);
        location.setPoint(point);
        
        checkForEnemies(location);
        checkForItems(location);
        
        tempPlayer.setLocation(location);
        BiseJosephTeam.BiseJosephTeam.game.setPlayer(tempPlayer);
        tempPlayer = new Player();
    }
    
    public static void checkForEnemies(Location location)
    {
     
       ArrayList<Character> enemies = BiseJosephTeam.BiseJosephTeam.game.getEnemies();
        
        for(int i = 0; i < enemies.size(); i++)
        {
            //System.out.println("Checking pl: " + location + " el: " + enemies.get(i).getLocation());
            if(location.equals(enemies.get(i).getLocation()))
            {
                System.out.println("They are equal !!!!!!!!!!!!!!!!!!!!");
                AttackView attackView = new AttackView();
                attackView.openMenu(BiseJosephTeam.BiseJosephTeam.game.getPlayer(), enemies.get(i));
            }
        }
    }
    public static void checkForItems(Location location)
    {
         ArrayList<Item> itemGameList = BiseJosephTeam.BiseJosephTeam.game.getItemGameList();
    }
    
    public static void useItem(Item item) throws PlayerControlsException
    {
        
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
             clueView.openClueView(item.getDescription());
         }
        
        else
         {
             throw new PlayerControlsException("Cannot use item of type: " + item.getType());
         }
        
        
    }

    public static ArrayList<Item> createItemList(Player player) throws ItemControlException {
        ArrayList<Item> items = new ArrayList<>();
        
        Location location = null;
        
        Item pistol = ItemControl.newItem("A short range pistol", 3, 'w', location); // this will be a problem because 
                                                                                                // item will not follow player... set it to null? 
        items.add(pistol);
        
        return items;
        
    }
        
}
