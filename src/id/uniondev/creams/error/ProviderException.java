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
public class ProviderException extends Exception {

    /**
     * Creates a new instance of <code>ProviderException</code> without detail
     * message.
     */
    public ProviderException() {
    }

    /**
     * Constructs an instance of <code>ProviderException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProviderException(String msg) {
        super(msg);
    }
}
