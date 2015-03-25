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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie
 */
public class BiseJosephTeam {

    public static Game game;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        BiseJosephTeam.logFile = logFile;
    }
    
    
        try {
    
    BiseJosephTeam.inFile = new BufferedReader(new InputStreamReader(System.in));

        BiseJosephTeam.outFile = new PrintWriter(System.out, true);

        String filePath = "log.txt";
        BiseJosephTeam.logFile = new PrintWriter(filePath);
} 
    catch (Exception e) {
        System.out.println("Exception: " + e.toString() +
                            "\nCause: " + e.getCause() +
                            "\nMessage: " + e.getMessage());
}
    
    finally {
        try {
            if (BiseJosephTeam.inFile != null) {
                BiseJosephTeam.inFile.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(BiseJosephTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (BiseJosephTeam.outFile != null)
        BiseJosephTeam.outFile.close();
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        BiseJosephTeam.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        BiseJosephTeam.inFile = inFile;
    }

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
        try {
            startProgramView.startProgram();
        } catch (Throwable te) {
        try{
            // open all files
        startProgramView.startProgram();
        }catch(Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.startProgram();
        }

    }

}
