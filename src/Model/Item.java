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
    private char type;

    public Item() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "type=" + type + '}';
    }
    
    
    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
   
    
    
}
