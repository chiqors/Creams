/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.error;

/**
 *
 * @author ACER
 */
public class CustomerException extends Exception {

    /**
     * Creates a new instance of <code>CustomerException</code> without detail
     * message.
     */
    public CustomerException() {
    }

    /**
     * Constructs an instance of <code>CustomerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerException(String msg) {
        super(msg);
    }
}
