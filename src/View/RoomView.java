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
public class RoomView extends View {

    public void display(Room room) {
        int numCol = room.getSize().height;
        int numRow = room.getSize().width;
        console.println('\n');
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                if (col == 0) 
                {
                    console.print("+-----+-----+-----+-----+-----+\n");
                }
                if (row == 0 && col == 0) 
                {
                    console.print("|     |     |  ^  |     |     |\n");
                } 
                else if(col == 0)
                {
                    console.print("|     |     |     |     |     |\n");
                }
                if (col == 4) 
                {
                    if(row == 2)
                        console.print("|  " + room.elements[row][col].getType() + " >|\n");
                    else
                        console.print("|  " + room.elements[row][col].getType() + "  |\n");
                    if(row == 4 && col == 4)
                        console.print("|     |     |  v  |     |     |\n");
                    else
                        console.print("|     |     |     |     |     |\n");
                    
                    if(row == 4)
                    console.print("+-----+-----+-----+-----+-----+\n");
                } 
                else 
                {
                    if (row == 2 && col == 0) 
                    {
                        console.print("|< " + room.elements[row][col].getType() + "  ");
                    } else 
                    {
                        console.print("|  " + room.elements[row][col].getType() + "  ");
                    }
                }

            }
        }
    }


@Override
        public void doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
