/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.CustomerCredit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class CustomerCreditTableModel extends AbstractTableModel {
    
    private List<CustomerCredit> list = new ArrayList<CustomerCredit>();

    public void setList(List<CustomerCredit> list) {
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

    public boolean add(CustomerCredit e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public CustomerCredit get(int index) {
        return list.get(index);
    }

    public CustomerCredit set(int index, CustomerCredit element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public CustomerCredit remove(int index) {
        try {  
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 : return "Provider Name";
            case 1 : return "Phone Number";
            case 2 : return "Balance";
            default : return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getProvider_name();
            case 1: return list.get(rowIndex).getPhone_number();
            case 2: return list.get(rowIndex).getBalance();
            default : return null;
        }
    }
    
}
