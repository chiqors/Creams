/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.event.EmployeeListener;
import id.uniondev.creams.service.EmployeeDao;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class EmployeeModel {
    private Integer id_employee;
    private String username;
    private String password;
    private String employee_name;
    private String role;

    private EmployeeListener listener;
    
    private EmployeeListener getListener() {
        return listener;
    }

    public void setListener(EmployeeListener listener) {
        this.listener = listener;
    }
    
    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
        fireOnChange();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        fireOnChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
        fireOnChange();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Employee employee) {
        if (listener != null) {
           listener.onInsert(employee);
        }
    }
    
    protected void fireOnUpdate(Employee employee) {
        if (listener != null) {
           listener.onUpdate(employee);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
           listener.onDelete();
        }
    }
    
    public void insertEmployee() throws SQLException, EmployeeException {
        EmployeeDao dao = CreamsDatabase.getEmployeeDao();
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setEmployee_name(employee_name);
        employee.setRole(role);
        
        dao.insertEmployee(employee);
        fireOnInsert(employee);
    }
    
    public void updateEmployee() throws SQLException, EmployeeException {
        EmployeeDao dao = CreamsDatabase.getEmployeeDao();
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setEmployee_name(employee_name);
        employee.setRole(role);
        employee.setId(id_employee);
        
        dao.updateEmployee(employee);
        fireOnUpdate(employee);
    }
    
    public void deleteEmployee() throws SQLException, EmployeeException {
        EmployeeDao dao = CreamsDatabase.getEmployeeDao();
        dao.deleteEmployee(id_employee);
        fireOnDelete();
    }
    
    public void resetEmployee() {
        setId_employee(0);
        setUsername("");
        setPassword("");
        setEmployee_name("");
        setRole("");
    }
}
