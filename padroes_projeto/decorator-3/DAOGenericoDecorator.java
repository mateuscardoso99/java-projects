package com.example;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

public class DAOGenericoDecorator<T> implements DAOGenericoInterface<T>{
    private SessionFactory sessionFactory;
    private DAOGenericoInterface<T> daoDecorado;

    public DAOGenericoDecorator(DAOGenericoInterface<T> daoDecorado) {
        this.daoDecorado = daoDecorado;
    }

    @Override
    public T getById(Serializable id) throws InvocationTargetException, IllegalAccessException {
        T t = daoDecorado.getById(id);
        Log log = new Log();
        log.setTipoEntrada(Log.TipoEntrada.ATUALIZAÇÃO);
        saveLog(t,log);
        return t;
    }

    @Override
    public void update(T o) throws InvocationTargetException, IllegalAccessException {
        Log log = new Log();
        log.setTipoEntrada(Log.TipoEntrada.ATUALIZAÇÃO);
        saveLog(o,log);
        daoDecorado.update(o);
    }

    @Override
    public void remove(T o) throws InvocationTargetException, IllegalAccessException {
        Log log = new Log();
        log.setTipoEntrada(Log.TipoEntrada.REMOÇÃO);
        saveLog(o,log);
        daoDecorado.remove(o);
    }

    @Override
    public void create(T o) throws InvocationTargetException, IllegalAccessException {
        Log log = new Log();
        log.setTipoEntrada(Log.TipoEntrada.CRIAÇÃO);
        saveLog(o,log);
        daoDecorado.create(o);
    }

    private void saveLog(T o, Log log) throws IllegalAccessException, InvocationTargetException {

        Class classe =  o.getClass();
        log.setClasseObjetoAlterado(classe.getName());
        for( Method method: classe.getMethods()){
            if(method.getName().equals("getId")){
                log.setId((Long) method.invoke(o));
            }
        }
        sessionFactory.getCurrentSession().save(log);
    }

    @Override
    public DataSource getDataSource() {
        return daoDecorado.getDataSource();
    }
}
