package com.nixsolution.ppp.sql_jdbs;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.core.api.dataset.SeedStrategy;
import com.nixsolution.ppp.sql_jdbs.connection.ConnectionManager;
import com.nixsolution.ppp.sql_jdbs.dao.JdbcUserDao;
import com.nixsolution.ppp.sql_jdbs.entiny.Role;
import com.nixsolution.ppp.sql_jdbs.entiny.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Date;


@DataSet(strategy = SeedStrategy.INSERT, cleanBefore = true, cleanAfter = true, executeScriptsBefore = {
        "userTable.sql"}
)
public class JdbcUserDaoTest {
    String dbName = "src/test/resources/testDatabase.properties";
    ConnectionManager connectionManager = new ConnectionManager(dbName);

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(connectionManager.getDbConnection());
    private Role role;
    private User user;
    JdbcUserDao jdbcUserDao = new JdbcUserDao(connectionManager);


    @Before
    public void setUp() {
        role = new Role(44L);
        user = new User(41L, "cccc", "3333", "com@gmail", "nik3", "lastN3", Date.valueOf("2020-11-10"), role);
    }


    @Test
    @ExpectedDataSet(value = "user/updatedUser.xml")
    public void shouldUpdateUser() throws SQLException {
        user.setId(11L);
        jdbcUserDao.update(user);
    }

    @Test
    @ExpectedDataSet("user/user.xml")
    public void shouldSelectAllUsers() throws SQLException {
        jdbcUserDao.findAll();
    }

    @Test
    @ExpectedDataSet(value = "user/user.xml")
    public void shouldFindUserByLogin() throws SQLException {
        jdbcUserDao.findByLogin("aaaa");
    }

    @Test
    @ExpectedDataSet(value = "user/user.xml")
    public void shouldFindUserByEmail() throws SQLException {
        jdbcUserDao.findByEmail("com@");

    }

    @Test
    @ExpectedDataSet(value = "user/user.xml")
    public void shouldFindUserById() throws SQLException {
        jdbcUserDao.findById(1L);
    }
}