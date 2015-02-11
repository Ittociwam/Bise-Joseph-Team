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

    public int attack(Player player, Character enemy) {

        if (enemy.getType() != 'e') {
            return -1;
        } // Invalid enemy
        
        if(player.getType() != 'p'){
            return -2; // invalid player
        }

        if (enemy.getAttack() < 0) {
            return -3; // invalid enemy attack value
        }

        if (player.getAttack() < 0) {
            return -4; // invalid player attack value
        }

        if (enemy.getHealth() <= 0) {
            return 1; // Player has won the fight
        }

        if (player.getHealth() <= 0) {
            return 2; // enemy has won  the fight
        }

        enemy.setHealth(enemy.getHealth() - player.getAttack());

        player.setHealth(player.getHealth() - enemy.getAttack());

        return 0;
    }

   

}
