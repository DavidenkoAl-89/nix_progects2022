package com.nixsolution.ppp.jpa_hibernate.util;

import com.nixsolution.ppp.jpa_hibernate.entity.Role;
import com.nixsolution.ppp.jpa_hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(User.class);

            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable e) {
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
