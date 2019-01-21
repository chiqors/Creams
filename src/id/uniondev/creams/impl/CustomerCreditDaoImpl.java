/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.CustomerCredit;
import id.uniondev.creams.error.CustomerCreditException;
import id.uniondev.creams.service.CustomerCreditDao;
import id.uniondev.creams.service.CustomerCreditDao;
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
public class CustomerCreditDaoImpl implements CustomerCreditDao {
    private Connection connection;
    
    private final String insertCustomerCredit = "INSERT INTO customer_credit(provider_name,"
            + "phone_number,balance) VALUES (?,?,?)";
    private final String updateCustomerCredit = "UPDATE customer_credit SET provider_name = ?, phone_number = ?, "
            + "balance = ? WHERE id_customer_credit = ?";
    private final String deleteCustomerCredit = "DELETE FROM customer_credit WHERE id_customer_credit = ?";
    private final String getById = "SELECT * FROM customer_credit WHERE id_customer_credit = ?";
    private final String getByPhone_number = "SELECT * FROM customer_credit WHERE "
            + "phone_number = ?";
    private final String selectAll = "SELECT * FROM customer_credit";

    public CustomerCreditDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertCustomerCredit(CustomerCredit customerCredit) throws CustomerCreditException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertCustomerCredit, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customerCredit.getProvider_name());
            statement.setString(2, customerCredit.getPhone_number());
            statement.setString(3, customerCredit.getBalance());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                customerCredit.setId_customer_credit(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerCreditException(e.getMessage());
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
    public CustomerCredit getCustomerCredit(Integer id) throws CustomerCreditException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            CustomerCredit provider = null;
            if (result.next()) {
                provider = new CustomerCredit();
                provider.setId_customer_credit(result.getInt("ID_CUSTOMER_CREDIT"));
                provider.setProvider_name(result.getString("PROVIDER_NAME"));
                provider.setPhone_number(result.getString("PHONE_NUMBER"));
                provider.setBalance(result.getString("BALANCE"));
            } else {
                throw new CustomerCreditException("Customer Credit with id " + id + " could not be find");
            }
            connection.commit();
            return provider;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerCreditException(e.getMessage());
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
    public CustomerCredit getCustomerCredit(String phone_number) throws CustomerCreditException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, phone_number);
            ResultSet result = statement.executeQuery();
            CustomerCredit provider = null;
            if (result.next()) {
                provider = new CustomerCredit();
                provider.setId_customer_credit(result.getInt("ID_CUSTOMER_CREDIT"));
                provider.setProvider_name(result.getString("PROVIDER_NAME"));
                provider.setPhone_number(result.getString("PHONE_NUMBER"));
                provider.setBalance(result.getString("BALANCE"));
            } else {
                throw new CustomerCreditException("Customer Credit with name " + phone_number + " could not be find");
            }
            connection.commit();
            return provider;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerCreditException(e.getMessage());
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
    public List<CustomerCredit> selectAllCustomerCredit() throws CustomerCreditException {
        Statement statement = null;
        List<CustomerCredit> list = new ArrayList<CustomerCredit>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            CustomerCredit customerCredit = null;
            while (result.next()) {
                customerCredit = new CustomerCredit();
                customerCredit.setId_customer_credit(result.getInt("ID_CUSTOMER_CREDIT"));
                customerCredit.setProvider_name(result.getString("PROVIDER_NAME"));
                customerCredit.setPhone_number(result.getString("PHONE_NUMBER"));
                customerCredit.setBalance(result.getString("BALANCE"));
                list.add(customerCredit);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerCreditException(e.getMessage());
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
