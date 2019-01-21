/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.CreditRestockKuota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class CreditRestockKuotaTableModel extends AbstractTableModel {
    private List<CreditRestockKuota> list = new ArrayList<CreditRestockKuota>();

    public void setList(List<CreditRestockKuota> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public boolean add(CreditRestockKuota c) {
        try {
            return list.add(c);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }
    
    public CreditRestockKuota get(int index) {
        return list.get(index);
    }

    public CreditRestockKuota set(int index, CreditRestockKuota element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public CreditRestockKuota remove(int index) {
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
            case 1 : return "Balance Stock";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getProvider_name();
            case 1 : return list.get(rowIndex).getBalance_current();
            default : return null;
        }
    }
}
