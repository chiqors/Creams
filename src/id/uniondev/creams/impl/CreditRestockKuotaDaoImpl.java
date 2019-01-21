/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.CreditRestockKuota;
import id.uniondev.creams.error.CreditRestockKuotaException;
import id.uniondev.creams.service.CreditRestockKuotaDao;
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
public class CreditRestockKuotaDaoImpl implements CreditRestockKuotaDao {
    private Connection connection;
    
    private final String updateCreditRestockKuota = "UPDATE credit_restock_kuota SET balance_current = ? WHERE provider_name = ?";
    private final String getById = "SELECT * FROM credit_restock_kuota WHERE id_credit_restock_kuota = ?";
    private final String getByProvider_name = "SELECT * FROM credit_restock_kuota WHERE provder_name = ?";
    private final String selectAll = "SELECT * FROM credit_restock_kuota";

    public CreditRestockKuotaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void updateCreditRestockKuota(CreditRestockKuota creditRestockKuota) throws CreditRestockKuotaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateCreditRestockKuota);
            statement.setInt(1, creditRestockKuota.getBalance_current());
            statement.setString(2, creditRestockKuota.getProvider_name());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CreditRestockKuotaException(e.getMessage());
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
    public CreditRestockKuota getCreditRestockKuota(Integer id) throws CreditRestockKuotaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            CreditRestockKuota creditRestockKuota = null;
            if (result.next()) {
                creditRestockKuota = new CreditRestockKuota();
                creditRestockKuota.setId_credit_restock_kuota(result.getInt("ID_CREDIT_RESTOCK_KUOTA"));
                creditRestockKuota.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestockKuota.setType(result.getString("TYPE"));
                creditRestockKuota.setBalance_current(result.getInt("BALANCE_CURRENT"));
            } else {
                throw new CreditRestockKuotaException("Credit Restock Kuota with id " + id + " could not be find");
            }
            connection.commit();
            return creditRestockKuota;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockKuotaException(e.getMessage());
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
        public CreditRestockKuota getCreditRestockKuota(String provider_name) throws CreditRestockKuotaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByProvider_name);
            statement.setString(1, provider_name);
            ResultSet result = statement.executeQuery();
            CreditRestockKuota creditRestockKuota = null;
            if (result.next()) {
                creditRestockKuota = new CreditRestockKuota();
                creditRestockKuota.setId_credit_restock_kuota(result.getInt("ID_CREDIT_RESTOCK_KUOTA"));
                creditRestockKuota.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestockKuota.setType(result.getString("TYPE"));
                creditRestockKuota.setBalance_current(result.getInt("BALANCE_CURRENT"));
            } else {
                throw new CreditRestockKuotaException("Credit Restock Kuota with provider " + provider_name + " could not be find");
            }
            connection.commit();
            return creditRestockKuota;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockKuotaException(e.getMessage());
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
    public List<CreditRestockKuota> selectAllCreditRestockKuota() throws CreditRestockKuotaException {
        Statement statement = null;
        List<CreditRestockKuota> list = new ArrayList<CreditRestockKuota>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            CreditRestockKuota creditRestockKuota = null;
            while (result.next()) {
                creditRestockKuota = new CreditRestockKuota();
                creditRestockKuota.setId_credit_restock_kuota(result.getInt("ID_CREDIT_RESTOCK_KUOTA"));
                creditRestockKuota.setProvider_name(result.getString("PROVIDER_NAME"));
                creditRestockKuota.setType(result.getString("TYPE"));
                creditRestockKuota.setBalance_current(result.getInt("BALANCE_CURRENT"));
                list.add(creditRestockKuota);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockKuotaException(e.getMessage());
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
