package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ProxyDinamico implements InvocationHandler{
    private PoolDB pool;
    private Connection c;

    public ProxyDinamico(PoolDB p, Connection c){
        this.pool = p;
        this.c = c;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(c, args);
        if(method.getName().equals("close")){
            synchronized(this){
                this.pool.getConexoesUsadas().remove(c);
                this.pool.getConexoesLivres().add(c);
                this.pool.notify();
            }
        }
        return ret;
    }

    
}