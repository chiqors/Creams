/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.CustomerBill;
import id.uniondev.creams.error.CustomerBillException;
import id.uniondev.creams.service.CustomerBillDao;
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
public class CustomerBillDaoImpl implements CustomerBillDao {
    private Connection connection;
    
    private final String insertCustomerBill = "INSERT INTO customer_bill(customer_number,"
            + "customer_name,type,balance) VALUES (?,?,?,?)";
    private final String updateCustomerBill = "UPDATE customer_bill SET customer_number = ?, "
            + "customer_name = ?, type = ?, balance = ? WHERE id_customer_bill = ?";
    private final String deleteCustomerBill = "DELETE FROM customer_bill WHERE "
            + "id_customer_bill = ?";
    private final String getById = "SELECT * FROM customer_bill WHERE id_customer_bill = ?";
    private final String getByCustomer_name = "SELECT * FROM customer_bill WHERE "
            + "customer_name = ?";
    private final String selectAll = "SELECT * FROM customer_bill";

    public CustomerBillDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertCustomerBill(CustomerBill customerBill) throws CustomerBillException {

         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertCustomerBill, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customerBill.getCustomer_number());
            statement.setString(2, customerBill.getCustomer_name());
            statement.setString(3, customerBill.getType());
            statement.setInt(4, customerBill.getBalance());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                customerBill.setId_customer_bill(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
    public void updateCustomerBill(CustomerBill customerBill) throws CustomerBillException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateCustomerBill, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customerBill.getCustomer_number());
            statement.setString(2, customerBill.getCustomer_name());
            statement.setString(3, customerBill.getType());
            statement.setInt(4, customerBill.getBalance());
            statement.setInt(5, customerBill.getId_customer_bill());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                customerBill.setId_customer_bill(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
    public void deleteCustomerBill(Integer id_customer_bill) throws CustomerBillException {
         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteCustomerBill);
            statement.setInt(1, id_customer_bill);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
    public CustomerBill getCustomerBill(Integer id_customer_bill) throws CustomerBillException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id_customer_bill);
            ResultSet result = statement.executeQuery();
            CustomerBill creditRestockPlnPdam = null;
            if (result.next()) {
                creditRestockPlnPdam = new CustomerBill();
                creditRestockPlnPdam.setId_customer_bill(result.getInt("ID_CUSTOMER_BILL"));
                creditRestockPlnPdam.setCustomer_number(result.getString("CUSTOMER_NUMBER"));
                creditRestockPlnPdam.setCustomer_name(result.getString("CUSTOMER_NAME"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getInt("BALANCE"));
            } else {
               throw new CustomerBillException("Billing with id " + id_customer_bill + " could not be find");
            }
            connection.commit();
            return creditRestockPlnPdam;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
    public CustomerBill getCustomerBill(String customer_name) throws CustomerBillException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByCustomer_name);
            statement.setString(1, customer_name);
            ResultSet result = statement.executeQuery();
            CustomerBill creditRestockPlnPdam = null;
            if (result.next()) {
                creditRestockPlnPdam = new CustomerBill();
                creditRestockPlnPdam.setId_customer_bill(result.getInt("ID_CUSTOMER_BILL"));
                creditRestockPlnPdam.setCustomer_number(result.getString("CUSTOMER_NUMBER"));
                creditRestockPlnPdam.setCustomer_name(result.getString("CUSTOMER_NAME"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getInt("BALANCE"));
            } else {
                throw new CustomerBillException("Billing with customer name " + customer_name + " could not be find");
            }
            connection.commit();
            return creditRestockPlnPdam;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
    public List<CustomerBill> selectAllCustomerBill() throws CustomerBillException {
        Statement statement = null;
        List<CustomerBill> list = new ArrayList<CustomerBill>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            CustomerBill creditRestockPlnPdam = null;
            while (result.next()) {
                creditRestockPlnPdam = new CustomerBill();
                creditRestockPlnPdam.setId_customer_bill(result.getInt("ID_CUSTOMER_BILL"));
                creditRestockPlnPdam.setCustomer_number(result.getString("CUSTOMER_NUMBER"));
                creditRestockPlnPdam.setCustomer_name(result.getString("CUSTOMER_NAME"));
                creditRestockPlnPdam.setType(result.getString("TYPE"));
                creditRestockPlnPdam.setBalance(result.getInt("BALANCE"));
                list.add(creditRestockPlnPdam);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerBillException(e.getMessage());
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
