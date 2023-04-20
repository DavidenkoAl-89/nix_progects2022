package com.nixsolution.ppp.jpa_hibernate.service;

import com.nixsolution.ppp.jpa_hibernate.dao.HibernateUserDao;
import com.nixsolution.ppp.jpa_hibernate.dao.UserDao;
import com.nixsolution.ppp.jpa_hibernate.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserDao {

    private final HibernateUserDao userDao;

    public UserService(HibernateUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user)  {
        try {
            this.userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user)  {
        try {
            this.userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) throws SQLException {
        this.userDao.remove(user);
    }

    @Override
    public List<User> findAll()  {
        try {
            return this.userDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id)  {
        try {
            return this.userDao.findById(id);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public User findByLogin(String login)  {
        try {
            return this.userDao.findByLogin(login);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        return this.userDao.findByEmail(email);
    }
}
