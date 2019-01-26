/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.Income;
import id.uniondev.creams.model.IncomeModel;

/**
 *
 * @author ACER
 */
public interface IncomeListener {
    public void onChange(IncomeModel model);
    public void onInsert(Income income);
    public void onUpdate(Income income);
    public void onDelete(Income income);
}
