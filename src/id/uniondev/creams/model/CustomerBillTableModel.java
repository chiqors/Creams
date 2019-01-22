/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.CustomerBill;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author
 */
public class CustomerBillTableModel extends AbstractTableModel {
    private List<CustomerBill> list = new ArrayList<CustomerBill>();

    public void setList(List<CustomerBill> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(CustomerBill e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }

    public CustomerBill get(int index) {
        return list.get(index);
    }

    public CustomerBill set(int index, CustomerBill element) {
       try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public CustomerBill remove(int index) {
        return list.remove(index);
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Id";
            case 1 : return "Customer Number";
            case 2 : return "Customer Name";
            case 3 : return "Type";
            case 4 : return "Balance";
            default : return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_customer_bill();
            case 1 : return list.get(rowIndex).getCustomer_number();
            case 2 : return list.get(rowIndex).getCustomer_name();
            case 3 : return list.get(rowIndex).getType();
            case 4 : return list.get(rowIndex).getBalance();
            default : return null;
        }
    }
}
