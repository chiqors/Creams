/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> list = new ArrayList<Employee>();

    public void setList(List<Employee> list) {
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

    public boolean add(Employee e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
        }
    }

    public Employee get(int index) {
        return list.get(index);
    }

    public Employee set(int index, Employee element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Employee remove(int index) {
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
            case 1 : return "Username";
            case 2 : return "Employee Name";
            case 3 : return "Role";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_employee();
            case 1 : return list.get(rowIndex).getUsername();
            case 2 : return list.get(rowIndex).getEmployee_name();
            case 3 : return list.get(rowIndex).getRole();
            default : return null;
        }
    }
    
}
