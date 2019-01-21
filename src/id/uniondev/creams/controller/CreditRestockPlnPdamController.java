/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;


import id.uniondev.creams.model.CreditRestockPlnPdamModel;
import id.uniondev.creams.view.MainFrame;
import id.uniondev.creams.view.SigninFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CreditRestockPlnPdamController {
    private CreditRestockPlnPdamModel model;

    public void setModel(CreditRestockPlnPdamModel model) {
        this.model = model;
    }
    
    public void resetCreditRestockPlnPdam(MainFrame frame) {
        model.resetCreditRestockPlnPdam();
    }
    
    public void insertCreditRestockPlnPdam(MainFrame frame) {
        
        String no_pelanggan = frame.getTxtNoPelanggan().getText();
        String nama_pelanggan = frame.getTxtNamaPelanggan().getText();
        String type= frame.getTxtJenisPembayaran().getText();
        String balance= frame.getTxtBalancePembayaran().getText();
        

        if (nama_pelanggan.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (type.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        }  else {
            
            model.setNo_pelanggan(no_pelanggan);
            model.setNama_pelanggan(nama_pelanggan);
            model.setType(type);
            model.setBalance(balance);
            try {
                model.insertCreditRestockPlnPdam();
                JOptionPane.showMessageDialog(frame, "New customer is successfully added");
                model.resetCreditRestockPlnPdam();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateCreditRestockPlnPdam(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblPlnPdam().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id = Integer.parseInt(frame.getTxtFormIdTagihan().getText());
        String no_pelanggan = frame.getTxtNoPelanggan().getText();
        String nama_pelanggan = frame.getTxtNamaPelanggan().getText();
        String type = frame.getTxtJenisPembayaran().getText();
        String balance = frame.getTxtBalancePembayaran().getText();

        if (nama_pelanggan.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (type.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        }else {
            model.setId_credit_restock_plnpdam(id);
            model.setNo_pelanggan(no_pelanggan);
            model.setNama_pelanggan(nama_pelanggan);
            model.setType(type);
            model.setBalance(balance);
            try {
                model.updateCreditRestockPlnPdam();
                JOptionPane.showMessageDialog(frame, "Customer is successfully edited");
                model.resetCreditRestockPlnPdam();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteCustomer(MainFrame frame) {
        if (frame.getTblPlnPdam().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to delete");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtFormIdTagihan().getText());
            model.setId_credit_restock_plnpdam(id);
            try {
                model.deleteCreditRestockPlnPdam();
                JOptionPane.showMessageDialog(frame, "Customer is successfully removed");
                model.resetCreditRestockPlnPdam();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
