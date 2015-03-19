/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiseJosephTeam;

import Control.PlayerControls;
import Model.Coordinates;
import Model.Element;
import Model.Location;
import Model.Character;
import Model.Game;
import Model.Item;
import Model.Player;
import Model.Map;
import Model.Person;
import Model.Room;
import View.StartProgramView;
import java.awt.Dimension;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Robbie
 */
public class BiseJosephTeam {

    public static Game game;

    public BiseJosephTeam() {
        game = new Game();
    }

    public static Game getGame() {
        System.out.println("get game called\n");
        return game;
    }

    public static void setGame(Game game) {
        BiseJosephTeam.game = game;
    }

    
    // a random number function to use in the game. pass in 2 ints and it will give
    // you an int in that range. 
    public static int randInt(int min, int max) {
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt((max - min) + 1) + min;
        return num;
    }

    public static void main(String[] args) {

        StartProgramView startProgramView = new StartProgramView();
        try{
        startProgramView.startProgram();
        }catch(Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.startProgram();
        }
 
    }

}
