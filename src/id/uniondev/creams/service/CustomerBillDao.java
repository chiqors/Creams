/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.CustomerBill;
import id.uniondev.creams.error.CustomerBillException;
import java.util.List;

/**
 *
 * @author
 */
public interface CustomerBillDao {
    public void insertCustomerBill(CustomerBill customerBill) throws CustomerBillException;
    public void updateCustomerBill(CustomerBill customerBill) throws CustomerBillException;
    public void deleteCustomerBill(Integer id_customer_bill) throws CustomerBillException;
    
    public CustomerBill getCustomerBill(Integer id_customer_bill) throws CustomerBillException;
    public CustomerBill getCustomerBill(String customer_name) throws CustomerBillException;
    public List<CustomerBill> selectAllCustomerBill() throws CustomerBillException;
}
