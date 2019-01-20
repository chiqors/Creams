/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.Provider;
import id.uniondev.creams.model.ProviderModel;

/**
 *
 * @author ACER
 */
public interface ProviderListener {
    public void onChange(ProviderModel model);
    public void onInsert(Provider provider);
}
