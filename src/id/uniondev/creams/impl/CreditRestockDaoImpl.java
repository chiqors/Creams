/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.CreditRestock;
import id.uniondev.creams.error.CreditRestockException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import id.uniondev.creams.service.CreditRestockDao;

/**
 *
 * @author ACER
 */
public class CreditRestockDaoImpl implements CreditRestockDao {
    private Connection connection;
    
    private final String updateCreditRestock = "UPDATE credit_restock SET balance_current = ? WHERE provider_name = ? type = ?";
    private final String getById = "SELECT * FROM credit_restock WHERE id_credit_restock = ?";
    private final String getByProvider_name = "SELECT * FROM credit_restock WHERE provder_name = ?";
    private final String selectAll = "SELECT * FROM credit_restock";

    public CreditRestockDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public CreditRestock getCreditRestock(Integer id) throws CreditRestockException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            CreditRestock creditRestock = null;
            if (result.next()) {
                creditRestock = new CreditRestock();
                creditRestock.setId_credit_restock(result.getInt("ID_CREDIT_RESTOCK"));
                creditRestock.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestock.setType(result.getString("TYPE"));
                creditRestock.setBalance_current(result.getInt("BALANCE_CURRENT"));
            } else {
                throw new CreditRestockException("Credit Restock Kuota with id " + id + " could not be find");
            }
            connection.commit();
            return creditRestock;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockException(e.getMessage());
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
        public CreditRestock getCreditRestock(String provider_name) throws CreditRestockException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByProvider_name);
            statement.setString(1, provider_name);
            ResultSet result = statement.executeQuery();
            CreditRestock creditRestock = null;
            if (result.next()) {
                creditRestock = new CreditRestock();
                creditRestock.setId_credit_restock(result.getInt("ID_CREDIT_RESTOCK"));
                creditRestock.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestock.setType(result.getString("TYPE"));
                creditRestock.setBalance_current(result.getInt("BALANCE_CURRENT"));
            } else {
                throw new CreditRestockException("Credit Restock Kuota with provider " + provider_name + " could not be find");
            }
            connection.commit();
            return creditRestock;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockException(e.getMessage());
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
    public List<CreditRestock> selectAllCreditRestock() throws CreditRestockException {
        Statement statement = null;
        List<CreditRestock> list = new ArrayList<CreditRestock>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            CreditRestock creditRestock = null;
            while (result.next()) {
                creditRestock = new CreditRestock();
                creditRestock.setId_credit_restock(result.getInt("ID_CREDIT_RESTOCK"));
                creditRestock.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestock.setType(result.getString("TYPE"));
                creditRestock.setBalance_current(result.getInt("BALANCE_CURRENT"));
                list.add(creditRestock);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockException(e.getMessage());
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
    public void updateCreditRestock(CreditRestock creditRestock) throws CreditRestockException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateCreditRestock);
            statement.setInt(1, creditRestock.getBalance_current());
            statement.setString(2, creditRestock.getProvider_name());
            statement.setString(3, creditRestock.getType());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CreditRestockException(e.getMessage());
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
}
