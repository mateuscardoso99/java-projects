package com.example;

import java.io.Serializable;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

public class DAOGenerico<T> implements DAOGenericoInterface<T> {
    private Class<T> classe;
    private SessionFactory sessionFactory;
    private DataSource dataSource;

    public DAOGenerico(Class<T> t) {
        classe = t;
    }

    @Override
    public T getById(Serializable id) {
        return sessionFactory.getCurrentSession().get(classe, id);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void remove(T t) {
        sessionFactory.getCurrentSession().remove(t);
    }

    @Override
    public void create(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
