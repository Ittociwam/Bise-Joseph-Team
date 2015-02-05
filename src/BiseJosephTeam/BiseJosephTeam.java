/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiseJosephTeam;

import Model.Coordinates;
import Model.Element;
import Model.Location;
import Model.Character;
import Model.Game;
import Model.Item;
import Model.Player;
import Model.Map;
import Model.Room;
import java.awt.Dimension;
import java.time.LocalTime;
import java.util.ArrayList;



/**
 *
 * @author Robbie
 */
public class BiseJosephTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //TESTING ELEMENT
        Element someElement = new Element();
        someElement.setDescription("This is an empty Element");
        someElement.setLocation(new Location());
        String someElementTest = someElement.toString();
        System.out.println(someElementTest);
        
        //TESTING COORDINATES
        Coordinates someCoords = new Coordinates();
        someCoords.setX(4);
        someCoords.setY(3);
        String someCoordsTest = someCoords.toString();
        System.out.println(someCoordsTest);
        
        //TESTING LOCATION
        Location someLocation = new Location();
        someLocation.setMapCoords(someCoords);
        someLocation.setRoomCoords(someCoords);
        String someLocationTest = someLocation.toString();
        System.out.println(someLocationTest);
        
        //TESTING CHARACTER
        Character someCharacter = new Character();
        someCharacter.setAttack(8);
        someCharacter.setDescription("One crazy dude who will kill you.");
        someCharacter.setHealth(2);
        someCharacter.setLocation(someLocation);
        String someCharacterTest = someCharacter.toString();
        System.out.println(someCharacterTest);
        
        //TESTING ITEM
        Item someItem = new Item();
        someItem.setDescription("A beautiful piece of cheese");
        someItem.setLocation(someLocation);
        someItem.setType('c');
        someItem.setPoints(5);
        someItem.setLocation(someLocation);
        String someItemTest = someItem.toString();
        System.out.println(someItemTest);       
        
        //TESTING PLAYER
        Player somePlayer = new Player();
        somePlayer.setAttack(9);
        somePlayer.setDescription("A not so crazy heroic dude");
        somePlayer.setHealth(6);
        somePlayer.setLocation(someLocation);
        ArrayList items = new ArrayList();
        items.add(someItem);
        somePlayer.setItems(items);
        String somePlayerTest = somePlayer.toString();
        System.out.println(somePlayerTest);

        //TESTING ROOM
        Room someRoom = new Room();
        Room someOtherRoom = new Room();
        someRoom.setDescription("A big room.");
        someOtherRoom.setDescription("A small room.");
        Dimension someDimension = new Dimension(20, 20);
        someRoom.setSize(someDimension);
        someOtherRoom.setSize(someDimension);
        String someRoomTest = someRoom.toString();
        System.out.println(someRoomTest);
        
        //TESTING MAP
        Map someMap = new Map();
        ArrayList rooms = new ArrayList();
        rooms.add(someRoom);
        rooms.add(someOtherRoom);
        
        //TESTING ROOM
        someMap.setRooms(rooms);
        someMap.setSize(someDimension);
        String someMapTest = someMap.toString();
        System.out.println(someMapTest);
        
        //TESTING GAME
        Game someGame = new Game();
        someGame.setEnemiesKilled(5);
        someGame.setMap(someMap);
        someGame.setTime(LocalTime.MIN);
        String someGameTest = someGame.toString();
        System.out.println(someGameTest);
        
        
    };
        

    
}