/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Travis
 */
public class Map {
    private Dimension size;
    private Room rooms[]; 

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Map() {
    }
    
    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

}
