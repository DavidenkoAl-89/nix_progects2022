package com.nixsolution.ppp.jpa_hibernate.dao;

import com.nixsolution.ppp.jpa_hibernate.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Entity;

public class HibernateRoleDao extends AbstractDao<Role> implements RoleDao {
    public HibernateRoleDao() {
        super(Role.class, Role.class.getAnnotation(Entity.class).name());
    }

    @Override
    public Role findByName(String name) {
        try (Session session = factory.openSession()) {
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("name", name));
            return (Role) criteria.setMaxResults(1).uniqueResult();
        }
    }
}
