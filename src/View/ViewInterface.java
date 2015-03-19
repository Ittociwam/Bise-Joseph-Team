/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PlayerControls;

/**
 *
 * @author Robbie
 */
public interface ViewInterface {
    public boolean display(Object obj);
    public String getInput();
    public void doAction(Object obj);
        
}
