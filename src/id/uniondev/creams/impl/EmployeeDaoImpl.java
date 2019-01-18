/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.Employee;
import id.uniondev.creams.error.EmployeeException;
import id.uniondev.creams.service.EmployeeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class EmployeeDaoImpl implements EmployeeDao{

    private Connection connection;
    
    private final String insertEmployee = "INSERT INTO employee(username,password,employee_name,role) VALUES (?,?,?,?)";
    private final String updateEmployee = "UPDATE employee SET username = ?, password = ?, "
            + "employee_name = ?, role = ? WHERE id_employee = ?";
    private final String deleteEmployee = "DELETE FROM employee WHERE id_employee = ?";
    private final String getById = "SELECT * FROM employee WHERE id_employee = ?";
    private final String getByEmployee_name = "SELECT * FROM employee WHERE "
            + "employee_name = ?";
    private final String selectAll = "SELECT * FROM employee";
    
    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertEmployee(Employee employee) throws EmployeeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(insertEmployee, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getUsername());
            statement.setString(2, employee.getPassword());
            statement.setString(3, employee.getEmployee_name());
            statement.setString(4, employee.getRole());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                employee.setId(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new EmployeeException(e.getMessage());
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
    public void updateEmployee(Employee employee) throws EmployeeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateEmployee);
            statement.setString(1, employee.getUsername());
            statement.setString(2, employee.getPassword());
            statement.setString(3, employee.getEmployee_name());
            statement.setString(4, employee.getRole());
            statement.setInt(5, employee.getId_employee());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new EmployeeException(e.getMessage());
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
    public void deleteEmployee(Integer id) throws EmployeeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteEmployee);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new EmployeeException(e.getMessage());
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
    public Employee getEmployee(Integer id) throws EmployeeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Employee employee = null;
            if (result.next()) {
                employee = new Employee();
                employee.setId(result.getInt("ID_EMPLOYEE"));
                employee.setUsername(result.getString("USERNAME"));
                employee.setPassword(result.getString("PASSWORD"));
                employee.setEmployee_name(result.getString("EMPLOYEE_NAME"));
                employee.setRole(result.getString("ROLE"));
            } else {
                throw new EmployeeException("Employee with id " + id + " could not be find");
            }
            connection.commit();
            return employee;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new EmployeeException(e.getMessage());
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
    public Employee getEmployee(String employee_name) throws EmployeeException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmployee_name);
            statement.setString(1, employee_name);
            ResultSet result = statement.executeQuery();
            Employee employee = null;
            if (result.next()) {
                employee = new Employee();
                employee.setId(result.getInt("ID_EMPLOYEE"));
                employee.setUsername(result.getString("USERNAME"));
                employee.setPassword(result.getString("PASSWORD"));
                employee.setEmployee_name(result.getString("EMPLOYEE_NAME"));
                employee.setRole(result.getString("ROLE"));
            } else {
                throw new EmployeeException("Employee with name " + employee_name + " could not be find");
            }
            connection.commit();
            return employee;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new EmployeeException(e.getMessage());
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
    public List<Employee> selectAllEmployee() throws EmployeeException {
        Statement statement = null;
        List<Employee> list = new ArrayList<Employee>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Employee employee = null;
            while (result.next()) {
                employee = new Employee();
                employee.setId(result.getInt("ID_EMPLOYEE"));
                employee.setUsername(result.getString("USERNAME"));
                employee.setPassword(result.getString("PASSWORD"));
                employee.setEmployee_name(result.getString("EMPLOYEE_NAME"));
                employee.setRole(result.getString("ROLE"));
                list.add(employee);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new EmployeeException(e.getMessage());
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
