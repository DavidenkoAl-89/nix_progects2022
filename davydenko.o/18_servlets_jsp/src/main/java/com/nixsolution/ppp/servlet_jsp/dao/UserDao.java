package com.nixsolution.ppp.servlet_jsp.dao;

import com.nixsolution.ppp.servlet_jsp.entity.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User> {

    User findByLogin(String login) throws SQLException;

    User findByEmail(String email) throws SQLException;
}
