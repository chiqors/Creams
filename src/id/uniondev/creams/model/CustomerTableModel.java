/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class CustomerTableModel extends AbstractTableModel {
    private List<Customer> list = new ArrayList<Customer>();

    public void setList(List<Customer> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public boolean add(Customer c) {
        try {
            return list.add(c);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }
    
    public Customer get(int index) {
        return list.get(index);
    }

    public Customer set(int index, Customer element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Id";
            case 1 : return "Username";
            case 2 : return "Customer Name";
            case 3 : return "Phone Number";
            case 4 : return "Status";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_customer();
            case 1 : return list.get(rowIndex).getUsername();
            case 2 : return list.get(rowIndex).getCustomer_name();
            case 3 : return list.get(rowIndex).getPhone_number();
            case 4 : return list.get(rowIndex).getStatus();
            default : return null;
        }
    }
}
