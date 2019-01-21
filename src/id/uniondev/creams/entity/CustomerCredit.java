/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.entity;

import java.util.Objects;

/**
 *
 * @author ACER
 */
public class CustomerCredit {
    private Integer id_customer_credit;
    private String provider_name;
    private String phone_number;
    private String balance;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id_customer_credit);
        hash = 59 * hash + Objects.hashCode(this.provider_name);
        hash = 59 * hash + Objects.hashCode(this.phone_number);
        hash = 59 * hash + Objects.hashCode(this.balance);
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
        final CustomerCredit other = (CustomerCredit) obj;
        if (!Objects.equals(this.provider_name, other.provider_name)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.phone_number, other.phone_number)) {
            return false;
        }
        if (!Objects.equals(this.id_customer_credit, other.id_customer_credit)) {
            return false;
        }
        return true;
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
    
}
