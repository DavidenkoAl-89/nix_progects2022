package com.nixsolution.ppp.servlet_jsp.dao;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;

import java.sql.Connection;
import java.util.List;

public abstract class GenericJdbcDao<E> implements Dao<E> {

    protected ConnectionManager connectionManager;

    public Connection getDbConnection() {
        return connectionManager.getDbConnection();
    }

    protected GenericJdbcDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public abstract void create(E entity);
    public abstract void update(E entity);
    public abstract void remove(E entity);
    public abstract List<E> findAll();
    public abstract E findById(Long id);
}