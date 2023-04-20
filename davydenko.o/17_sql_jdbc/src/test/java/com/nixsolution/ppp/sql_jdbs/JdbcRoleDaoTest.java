package com.nixsolution.ppp.sql_jdbs;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.core.api.dataset.SeedStrategy;
import com.nixsolution.ppp.sql_jdbs.connection.ConnectionManager;
import com.nixsolution.ppp.sql_jdbs.dao.JdbcRoleDao;
import com.nixsolution.ppp.sql_jdbs.entiny.Role;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.sql.SQLException;

@DataSet(strategy = SeedStrategy.INSERT, cleanBefore = true, cleanAfter = true, executeScriptsBefore = {
        "roleTable.sql"}
)
public class JdbcRoleDaoTest {
    private static final String testDb = "src/test/resources/testDatabase.properties";
    ConnectionManager connectionManager = new ConnectionManager(testDb);

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(connectionManager.getDbConnection());

    private Role role;

    private JdbcRoleDao roleDao = new JdbcRoleDao(connectionManager);

    @Before
    public void setUp() {
        role = new Role(4L, "TEST");
    }

    @Test
    @ExpectedDataSet(value = "role/role.xml")
    public void shouldSelectAllRoles() {
        roleDao.findAll();
    }

    @Test
    @ExpectedDataSet(value = "role/createdRole.xml")
    public void shouldCreateRole() {
        roleDao.create(role);
    }

    @Test
    @ExpectedDataSet(value = "role/updateRoles.xml")
    public void shouldUpdateRole() throws SQLException {
        role.setName("TEST");
        roleDao.update(role);
    }

    @Test
    @ExpectedDataSet(value = "role/removeRole.xml")
    public void shouldRemoveRole() throws SQLException {
        roleDao.remove(role);
    }

    @Test
    @ExpectedDataSet(value = "role/role.xml")
    public void shouldFindRoleByName() throws SQLException {
        roleDao.findByName("Admin");
    }

    @Test
    @ExpectedDataSet(value = "role/role.xml")
    public void shouldFindRoleById() throws SQLException {
        roleDao.findById(1L);
    }
}