/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
/**
 *
 * @author Robbie
 */
public class HelpMenuView extends View {

    private final String HELPMENU = "\n"
            + "-------------------------------------\n"
            + "            Help Menu                \n"
            + "-------------------------------------\n"
            + "          G - The Goal of the game  \n"
            + "          M - Moving help           \n"
            + "          I - Item help              \n"
            + "          B - Battle Help            \n"
            + "          E - Exit                   \n"
            + "-------------------------------------\n";
    private final String GOAL = "\n"
            + "The goal of the game is to find the secret base, discover a \n"
            + " key to unlock the base and find a bomb to destroy the base \n";
    private final String MOVING = "\n"
            + "To move around the map you simply use the arrow keys. You  \n"
            + " move from room to room by passing your character over the \n"
            + " arrows at the top, bottom, left or right of the screen.   \n";
    private final String ITEM = "\n"
            + "To pick up an item you simply walk over it. The game will \n"
            + " then ask you if you would like to pick it up or not. You \n"
            + " then can equip the item by viewing your inventory and    \n"
            + " entering the number of the item you want to equip.       \n";
    private final String BATTLE = "\n"
            + "To engage an enemy in battle you pass over a square with an \n"
            + " enemy inside of it. The game will then automatically apply \n"
            + " the first attack and ask you if you would like to flee or  \n"
            + " continue attacking\n";

    void openMenu() {
        String value = " ";
        do {
            display(HELPMENU);

            value = getInput();
            doAction(value);

            
        } while (value != "E");
    }
    
    public void doAction(Object obj)
    {
        String value = (String)obj;
         switch (value) {

                case "G":
                    display(GOAL);
                    break;
                case "M":
                    display(MOVING);
                    break;
                case "I":
                    display(ITEM);
                    break;
                case "B":
                    display(BATTLE);
                    break;
                case "E":
                    break;
                default:
                    display("Invalid input, Try again\n");

            }
    }

}
