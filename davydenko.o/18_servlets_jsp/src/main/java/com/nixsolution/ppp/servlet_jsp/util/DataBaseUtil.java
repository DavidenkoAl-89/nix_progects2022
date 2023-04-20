package com.nixsolution.ppp.servlet_jsp.util;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

public class DataBaseUtil  {

    private static final Logger LOG = LogManager.getLogger(DataBaseUtil.class);
    ConnectionManager connectionManager;
    Connection connection;
    public DataBaseUtil(ConnectionManager connectionManager){
      this.connectionManager = connectionManager;
    }

    public void createTableRoles() throws SQLException {
        LOG.info("creating table {}", TABLE_ROLES);
        try (Connection connection = connectionManager.getDbConnection();
             PreparedStatement stmt = connection.prepareStatement(CREATE_TABLE_ROLES)) {
            stmt.execute();
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
            connection.rollback();
        }
        LOG.info("Table {} was created", TABLE_ROLES);
    }

    public void createTableUsers() throws SQLException {
        LOG.info("creating table {}", SqlCommand.TABLE_USERS);
        try (Connection connection = connectionManager.getDbConnection();
             PreparedStatement stmt = connection.prepareStatement(CREATE_TABLE_USERS)) {
            stmt.execute();
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
            connection.rollback();
        }
        LOG.info("Table {} was created", TABLE_USERS);
    }
}