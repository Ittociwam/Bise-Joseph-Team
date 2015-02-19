/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Person;

/**
 *
 * @author Robbie
 */
public class GameControls {

    public static Person createPerson(String playersName) {
        if(playersName == null)
        {
            return null;
        }
        
        Person person = new Person();
        person.setName(playersName);
        BiseJosephTeam.setPerson(person);
        System.out.println("***createPerson function called ***\n");
        return person;
    }

    private int bmi() {
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
