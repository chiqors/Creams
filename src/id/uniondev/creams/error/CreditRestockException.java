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
public class CreditRestockException extends Exception {

    /**
     * Creates a new instance of <code>CreditRestockException</code>
     * without detail message.
     */
    public CreditRestockException() {
    }

    /**
     * Constructs an instance of <code>CreditRestockException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CreditRestockException(String msg) {
        super(msg);
    }
}
