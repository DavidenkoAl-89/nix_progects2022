package com.nixsolution.ppp.sql_jdbs.dao;

import com.nixsolution.ppp.sql_jdbs.entiny.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User> {

    User findByLogin(String login) throws SQLException;

    User findByEmail(String email) throws SQLException;
}
