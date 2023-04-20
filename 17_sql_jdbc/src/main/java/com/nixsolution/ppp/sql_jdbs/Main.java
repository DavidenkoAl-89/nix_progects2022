package com.nixsolution.ppp.sql_jdbs;

import com.nixsolution.ppp.sql_jdbs.connection.ConnectionManager;
import com.nixsolution.ppp.sql_jdbs.dao.JdbcRoleDao;
import com.nixsolution.ppp.sql_jdbs.dao.JdbcUserDao;
import com.nixsolution.ppp.sql_jdbs.entiny.Role;
import com.nixsolution.ppp.sql_jdbs.entiny.User;
import com.nixsolution.ppp.sql_jdbs.util.DataBaseUtil;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String testDb = "src/test/resources/testDatabase.properties";
        String db = "src/main/resources/database.properties";
        ConnectionManager connectionManager = new ConnectionManager(db);
        DataBaseUtil dataBaseUtil = new DataBaseUtil(connectionManager);
        JdbcUserDao jdbcUserDao = new JdbcUserDao(connectionManager);
        JdbcRoleDao jdbcRoleDao = new JdbcRoleDao(connectionManager);
        Role role = new Role(1L, "Admin");
        Role role1 = new Role(2L, "Client");
        User user = new User(1L, "Alex", "0000", "Alex@gmail", "Alexandr", "AlexLastName", new Date(2000, 10, 10), role);
        User user1 = new User("Vasia", "1111", "Vasia@gmail", "Vasiliy", "VasLastName", new Date(1999, 11, 11), role1);

        dataBaseUtil.createTableRoles();
        dataBaseUtil.createTableUsers();
        jdbcRoleDao.create(role);
        jdbcRoleDao.create(role1);
        jdbcUserDao.create(user);
        jdbcUserDao.create(user1);
        jdbcUserDao.findAll();

    }
}