/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Room;

/**
 *
 * @author Robbie
 */
public class RoomView extends View{
    
    
    
    public void display(Room room)
    {
        int col = room.getSize().height;
        int row = room.getSize().width;
        
        for(int i = 0; i < row; i++)
            for(int j = 0; i < col; i++)
            {
                this.console.println("+-----+-----+-----+-----+-----+\n");
                this.console.println("|     |     |  ^  |     |     |\n");
                this.console.println("|     |     |     |     |     |\n");
            }
    }

    @Override
    public void doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
