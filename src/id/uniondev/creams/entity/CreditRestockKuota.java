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
public class CreditRestockKuota {
    private Integer id_credit_restock_kuota;
    private String provider_name;
    private String type;
    private Integer balance_current;

    public Integer getId_credit_restock_kuota() {
        return id_credit_restock_kuota;
    }

    public void setId_credit_restock_kuota(Integer id_credit_restock_kuota) {
        this.id_credit_restock_kuota = id_credit_restock_kuota;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBalance_current() {
        return balance_current;
    }

    public void setBalance_current(Integer balance_current) {
        this.balance_current = balance_current;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id_credit_restock_kuota);
        hash = 79 * hash + Objects.hashCode(this.provider_name);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.balance_current);
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
        final CreditRestockKuota other = (CreditRestockKuota) obj;
        if (!Objects.equals(this.provider_name, other.provider_name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id_credit_restock_kuota, other.id_credit_restock_kuota)) {
            return false;
        }
        if (!Objects.equals(this.balance_current, other.balance_current)) {
            return false;
        }
        return true;
    }
    
    
}
