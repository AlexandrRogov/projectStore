package com.gmail.rogov.dao.dao.util;

import com.gmail.rogov.dao.config.HibernateConfigurationManager;
import com.gmail.rogov.dao.dao.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;


import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> settings = new HashMap<>();
                settings.put(Environment.DRIVER, HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.DATABASE_DRIVER_NAME));
                settings.put(Environment.URL, HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.DATABASE_URL));
                settings.put(Environment.USER, HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.DATABASE_USERNAME));
                settings.put(Environment.PASS, HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.DATABASE_PWD));
                settings.put(Environment.HBM2DDL_AUTO, HibernateConfigurationManager.getInstance().getProperty(HibernateConfigurationManager.HBM2DDL_AUTO));
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, HibernateConfigurationManager.getInstance().getProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS));
                settings.put(Environment.SHOW_SQL,HibernateConfigurationManager.getInstance().getProperty(Environment.SHOW_SQL));
                settings.put(Environment.DIALECT,HibernateConfigurationManager.getInstance().getProperty(Environment.DIALECT));

                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();
                logger.info("Hibernate Registry builder created.");

                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(Role.class);
                sources.addAnnotatedClass(Audit.class);
                sources.addAnnotatedClass(Comment.class);
                sources.addAnnotatedClass(Item.class);
                sources.addAnnotatedClass(News.class);
                sources.addAnnotatedClass(Order.class);
                sources.addAnnotatedClass(Permission.class);
                sources.addAnnotatedClass(Profile.class);
                sources.addAnnotatedClass(User.class);
                sources.addAnnotatedClass(Discount.class);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
                logger.info("SessionFactory created.");
            } catch (Exception e) {
                logger.error("SessionFactory creation failed.");
                logger.error(e.getMessage(), e);
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}
