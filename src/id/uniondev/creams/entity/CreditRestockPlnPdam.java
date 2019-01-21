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
public class CreditRestockPlnPdam {
    private Integer id_credit_restock_plnpdam;
    private String no_pelanggan;
    private String nama_pelanggan;
    private String type;
    private String Balance;

    public Integer getId_credit_restock_plnpdam() {
        return id_credit_restock_plnpdam;
    }

    public void setId_credit_restock_plnpdam(Integer id_credit_restock_plnpdam) {
        this.id_credit_restock_plnpdam = id_credit_restock_plnpdam;
    }

    public String getNo_pelanggan() {
        return no_pelanggan;
    }

    public void setNo_pelanggan(String no_pelanggan) {
        this.no_pelanggan = no_pelanggan;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id_credit_restock_plnpdam);
        hash = 47 * hash + Objects.hashCode(this.no_pelanggan);
        hash = 47 * hash + Objects.hashCode(this.nama_pelanggan);
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + Objects.hashCode(this.Balance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CreditRestockPlnPdam other = (CreditRestockPlnPdam) obj;
        if (!Objects.equals(this.id_credit_restock_plnpdam, other.id_credit_restock_plnpdam)) {
            return false;
        }
        if (!Objects.equals(this.no_pelanggan, other.no_pelanggan)) {
            return false;
        }
        if (!Objects.equals(this.nama_pelanggan, other.nama_pelanggan)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.Balance, other.Balance)) {
            return false;
        }
        return true;
    }
    
    
}
