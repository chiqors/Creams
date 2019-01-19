/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.Customer;
import id.uniondev.creams.error.CustomerException;
import id.uniondev.creams.service.CustomerDao;
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
public class CustomerDaoImpl implements CustomerDao {
    private Connection connection;
    
    private final String insertCustomer = "INSERT INTO customer(username,"
            + "password,customer_name,phone_number,status) VALUES (?,?,?,?,?)";
    private final String updateCustomer = "UPDATE customer SET username = ?, password = ?, "
            + "customer_name = ?, phone_number = ?, status = ? WHERE id_customer = ?";
    private final String deleteCustomer = "DELETE FROM customer WHERE id_customer = ?";
    private final String getById = "SELECT * FROM customer WHERE id_customer = ?";
    private final String getByPhoneNumber = "SELECT * FROM customer WHERE "
            + "phone_number = ?";
    private final String selectAll = "SELECT * FROM customer";

    public CustomerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertCustomer(Customer customer) throws CustomerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getCustomer_name());
            statement.setString(4, customer.getPhone_number());
            statement.setString(5, customer.getStatus());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                customer.setId_customer(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerException(e.getMessage());
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
    public void updateCustomer(Customer customer) throws CustomerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateCustomer);
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getCustomer_name());
            statement.setString(4, customer.getPhone_number());
            statement.setString(5, customer.getStatus());
            statement.setInt(6, customer.getId_customer());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CustomerException(e.getMessage());
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
    public void deleteCustomer(Integer id) throws CustomerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteCustomer);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerException(e.getMessage());
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
    public Customer getCustomer(Integer id) throws CustomerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Customer customer = null;
            if (result.next()) {
                customer = new Customer();
                customer.setId_customer(result.getInt("ID_CUSTOMER"));
                customer.setUsername(result.getString("USERNAME"));
                customer.setPassword(result.getString("PASSWORD"));
                customer.setCustomer_name(result.getString("CUSTOMER_NAME"));
                customer.setPhone_number(result.getString("PHONE_NUMBER"));
                customer.setStatus(result.getString("STATUS"));
            } else {
                throw new CustomerException("Customer with id " + id + " could not be find");
            }
            connection.commit();
            return customer;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerException(e.getMessage());
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
    public Customer getCustomer(String customer_name) throws CustomerException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByPhoneNumber);
            statement.setString(1, customer_name);
            ResultSet result = statement.executeQuery();
            Customer customer = null;
            if (result.next()) {
                customer = new Customer();
                customer.setId_customer(result.getInt("ID_CUSTOMER"));
                customer.setUsername(result.getString("USERNAME"));
                customer.setPassword(result.getString("PASSWORD"));
                customer.setCustomer_name(result.getString("CUSTOMER_NAME"));
                customer.setPhone_number(result.getString("STATUS"));
            } else {
                throw new CustomerException("Customer with name " + customer_name + " could not be find");
            }
            connection.commit();
            return customer;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerException(e.getMessage());
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
    public List<Customer> selectAllCustomer() throws CustomerException {
        Statement statement = null;
        List<Customer> list = new ArrayList<Customer>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Customer customer = null;
            while (result.next()) {
                customer = new Customer();
                customer.setId_customer(result.getInt("ID_CUSTOMER"));
                customer.setUsername(result.getString("USERNAME"));
                customer.setPassword(result.getString("PASSWORD"));
                customer.setCustomer_name(result.getString("CUSTOMER_NAME"));
                customer.setPhone_number(result.getString("PHONE_NUMBER"));
                customer.setPhone_number(result.getString("STATUS"));
                list.add(customer);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new CustomerException(e.getMessage());
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
