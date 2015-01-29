/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Robbie
 */
public class Location implements Serializable{
        private Coordinates mapCoords;
    private Coordinates roomCoords;

    public Location() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Location other = (Location) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "mapCoords=" + mapCoords + ", roomCoords=" + roomCoords + '}';
    }

    
    
    
    public Coordinates getMapCoords() {
        return mapCoords;
    }

    public void setMapCoords(Coordinates mapCoords) {
        this.mapCoords = mapCoords;
    }

    public Coordinates getRoomCoords() {
        return roomCoords;
    }

    public void setRoomCoords(Coordinates roomCoords) {
        this.roomCoords = roomCoords;
    }
    
    
    
    
}
