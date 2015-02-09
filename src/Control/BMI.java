/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static java.lang.System.in;

/**
 *
 * @author Travis
 */
public class BMI {
        
        private int bmi(){
        int weight;
        int height;
        
        System.out.println("Enter a weight");
        weight.nextInt();
        
        System.out.println("Enter a height");
        height.nextInt();
        
        int extraPoints = weight / height;
        return extraPoints;
        }
}
