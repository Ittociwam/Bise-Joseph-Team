/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Room;

import java.util.Random;

/**
 *
 * @author Robbie
 */
public class RoomControls {

    public Room generateRandomRoom() {
        Random randomGenerator = new Random();
        MapControls mapControls = new MapControls();
        int num = randomGenerator.nextInt(5);
        System.out.println("random number: " + Integer.toString(num));
        return mapControls.getARoom(num);
    }
    
}
