package com.nixsolution.ppp.servlet_jsp.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static final Logger LOG = LogManager.getLogger(ConnectionManager.class);
    private static final BasicDataSource bds = new BasicDataSource();
    private final String resourcesPath;

    public ConnectionManager(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    private Properties loadProperties() {
        Properties property = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(resourcesPath);
            property.load(fis);
        } catch (IOException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
        }
        return property;
    }

    public BasicDataSource loadDatasource() {
        Properties property = loadProperties();
        bds.setDriverClassName(property.getProperty("db.drivers"));
        bds.setUrl(property.getProperty("db.url"));
        bds.setUsername(property.getProperty("db.username"));
        bds.setPassword(property.getProperty("db.password"));
        bds.setMaxTotal(10);
        bds.setDefaultAutoCommit(false);
        return bds;
    }

    public Connection getDbConnection() {
        try {
            return loadDatasource().getConnection();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR,e);
            throw new RuntimeException(e);
        }
    }
}