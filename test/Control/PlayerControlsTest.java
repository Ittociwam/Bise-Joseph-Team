/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Character;
import Model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robbie
 */
public class PlayerControlsTest {

    public PlayerControlsTest() {
    }

    /**
     * Test of isAlpha method, of class PlayerControls.
     */
    @Test
    public void testIsAlpha() 
    {
        System.out.println("isAlpha");
        String code = "Hello";
        PlayerControls instance = new PlayerControls();
        boolean expResult = true;
        boolean result = instance.isAlpha(code);
        assertEquals(expResult, result);
        
        code = "4ello";
        expResult = false;
        result = instance.isAlpha(code);
        assertEquals(expResult, result);
        
        code = "hell0";
        expResult = false;
        result = instance.isAlpha(code);
        assertEquals(expResult, result);
        

    }

    /**
     * Test of dicipherCode method, of class PlayerControls.
     */
    @Test
    public void testDicipherCode() 
    {
        // no error
        System.out.println("dicipherCode");
        String code = "prfne pvcure";
        PlayerControls instance = new PlayerControls();
        String expResult = "CESAR CIPHER";
        String result = instance.dicipherCode(code);
        assertEquals(expResult, result);
        
        // invalid input
        code = "prfne pv5ure";
        expResult = "!";
        result = instance.dicipherCode(code);
        assertEquals(expResult, result);
        
        
        // empty input
        code = "";
        expResult = "*";
        result = instance.dicipherCode(code);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of attack method, of class PlayerControls.
     */
    @Test
    public void testAttack() 
    {

        // continue fight
        Character someCharacter = new Character();
        someCharacter.setAttack(5);
        someCharacter.setType('e');
        someCharacter.setHealth(10);

        Player somePlayer = new Player();
        somePlayer.setAttack(9);
        somePlayer.setType('p');
        somePlayer.setHealth(22);

        System.out.println("attack");
        PlayerControls instance = new PlayerControls();

        int expResult = 0;
        int result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //player is dead
        someCharacter.setAttack(5);
        someCharacter.setType('e');
        someCharacter.setHealth(10);

        somePlayer.setAttack(9);
        somePlayer.setType('p');
        somePlayer.setHealth(0);

        System.out.println("attack");

        expResult = 2;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //enemy is dead
        someCharacter.setAttack(5);
        someCharacter.setType('e');
        someCharacter.setHealth(0);

        somePlayer.setAttack(9);
        somePlayer.setType('p');
        somePlayer.setHealth(22);

        System.out.println("attack");

        expResult = 1;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //invalid enemy type
        someCharacter.setAttack(5);
        someCharacter.setType('w');
        someCharacter.setHealth(10);

        somePlayer.setAttack(9);
        somePlayer.setType('p');
        somePlayer.setHealth(22);

        System.out.println("attack");

        expResult = -1;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //invalid player type
        someCharacter.setAttack(5);
        someCharacter.setType('e');
        someCharacter.setHealth(10);

        somePlayer.setAttack(9);
        somePlayer.setType('d');
        somePlayer.setHealth(22);

        System.out.println("attack");

        expResult = -2;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //invalid enemy attack
        someCharacter.setAttack(-4);
        someCharacter.setType('e');
        someCharacter.setHealth(10);

        somePlayer.setAttack(9);
        somePlayer.setType('p');
        somePlayer.setHealth(22);

        System.out.println("attack");

        expResult = -3;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        //invalid player attack
        someCharacter.setAttack(7);
        someCharacter.setType('e');
        someCharacter.setHealth(10);

        somePlayer.setAttack(-9);
        somePlayer.setType('p');
        somePlayer.setHealth(22);

        System.out.println("attack");

        expResult = -4;
        result = instance.attack(somePlayer, someCharacter);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

    }
     @Test
    public void testCalcBMI() 
    {
        System.out.println("calcBMI");
        Player player = new Player();
        player.setHealth(25);
        int fat = 200;
        int tall = 5;
        PlayerControls instance = new PlayerControls();
        int expResult = 65;
        int result = instance.calcBMI(player, fat, tall);
        assertEquals(expResult, result);
        
        System.out.println("calcBMI");
        player.setHealth(25);
        fat = 200;
        tall = -5;
        expResult = -1;
        result = instance.calcBMI(player, fat, tall);
        assertEquals(expResult, result);
        
        System.out.println("calcBMI");
        player.setHealth(25);
        fat = -200;
        tall = 5;
        expResult = -2;
        result = instance.calcBMI(player, fat, tall);
        assertEquals(expResult, result);

    }


}
