/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import Model.Player;

/**
 *
 * @author Robbie
 */
public class PlayerControls {

    public PlayerControls() {
    }

    
    public String dicipherCode(String code) {

        String message = null;

        return message;
    }

    public void attack(Player player, Character enemy) {
        boolean done = false;

        if (enemy.getType() != 'e') {
            //ERROR MESSAGE HERE
        }

        if (enemy.getAttack() < 0 || enemy.getHealth() < 0) {
            //INVALID ENEMY STATS ERROR
        }

        if (player.getAttack() < 0 || player.getHealth() < 0) {
            //INVALID ENEMY STATS ERROR
        }

        enemy.setHealth(enemy.getHealth() - player.getAttack());

        player.setHealth(player.getHealth() - enemy.getAttack());

        return;
    }

   

}
