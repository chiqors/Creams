/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.error.CustomerCreditException;
import id.uniondev.creams.service.CustomerCreditDao;
import java.sql.SQLException;
import id.uniondev.creams.event.CustomerCreditListener;

/**
 *
 * @author ACER
 */
public class CustomerCreditModel {
    private Integer id_customer_credit;
    private String provider_name;
    private String phone_number;
    private String balance;
    
    private CustomerCreditListener listener;

    public CustomerCreditListener getListener() {
        return listener;
    }

    public void setListener(CustomerCreditListener listener) {
        this.listener = listener;
    }

    public Integer getId_customer_credit() {
        return id_customer_credit;
    }

    public void setId_customer_credit(Integer id_customer_credit) {
        this.id_customer_credit = id_customer_credit;
    }
    
    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(CustomerCredit provider) {
        if (listener != null) {
           listener.onInsert(provider);
        }
    }
    
    public void insertCustomerCredit() throws SQLException, CustomerCreditException {
        CustomerCreditDao dao = CreamsDatabase.getCustomerCreditDao();
        CustomerCredit customerCredit = new CustomerCredit();
        customerCredit.setProvider_name(provider_name);
        customerCredit.setPhone_number(phone_number);
        customerCredit.setBalance(balance);
        
        dao.insertCustomerCredit(customerCredit);
        fireOnInsert(customerCredit);
    }
    
    public void resetCustomerCredit() {
        setId_customer_credit(0);
        setProvider_name("");
        setPhone_number("");
        setBalance("");
    }
}
