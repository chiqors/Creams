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
public class CustomerCreditException extends Exception {

    /**
     * Creates a new instance of <code>CustomerCreditException</code> without
     * detail message.
     */
    public CustomerCreditException() {
    }

    /**
     * Constructs an instance of <code>CustomerCreditException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerCreditException(String msg) {
        super(msg);
    }
}
