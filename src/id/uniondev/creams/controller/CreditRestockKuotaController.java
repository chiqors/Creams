/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;

import id.uniondev.creams.model.CreditRestockKuotaModel;
import id.uniondev.creams.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CreditRestockKuotaController {
    private CreditRestockKuotaModel model;

    public void setModel(CreditRestockKuotaModel model) {
        this.model = model;
    }
    
    public void resetCreditRestockKuota(MainFrame frame) {
        model.resetCreditRestockKuota();
    }
    
    public void updateCreditRestockKuota(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblRestockKuotaPulsa().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        String provider_name = frame.getTxtRestockKuotaProviderName().getText();
        Integer balance_current = Integer.parseInt(frame.getTxtRestockKuotaBalance_current().getText());

        if (provider_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Provider Name still empty!");
        } else if (balance_current.equals(0)) {
            JOptionPane.showMessageDialog(frame, "Balance still empty!");
        } else if (balance_current.equals("")) {
            JOptionPane.showMessageDialog(frame, "Balance still empty!");
        } else {
            model.setProvider_name(provider_name);
            model.setBalance_current(balance_current);
            try {
                model.updateCreditRestockKuota();
                JOptionPane.showMessageDialog(frame, "Credit Restock is successfully updated");
                model.resetCreditRestockKuota();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}