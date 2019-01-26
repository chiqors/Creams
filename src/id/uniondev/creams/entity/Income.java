/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.entity;

import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Income {
    private Integer id_income;
    private Integer credit;
    private Integer credit_perdana;
    private Integer credit_kuota;
    private Integer pln;
    private Integer pdam;
    private Integer outcome;
    private String current_date;
    private Integer total;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id_income);
        hash = 37 * hash + Objects.hashCode(this.credit);
        hash = 37 * hash + Objects.hashCode(this.credit_perdana);
        hash = 37 * hash + Objects.hashCode(this.credit_kuota);
        hash = 37 * hash + Objects.hashCode(this.pln);
        hash = 37 * hash + Objects.hashCode(this.pdam);
        hash = 37 * hash + Objects.hashCode(this.outcome);
        hash = 37 * hash + Objects.hashCode(this.current_date);
        hash = 37 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Income other = (Income) obj;
        if (!Objects.equals(this.current_date, other.current_date)) {
            return false;
        }
        if (!Objects.equals(this.id_income, other.id_income)) {
            return false;
        }
        if (!Objects.equals(this.credit, other.credit)) {
            return false;
        }
        if (!Objects.equals(this.credit_perdana, other.credit_perdana)) {
            return false;
        }
        if (!Objects.equals(this.credit_kuota, other.credit_kuota)) {
            return false;
        }
        if (!Objects.equals(this.pln, other.pln)) {
            return false;
        }
        if (!Objects.equals(this.pdam, other.pdam)) {
            return false;
        }
        if (!Objects.equals(this.outcome, other.outcome)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }
    
}
