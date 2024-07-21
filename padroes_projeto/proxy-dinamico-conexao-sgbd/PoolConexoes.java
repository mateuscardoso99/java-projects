package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PoolConexoes {
    private DataSource dataSource;
    private List<Connection> instanciasCriadas = new ArrayList<>(20);
    private List<Connection> instanciasDisponiveis = new ArrayList<>(20);

    public PoolConexoes(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        for (int i = 0; i < 3; i++) {
            Connection connection = instanciaConnection();
            instanciasCriadas.add(connection);
            instanciasDisponiveis.add(connection);
        }
    }

    private Connection instanciaConnection() throws SQLException{
        Connection connection = this.dataSource.getConnection();
        return (Connection) Proxy.newProxyInstance(
                this.getClass().getClassLoader(), 
                new Class[]{Connection.class},
                new ConnectionProxyInvocationHandler(connection)
        );//dessa forma toda as chamadas a métodos da interface Connection serão passadas para a classe ConnectionProxyInvocationHandler que invocará o método invoke()
    }

    public Connection acquire() throws InterruptedException, SQLException {
        synchronized (instanciasDisponiveis) {
            if (!instanciasDisponiveis.isEmpty()) {//se instanciasDisponiveis não estiver vazia, retorna a primeira da lista pro cara
                return instanciasDisponiveis.remove(0);
            } else {
                if (instanciasCriadas.size() < 20) { //se instanciasCriadas não chegou ao limite de 20, cria uma nova e retorna ela pro cara que pediu
                    Connection con = instanciaConnection();
                    instanciasCriadas.add(con);
                    return con;
                } else { // se não tiver instanciasDisponiveis e instanciasCriadas já chegou no limite, então o cara vai ter que esperar alguém devolver uma conexão
                    instanciasDisponiveis.wait();
                    return instanciasDisponiveis.remove(0);
                }
            }
        }
    }

    private void release(Connection conn) {
        synchronized (instanciasDisponiveis) {
            if (!instanciasCriadas.contains(conn)) {
                return;
            }
            instanciasDisponiveis.add(conn);
            if(instanciasDisponiveis.size() == 1){
                instanciasDisponiveis.notify();
            }
        }
    }

    private class ConnectionProxyInvocationHandler implements InvocationHandler{
        private Connection connection;

        private ConnectionProxyInvocationHandler(Connection connection){
            this.connection = connection;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("close")){//se o método chamado for close(), não invoca o método close() pois a conexão seria fechada. apenas devolve pro pool, dessa forma a conexão nunca será fechada ao invés disso volta pro pool
                PoolConexoes.this.release((Connection) proxy);
                return null;
            }
            else{//se não tiver chamando o método close() de connection, invoca o método (que pode ser qualquer método da interface Connection (createStatement(), executeQuery() etc...) ) normalmente e retorna o retorno
                Object retorno = method.invoke(connection, args);
                return retorno;
            }
        }

    }
}
