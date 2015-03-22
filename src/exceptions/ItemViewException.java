/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Travis
 */
public class ItemViewException extends Exception{

    public ItemViewException() {
    }

    public ItemViewException(String message) {
        super(message);
    }

    public ItemViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemViewException(Throwable cause) {
        super(cause);
    }

    public ItemViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
