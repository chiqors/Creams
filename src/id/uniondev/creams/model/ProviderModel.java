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
    private String status;
    private Integer balance;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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
    
    protected void fireOnUpdate(Provider provider) {
        if (listener != null) {
           listener.onUpdate(provider);
        }
    }
    
    protected void fireOnDelete(Provider provider) {
        if (listener != null) {
           listener.onDelete(provider);
        }
    }
    
    public void insertProvider() throws SQLException, ProviderException {
        ProviderDao dao = CreamsDatabase.getProviderDao();
        Provider provider = new Provider();
        provider.setProvider_name(provider_name);
        provider.setStatus(status);
        provider.setBalance(balance);
        
        dao.insertProvider(provider);
        fireOnInsert(provider);
    }
    
    public void updateProvider() throws SQLException, ProviderException {
        ProviderDao dao = CreamsDatabase.getProviderDao();
        Provider provider = new Provider();
        provider.setProvider_name(provider_name);
        provider.setStatus(status);
        provider.setBalance(balance);
        provider.setId_provider(id_provider);
        
        dao.updateProvider(provider);
        fireOnUpdate(provider);
    }
    
    public void deleteProvider() throws SQLException, ProviderException {
        ProviderDao dao = CreamsDatabase.getProviderDao();
        Provider provider = new Provider();
        dao.deleteProvider(id_provider);
        fireOnDelete(provider);
    }
    
    public void resetProvider() {
        setId_provider(0);
        setProvider_name("");
        setStatus("");
        setBalance(0);
    }
}
