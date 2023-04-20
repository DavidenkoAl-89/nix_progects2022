package com.nixsolution.ppp.jpa_hibernate.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<E> {
    void create(E entity) throws SQLException;

    void update(E entity) throws SQLException;

    void remove(E entity) throws SQLException;

    List<E> findAll() throws SQLException;

    E findById(Long id) throws SQLException;
}
