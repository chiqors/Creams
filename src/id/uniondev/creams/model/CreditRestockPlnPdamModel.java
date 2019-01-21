/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;


import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CreditRestockPlnPdam;
import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.error.CreditRestockPlnPdamException;
import id.uniondev.creams.error.CustomerCreditException;
import id.uniondev.creams.error.CustomerException;
import id.uniondev.creams.event.CreditRestockPlnPdamListener;
import id.uniondev.creams.event.CustomerListener;
import id.uniondev.creams.service.CreditRestockPlnPdamDao;
import id.uniondev.creams.service.CustomerCreditDao;
import id.uniondev.creams.service.CustomerDao;
import java.sql.SQLException;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CreditRestockPlnPdamModel {
    private Integer id_credit_restock_plnpdam;
    private String no_pelanggan;
    private String nama_pelanggan;
    private String type;
    private String Balance;
    
    private CreditRestockPlnPdamListener listener;

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


    public CreditRestockPlnPdamListener getListener() {
        return listener;
    }

    public void setListener(CreditRestockPlnPdamListener listener) {
        this.listener = listener;
    }
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(CreditRestockPlnPdam creditRestockPlnPdam) {
        if (listener != null) {
           listener.onInsert(creditRestockPlnPdam);
        }
    }
    
    protected void fireOnUpdate(CreditRestockPlnPdam creditRestockPlnPdam) {
        if (listener != null) {
           listener.onUpdate(creditRestockPlnPdam);
        }
    }
    
    protected void fireOnDelete(CreditRestockPlnPdam creditRestockPlnPdam) {
        if (listener != null) {
           listener.onDelete(creditRestockPlnPdam);
        }
    }
    public void insertCreditRestockPlnPdam() throws SQLException, CreditRestockPlnPdamException {
        CreditRestockPlnPdamDao dao = CreamsDatabase.getCreditRestockPlnPdamDao();
        CreditRestockPlnPdam creditRestockPlnPdam = new CreditRestockPlnPdam();
        creditRestockPlnPdam.setNo_pelanggan(no_pelanggan);
        creditRestockPlnPdam.setNama_pelanggan(nama_pelanggan);
        creditRestockPlnPdam.setType(type);
        creditRestockPlnPdam.setBalance(Balance);
        
        dao.insertCreditRestockPlnPdam(creditRestockPlnPdam);
        fireOnInsert(creditRestockPlnPdam);
    }
    
    public void updateCreditRestockPlnPdam() throws SQLException, CreditRestockPlnPdamException {
        CreditRestockPlnPdamDao dao = CreamsDatabase.getCreditRestockPlnPdamDao();
        CreditRestockPlnPdam creditRestockPlnPdam = new CreditRestockPlnPdam();
        creditRestockPlnPdam.setNo_pelanggan(no_pelanggan);
        creditRestockPlnPdam.setNama_pelanggan(nama_pelanggan);
        creditRestockPlnPdam.setType(type);
        creditRestockPlnPdam.setBalance(Balance);
        creditRestockPlnPdam.setId_credit_restock_plnpdam(id_credit_restock_plnpdam);
        
        dao.updateCreditRestockPlnPdam(creditRestockPlnPdam);
        fireOnUpdate(creditRestockPlnPdam);
    }
    
    public void deleteCreditRestockPlnPdam() throws SQLException, CreditRestockPlnPdamException {
        CreditRestockPlnPdamDao dao = CreamsDatabase.getCreditRestockPlnPdamDao();
        CreditRestockPlnPdam creditRestockPlnPdam = new CreditRestockPlnPdam();
        dao.deleteCreditRestockPlnPdam(id_credit_restock_plnpdam);
        fireOnDelete(creditRestockPlnPdam);
    }
    
    public void resetCreditRestockPlnPdam() {
        setId_credit_restock_plnpdam(0);
        setNo_pelanggan("");
        setNama_pelanggan("");
        setType("");
        setBalance("");
    }

}
