/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Robbie
 */
public class Character extends Element implements Serializable{

    private int health;
    private int attack;

    public Character() {
        this.attack = 0;
        this.health = 0;
        this.description = "";
        this.type = 'e';
        
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.health;
        hash = 83 * hash + this.attack;
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
        final Character other = (Character) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.attack != other.attack) {
            return false;
        }
        return true;
    }



    
    @Override
    public String toString() {
        return "Character{" + "health=" + health + ", attack=" + attack + ", description= " + description +'}';
    }

}
