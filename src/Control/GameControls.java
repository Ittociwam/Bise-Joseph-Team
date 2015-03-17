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
        Item[] sortedGameList = null;
        sortedGameList[0] = arr.get(0);
        sortedGameList[1] = arr.get(1);
        sortedGameList[2] = arr.get(2);
        sortedGameList[3] = arr.get(3);
        sortedGameList[4] = arr.get(4);
        
        for (int i = 0; i < sortedGameList.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < sortedGameList.length; j++)
                if (sortedGameList[j].getPoints() < sortedGameList[index].getPoints())
                    index = j;
      
            smallerNumber = sortedGameList[index]; 
            sortedGameList[index] = sortedGameList[i];
            sortedGameList[i] = smallerNumber;
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
