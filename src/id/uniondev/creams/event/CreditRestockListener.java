/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.CreditRestock;
import id.uniondev.creams.model.CreditRestockModel;

/**
 *
 * @author ACER
 */
public interface CreditRestockListener {
    public void onChange(CreditRestockModel model);
    public void onUpdate(CreditRestock creditRestock);
}
