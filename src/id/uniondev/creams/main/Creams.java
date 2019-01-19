/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.main;

import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.view.SigninFrame;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author UnionDev
 */
public class Creams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, EmployeeException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SigninFrame login = new SigninFrame();
                    login.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }
}
