/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.model.CustomerCreditModel;

/**
 *
 * @author ACER
 */
public interface CustomerCreditListener {
    public void onChange(CustomerCreditModel model);
    public void onInsert(CustomerCredit customerCredit);
}
