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
public class Usable extends Item implements Serializable {
    
    private int points;

    public Usable() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Usable other = (Usable) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Usable{" + "points=" + points + '}';
    }
    
    

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    // apply the points to either the attack or defence
    // of the player depending on the type of item
    public void modify()
    {
        
    }
    
}
