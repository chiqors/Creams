/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.CreditRestock;
import id.uniondev.creams.error.CreditRestockException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CreditRestockDao  {
    public void updateCreditRestock(CreditRestock creditRestock) throws CreditRestockException;
    
    public CreditRestock getCreditRestock(Integer id) throws CreditRestockException;
    public CreditRestock getCreditRestock(String provider_name) throws CreditRestockException;
    public List<CreditRestock> selectAllCreditRestock() throws CreditRestockException;
}
