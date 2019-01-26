/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.Provider;
import id.uniondev.creams.error.ProviderException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ProviderDao {
    public void insertProvider(Provider provider) throws ProviderException;
    public void updateProvider(Provider provider) throws ProviderException;
    public void deleteProvider(Integer id) throws ProviderException;
    
    public Provider getProvider(Integer id) throws ProviderException;
    public Provider getProvider(String provider_name) throws ProviderException;
    public List<Provider> selectAllIProvider() throws ProviderException;
}
