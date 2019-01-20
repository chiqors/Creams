/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class ProviderTableModel extends AbstractTableModel {
    
    private List<Provider> list = new ArrayList<Provider>();

    public void setList(List<Provider> list) {
        this.list = list;
    }
    
    
            
    @Override
    public int getRowCount() {
        
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public boolean add(Provider e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Provider get(int index) {
        return list.get(index);
    }

    public Provider set(int index, Provider element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
        
        
    }

    public Provider remove(int index) {
        try {
            
        return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    
    
    @Override
    public String getColumnName(int column) {
         //To change body of generated methods, choose Tools | Templates.
        switch (column){
            case 1:
                return "PROVIDER_NAME";
            case 2:
                return "PHONE_NUMBER";
            case 3:
                return "BALANCE";
            default :
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 1:
                return list.get(rowIndex).getProvider_name();
            case 2:
                return list.get(rowIndex).getPhone_number();
            case 3:
                return list.get(rowIndex).getBalance();
            default :
                return null;
        }
    }
    
}
