package com.nixsolution.ppp.servlet_jsp.dao;

import com.nixsolution.ppp.servlet_jsp.entity.Role;

public interface RoleDao extends Dao<Role> {

    Role findByName(String name);
}
