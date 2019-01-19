/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.error.CustomerException;
import id.uniondev.creams.event.CustomerListener;
import id.uniondev.creams.service.CustomerDao;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class CustomerModel {
    private Integer id_customer;
    private String username;
    private String password;
    private String customer_name;
    private String phone_number;
    private String status;
    
    private CustomerListener listener;

    public CustomerListener getListener() {
        return listener;
    }

    public void setListener(CustomerListener listener) {
        this.listener = listener;
    }
    
    public Integer getId_customer() {
        return id_customer;
    }

    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Customer customer) {
        if (listener != null) {
           listener.onInsert(customer);
        }
    }
    
    protected void fireOnUpdate(Customer customer) {
        if (listener != null) {
           listener.onUpdate(customer);
        }
    }
    
    protected void fireOnDelete(Customer customer) {
        if (listener != null) {
           listener.onDelete(customer);
        }
    }
    
    public void insertCustomer() throws SQLException, CustomerException {
        CustomerDao dao = CreamsDatabase.getCustomerDao();
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setCustomer_name(customer_name);
        customer.setPhone_number(phone_number);
        customer.setStatus(status);
        
        dao.insertCustomer(customer);
        fireOnInsert(customer);
    }
    
    public void updateCustomer() throws SQLException, CustomerException {
        CustomerDao dao = CreamsDatabase.getCustomerDao();
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setCustomer_name(customer_name);
        customer.setPhone_number(phone_number);
        customer.setStatus(status);
        customer.setId_customer(id_customer);
        
        dao.updateCustomer(customer);
        fireOnUpdate(customer);
    }
    
    public void deleteCustomer() throws SQLException, CustomerException {
        CustomerDao dao = CreamsDatabase.getCustomerDao();
        Customer customer = new Customer();
        dao.deleteCustomer(id_customer);
        fireOnDelete(customer);
    }
    
    public void resetCustomer() {
        setId_customer(0);
        setUsername("");
        setPassword("");
        setCustomer_name("");
        setStatus("");
    }
}
