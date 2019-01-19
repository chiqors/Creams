/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import id.uniondev.creams.impl.CustomerDaoImpl;
import id.uniondev.creams.impl.EmployeeDaoImpl;
import id.uniondev.creams.impl.ProviderDaoImpl;
import id.uniondev.creams.service.CustomerDao;
import id.uniondev.creams.service.EmployeeDao;
import id.uniondev.creams.service.ProviderDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class CreamsDatabase {
    private static Connection connection;
    private static EmployeeDao employeeDao;
    private static CustomerDao customerDao;
    private static ProviderDao providerDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/creams");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = (Connection) dataSource.getConnection();
        }
        return connection;
    }
    
    public static EmployeeDao getEmployeeDao() throws SQLException {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl(getConnection());
        }
        return employeeDao;
    }

    public static CustomerDao getCustomerDao() throws SQLException {
        if (customerDao == null) {
            customerDao = new CustomerDaoImpl(getConnection());
        }
        return customerDao;
    }

    public static ProviderDao getProviderDao() throws SQLException {
        if (providerDao == null) {
            providerDao = new ProviderDaoImpl(getConnection());
        }
        return providerDao;
    }
    
}
