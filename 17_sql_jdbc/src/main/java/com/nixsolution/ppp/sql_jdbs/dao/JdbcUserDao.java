package com.nixsolution.ppp.sql_jdbs.dao;

import com.nixsolution.ppp.sql_jdbs.connection.ConnectionManager;
import com.nixsolution.ppp.sql_jdbs.entiny.Role;
import com.nixsolution.ppp.sql_jdbs.entiny.User;
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
import java.util.Objects;

import static com.nixsolution.ppp.sql_jdbs.util.SqlCommand.*;

public class JdbcUserDao extends GenericJdbcDao<User> implements UserDao {
    private static final Logger LOG = LogManager.getLogger(JdbcUserDao.class);
    Connection connection = null;

    public JdbcUserDao(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    public void create(User user) {
        LOG.info("Adding user");
        if (user == null) {
            LOG.throwing(Level.ERROR, new RuntimeException("user is null"));
        }
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_USERS)) {
            ps.setString(1, Objects.requireNonNull(user).getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setDate(6, user.getBirthday());
            ps.setLong(7, user.getRole().getRoleId());
            ps.executeUpdate();
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
        LOG.info("Add user: " + user);
    }

    @Override
    public void update(User user) {
        LOG.info("Start updating user");
        if (user == null) {
            LOG.throwing(Level.ERROR, new RuntimeException("user is null"));
        }
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_USER)) {
            ps.setString(1, Objects.requireNonNull(user).getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setDate(6, user.getBirthday());
            ps.setLong(7, user.getRole().getRoleId());
            ps.setLong(8, user.getId());
            ps.executeUpdate();
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
        LOG.info("Updated user: " + user);
    }

    @Override
    public void remove(User user) {
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_USER)) {
            ps.setLong(1, user.getId());
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
        LOG.info("User deleted: " + user);
    }

    @Override
    public List<User> findAll() {
        LOG.info("Find all users");
        List<User> usersList = new ArrayList<>();
        try (Connection connection = getDbConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(FIND_ALL_USERS);
            while (res.next()) {
                Role role = new Role();
                User user = new User();
                user.setId(res.getLong("id"));
                user.setFirstName(res.getString("firstName"));
                user.setLastName(res.getString("lastName"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setLogin(res.getString("login"));
                user.setBirthday(res.getDate("birthday"));
                role.setName(res.getString("name"));
                role.setRoleId(res.getLong("id"));
                user.setRole(role);
                usersList.add(user);
                connection.commit();
            }
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOG.catching(Level.ERROR, ex);
                LOG.throwing(new RuntimeException(ex));
            }
        }
        LOG.info("All users: " + usersList);
        return usersList;
    }

    @Override
    public User findByLogin(String login) throws SQLException {
        LOG.info("Find user by login");
        if (login == null || login.isBlank() || login.isEmpty()) {
            LOG.catching(Level.ERROR, new RuntimeException("login is null or empty"));
        }
        User user = new User();
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_LOGIN)) {
            ps.setString(1, login);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Role role = new Role();
                user.setId(res.getLong("id"));
                user.setFirstName(res.getString("firstName"));
                user.setLastName(res.getString("lastName"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setLogin(res.getString("login"));
                user.setBirthday(res.getDate("birthday"));
                role.setName(res.getString("name"));
                role.setRoleId(res.getLong("roleId"));
                user.setRole(role);
                connection.commit();
            }
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            connection.rollback();
            LOG.throwing(new RuntimeException(e));
        }
        LOG.info("Find user by login: " + user);
        return user;
    }


    @Override
    public User findByEmail(String email) throws SQLException {
        LOG.info("Find user by email");
        User user = new User();
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            ps.setString(1, email);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Role role = new Role();
                user.setId(res.getLong("id"));
                user.setFirstName(res.getString("firstName"));
                user.setLastName(res.getString("lastName"));
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("password"));
                user.setLogin(res.getString("login"));
                user.setBirthday(res.getDate("birthday"));
                role.setName(res.getString("name"));
                role.setRoleId(res.getLong("roleId"));
                user.setRole(role);
            }
            connection.commit();
        } catch (SQLException e) {
            LOG.catching(Level.ERROR, e);
            connection.rollback();
        }
        LOG.info("Find user by email: " + user);
        return user;
    }

    @Override
    public User findById(Long id) {
        LOG.info("Find user by id");
        User user = new User();
        try (Connection connection = getDbConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setLogin(rs.getString("login"));
                user.setBirthday(rs.getDate("birthday"));
                role.setName(rs.getString("name"));
                role.setRoleId(rs.getLong("roleId"));
                user.setRole(role);
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
        LOG.info("Find user by id: " + user);
        return user;
    }
}
