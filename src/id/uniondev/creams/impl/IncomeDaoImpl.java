/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.Income;
import id.uniondev.creams.error.IncomeException;
import id.uniondev.creams.service.IncomeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class IncomeDaoImpl implements IncomeDao {
    private Connection connection;
    
    private final String insertIncome = "INSERT INTO income(credit,credit_perdana,"
            + "credit_kuota,pln,pdam,outcome,current_date) VALUES (?,?,?,?,?,?)";
    private final String updateIncome = "UPDATE income SET income = ?, total = ? "
            + "WHERE id_income = ?";
    private final String deleteIncome = "DELETE FROM income WHERE id_income = ?";
    private final String getById = "SELECT * FROM income WHERE id_income = ?";
    private final String getByOutcome = "SELECT * FROM income WHERE "
            + "outcome = ?";
    private final String selectAll = "SELECT * FROM income";

    public IncomeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertIncome(Income income) throws IncomeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertIncome, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, income.getCredit_perdana());
            statement.setInt(2, income.getCredit_perdana());
            statement.setInt(3, income.getCredit_kuota());
            statement.setInt(4, income.getPln());
            statement.setInt(5, income.getPdam());
            statement.setInt(6, income.getOutcome());
            statement.setString(7, income.getCurrent_date());
            statement.setInt(8, income.getTotal());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                income.setId_income(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }

    @Override
    public void updateIncome(Income income) throws IncomeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateIncome);
            statement.setInt(1, income.getOutcome());
            statement.setInt(2, income.getTotal());
            statement.setInt(3, income.getId_income());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }

    @Override
    public void deleteIncome(Integer id) throws IncomeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteIncome);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }

    @Override
    public Income getIncome(Integer id) throws IncomeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Income income = null;
            if (result.next()) {
                income = new Income();
                income.setId_income(result.getInt("ID_INCOME"));
                income.setCredit(result.getInt("CREDIT"));
                income.setCredit_perdana(result.getInt("CREDIT_PERDANA"));
                income.setCredit_kuota(result.getInt("CREDIT_KUOTA"));
                income.setPln(result.getInt("PLN"));
                income.setPdam(result.getInt("PDAM"));
                income.setOutcome(result.getInt("OUTCOME"));
                income.setCurrent_date(result.getString("CURRENT_DATE"));
                income.setTotal(result.getInt("TOTAL"));
            } else {
                throw new IncomeException("Income with id " + id + " could not be find");
            }
            connection.commit();
            return income;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }

    @Override
    public Income getIncomeOutcome(Integer outcome) throws IncomeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByOutcome);
            statement.setInt(1, outcome);
            ResultSet result = statement.executeQuery();
            Income income = null;
            if (result.next()) {
                income = new Income();
                income.setId_income(result.getInt("ID_INCOME"));
                income.setCredit(result.getInt("CREDIT"));
                income.setCredit_perdana(result.getInt("CREDIT_PERDANA"));
                income.setCredit_kuota(result.getInt("CREDIT_KUOTA"));
                income.setPln(result.getInt("PLN"));
                income.setPdam(result.getInt("PDAM"));
                income.setOutcome(result.getInt("OUTCOME"));
                income.setCurrent_date(result.getString("CURRENT_DATE"));
                income.setTotal(result.getInt("TOTAL"));
            } else {
                throw new IncomeException("Income with outcome " + outcome + " could not be find");
            }
            connection.commit();
            return income;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Income> selectAllIncome() throws IncomeException {
        Statement statement = null;
        List<Income> list = new ArrayList<Income>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Income income = null;
            while (result.next()) {
                income = new Income();
                income.setId_income(result.getInt("ID_INCOME"));
                income.setCredit(result.getInt("CREDIT"));
                income.setCredit_perdana(result.getInt("CREDIT_PERDANA"));
                income.setCredit_kuota(result.getInt("CREDIT_KUOTA"));
                income.setPln(result.getInt("PLN"));
                income.setPdam(result.getInt("PDAM"));
                income.setOutcome(result.getInt("OUTCOME"));
                income.setCurrent_date(result.getString("CURRENT_DATE"));
                income.setTotal(result.getInt("TOTAL"));
                list.add(income);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new IncomeException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException e) {
                }
            }
        }
    }
}
