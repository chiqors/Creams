/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.CreditRestockKuota;
import id.uniondev.creams.model.CreditRestockKuotaModel;

/**
 *
 * @author ACER
 */
public interface CreditRestockKuotaListener {
    public void onChange(CreditRestockKuotaModel model);
    public void onUpdate(CreditRestockKuota creditRestockKuota);
}
