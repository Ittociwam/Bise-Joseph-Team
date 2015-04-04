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

    public static boolean isAlpha(String code) {
        return code.matches("[a-zA-Z\\s]+");
    }

    public static int attack(Player player, Character enemy) throws PlayerControlsException {

        System.out.println("playercontrols attack emeny: " + enemy);
                System.out.println("player: " + player);
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

    private static boolean exceedsRoom(String direction, Location tempLocation) throws PlayerControlsException {
        Point roomPoint = tempLocation.getPoint();

        switch (direction) {
            case "N": // if the user wants to move north
                if (roomPoint.y - 1 == -1) {
                    return true;
                }
                break;
            case "E":
                if (roomPoint.x + 1 == 5) {
                    return true;
                }
                break;
            case "W":
                if (roomPoint.x - 1 == -1) {
                    return true;
                }
                break;
            case "S":
                if (roomPoint.y + 1 == 5) {
                    return true;
                }
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");
        }

        return false;
    }

    private static boolean exceedsMap(String direction, Location tempLocation) throws PlayerControlsException {
        Point mapPoint = tempLocation.getRoom().getCoords();
        //Point roomPoint = tempLocation.getPoint();
        switch (direction) {
            case "N": // if the user wants to move north
                if (mapPoint.y - 1 == -1) {
                    return true;
                }
                break;
            case "E":
                if (mapPoint.x + 1 == 6) {
                    return true;
                }
                break;
            case "W":
                if (mapPoint.x - 1 == -1) {
                    return true;
                }
                break;
            case "S":
                if (mapPoint.y + 1 == 6) {
                    return true;
                }
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");

        }

        return false;
    }

    private static Location shiftInRoom(String direction, Location tempLocation) throws PlayerControlsException {
        Point roomPoint = tempLocation.getPoint();
        switch (direction) {
            case "N": // if the user wants to move north
                roomPoint.y--; // subtract 1 from players y point
                break;
            case "E":
                roomPoint.x++;
                break;
            case "W":
                roomPoint.x--;
                break;
            case "S":
                roomPoint.y++;
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");
        }

        tempLocation.setPoint(roomPoint);
        System.out.println("shiftInRoom is returning: " + tempLocation);
        return tempLocation;

    }

    private static Location shiftInMap(String direction, Location tempLocation) {
        Point roomPoint = tempLocation.getPoint();
        Room room = tempLocation.getRoom();
        Point mapPoint = room.getCoords();

        System.out.println("mappoint before: " + mapPoint + "direction: " + direction);
        switch (direction) {
            case "N":
                System.out.println("changing y: " + mapPoint.y);
                mapPoint.y--;
                System.out.println("to: " + mapPoint.y);
                roomPoint.y = 4;
                break;
            case "S":
                mapPoint.y++;
                roomPoint.y = 0;
                break;
            case "E":
                mapPoint.x++;
                roomPoint.x = 0;
                break;
            case "W":
                mapPoint.x--;
                roomPoint.x = 4;
                break;
        }
        System.out.println("mappoint after: " + mapPoint);
        System.out.println("room before: " + room);
        room = BiseJosephTeam.BiseJosephTeam.game.getMap().getRooms()[mapPoint.x][mapPoint.y];
        room.setCoords(mapPoint);
        System.out.println("room after: " + room);
        tempLocation.setPoint(roomPoint);
        tempLocation.setRoom(room);
        System.out.println("shiftInMap is returning: " + tempLocation);
        return tempLocation;
    }

    private static void removePastLocation(Location tempLocation) {
        tempLocation.getRoom().elements[tempLocation.getPoint().y][tempLocation.getPoint().x] = new Element();
    }

    public static void move(String direction) throws PlayerControlsException {
        // move the character in the direction sent in

        //******If we want this function to print where a character moved then we need it to return 
        // the string of where they moved and print out the string in the view class
        Location tempLocation = BiseJosephTeam.BiseJosephTeam.game.getPlayer().getLocation(); // assign player to a temp player to manipulate it
        Point roomPoint = tempLocation.getPoint();
        Room room = tempLocation.getRoom();
        Point mapPoint = room.getCoords();

        if (exceedsRoom(direction, tempLocation)) {
            System.out.println("!!!!This move is taking us to a new room!!!!");
            if (exceedsMap(direction, tempLocation)) {
                System.out.println("!!!!cannot go this way, out of bounds!!!!"); // do nothing
            } else {
                removePastLocation(tempLocation);
                tempLocation = shiftInMap(direction, tempLocation);
            }

        } else {
            removePastLocation(tempLocation);
            tempLocation = shiftInRoom(direction, tempLocation);
        }

        checkForEnemies(tempLocation);
        //checkForItems(tempLocation);
        BiseJosephTeam.BiseJosephTeam.game.getPlayer().setLocation(tempLocation);

    }

    public static void checkForEnemies(Location location) {

        ArrayList<Character> enemies = BiseJosephTeam.BiseJosephTeam.game.getEnemies();

        for (int i = 0; i < enemies.size(); i++) {
            if (location.equals(enemies.get(i).getLocation())) {
                System.out.println("They are equal !!!!!!!!!!!!!!!!!!!!");
                AttackView attackView = new AttackView();
                attackView.openMenu(BiseJosephTeam.BiseJosephTeam.game.getPlayer(), enemies.get(i));
            }
        }
    }

    public static void checkForItems(Location location) {
        ArrayList<Item> itemGameList = BiseJosephTeam.BiseJosephTeam.game.getItemGameList();
    }

    public static String useItem(Item item) throws PlayerControlsException {

        switch (item.type) {
            case 'w':
                BiseJosephTeam.BiseJosephTeam.game.getPlayer().equip(item);
                return item.description + " equipped! Your attack is now " + BiseJosephTeam.BiseJosephTeam.game.getPlayer().getAttack();
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
