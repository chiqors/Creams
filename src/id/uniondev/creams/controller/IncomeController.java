/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.controller;

import id.uniondev.creams.model.IncomeModel;
import id.uniondev.creams.view.MainFrame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class IncomeController {
    private IncomeModel model;

    public void setModel(IncomeModel model) {
        this.model = model;
    }
    
    public void resetIncome(MainFrame frame) {
        model.resetIncome();
    }
    
    public void insertIncome(MainFrame frame) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        Integer credit = Integer.parseInt(frame.getTxtPendapatanCredit().getText());
        Integer credit_perdana = Integer.parseInt(frame.getTxtPendapatanCreditPerdana().getText());
        Integer credit_kuota = Integer.parseInt(frame.getTxtPendapatanCreditKuota().getText());
        Integer pln = Integer.parseInt(frame.getTxtPendapatanPLN().getText());
        Integer pdam = Integer.parseInt(frame.getTxtPendapatanPDAM().getText());
        Integer outcome = Integer.parseInt(frame.getTxtPendapatanOutcome().getText());
        String current_date = dateFormat.format(date).toString();
        Integer total = Integer.parseInt(frame.getTxtPendapatanTotal().getText());
        
        if (credit.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Credit still empty!");
        } else if (credit_perdana.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Credit Perdana Name still empty!");
        } else if (credit_kuota.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Credit Kuota still empty!");
        } else if (pln.equals(null)) {
            JOptionPane.showMessageDialog(frame, "PLN still empty!");
        } else if (pdam.equals(null)) {
            JOptionPane.showMessageDialog(frame, "PDAM still empty!");
        } else if (outcome.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Outcome still empty!");
        } else if (current_date.trim().equals("")) {
            JOptionPane.showMessageDialog(frame, "Current Date still empty!");
        } else if (total.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Total still empty!");
        } else {
            model.setCredit(credit);
            model.setCredit_perdana(credit_perdana);
            model.setCredit_kuota(credit_kuota);
            model.setPln(pln);
            model.setPdam(pdam);
            model.setOutcome(outcome);
            model.setCurrent_date(current_date);
            model.setTotal(total);
            try {
                model.insertIncome();
                JOptionPane.showMessageDialog(frame, "New income is successfully added");
                model.resetIncome();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateIncome(MainFrame frame) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (frame.getTblPendapatan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to update");
            return;
        }

        Integer id = Integer.parseInt(frame.getTxtPendapatanId_income().getText());
        Integer outcome = Integer.parseInt(frame.getTxtPendapatanOutcome().getText());
        Integer total = Integer.parseInt(frame.getTxtPendapatanTotal().getText());

        if (outcome.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Outcome still empty!");
        } else if (total.equals(null)) {
            JOptionPane.showMessageDialog(frame, "Total still empty!");
        } else {
            model.setId_income(id);
            model.setOutcome(outcome);
            model.setTotal(total);
            try {
                model.updateIncome();
                JOptionPane.showMessageDialog(frame, "Income is successfully edited");
                model.resetIncome();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteIncome(MainFrame frame) {
        if (frame.getTblPendapatan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(frame, "Please, select the row data that you wanted to delete");
            return;
        }
        if (JOptionPane.showConfirmDialog(frame, "Are you sure to delete this?") == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(frame.getTxtPendapatanId_income().getText());
            model.setId_income(id);
            try {
                model.deleteIncome();
                JOptionPane.showMessageDialog(frame, "Customer is successfully removed");
                model.resetIncome();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(frame, new Object[]{
                    "Error appeared with message ", throwable.getMessage()
                });
            }
        }
    }
}
