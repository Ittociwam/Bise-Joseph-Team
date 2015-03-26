/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Map;
import Model.Room;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 */
public class MapControls {

    private Room[] roomTypes;

    public MapControls() {
        roomTypes = new Room[5];
        initializeRooms();
    }

    public static void createMap() {
        // this is done in map constructor
    }

    static void movePlayerToStartingLocation(Map map) {

    }

    public void initializeRooms() {

        for (int i = 0; i < 5; i++) {
            roomTypes[i] = new Room();
        }


        roomTypes[0].setDescription("A forest area");
        roomTypes[1].setDescription("A Beach Area");
        roomTypes[2].setDescription("A picnic area");
        roomTypes[3].setDescription("A zoo");
        roomTypes[4].setDescription("A bathroom");
    }

    public Room getARoom(int num) {

        return roomTypes[num];
    }

}
