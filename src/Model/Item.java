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



public class Item extends Element implements Serializable {
    private int points;

    public Item() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.type;
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
        final Item other = (Item) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Item{" + "type=" + type + '}';
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }     
}
