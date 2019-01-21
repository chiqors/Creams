/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;



import id.uniondev.creams.model.CustomerCreditModel;
import id.uniondev.creams.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CustomerCreditController {
    private CustomerCreditModel model;
    public void setModel(CustomerCreditModel model) {
        this.model = model;
    }
    
    public void resetCustomerCredit(MainFrame frame) {
        model.resetCustomerCredit();
    }
    
    public void insertCustomerCredit(MainFrame frame) {
        String provider_name = frame.getCbProviderPulsaHome().getSelectedItem().toString();
        String phone_number = frame.getTxtFormNomorPulsaHome().getText();
        String balance = frame.getCbBesarPulsaHome().getSelectedItem().toString();

        if (provider_name.trim().equals("--PROVIDER--")) {
            JOptionPane.showMessageDialog(frame, "Provider Still Empty");
        } else if (phone_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        } else if (balance.trim().equals("--NUMBER--")) {
            JOptionPane.showMessageDialog(frame, "Balance still empty!");
        } else {
            model.setProvider_name(provider_name);
            model.setPhone_number(phone_number);
            model.setBalance(balance);
            try {
                model.insertCustomerCredit();
                JOptionPane.showMessageDialog(frame, "New Customer Credit is successfully added");
                model.resetCustomerCredit();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    
}
        
    

