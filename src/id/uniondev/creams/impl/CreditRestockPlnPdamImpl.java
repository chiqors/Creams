/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.CreditRestockPlnPdam;
import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.error.CreditRestockPlnPdamException;
import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.service.CreditRestockPlnPdamDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditya Nur Iskandar
 */
public class CreditRestockPlnPdamImpl implements CreditRestockPlnPdamDao {
    private Connection connection;
    
    private final String insertCreditRestockPlnPdam = "INSERT INTO credit_restock_plnpdam(no_pelanggan,"
            + "nama_pelanggan,type,balance) VALUES (?,?,?,?)";
    private final String updateCreditRestockPlnPdam = "UPDATE credit_restock_plnpdam SET no_pelanggan = ?, "
            + "nama_pelanggan = ?, type = ?, balance = ? WHERE id_credit_restock_plnpdam = ?";
    private final String deleteCreditRestockPlnPdam = "DELETE FROM credit_restock_plnpdam WHERE "
            + "id_credit_restock_plnpdam = ?";
    private final String getById = "SELECT * FROM customer WHERE id_credit_restock_plnpdam = ?";
    private final String getByNoPelanggan = "SELECT * FROM customer WHERE "
            + "phone_number = ?";
    private final String selectAll = "SELECT * FROM customer";

    public CreditRestockPlnPdamImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertCreditRestockPlnPdam(CreditRestockPlnPdam creditRestockPlnPdam) throws CreditRestockPlnPdamException {

         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertCreditRestockPlnPdam, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, creditRestockPlnPdam.getNo_pelanggan());
            statement.setString(1, creditRestockPlnPdam.getNama_pelanggan());
            statement.setString(2, creditRestockPlnPdam.getType());
            statement.setString(3, creditRestockPlnPdam.getBalance());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                creditRestockPlnPdam.setId_credit_restock_plnpdam(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
    public void updateCreditRestockPlnPdam(CreditRestockPlnPdam creditRestockPlnPdam) throws CreditRestockPlnPdamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateCreditRestockPlnPdam, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, creditRestockPlnPdam.getNo_pelanggan());
            statement.setString(1, creditRestockPlnPdam.getNama_pelanggan());
            statement.setString(2, creditRestockPlnPdam.getType());
            statement.setString(3, creditRestockPlnPdam.getBalance());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                creditRestockPlnPdam.setId_credit_restock_plnpdam(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
    public void deleteCreditRestockPlnPdam(Integer id_credit_restock_plnpdam) throws CreditRestockPlnPdamException {
         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteCreditRestockPlnPdam);
            statement.setInt(1, id_credit_restock_plnpdam);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
    public CreditRestockPlnPdam getCreditRestockPlnPdam(Integer id_credit_restock_plnpdam) throws CreditRestockPlnPdamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id_credit_restock_plnpdam);
            ResultSet result = statement.executeQuery();
            CreditRestockPlnPdam creditRestockPlnPdam = null;
            if (result.next()) {
                creditRestockPlnPdam = new CreditRestockPlnPdam();
                creditRestockPlnPdam.setId_credit_restock_plnpdam(result.getInt("ID_CREDIT_RESTOCK_PLNPDAM"));
                creditRestockPlnPdam.setNo_pelanggan(result.getString("NO_PELANGGAN"));
                creditRestockPlnPdam.setNama_pelanggan(result.getString("NAMA_PELANGGAN"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getString("BALANCE"));
            } else {
               throw new CreditRestockPlnPdamException("Customer with id " + id_credit_restock_plnpdam + " could not be find");
            }
            connection.commit();
            return creditRestockPlnPdam;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
    public CreditRestockPlnPdam getCreditRestockPlnPdam(String nama_pelanggan, String type) throws CreditRestockPlnPdamException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNoPelanggan);
            statement.setString(1, nama_pelanggan);
            ResultSet result = statement.executeQuery();
            CreditRestockPlnPdam creditRestockPlnPdam = null;
            if (result.next()) {
                creditRestockPlnPdam = new CreditRestockPlnPdam();
                creditRestockPlnPdam.setId_credit_restock_plnpdam(result.getInt("ID_CREDIT_RESTOCK_PLNPDAM"));
                creditRestockPlnPdam.setNo_pelanggan(result.getString("NO_PELANGGAN"));
                creditRestockPlnPdam.setNama_pelanggan(result.getString("NAMA_PELANGGAN"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getString("BALANCE"));
            } else {
                throw new CreditRestockPlnPdamException("Customer with name " + nama_pelanggan + " could not be find");
            }
            connection.commit();
            return creditRestockPlnPdam;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
    public List<CreditRestockPlnPdam> selectAllCreditRestockPlnPdam() throws CreditRestockPlnPdamException {
        Statement statement = null;
        List<CreditRestockPlnPdam> list = new ArrayList<CreditRestockPlnPdam>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            CreditRestockPlnPdam creditRestockPlnPdam = null;
            while (result.next()) {
                creditRestockPlnPdam = new CreditRestockPlnPdam();
                creditRestockPlnPdam.setId_credit_restock_plnpdam(result.getInt("ID_CREDIT_RESTOCK_PLNPDAM"));
                creditRestockPlnPdam.setNo_pelanggan(result.getString("NO_PELANGGAN"));
                creditRestockPlnPdam.setNama_pelanggan(result.getString("NAMA_PELANGGAN"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getString("BALANCE"));
                list.add(creditRestockPlnPdam);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CreditRestockPlnPdamException(e.getMessage());
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
