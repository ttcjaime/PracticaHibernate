package com.jaimemendo.practica1ud3.util;

import com.jaimemendo.practica1ud3.model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Artista.class);
            config.addAnnotatedClass(Cancion.class);
            config.addAnnotatedClass(Disco.class);
            config.addAnnotatedClass(Discografica.class);
            config.addAnnotatedClass(Participacion.class);

            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties())
                            .build();

            sessionFactory = config.buildSessionFactory(registry);
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null){
            sessionFactory.close();
        }

    }
}
