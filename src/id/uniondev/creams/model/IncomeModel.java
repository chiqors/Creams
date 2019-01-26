/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.model;

import id.uniondev.creams.database.CreamsDatabase;
import id.uniondev.creams.entity.Income;
import id.uniondev.creams.error.IncomeException;
import id.uniondev.creams.event.IncomeListener;
import id.uniondev.creams.service.IncomeDao;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class IncomeModel {
    private Integer id_income;
    private Integer credit;
    private Integer credit_perdana;
    private Integer credit_kuota;
    private Integer pln;
    private Integer pdam;
    private Integer outcome;
    private String current_date;
    private Integer total;
    
    private IncomeListener listener;

    public Integer getId_income() {
        return id_income;
    }

    public void setId_income(Integer id_income) {
        this.id_income = id_income;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
    
    public Integer getCredit_perdana() {
        return credit_perdana;
    }

    public void setCredit_perdana(Integer credit_perdana) {
        this.credit_perdana = credit_perdana;
    }

    public Integer getCredit_kuota() {
        return credit_kuota;
    }

    public void setCredit_kuota(Integer credit_kuota) {
        this.credit_kuota = credit_kuota;
    }

    public Integer getPln() {
        return pln;
    }

    public void setPln(Integer pln) {
        this.pln = pln;
    }

    public Integer getPdam() {
        return pdam;
    }

    public void setPdam(Integer pdam) {
        this.pdam = pdam;
    }

    public Integer getOutcome() {
        return outcome;
    }

    public void setOutcome(Integer outcome) {
        this.outcome = outcome;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public IncomeListener getListener() {
        return listener;
    }

    public void setListener(IncomeListener listener) {
        this.listener = listener;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
           listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Income income) {
        if (listener != null) {
           listener.onInsert(income);
        }
    }
    
    protected void fireOnUpdate(Income income) {
        if (listener != null) {
           listener.onUpdate(income);
        }
    }
    
    protected void fireOnDelete(Income income) {
        if (listener != null) {
           listener.onDelete(income);
        }
    }
    
    public void insertIncome() throws SQLException, IncomeException {
        IncomeDao dao = CreamsDatabase.getIncomeDao();
        Income income = new Income();
        income.setCredit_perdana(credit_perdana);
        income.setCredit_kuota(credit_kuota);
        income.setPln(pln);
        income.setPdam(pdam);
        income.setOutcome(outcome);
        income.setCurrent_date(current_date);
        income.setTotal(total);
        
        dao.insertIncome(income);
        fireOnInsert(income);
    }
    
    public void updateIncome() throws SQLException, IncomeException {
        IncomeDao dao = CreamsDatabase.getIncomeDao();
        Income income = new Income();
        income.setOutcome(outcome);
        income.setTotal(total);
        
        dao.updateIncome(income);
        fireOnUpdate(income);
    }
    
    public void deleteIncome() throws SQLException, IncomeException {
        IncomeDao dao = CreamsDatabase.getIncomeDao();
        Income income = new Income();
        dao.deleteIncome(id_income);
        fireOnDelete(income);
    }
    
    public void resetIncome() {
        setOutcome(0);
        setTotal(0);
    }
}
