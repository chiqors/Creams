/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.Income;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class IncomeTableModel extends AbstractTableModel {
    private List<Income> list = new ArrayList<Income>();

    public void setList(List<Income> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    public boolean add(Income i) {
        try {
            return list.add(i);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }
    
    public Income get(int index) {
        return list.get(index);
    }

    public Income set(int index, Income element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Income remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Id";
            case 1 : return "Pulsa";
            case 2 : return "Perdana";
            case 3 : return "Kuota";
            case 4 : return "PLN";
            case 5 : return "PDAM";
            case 6 : return "Outcome";
            case 7 : return "Current Date";
            case 8 : return "Total";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_income();
            case 1 : return list.get(rowIndex).getCredit();
            case 2 : return list.get(rowIndex).getCredit_perdana();
            case 3 : return list.get(rowIndex).getCredit_kuota();
            case 4 : return list.get(rowIndex).getPln();
            case 5 : return list.get(rowIndex).getPdam();
            case 6 : return list.get(rowIndex).getOutcome();
            case 7 : return list.get(rowIndex).getCurrent_date();
            case 8 : return list.get(rowIndex).getTotal();
            default : return null;
        }
    }
}
