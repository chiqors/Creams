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
public class CreditRestockKuotaException extends Exception {

    /**
     * Creates a new instance of <code>CreditRestockKuotaException</code>
     * without detail message.
     */
    public CreditRestockKuotaException() {
    }

    /**
     * Constructs an instance of <code>CreditRestockKuotaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CreditRestockKuotaException(String msg) {
        super(msg);
    }
}
