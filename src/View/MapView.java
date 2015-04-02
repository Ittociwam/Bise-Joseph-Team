/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Map;
import java.awt.Point;

/**
 *
 * @author Robbie
 */
public class MapView extends View {

    public void display(Map map) {
        int numCol = map.getSize().height;
        int numRow = map.getSize().width;
        Point playerPoint = BiseJosephTeam.BiseJosephTeam.game.getPlayer().getLocation().getRoom().getCoords();

        console.println('\n');
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                if (col == 0) {
                    console.print("+-----+-----+-----+-----+-----+-----+\n");
                }
                if (col == playerPoint.x && row == playerPoint.y)
                {
                    if(col == 5)
                        console.print("|  x  |\n");
                    else
                        console.print("|  x  ");
                    continue;
                }
                console.print("|     ");
                if(col == 5)
                {
                    console.print("|\n");
                }
            }

        }
        console.println("+-----+-----+-----+-----+-----+-----+\n");
    }

    @Override
    public void doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
