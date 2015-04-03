/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robbie
 */
public class Location implements Serializable{

    private Room room;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }


    private Point point;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Point getPoint() {
        return point;
    }

    public boolean setPoint(Point point) {
        if (point.x < 0 || point.x > 24 || point.y < 0 || point.y > 24) {
            return false;
        }

        this.point = point;
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "room=" + room + ", point=" + point + '}';
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
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }

}
