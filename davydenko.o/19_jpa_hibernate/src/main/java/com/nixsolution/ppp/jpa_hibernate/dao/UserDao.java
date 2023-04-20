package com.nixsolution.ppp.jpa_hibernate.dao;

import com.nixsolution.ppp.jpa_hibernate.entity.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User> {

    User findByLogin(String login) throws SQLException;

    User findByEmail(String email) throws SQLException;
}
