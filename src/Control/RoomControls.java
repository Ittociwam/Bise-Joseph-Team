/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Room;
import static java.lang.System.console;

import java.util.Random;

/**
 *
 * @author Robbie
 */
public final class RoomControls {

    public static Room generateRandomRoom() {
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(5);
        return MapControls.getARoom(num);
    }

    private RoomControls() {
    }
    
}
