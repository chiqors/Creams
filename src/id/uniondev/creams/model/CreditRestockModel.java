/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CreditRestock;
import id.uniondev.creams.error.CreditRestockException;
import java.sql.SQLException;
import id.uniondev.creams.event.CreditRestockListener;
import id.uniondev.creams.service.CreditRestockDao;

/**
 *
 * @author ACER
 */
public class CreditRestockModel {
    private Integer id_credit_restock;
    private String provider_name;
    private String type;
    private Integer balance_current;
    
    private CreditRestockListener listener;
    
    public CreditRestockListener getListener() {
        return listener;
    }

    public void setListener(CreditRestockListener listener) {
        this.listener = listener;
    }

    public Integer getId_credit_restock() {
        return id_credit_restock;
    }

    public void setId_credit_restock(Integer id_credit_restock) {
        this.id_credit_restock = id_credit_restock;
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
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnUpdate(CreditRestock creditRestock) {
        if (listener != null) {
           listener.onUpdate(creditRestock);
        }
    }
    
    public void updateCreditRestock() throws SQLException, CreditRestockException {
        CreditRestockDao dao = CreamsDatabase.getCreditRestockDao();
        CreditRestock creditRestock = new CreditRestock();
        creditRestock.setId_credit_restock(id_credit_restock);
        creditRestock.setProvider_name(provider_name);
        creditRestock.setType(type);
        creditRestock.setBalance_current(balance_current);
        
        dao.updateCreditRestock(creditRestock);
        fireOnUpdate(creditRestock);
    }
    
    public void resetCreditRestock() {
        setProvider_name("");
        setBalance_current(0);
        setType("");
    }
}
