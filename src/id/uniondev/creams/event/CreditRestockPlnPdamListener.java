/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.CreditRestockPlnPdam;
import id.uniondev.creams.model.CreditRestockPlnPdamModel;


/**
 *
 * @author Aditya Nur Iskandar
 */
public interface CreditRestockPlnPdamListener {
    public void onChange(CreditRestockPlnPdamModel model);
    public void onInsert(CreditRestockPlnPdam creditRestockPlnPdam);
    public void onUpdate(CreditRestockPlnPdam creditRestockPlnPdam);
    public void onDelete(CreditRestockPlnPdam creditRestockPlnPdam);
}
