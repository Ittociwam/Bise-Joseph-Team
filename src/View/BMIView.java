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
            display("Add points to your health by entering your height"
                    + "and weight to calculate your bmi!\n");
        
        display("Please enter your weight: ");
        
        String input = getInput();
        int weight = parseInt(input);
        
        display("Please enter your height: ");
        
        input = getInput();
        int height = parseInt(input);
        int newHealth = PlayerControls.calcBMI(weight, height);
        this.console.println("Your new health is " + newHealth);
        }
        
        catch(NumberFormatException nfe){
            ErrorView.display(this.getClass().getName(),nfe.getMessage());
        }
    }

    @Override
    public void doAction(Object obj) {
        int bmi = (int)obj;
 BiseJosephTeam.BiseJosephTeam.game.getPlayer().setHealth(BiseJosephTeam.BiseJosephTeam.game.getPlayer().getHealth() + bmi);
    }
    
}
