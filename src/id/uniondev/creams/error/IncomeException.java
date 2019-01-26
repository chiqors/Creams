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
public class IncomeException extends Exception {

    /**
     * Creates a new instance of <code>IncomeException</code> without detail
     * message.
     */
    public IncomeException() {
    }

    /**
     * Constructs an instance of <code>IncomeException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public IncomeException(String msg) {
        super(msg);
    }
}
