package com.nixsolution.ppp.jpa_hibernate.service;

import com.nixsolution.ppp.jpa_hibernate.dao.HibernateRoleDao;
import com.nixsolution.ppp.jpa_hibernate.dao.RoleDao;
import com.nixsolution.ppp.jpa_hibernate.entity.Role;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements RoleDao {
    private static final Logger LOG =  LogManager.getLogger(RoleService.class);

    private final HibernateRoleDao roleDao;

    public RoleService(HibernateRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void create(Role role) {
        try {
            this.roleDao.create(role);
            LOG.info("Role created");
        } catch (SQLException e) {
           LOG.catching(Level.ERROR,e);
           LOG.throwing(new RuntimeException(e));
        }
    }

    @Override
    public void update(Role role) throws SQLException {
        this.roleDao.update(role);
    }

    @Override
    public void remove(Role role) throws SQLException {
        this.roleDao.remove(role);
    }

    @Override
    public List<Role> findAll() {
        try {
            return this.roleDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Role findById(java.lang.Long id) {
        try {
            return this.roleDao.findById(id);
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
    }

    @Override
    public Role findByName(String name) {
        return this.roleDao.findByName(name);
    }
}
