/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;



import id.uniondev.creams.model.ProviderModel;
import id.uniondev.creams.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class ProviderController {
    private ProviderModel model;
    public void setModel(ProviderModel model) {
        this.model = model;
    }
    
    public void resetProvider(MainFrame frame) {
        model.resetProvider();
    }
    
    public void insertProvider(MainFrame frame) {
        String provider_name = frame.getCbProviderPulsaHome().getSelectedItem().toString();
        String phone_number = frame.getTxtFormNomorPulsaHome().getText();
        String balance = frame.getCbBesarPulsaHome().getSelectedItem().toString();

        if (provider_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Provider Still Empty");
        } else if (phone_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        } else if (balance.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Price still empty!");
        } else {
            model.setProvider_name(provider_name);
            model.setPhone_number(phone_number);
            model.setBalance(balance);
            try {
                model.insertProvider();
                JOptionPane.showMessageDialog(frame, "New Provider is successfully added");
                model.resetProvider();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    
}
        
    

