/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.entity;

import java.util.Objects;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CustomerBill {
    private Integer id_customer_bill;
    private String customer_number;
    private String customer_name;
    private String type;
    private Integer balance;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_customer_bill);
        hash = 29 * hash + Objects.hashCode(this.customer_number);
        hash = 29 * hash + Objects.hashCode(this.customer_name);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + Objects.hashCode(this.balance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerBill other = (CustomerBill) obj;
        if (!Objects.equals(this.customer_number, other.customer_number)) {
            return false;
        }
        if (!Objects.equals(this.customer_name, other.customer_name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.id_customer_bill, other.id_customer_bill)) {
            return false;
        }
        return true;
    }
    
}
