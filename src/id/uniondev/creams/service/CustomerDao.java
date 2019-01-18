/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;
import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.error.CustomerException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CustomerDao {
    public void insertEmployee(Customer customer) throws CustomerException;
    public void updateEmployee(Customer customer) throws CustomerException;
    public void deleteEmployee(Integer id) throws CustomerException;
    
    public Customer getCustomer(Integer id) throws CustomerException;
    public Customer getCustomer(String customer_name) throws CustomerException;
    public List<Customer> selectAllEmployee() throws CustomerException;
}
