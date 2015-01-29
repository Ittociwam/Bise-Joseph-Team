/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiseJosephTeam;

import Model.Element;
import Model.Location;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Robbie
 */
public class BiseJosephTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element firstElement = new Element();
        
        firstElement.setDescription("This is an empty Element");
        firstElement.setLocation(new Location());
        
        String elementInfo = firstElement.toString();
        System.out.println(elementInfo);
        
        
        
    }
    
}