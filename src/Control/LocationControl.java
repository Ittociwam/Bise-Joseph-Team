/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Location;
import java.awt.Point;

/**
 *
 * @author Robbie
 */
public final class LocationControl {

    public LocationControl() {
    }

    public static Location generateRandomLocation() {
        Location location = new Location();
        
        Point point = new Point();
        
        point.x = BiseJosephTeam.randInt(0, 4);
        point.y = BiseJosephTeam.randInt(0, 4);
        
        location.setPoint(point);
        
        location.setRoom(BiseJosephTeam.game.getMap().getRooms()
                [BiseJosephTeam.randInt(0, 5)]
                [BiseJosephTeam.randInt(0, 5)]);
        
        return location;
    }
    
}
