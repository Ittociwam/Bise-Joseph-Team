/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Control.RoomControls;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Travis
 */
public class Map {
    Dimension size;
    //ArrayList<Room> rooms;
    private Room[][] rooms;

    public Map() {
        size = new Dimension(6, 6);
        rooms = new Room[6][6];

        RoomControls roomControls = new RoomControls();
        for(int row = 0; row < 6; row++)
            for(int col = 0; col < 6; col++)
            {
                rooms[row][col] = roomControls.generateRandomRoom();
            }
    }

    public Map(int row, int col) {
     // map must be 6 x 6 always. 
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }
}
