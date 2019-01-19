/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.model.CustomerModel;

/**
 *
 * @author ACER
 */
public interface CustomerListener {
    public void onChange(CustomerModel model);
    public void onInsert(Customer customer);
    public void onUpdate(Customer customer);
    public void onDelete(Customer customer);
}
