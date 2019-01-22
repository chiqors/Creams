/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;


import id.uniondev.creams.model.CustomerBillModel;
import id.uniondev.creams.view.MainFrame;
import id.uniondev.creams.view.SigninFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class CustomerBillController {
    private CustomerBillModel model;

    public void setModel(CustomerBillModel model) {
        this.model = model;
    }
    
    public void resetCustomerBill(MainFrame frame) {
        model.resetCustomerBill();
    }
    
    public void insertCustomerBill(MainFrame frame) {
        String customer_number = frame.getTxtFormCustomerBillCustomer_number().getText();
        String customer_name = frame.getTxtFormCustomerBillCustomer_name().getText();
        String type = frame.getTxtFormCustomerBillType().getText();
        Integer balance = Integer.parseInt(frame.getTxtFormCustomerBillBalance().getText());
        
        if (customer_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Number still empty!");
        } else if (customer_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (type.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Type still empty!");
        } else if (balance.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Balance still empty!");
        } else {
            model.setCustomer_number(customer_number);
            model.setCustomer_name(customer_name);
            model.setType(type);
            model.setBalance(balance);
            try {
                model.insertCustomerBill();
                JOptionPane.showMessageDialog(frame, "Customer Billing is successfully added");
                model.resetCustomerBill();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateCustomerBill(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblCustomerBill().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id_customer_bill = Integer.parseInt(frame.getTxtFormCustomerBillId_customer_bill().getText());
        String customer_number = frame.getTxtFormCustomerBillCustomer_number().getText();
        String customer_name = frame.getTxtFormCustomerBillCustomer_name().getText();
        String type = frame.getTxtFormCustomerBillType().getText();
        Integer balance = Integer.parseInt(frame.getTxtFormCustomerBillBalance().getText());

        if (customer_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Number still empty!");
        } else if (customer_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (type.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Type still empty!");
        } else if (balance.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Balance still empty!");
        } else {
            model.setId_customer_bill(id_customer_bill);
            model.setCustomer_number(customer_number);
            model.setCustomer_name(customer_name);
            model.setType(type);
            model.setBalance(balance);
            try {
                model.updateCustomerBill();
                JOptionPane.showMessageDialog(frame, "Customer Billing is successfully edited");
                model.resetCustomerBill();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteCustomerBill(MainFrame frame) {
        if (frame.getTblCustomerBill().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to delete");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtFormCustomerBillId_customer_bill().getText());
            model.setId_customer_bill(id);
            try {
                model.deleteCustomerBill();
                JOptionPane.showMessageDialog(frame, "Customer Billing is successfully removed");
                model.resetCustomerBill();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
