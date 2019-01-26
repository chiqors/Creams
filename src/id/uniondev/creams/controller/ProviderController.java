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
        String provider_name = frame.getTxtFormProviderProvider_name().getText();

        if (provider_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Provider name still empty!");
        } else if (provider_name.length() > 255) {
            JOptionPane.showMessageDialog(frame, "Provider name are not allowed to above 255 characters");
        } else {
            model.setProvider_name(provider_name);
            try {
                model.insertProvider();
                JOptionPane.showMessageDialog(frame, "New provider is successfully added");
                model.resetProvider();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateProvider(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblProvider().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id = Integer.parseInt(frame.getTxtFormProviderId_provider().getText());
        String provider_name = frame.getTxtFormProviderProvider_name().getText();

        if (provider_name.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Provider name still empty!");
        } else if (provider_name.length() > 255) {
            JOptionPane.showMessageDialog(frame, "Provider name are not allowed to above 255 characters");
        } else {
            model.setId_provider(id);
            model.setProvider_name(provider_name);
            try {
                model.updateProvider();
                JOptionPane.showMessageDialog(frame, "Provider is successfully edited");
                model.resetProvider();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteProvider(MainFrame frame) {
        if (frame.getTblProvider().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtFormProviderId_provider().getText());
            model.setId_provider(id);
            try {
                model.deleteProvider();
                JOptionPane.showMessageDialog(frame, "Provider is successfully removed");
                model.resetProvider();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
