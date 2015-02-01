/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Element;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Travis
 */
public class Room extends Element implements Serializable{
    private int size;
    private String description2;

    public Room() {
    }

    
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    @Override
    public String toString() {
        return "Room{" + "size=" + size + ", description2=" + description2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.size;
        hash = 67 * hash + Objects.hashCode(this.description2);
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
        final Room other = (Room) obj;
        if (this.size != other.size) {
            return false;
        }
        if (!Objects.equals(this.description2, other.description2)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
