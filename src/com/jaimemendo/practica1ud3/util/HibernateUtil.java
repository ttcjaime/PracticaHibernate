package com.jaimemendo.practica1ud3.util;

import com.jaimemendo.practica1ud3.model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {}
    private static StandardServiceRegistry registry;

    public static void connect() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            return; // ya conectado
        }

        Configuration config = new Configuration().configure("hibernate.cfg.xml");

        config.addAnnotatedClass(Artista.class);
        config.addAnnotatedClass(Disco.class);
        config.addAnnotatedClass(Cancion.class);
        config.addAnnotatedClass(Discografica.class);
        config.addAnnotatedClass(Participacion.class);

        registry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();

        sessionFactory = config.buildSessionFactory(registry);

        System.out.println("hibernate CONNECTED");
    }

    //Obtener SessionFactory SOLO si está conectado
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
//            throw new IllegalStateException("Hibernate is NOT connected.");
        }
        return sessionFactory;
    }

    public static void disconnect() {

        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }

        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        sessionFactory = null;
        registry = null;

        System.out.println("Hibernate DISCONNECTED");
    }

    public static boolean isConnected() {
        return sessionFactory != null && !sessionFactory.isClosed();
    }

    public static void shutdown() {
        if (sessionFactory != null){
            sessionFactory.close();
        }

    }
}
