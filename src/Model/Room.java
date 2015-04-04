/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Element;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Travis
 */
public class Room implements Serializable{

    private String description;
    private Dimension size;
    private Point coords;

    public Point getCoords() {
        return coords;
    }

    public void setCoords(Point coords) {
        this.coords = coords;
    }
    public Element[][] elements;
    
    
    
    
    public Room() {
         this.elements = new Element [5][5];
        for (int i=0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++)
           elements[i][j] = new Element();
       }
         Element defaultE = new Element();
        this.description = "a";
        this.size = new Dimension(5, 5);
    }

    public String getDescription() {
        return description;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.size);
        return hash;
    }

    @Override
    public String toString() {
        return "Room{" + "description=" + description + ", size=" + size + ", mapSpot=" + coords + '}';
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.coords, other.coords)) {
            return false;
        }
        if (!Arrays.deepEquals(this.elements, other.elements)) {
            return false;
        }
        return true;
    }
    
    




   
    
    
    
}
