/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.Provider;
import id.uniondev.creams.error.ProviderException;
import id.uniondev.creams.event.ProviderListener;
import id.uniondev.creams.service.ProviderDao;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class ProviderModel {
    private Integer id_provider;
    private String provider_name;
    private String phone_number;
    private String balance;
    
    private ProviderListener listener;

    public ProviderListener getListener() {
        return listener;
    }

    public void setListener(ProviderListener listener) {
        this.listener = listener;
    }
    
    public Integer getId_provider() {
        return id_provider;
    }

    public void setId_provider(Integer id_provider) {
        this.id_provider = id_provider;
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
    
    protected void fireOnInsert(Provider provider) {
        if (listener != null) {
           listener.onInsert(provider);
        }
    }
    
    
    
    public void insertProvider() throws SQLException, ProviderException {
        ProviderDao dao = CreamsDatabase.getProviderDao();
        Provider provider = new Provider();
        provider.setProvider_name(provider_name);
        provider.setPhone_number(phone_number);
        provider.setBalance(balance);
        
        dao.insertProvider(provider);
        fireOnInsert(provider);
    }
    
    public void resetProvider() {
        setId_provider(0);
        setProvider_name("");
        setPhone_number("");
        setBalance("");
    }
}
