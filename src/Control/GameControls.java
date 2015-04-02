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
import View.BMIView;
import exceptions.GameControlException;
import exceptions.ItemControlException;
import exceptions.PlayerControlsException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.max;

/**
 *
 * @author Robbie
 */
public final class GameControls {

    public static void printItemList(Game game, String filePath) throws GameControlException {
        ArrayList<Item> reportList = BiseJosephTeam.game.getItemGameList();
        
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(reportList);
        }
        catch (IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

//    public static void printItemList() {
//        Item storeList = new Item();
//        ArrayList<Item> reportList = BiseJosephTeam.game.getItemGameList();
//        
//        this.console.println("Description----------Points-----Type--");
//        for (int i = 0; i < reportList.size(); i++)
//        {
//            storeList = reportList.get(i);
//            this.console.println(storeList.description);
////            this.console.println(newListItem.description + "\n");
//        }
//    }

    private GameControls() {
    }

    public static void createPerson(String playersName)throws GameControlException, PlayerControlsException {
        if(playersName == null)
        {
            throw new GameControlException("Cannot create person when"
                    + "playersName is null."
                    + "playersName: " + playersName);
        }

        BiseJosephTeam.game.getPerson().setName(playersName);

        BMIView bMIView = new BMIView();
        bMIView.openBMIView();
    }

    public static Game  createNewGame(String name) throws GameControlException, PlayerControlsException, ItemControlException {
        
        Game game = new Game();
        
        BiseJosephTeam.setGame(game);
        
        createPerson(name);
        
        game.setPerson(BiseJosephTeam.game.getPerson());
        
        Player player = new Player();
        game.setPlayer(player);
        
        Map map = new Map();
        game.setMap(map);
        MapControls.movePlayerToStartingLocation(map, player);
        
        ArrayList<Item> items = PlayerControls.createItemList(player);
        player.setItems(items);        
        
        BiseJosephTeam.game.initializeGameItems();
        ArrayList<Character> enemies = new ArrayList<>();
        
        
        
       CharacterControl.addEnemies(10);
        
        game.setEnemiesKilled(0);
        
        game.setTime(LocalTime.MIN);
        
        return game;
    }

    public static void saveGame(Game game, String filePath) throws GameControlException {
        try( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(game);
        }
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) throws GameControlException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream output = new ObjectInputStream(fips);
            
            game = (Game) output.readObject();
        }
        catch(FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        BiseJosephTeam.setGame(game);
    }
    
    
    public static Character findStrongestEnemy() throws GameControlException
    {
        ArrayList<Character> characterCompare = new ArrayList<>();
        for(Character character : BiseJosephTeam.getGame().getEnemies())
        {
            characterCompare.add(character);
        } 
        
        if(characterCompare.isEmpty())
        {
            throw new GameControlException("Enemy array is empty.");
        }
        
        Character tmp = characterCompare.get(0);
        
        for(int i = 1; i < characterCompare.size(); i++)
        {
            if(characterCompare.get(i).getAttack() > tmp.getAttack())
            {
                tmp = characterCompare.get(i);
            }
        }
        
        return tmp;
        
        
        
    }
    
//    public static void sortGameItems(){
//        
//        Item smallerNumber = new Item();
//        ArrayList<Item> arr = BiseJosephTeam.game.getItemGameList();
//        this.console.println(arr.toString());
//        Item newListItem = new Item();
//        for (int i = 0; i < arr.size() - 1; i++)
//        {
//            int index = i;
//            for (int j = i + 1; j < arr.size(); j++){
//                if (arr.get(j).getPoints() < arr.get(index).getPoints())
//                    index = j;
//            }
//      
//            smallerNumber = arr.get(index); 
//            arr.set(index, arr.get(i));
//            arr.set(i, smallerNumber);
//            newListItem = arr.get(index);
//            this.console.println(newListItem.description + "\n");
//            
//        }
//        this.console.println("Your weapons from weakest to strongest\n");
//        
//    }

}
