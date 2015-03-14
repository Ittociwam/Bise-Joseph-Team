/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Robbie
 */
public class Location implements Serializable{

    private Room room;
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

}
