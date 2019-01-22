/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.error;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CustomerBillException extends Exception {

    /**
     * Creates a new instance of <code>CreditRestockPlnPdam</code> without
     * detail message.
     */
    public CustomerBillException() {
    }

    /**
     * Constructs an instance of <code>CreditRestockPlnPdam</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerBillException(String msg) {
        super(msg);
    }
}
