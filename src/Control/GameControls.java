/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BiseJosephTeam.BiseJosephTeam;
import Model.Element;
import Model.Game;
import Model.Item;
import Model.Map;
import Model.Person;
import Model.Player;
import java.time.LocalTime;
import java.util.ArrayList;

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
        
        game.setEnemiesKilled(0);
        
        game.setTime(LocalTime.MIN);
        
        return game;
    }
    
    public void findStrongestEnemy()
    {
        ArrayList<Character> charCompare = new ArrayList<>();
        for(Model.Character character : BiseJosephTeam.getGame().getEnemies())
        {
            
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
