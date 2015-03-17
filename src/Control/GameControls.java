/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import static BiseJosephTeam.BiseJosephTeam.game;
import Model.Element;
import Model.Game;
import Model.Item;
import Model.Map;
import Model.Person;
import Model.Character;
import Model.Player;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.max;

/**
 *
 * @author Robbie
 */
public class GameControls {

    public static void createPerson(String playersName) {
        if(playersName == null)
        {
            return;
        }

        System.out.println(playersName);
        BiseJosephTeam.game.getPerson().setName(playersName);

        // call bmiView 
        System.out.println("***createPerson function called ***\n");
    }

    public static Game  createNewGame(String name) {
        PlayerControls playerControls = new PlayerControls();
        
        Game game = new Game();
        
        BiseJosephTeam.setGame(game);
        
        createPerson(name);
        
        game.setPerson(BiseJosephTeam.game.getPerson());
        
        Player player = new Player();
        game.setPlayer(player);
        
        Map map = new Map();
        game.setMap(map);
        MapControls.movePlayerToStartingLocation(map);
        
        ArrayList<Item> items = playerControls.createItemList(player);
        player.setItems(items);        
        
        ArrayList<Item> itemGameList = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();
        game.setitemGameList(itemGameList);
        
        CharacterControl cC = new CharacterControl();
        
        cC.addEnemies(10);
        
        game.setEnemiesKilled(0);
        
        game.setTime(LocalTime.MIN);
        
        return game;
    }
    
    public void findStrongestEnemy()
    {
        ArrayList<Character> characterCompare = new ArrayList<>();
        for(Character character : BiseJosephTeam.getGame().getEnemies())
        {
            characterCompare.add(character);
        }
        
        Character tmp = characterCompare.get(0);
        
        for(int i = 1; i < characterCompare.size(); i++)
        {
            if(characterCompare.get(i).getAttack() > tmp.getAttack())
            {
                tmp = characterCompare.get(i);
            }
        }
        
        System.out.println("The strongest enemy in this game is: " + tmp.toString() + "\n");
        
        
    }
    
    public void sortGameItems(){
        
        Item smallerNumber = new Item();
        ArrayList<Item> arr = game.getItemGameList();
        
        for (int i = 0; i < arr.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++)
                if (arr.get(j).getPoints() < arr.get(index).getPoints())
                    index = j;
      
            smallerNumber = arr.get(index); 
            arr.set(index, arr.get(i));
            arr.set(i, smallerNumber);
            System.out.println(arr.get(index));
        }
        
        
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
