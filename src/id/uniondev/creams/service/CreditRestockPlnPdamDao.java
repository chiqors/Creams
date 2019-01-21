/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.CreditRestockPlnPdam;
import id.uniondev.creams.error.CreditRestockPlnPdamException;
import java.util.List;

/**
 *
 * @author Aditya Nur Iskandar
 */
public interface CreditRestockPlnPdamDao {
    public void insertCreditRestockPlnPdam(CreditRestockPlnPdam creditRestockPlnPdam) throws CreditRestockPlnPdamException;
    public void updateCreditRestockPlnPdam(CreditRestockPlnPdam creditRestockPlnPdam) throws CreditRestockPlnPdamException;
    public void deleteCreditRestockPlnPdam(Integer id_credit_restock_plnpdam) throws CreditRestockPlnPdamException;
    
    public CreditRestockPlnPdam getCreditRestockPlnPdam(Integer id_credit_restock_plnpdam) throws CreditRestockPlnPdamException;
    public CreditRestockPlnPdam getCreditRestockPlnPdam(String nama_pelanggan, String type) throws CreditRestockPlnPdamException;
    public List<CreditRestockPlnPdam> selectAllCreditRestockPlnPdam() throws CreditRestockPlnPdamException;
}
