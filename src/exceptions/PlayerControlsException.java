/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Robbie
 */
public class PlayerControlsException extends Exception {

    public PlayerControlsException() {
    }

    public PlayerControlsException(String string) {
        super(string);
    }

    public PlayerControlsException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PlayerControlsException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PlayerControlsException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
