/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;

/**
 *
 * @author Robbie
 */
public class PlayerControls {

    
    
    
    String dicipherCode(String code)
    {
        
        
        
        return message;
    }
    
    
    
    
    
    
    
    void attack(Character enemy) 
    {
        bool done = false;
        while (!done) 
        {
            if (enemy.getType != 'e') 
            {
                //ERROR MESSAGE HERE
            }

            if (enemy.getAttack() < 0 || enemy.getHealth() < 0) 
            {
                //INVALID ENEMY STATS ERROR
            }

            if (somePlayer.getAttack() < 0 || player.getHealth() < 0) 
            {
                //INVALID ENEMY STATS ERROR
            }

            enemy.setHealth(enemy.getHealth() - player.getAttack());

            player.setHealth(player.getHealth() - enemy.getAttack());

            //DISPLAY CURRENT HEALTH AND PROMPT USER IF THEY WANT TO ATTACK AGAIN
            String response;
            // response = PLAYERS INPUT
            if ("no".equals(response.toLowerCase())) 
            {
            done = true;
            }
        }
        return;
    }

}

}
