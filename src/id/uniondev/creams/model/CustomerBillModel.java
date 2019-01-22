/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;


import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CustomerBill;
import id.uniondev.creams.error.CustomerBillException;
import id.uniondev.creams.event.CustomerBillListener;
import id.uniondev.creams.service.CustomerBillDao;
import java.sql.SQLException;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CustomerBillModel {
    private Integer id_customer_bill;
    private String customer_number;
    private String customer_name;
    private String type;
    private Integer balance;
    
    private CustomerBillListener listener;

    public Integer getId_customer_bill() {
        return id_customer_bill;
    }

    public void setId_customer_bill(Integer id_customer_bill) {
        this.id_customer_bill = id_customer_bill;
    }
    
    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public CustomerBillListener getListener() {
        return listener;
    }
    
    public void setListener(CustomerBillListener listener) {
        this.listener = listener;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(CustomerBill customerBill) {
        if (listener != null) {
           listener.onInsert(customerBill);
        }
    }
    
    protected void fireOnUpdate(CustomerBill customerBill) {
        if (listener != null) {
           listener.onUpdate(customerBill);
        }
    }
    
    protected void fireOnDelete(CustomerBill customerBill) {
        if (listener != null) {
           listener.onDelete(customerBill);
        }
    }
    public void insertCustomerBill() throws SQLException, CustomerBillException {
        CustomerBillDao dao = CreamsDatabase.getCustomerBillDao();
        CustomerBill customerBill = new CustomerBill();
        customerBill.setCustomer_number(customer_number);
        customerBill.setCustomer_name(customer_name);
        customerBill.setType(type);
        customerBill.setBalance(balance);
        
        dao.insertCustomerBill(customerBill);
        fireOnInsert(customerBill);
    }
    
    public void updateCustomerBill() throws SQLException, CustomerBillException {
        CustomerBillDao dao = CreamsDatabase.getCustomerBillDao();
        CustomerBill customerBill = new CustomerBill();
        customerBill.setCustomer_number(customer_number);
        customerBill.setCustomer_name(customer_name);
        customerBill.setType(type);
        customerBill.setBalance(balance);
        customerBill.setId_customer_bill(id_customer_bill);
        
        dao.updateCustomerBill(customerBill);
        fireOnUpdate(customerBill);
    }
    
    public void deleteCustomerBill() throws SQLException, CustomerBillException {
        CustomerBillDao dao = CreamsDatabase.getCustomerBillDao();
        CustomerBill customerBill = new CustomerBill();
        dao.deleteCustomerBill(id_customer_bill);
        fireOnDelete(customerBill);
    }
    
    public void resetCustomerBill() {
        setId_customer_bill(0);
        setCustomer_number("");
        setCustomer_name("");
        setType("");
        setBalance(0);
    }
}
