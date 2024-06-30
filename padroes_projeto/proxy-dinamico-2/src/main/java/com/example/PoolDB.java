package com.example;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

public class PoolDB implements Pool{
    private List<Connection> conexoesLivres = new LinkedList<>();
    private List<Connection> conexoesUsadas = new LinkedList<>();

    public PoolDB(DataSource dataSource){
        for(int i=0; i<20; i++){
            try {
                Connection conn = (Connection) Proxy.newProxyInstance(
                                    Connection.class.getClassLoader(),
                                    new Class[] { Connection.class },
                                    new ProxyDinamico(this, dataSource.getConnection())
                                );
                conexoesLivres.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
    }

    public List<Connection> getConexoesLivres() {
        return conexoesLivres;
    }

    public List<Connection> getConexoesUsadas() {
        return conexoesUsadas;
    }

    @Override
    public Connection acquire() {
        synchronized(this){
            try{
                if(conexoesLivres.isEmpty()) this.wait();
    
                Connection conn = conexoesLivres.remove(0);
                conexoesUsadas.add(conn);
                return conn;
    
            }catch(Exception e){
                return null;
            }
        }
    }
    
}
