package com.nixsolution.ppp.jpa_hibernate.dao;

import com.nixsolution.ppp.jpa_hibernate.entity.Role;

public interface RoleDao extends Dao<Role> {

    Role findByName(String name);
}
