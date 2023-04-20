package com.nixsolution.ppp.jpa_hibernate.dao;

import com.nixsolution.ppp.jpa_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AbstractDao<E> implements Dao<E> {
    protected SessionFactory factory = HibernateUtil.getSessionFactory();
    protected  Class aClass;
    protected  String tableName;

    protected AbstractDao(Class aClass, String tableName) {
        this.aClass = aClass;
        this.tableName = tableName;
    }

    @Override
    public void create(E entity) throws SQLException {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(E entity) throws SQLException {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void remove(E entity) throws SQLException {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
    }

    @Override
    public List<E> findAll() throws SQLException {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from User");
            return query.list();
        }
    }

    @Override
    public E findById(Long id) throws SQLException {
        try (Session session = factory.openSession()) {
            return (E) session.get(aClass, id);
        }
    }
}
