/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Travis
 */
public class Map {
    private int size;
    private int rooms;

    public Map() {
    }

    
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Map{" + "size=" + size + ", rooms=" + rooms + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.size;
        hash = 53 * hash + this.rooms;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.size != other.size) {
            return false;
        }
        if (this.rooms != other.rooms) {
            return false;
        }
        return true;
    }
    
    
    
    // This function draws the map for the player on the screen
    public void draw() {
    }
}
