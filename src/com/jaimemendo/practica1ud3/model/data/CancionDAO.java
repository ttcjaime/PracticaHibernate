package com.jaimemendo.practica1ud3.model.data;

import com.jaimemendo.practica1ud3.model.entity.Artista;
import com.jaimemendo.practica1ud3.model.entity.Cancion;
import com.jaimemendo.practica1ud3.model.entity.Disco;
import com.jaimemendo.practica1ud3.model.repository.ICancionDAO;
import com.jaimemendo.practica1ud3.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CancionDAO implements ICancionDAO {
    @Override
    public Cancion add(Cancion cancion) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cancion);
            session.getTransaction().commit();
            return cancion;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Cancion cancion) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cancion);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Cancion cancion) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cancion);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Cancion> showAll() {
        Session session = null;
        List<Cancion> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Cancion ");
            list = (List<Cancion>) query.getResultList();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Cancion getOne(String name) {
        Session session = null;
        Cancion cancion = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cancion = session.createQuery(
                    "FROM Cancion c WHERE c.titulo = :titulo",
                    Cancion.class)
                    .setParameter("titulo", name)
                    .uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cancion;
    }

    @Override
    public Cancion getId(int idCancion) {
        Session session = null;
        Cancion cancion = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cancion = session.get(Cancion.class, idCancion);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cancion;
    }
}
