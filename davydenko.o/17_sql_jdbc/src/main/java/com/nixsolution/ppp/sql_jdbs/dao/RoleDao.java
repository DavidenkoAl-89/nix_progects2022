package com.nixsolution.ppp.sql_jdbs.dao;

import com.nixsolution.ppp.sql_jdbs.entiny.Role;

public interface RoleDao extends Dao<Role> {

    Role findByName(String name);
}
