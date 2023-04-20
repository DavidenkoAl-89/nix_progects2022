package com.nixsolution.ppp.sql_jdbs.service;

import com.nixsolution.ppp.sql_jdbs.dao.UserDao;
import com.nixsolution.ppp.sql_jdbs.entiny.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserDao {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void create(User user) throws SQLException {
        this.userDao.create(user);

    }

    @Override
    public void update(User user) throws SQLException {
        this.userDao.update(user);
    }

    @Override
    public void remove(User user) throws SQLException {
        this.userDao.remove(user);
    }

    @Override
    public List<User> findAll() throws SQLException {
        return this.userDao.findAll();
    }

    @Override
    public User findById(Long id) throws SQLException {
        return this.userDao.findById(id);
    }

    @Override
    public User findByLogin(String login) throws SQLException {
        return this.userDao.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        return this.userDao.findByEmail(email);
    }
}
