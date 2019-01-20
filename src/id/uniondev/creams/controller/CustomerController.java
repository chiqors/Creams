/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;

import id.uniondev.creams.model.CustomerModel;
import id.uniondev.creams.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CustomerController {
    private CustomerModel model;

    public void setModel(CustomerModel model) {
        this.model = model;
    }
    
    public void resetCustomer(MainFrame frame) {
        model.resetCustomer();
    }
    
    public void insertCustomer(MainFrame frame) {
        String customer_name = frame.getTxtCustomer_name().getText();
        String phone_number = frame.getTxtCustomerPhoneNumber().getText();
        String status = frame.getTxtCustomerStatus().getText();

        if (customer_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (phone_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        } else if (status.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Status still empty!");
        } else {
            model.setCustomer_name(customer_name);
            model.setPhone_number(phone_number);
            model.setStatus(status);
            try {
                model.insertCustomer();
                JOptionPane.showMessageDialog(frame, "New customer is successfully added");
                model.resetCustomer();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateCustomer(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblCustomer().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id = Integer.parseInt(frame.getTxtId_customer().getText());
        String customer_name = frame.getTxtCustomer_name().getText();
        String phone_number = frame.getTxtCustomerPhoneNumber().getText();
        String status = frame.getTxtCustomerStatus().getText();

        if (customer_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer Name still empty!");
        } else if (phone_number.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Phone Number still empty!");
        } else if (status.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Status still empty!");
        } else {
            model.setId_customer(id);
            model.setCustomer_name(customer_name);
            model.setPhone_number(phone_number);
            model.setStatus(status);
            try {
                model.updateCustomer();
                JOptionPane.showMessageDialog(frame, "Customer is successfully edited");
                model.resetCustomer();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteCustomer(MainFrame frame) {
        if (frame.getTblCustomer().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to delete");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtId_customer().getText());
            model.setId_customer(id);
            try {
                model.deleteCustomer();
                JOptionPane.showMessageDialog(frame, "Customer is successfully removed");
                model.resetCustomer();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
