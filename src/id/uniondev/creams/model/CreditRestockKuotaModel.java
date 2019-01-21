/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.CreditRestockKuota;
import id.uniondev.creams.error.CreditRestockKuotaException;
import id.uniondev.creams.event.CreditRestockKuotaListener;
import id.uniondev.creams.service.CreditRestockKuotaDao;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class CreditRestockKuotaModel {
    private Integer id_credit_restock_kuota;
    private String provider_name;
    private String type;
    private Integer balance_current;
    
    private CreditRestockKuotaListener listener;
    
    public CreditRestockKuotaListener getListener() {
        return listener;
    }

    public void setListener(CreditRestockKuotaListener listener) {
        this.listener = listener;
    }
    
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
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnUpdate(CreditRestockKuota creditRestockKuota) {
        if (listener != null) {
           listener.onUpdate(creditRestockKuota);
        }
    }
    
    public void updateCreditRestockKuota() throws SQLException, CreditRestockKuotaException {
        CreditRestockKuotaDao dao = CreamsDatabase.getCreditRestockKuotaDao();
        CreditRestockKuota creditRestockKuota = new CreditRestockKuota();
        creditRestockKuota.setId_credit_restock_kuota(id_credit_restock_kuota);
        creditRestockKuota.setProvider_name(provider_name);
        creditRestockKuota.setType(type);
        creditRestockKuota.setBalance_current(balance_current);
        
        dao.updateCreditRestockKuota(creditRestockKuota);
        fireOnUpdate(creditRestockKuota);
    }
    
    public void resetCreditRestockKuota() {
        setProvider_name("");
        setBalance_current(0);
    }
}
