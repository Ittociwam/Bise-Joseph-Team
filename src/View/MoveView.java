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
public class MoveView {
    
        private final String HELPMENU = "\n"
            + "-------------------------------------\n"
            + "            Move Menu                \n"
            + "-------------------------------------\n"
            + "          N - Move North             \n"
            + "          E - Move East              \n"
            + "          S - Move South             \n"
            + "          W - Move West              \n"
            + "          H - Display this menu      \n"
            + "-------------------------------------\n";    
    void displayMoveMenu(){
        System.out.println("Which way would you like to move?\n");
        System.out.println("Press 'H' for help\n ");
        char choice = getInput();
        doAction();
        
    }

    private char getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
