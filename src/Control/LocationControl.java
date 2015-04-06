/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Element;
import Model.Location;
import Model.Room;
import exceptions.PlayerControlsException;
import java.awt.Dimension;
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
        int randx = BiseJosephTeam.randInt(0, 5);
        int randy = BiseJosephTeam.randInt(0, 5);
        
        location.setRoom(BiseJosephTeam.game.getMap().getRooms()[randx][randy]);
        Point mPoint = new Point();
        mPoint.x = randx;
        mPoint.y = randy;
        location.getRoom().setCoords(mPoint);
        
        return location;
    }
    
    
    
    public static boolean exceedsRoom(String direction, Location tempLocation) throws PlayerControlsException {
        Point roomPoint = tempLocation.getPoint();

        switch (direction) {
            case "N": // if the user wants to move north
                if (roomPoint.y - 1 == -1) {
                    return true;
                }
                break;
            case "E":
                if (roomPoint.x + 1 == 5) {
                    return true;
                }
                break;
            case "W":
                if (roomPoint.x - 1 == -1) {
                    return true;
                }
                break;
            case "S":
                if (roomPoint.y + 1 == 5) {
                    return true;
                }
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");
        }

        return false;
    }

    public static boolean exceedsMap(String direction, Location tempLocation) throws PlayerControlsException {
        Point mapPoint = tempLocation.getRoom().getCoords();
        //Point roomPoint = tempLocation.getPoint();
        switch (direction) {
            case "N": // if the user wants to move north
                if (mapPoint.y - 1 == -1) {
                    return true;
                }
                break;
            case "E":
                if (mapPoint.x + 1 == 6) {
                    return true;
                }
                break;
            case "W":
                if (mapPoint.x - 1 == -1) {
                    return true;
                }
                break;
            case "S":
                if (mapPoint.y + 1 == 6) {
                    return true;
                }
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");

        }

        return false;
    }

    public static Location shiftInRoom(String direction, Location tempLocation) throws PlayerControlsException {
        Point roomPoint = tempLocation.getPoint();
        switch (direction) {
            case "N": // if the user wants to move north
                roomPoint.y--; // subtract 1 from players y point
                break;
            case "E":
                roomPoint.x++;
                break;
            case "W":
                roomPoint.x--;
                break;
            case "S":
                roomPoint.y++;
                break;
            default:
                throw new PlayerControlsException("Invalid Direction");
        }

        tempLocation.setPoint(roomPoint);
        return tempLocation;

    }

    public static Location shiftInMap(String direction, Location tempLocation) {
        Point roomPoint = tempLocation.getPoint();
        Room room = tempLocation.getRoom();
        Point mapPoint = room.getCoords();

        switch (direction) {
            case "N":
                mapPoint.y--;
                roomPoint.y = 4;
                break;
            case "S":
                mapPoint.y++;
                roomPoint.y = 0;
                break;
            case "E":
                mapPoint.x++;
                roomPoint.x = 0;
                break;
            case "W":
                mapPoint.x--;
                roomPoint.x = 4;
                break;
        }
        room = BiseJosephTeam.game.getMap().getRooms()[mapPoint.x][mapPoint.y];
        room.setCoords(mapPoint);
        tempLocation.setPoint(roomPoint);
        tempLocation.setRoom(room);
        return tempLocation;
    }

    public static void removePastLocation(Location tempLocation) {
        tempLocation.getRoom().elements[tempLocation.getPoint().y][tempLocation.getPoint().x] = new Element();
    }
    
}

