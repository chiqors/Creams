/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.CreditRestockKuota;
import id.uniondev.creams.error.CreditRestockKuotaException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CreditRestockKuotaDao  {
    public void updateCreditRestockKuota(CreditRestockKuota creditRestockKuota) throws CreditRestockKuotaException;
    
    public CreditRestockKuota getCreditRestockKuota(Integer id) throws CreditRestockKuotaException;
    public CreditRestockKuota getCreditRestockKuota(String provider_name) throws CreditRestockKuotaException;
    public List<CreditRestockKuota> selectAllCreditRestockKuota() throws CreditRestockKuotaException;
}
