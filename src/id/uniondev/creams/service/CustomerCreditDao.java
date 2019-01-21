/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.error.CustomerCreditException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CustomerCreditDao {
    public void insertCustomerCredit(CustomerCredit customerCredit) throws CustomerCreditException;
    
    public CustomerCredit getCustomerCredit(Integer id) throws CustomerCreditException;
    public CustomerCredit getCustomerCredit(String phone_number) throws CustomerCreditException;
    public List<CustomerCredit> selectAllCustomerCredit() throws CustomerCreditException;
}
