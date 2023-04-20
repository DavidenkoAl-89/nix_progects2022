package com.nixsolution.ppp.servlet_jsp.dao;

import com.nixsolution.ppp.servlet_jsp.connection.ConnectionManager;
import com.nixsolution.ppp.servlet_jsp.entity.Role;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.nixsolution.ppp.servlet_jsp.util.SqlCommand.*;

public class JdbcRoleDao extends GenericJdbcDao<Role> implements RoleDao {
    private static final Logger LOG = LogManager.getLogger(JdbcRoleDao.class);
    Role role = new Role();
    Connection connection = null;

    public JdbcRoleDao(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    public void create(Role role) {
        LOG.info("Add role");
        if (role == null) {
            LOG.throwing(new RuntimeException("role is null"));
        }
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_ROLES)) {
            ps.setString(1, role.getName());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOG.catching(Level.ERROR,ex);
            }
        }
        LOG.info("Role created: " + role);
    }

    @Override
    public void update(Role role) {
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_ROLES)) {
            ps.setString(1, role.getName());
            ps.setLong(2, role.getRoleId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOG.catching(Level.ERROR, ex);
                LOG.throwing(new RuntimeException(ex));
            }
        }
        LOG.info(role + " was updated");
    }

    @Override
    public void remove(Role role) {
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_FROM_ROLES)) {
            ps.setLong(1, role.getRoleId());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
            try {
                connection.rollback();
            } catch (SQLException ex) {
               LOG.catching(Level.ERROR,ex);
            }
        }
        LOG.info(role + " was deleted");
    }

    @Override
    public Role findByName(String name) {
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_BY_NAME_IN_ROLES)) {
            ps.setString(1, name);
            try (ResultSet res = ps.executeQuery()) {
                if (res.next()) {
                    role.setRoleId(res.getLong(1));
                    role.setName(res.getString(2));
                }
            }
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
        }
        LOG.info(role + " was find");
        return role;
    }

    @Override
    public List<Role> findAll() {
        LOG.info("Find all roles");
        List<Role> rolesList = new ArrayList<>();
        try (Connection connection = getDbConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(FIND_ALL_ROLES);
            while (resultSet.next()) {
                Role role = new Role();
                role.setRoleId(resultSet.getLong("Id"));
                role.setName(resultSet.getString("name"));
                rolesList.add(role);
            }
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        LOG.info("All roles: " + rolesList);
        return rolesList;
    }

    @Override
    public Role findById(java.lang.Long id) {
        try (Connection connection = getDbConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ROLE_BY_ID)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                java.lang.Long id1 = rs.getLong(1);
                String name = rs.getString(2);
                role.setRoleId(id1);
                role.setName(name);
            }
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOG.catching(Level.ERROR, ex);
                LOG.throwing(new RuntimeException(ex));
            }
        }
        return role;
    }
}


