package com.nixsolution.ppp.jpa_hibernate.dao;


import com.nixsolution.ppp.jpa_hibernate.entity.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HibernateRoleDaoTest {

    private HibernateRoleDao hibernateRoleDao = new HibernateRoleDao();

    @BeforeAll


    @Test
    public void createRole() throws SQLException {
        Role role = new Role(1L,"Admin");
        hibernateRoleDao.create(role);
        Assertions.asser(role.getRoleId().isGreaterThan(0);
    }

}
