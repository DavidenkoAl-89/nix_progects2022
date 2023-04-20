package com.nixsolution.ppp.sql_jdbs.service;

import com.nixsolution.ppp.sql_jdbs.dao.RoleDao;
import com.nixsolution.ppp.sql_jdbs.entiny.Role;

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
    public List<Role> findAll() throws SQLException {
        return this.roleDao.findAll();
    }

    @Override
    public Role findById(Long id) throws SQLException {
        return this.roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return this.roleDao.findByName(name);
    }
}
