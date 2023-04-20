package com.nixsolution.ppp.jpa_hibernate.dao;

import com.nixsolution.ppp.jpa_hibernate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Entity;
import java.sql.SQLException;

public class HibernateUserDao extends AbstractDao<User> implements UserDao {

    public HibernateUserDao() {
        super(User.class, User.class.getAnnotation(Entity.class).name());
    }

    @Override
    public User findByLogin(String login) throws SQLException {
        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            return (User) criteria.setMaxResults(1).uniqueResult();
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
            return (User) criteria.uniqueResult();
        }
    }
}
