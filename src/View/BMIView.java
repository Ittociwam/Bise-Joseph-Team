/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;
import exceptions.PlayerControlsException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 *
 * @author Robbie
 */
public class BMIView extends View{
    
    public void openBMIView() throws PlayerControlsException{
        try{
        PlayerControls playerControls = new PlayerControls();
        
        System.out.println("Please enter your weight: ");
        
        String input = getInput();
        int weight = parseInt(input);
        
        System.out.println("Please enter your height: ");
        
        input = getInput();
        int height = parseInt(input);
        int newHealth = playerControls.calcBMI(BiseJosephTeam.BiseJosephTeam.game.getPlayer(), weight, height);
        System.out.println("Your new health is " + newHealth);
        }
        
        catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage());
        }
    }

    @Override
    public void doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
