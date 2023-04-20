package com.nixsolution.ppp.servlet_jsp.service;

import com.nixsolution.ppp.servlet_jsp.dao.RoleDao;
import com.nixsolution.ppp.servlet_jsp.entity.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements RoleDao {

    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public void create(Role role) throws SQLException {
        this.roleDao.create(role);
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
