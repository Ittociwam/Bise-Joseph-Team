/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Robbie
 */
public class GameControls {
    
            private int bmi(){
        int weight = 0;
        int height = 0;
        
        System.out.println("Enter a weight");
       //user input
        
        System.out.println("Enter a height");
        //user input
        
        int extraPoints = weight / height;
        return extraPoints;
        }
    
}
