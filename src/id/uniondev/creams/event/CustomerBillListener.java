/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.CustomerBill;
import id.uniondev.creams.model.CustomerBillModel;


/**
 *
 * @author Aditya Nur Iskandar
 */
public interface CustomerBillListener {
    public void onChange(CustomerBillModel model);
    public void onInsert(CustomerBill customerBill);
    public void onUpdate(CustomerBill customerBill);
    public void onDelete(CustomerBill customerBill);
}
