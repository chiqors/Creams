/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;

import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.model.EmployeeModel;
import id.uniondev.creams.view.MainFrame;
import id.uniondev.creams.view.SigninFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class EmployeeController {
    private EmployeeModel model;

    public void setModel(EmployeeModel model) {
        this.model = model;
    }
    
    public void resetEmployee(MainFrame frame) {
        model.resetEmployee();
    }
    
    public void signinEmployee(SigninFrame signinframe) {
        String username = signinframe.getTxtUsername().getText();
        String password = signinframe.getTxtPassword().getText();
        if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(signinframe, "Username still empty!");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(signinframe, "Password still empty");
        } else {
            model.setUsername(username);
            model.setPassword(password);
            try {
                model.signinEmployee();
                JOptionPane.showMessageDialog(signinframe, "Your account is successfully signed in!");
                model.signinresetEmployee();
                MainFrame main = new MainFrame();
                main.getLblHeaderName().setText(signinframe.getTxtUsername().getText());
                main.loadDatabase();
                main.setVisible(true);
                signinframe.setVisible(false);
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(signinframe, new Object[]{
                    "Error Signin appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void insertEmployee(MainFrame frame) {
        String username = frame.getTxtUsername().getText();
        String password = frame.getTxtPassword().getText();
        String employee_name = frame.getTxtEmployee_name().getText();
        String role = frame.getTxtRole().getText();

        if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Username still empty!");
        } else if (username.length() > 255) {
            JOptionPane.showMessageDialog(frame, "Username are not allowed to above 255 characters");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Password still empty!");
        } else if (employee_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Employee still empty!");
        } else if (role.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Role still empty!");
        } else {
            model.setUsername(username);
            model.setPassword(password);
            model.setEmployee_name(employee_name);
            model.setRole(role);
            try {
                model.insertEmployee();
                JOptionPane.showMessageDialog(frame, "New employee is successfully added");
                model.resetEmployee();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateEmployee(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblEmployee().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id = Integer.parseInt(frame.getTxtId_Employee().getText());
        String username = frame.getTxtUsername().getText();
        String password = frame.getTxtPassword().getText();
        String employee_name = frame.getTxtEmployee_name().getText();
        String role = frame.getTxtRole().getText();

        if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Username still empty!");
        } else if (username.length() > 255) {
            JOptionPane.showMessageDialog(frame, "Username are not allowed to above 255 characters");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Password still empty!");
        } else if (employee_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Employee still empty!");
        } else if (role.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Role still empty!");
        } else {
            model.setId_employee(id);
            model.setUsername(username);
            model.setPassword(password);
            model.setEmployee_name(employee_name);
            model.setRole(role);
            try {
                model.updateEmployee();
                JOptionPane.showMessageDialog(frame, "Employee is successfully edited");
                model.resetEmployee();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteEmployee(MainFrame frame) {
        if (frame.getTblEmployee().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to delete");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtId_Employee().getText());
            model.setId_employee(id);
            try {
                model.deleteEmployee();
                JOptionPane.showMessageDialog(frame, "Employee is successfully removed");
                model.resetEmployee();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
