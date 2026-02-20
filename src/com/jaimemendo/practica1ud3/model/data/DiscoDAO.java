package com.jaimemendo.practica1ud3.model.data;

import com.jaimemendo.practica1ud3.model.entity.Disco;
import com.jaimemendo.practica1ud3.model.repository.IDiscoDAO;
import com.jaimemendo.practica1ud3.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DiscoDAO implements IDiscoDAO {
    @Override
    public Disco add(Disco disco) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(disco);
            session.getTransaction().commit();
            return disco;
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
    public boolean delete(Disco disco) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(disco);
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
    public boolean update(Disco disco) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(disco);
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
    public List<Disco> showAll() {
        Session session = null;
        List<Disco> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Disco ");
            list = (List<Disco>) query.getResultList();
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
    public Disco getOne(String nombre) {
        Session session = null;
        Disco disco = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            disco = session.createQuery(
                    "FROM Disco d WHERE d.nombre = :nombre",
                    Disco.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return disco;
    }

    @Override
    public Disco getId(int discoId) {
        Session session = null;
        Disco disco = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            disco = session.get(Disco.class, discoId);
            disco.getParticipaciones().size();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return disco;
    }
}
