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
public class StartProgramView {

    public StartProgramView() {
    }
    
    public void startProgram(){
        this.displayBanner();
        
        
    }

    private void displayBanner() {
        System.out.println("\n\n************************************************");
        
        System.out.println("*                                                  *" 
                         + "*      \n ALL QUIET ON THE PACIFIC THEATER         *"
                         + "                Add game banner here!              *");
        
        System.out.println("****************************************************");
        
    }
    
}
