/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.service;

import id.uniondev.creams.entity.Income;
import id.uniondev.creams.error.IncomeException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface IncomeDao {
    public void insertIncome(Income income) throws IncomeException;
    public void updateIncome(Income income) throws IncomeException;
    public void deleteIncome(Integer id) throws IncomeException;
    
    public Income getIncome(Integer id) throws IncomeException;
    public Income getIncomeOutcome(Integer outcome) throws IncomeException;
    public List<Income> selectAllIncome() throws IncomeException;
}
