/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.CharacterControl;
import Control.ItemControl;
import Control.LocationControl;
import exceptions.ItemControlException;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Robbie
 */
public class Game implements Serializable {

    private Player player;
    private Person person;
    private int enemiesKilled;
    private LocalTime time;
    private Map map;
    private ArrayList<Item> itemGameList;
    private ArrayList<Character> enemies;


    public Game() {

        person = new Person();
        player = new Player();
        
        itemGameList = new ArrayList<>();
        enemies = new ArrayList<>();

        map = new Map();

    }

    public ArrayList<Item> getItemGameList() {
        return itemGameList;
    }

    public void setItemGameList(ArrayList<Item> itemGameList) {
        this.itemGameList = itemGameList;
    }



    public ArrayList<Item> getitemGameList() {
        return itemGameList;
    }

    public void setitemGameList(ArrayList<Item> itemGameList) {
        this.itemGameList = itemGameList;
    }

    public ArrayList<Character> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Character> enemies) {
        this.enemies = enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void initializeGameItems() throws ItemControlException {


        // set location for player to start location
        // each element will be set to a random location after player
        // generate random numbers 
        // Adding Items
        itemGameList.add(ItemControl.newItem("A light-weight Sword", 4, 'w', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("A rusty old rifle", 5, 'w', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("A sexy shotgun", 7, 'w', LocationControl.generateRandomLocation())); // move this to item control
        itemGameList.add(ItemControl.newItem("A friggen Katana", 10, 'w', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("A flame-thrower", 10, 'w', LocationControl.generateRandomLocation()));
        
        for(int i = 0; i < 10; i++)
        itemGameList.add(ItemControl.newItem("First Aid Kit", BiseJosephTeam.BiseJosephTeam.randInt(2, 7), 'h', LocationControl.generateRandomLocation()));

        // Add clues
        itemGameList.add(ItemControl.newItem("wklv lv d vhfuhw phvvdjh", 0, 'c', LocationControl.generateRandomLocation())); // move this to item control
        itemGameList.add(ItemControl.newItem("Brx qrwlfh d udelg udeelw krsslqj wrzdugv brx... Brx vkrrw lw ehiruh lw jhwv wrr forvh. Brx fdq qhyhu eh wrr fduhixo.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx qrwlfh eduuhov ri elr-kducdugrxv pdwhuldov qhdu wkh frdvw ri wkh ehdfk. Vrphrqh pxvw eh gxpslqj fkhplfdo zdvwh khuh.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx khdu vrph guhdgixo prdqlqj lq wkh glvwdqfh.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx hadplqh d ghdg qdcl vroglhu dqg qrwlfh elwh  pdunv dqg vfudwfkhv iurp d vwuxjjoh zlwk vrph hylo fuhdwxuh.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Wkh exvkhv uxvwoh qhaw wr brx dqg brx dlp brxu jxq wr vkrrw zkdwhyhu pljkw mxps rxw dw brx. D vpdoo ghhu exuvwv rxw, iohhlqj iurp vrph xqvhhq wkuhdw.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("D ehooljhuhqw pdq vwxpeohv diwhu brx, vhhplqjob pdg. Kh dwwhpswv wr elwh brx, exw ehiruh kh fdq uhdfk brxu vkrxoghu brx sxw d exoohw lq klp.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx khdu dq Dphulfdq pdq fdoolqj iru khos lq wkh iruhvw, exw grq'w nqrz zkhuh kh lv. Brx iroorz wkh yrlfh, exw zkhq brx duulyh dw wkh vrxufh brx vhh rqob wkh uhpdlqv ri wkh pdq.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx qrwlfh d odujh iruwuhvv rii lq wkh glvwdqfh. Brx nqrz wkdw lv zkb brx kdyh ehhq vhqw wr wklv lvodqg.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx qrwlfh Eduuhov ri hasorvlyh oltxlg lq wkh fruqhu ri wkh urrp. Wklv pljkw eh krz brx fdq ulg wkh zruog ri wklv zlfnhg iruwuhvv.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx wklqn wr brxuvhoi, li rqob brx kdg eurxjkw hasorvlyhv. Wkhq brx frxog ghvwurb wkdw iruwuhvv qr sureohp.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx qrwlfh dqrwkhu rqh ri wkh Qdcl'v glvjxvwlqj hashulphqwv uxqqlqj wrzdugv brx. Wklv rqh lv gliihuhqw. Lw wdnhv vhyhudo exoohwv wr wdnh grzq ehiruh lw idoov dw brxu ihhw. Wkhb duh jhwwlqj vwurqjhu.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx wklqn derxw krph, derxw brxu vzhhw khduw wkdw brx ohiw wkhuh, zrqghulqj li brx'oo hyhu vhh wkdw vzhhw idfh djdlq.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Wkh wlph eoxuv wrjhwkhu. Brx fdq'w uhphpehu krz orqj brx kdyh ehhq rq wkh lvodqg, exw d vhqvh ri gxwb exuqv lq brx wr frpsohwh brxu plvvlrq dv vrrq dv srvvleoh.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx ghvsdlu dv brx qrwlfh ghdg prqnhbv rq wkh jurxqg. Wkhlu whhwk odujhu dqg vkdushu wkdq dqb brx kdyh hyhu vhhq. Brx qrwlfh wkh whoo-wdoh vljqv ri qdcl hashulphqwdwlrq rq wkhp.", 0, 'c', LocationControl.generateRandomLocation()));
        itemGameList.add(ItemControl.newItem("Brx glvwdqwob uhplqlvfh ri wkdw zdup ehg dqg wkh frpiruwv ri krph.", 0, 'c', LocationControl.generateRandomLocation()));        

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.enemiesKilled;
        hash = 37 * hash + Objects.hashCode(this.time);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.enemiesKilled != other.enemiesKilled) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "enemiesKilled=" + enemiesKilled + ", time=" + time + '}';
    }



}
