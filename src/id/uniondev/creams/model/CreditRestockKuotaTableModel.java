/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.CreditRestock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class CreditRestockKuotaTableModel extends AbstractTableModel {
    private List<CreditRestock> list = new ArrayList<CreditRestock>();

    public void setList(List<CreditRestock> list) {
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

    public boolean add(CreditRestock c) {
        try {
            return list.add(c);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }
    
    public CreditRestock get(int index) {
        return list.get(index);
    }

    public CreditRestock set(int index, CreditRestock element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public CreditRestock remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Provider Name";
            case 1 : return "Stock";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getProvider_name();
            case 1 : return list.get(rowIndex).getBalance_current();
            case 2 : return list.get(rowIndex).getType();
            default : return null;
        }
    }
}
