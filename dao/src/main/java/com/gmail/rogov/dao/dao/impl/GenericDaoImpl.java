package com.gmail.rogov.dao.dao.impl;

import com.gmail.rogov.dao.dao.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.gmail.rogov.dao.dao.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

    private static final Logger logger = LogManager.getLogger(GenericDaoImpl.class);
    private Class<T> clazz;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(long id) {
        return getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    public void create(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
