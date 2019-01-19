/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.uniondev.creams.impl;

import id.uniondev.creams.entity.Provider;
import id.uniondev.creams.error.ProviderException;
import id.uniondev.creams.service.ProviderDao;
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
public class ProviderDaoImpl implements ProviderDao {
    private Connection connection;
    
    private final String insertProvider = "INSERT INTO provider(provider_name,"
            + "status,balance) VALUES (?,?,?)";
    private final String updateProvider = "UPDATE provider SET provider_name = ?, status = ?, "
            + "balance = ? WHERE id_provider = ?";
    private final String deleteProvider = "DELETE FROM provider WHERE id_provider = ?";
    private final String getById = "SELECT * FROM provider WHERE id_provider = ?";
    private final String getByProvider_name = "SELECT * FROM provider WHERE "
            + "provider_name = ?";
    private final String selectAll = "SELECT * FROM provider";

    public ProviderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertProvider(Provider provider) throws ProviderException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertProvider, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, provider.getProvider_name());
            statement.setString(2, provider.getStatus());
            statement.setInt(3, provider.getBalance());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                provider.setId_provider(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new ProviderException(e.getMessage());
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
    public void updateProvider(Provider provider) throws ProviderException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateProvider);
            statement.setString(1, provider.getProvider_name());
            statement.setString(2, provider.getStatus());
            statement.setInt(3, provider.getBalance());
            statement.setInt(4, provider.getId_provider());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new ProviderException(e.getMessage());
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
    public void deleteProvider(Integer id) throws ProviderException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteProvider);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new ProviderException(e.getMessage());
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
    public Provider getProvider(Integer id) throws ProviderException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Provider provider = null;
            if (result.next()) {
                provider = new Provider();
                provider.setId_provider(result.getInt("ID_PROVIDER"));
                provider.setProvider_name(result.getString("PROVIDER_NAME"));
                provider.setStatus(result.getString("STATUS"));
                provider.setBalance(result.getInt("BALANCE"));
            } else {
                throw new ProviderException("Provider with id " + id + " could not be find");
            }
            connection.commit();
            return provider;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new ProviderException(e.getMessage());
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
    public Provider getProvider(String provider_name) throws ProviderException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, provider_name);
            ResultSet result = statement.executeQuery();
            Provider provider = null;
            if (result.next()) {
                provider = new Provider();
                provider.setId_provider(result.getInt("ID_PROVIDER"));
                provider.setProvider_name(result.getString("PROVIDER_NAME"));
                provider.setStatus(result.getString("STATUS"));
                provider.setBalance(result.getInt("BALANCE"));
            } else {
                throw new ProviderException("Provider with name " + provider_name + " could not be find");
            }
            connection.commit();
            return provider;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new ProviderException(e.getMessage());
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
    public List<Provider> selectAllProvider() throws ProviderException {
        Statement statement = null;
        List<Provider> list = new ArrayList<Provider>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Provider provider = null;
            while (result.next()) {
                provider = new Provider();
                provider.setId_provider(result.getInt("ID_PROVIDER"));
                provider.setProvider_name(result.getString("PROVIDER_NAME"));
                provider.setStatus(result.getString("STATUS"));
                provider.setBalance(result.getInt("BALANCE"));
                list.add(provider);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            throw new ProviderException(e.getMessage());
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
