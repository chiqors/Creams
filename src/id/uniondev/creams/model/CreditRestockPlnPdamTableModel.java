/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.CreditRestockPlnPdam;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CreditRestockPlnPdamTableModel extends AbstractTableModel {
    private List<CreditRestockPlnPdam> list = new ArrayList<CreditRestockPlnPdam>();

    public void setList(List<CreditRestockPlnPdam> list) {
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

    public boolean add(CreditRestockPlnPdam e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }

    public CreditRestockPlnPdam get(int index) {
        return list.get(index);
    }

    public CreditRestockPlnPdam set(int index, CreditRestockPlnPdam element) {
       try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public CreditRestockPlnPdam remove(int index) {
        return list.remove(index);
    }

    
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Id";
            case 1 : return "No Pelanggan";
            case 2 : return "Nama Pelanggan";
            case 3 : return "Type";
            case 4 : return "Balance";
            default : return null;
        }
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_credit_restock_plnpdam();
            case 1 : return list.get(rowIndex).getNo_pelanggan();
            case 2 : return list.get(rowIndex).getNama_pelanggan();
            case 3 : return list.get(rowIndex).getType();
            case 4 : return list.get(rowIndex).getBalance();
            default : return null;
        }
    }
    
    
}
