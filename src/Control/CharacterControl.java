/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import BiseJosephTeam.BiseJosephTeam;
import Model.Room;
import Control.LocationControl;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Robbie
 */
public final class CharacterControl {

    private static String[] enemyTypes;

    public static Character generateRandomEnemy() {

        Character character = new Character();
        enemyTypes = new String[4];
        enemyTypes[0] = ("An ugly looking zombie");
        enemyTypes[1] = ("Another ugly looking zombie");
        enemyTypes[2] = ("A really ugly looking zombie");
        enemyTypes[3] = ("An ugly looking nazi-zombie");

        LocationControl lC = new LocationControl();

        character.setDescription(enemyTypes[BiseJosephTeam.randInt(0, 3)]);
        character.setAttack(BiseJosephTeam.randInt(1, 20));
        character.setHealth(BiseJosephTeam.randInt(1, 15));
        character.setLocation(LocationControl.generateRandomLocation());

        return character;

    }

    public static void addEnemies(int numEnemies) {

        ArrayList<Character> enemies = new ArrayList<>();

        for (int i = 0; i < numEnemies; i++) {
            
            Character enemy = generateRandomEnemy();
            
            enemies.add(enemy);

        }

        BiseJosephTeam.game.setEnemies(enemies);
    }

}
