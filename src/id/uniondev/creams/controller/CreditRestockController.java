/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;

import id.uniondev.creams.model.CreditRestockModel;
import id.uniondev.creams.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CreditRestockController {
    private CreditRestockModel model;

    public void setModel(CreditRestockModel model) {
        this.model = model;
    }
    
    public void resetCreditRestock(MainFrame frame) {
        model.resetCreditRestock();
    }
    
    public void updateCreditRestock(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblRestockPulsa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        String provider_name = frame.getTxtRestockProviderName().getText();
        String type = frame.getTxtRestockType().getText();
        Integer balance_current = Integer.parseInt(frame.getTxtRestockBalance_current().getText());

        if (provider_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Provider Name still empty!");
        } else if (type.equals("")) {
            JOptionPane.showMessageDialog(frame, "Type still empty!");
        } else if (balance_current.equals(0)) {
            JOptionPane.showMessageDialog(frame, "Stock still empty!");
        } else {
            model.setProvider_name(provider_name);
            model.setBalance_current(balance_current);
            model.setType(type);
            try {
                model.updateCreditRestock();
                JOptionPane.showMessageDialog(frame, "Credit Restock is successfully updated");
                model.resetCreditRestock();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}