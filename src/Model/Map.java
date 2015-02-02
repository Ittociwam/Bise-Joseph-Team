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
    private ArrayList <Location> locations; 

    public Map() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.size);
        hash = 13 * hash + Objects.hashCode(this.locations);
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
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }


    
    
    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public ArrayList<Location> getRooms() {
        return locations;
    }

    public void setRooms(ArrayList<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Map{" + "size=" + size + ", locations=" + locations + '}';
    }

}
