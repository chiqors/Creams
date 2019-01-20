/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.error.EmployeeException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface EmployeeDao {
    public void insertEmployee(Employee employee) throws EmployeeException;
    public void updateEmployee(Employee employee) throws EmployeeException;
    public void deleteEmployee(Integer id) throws EmployeeException;
    
    public Employee getEmployee(Integer id) throws EmployeeException;
    public Employee getEmployee(String username, String password) throws EmployeeException;
    public Employee getEmployee(String employee_name) throws EmployeeException;
    public List<Employee> selectAllEmployee() throws EmployeeException;
}
