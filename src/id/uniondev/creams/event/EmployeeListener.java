/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.event;

import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.model.EmployeeModel;

/**
 *
 * @author ACER
 */
public interface EmployeeListener {
    public void onChange(EmployeeModel model);
    public void onInsert(Employee employee);
    public void onUpdate(Employee employee);
    public void onDelete(Employee employee);
}
