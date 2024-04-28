/**
 * O padrão de pool de objetos é um padrão de design de criação de software usado em situações em que o custo de inicialização de uma instância de classe é muito alto. 
 * Basicamente, um pool de objetos é um contêiner que contém uma certa quantidade de objetos. Portanto, quando um objeto é retirado do pool, ele não fica disponível no pool até que seja colocado de volta. 
 * Os objetos no pool têm um ciclo de vida: 
 * Criação
 * Validação
 * Destruir.
 */


/*
 * Vejamos o exemplo das conexões de banco de dados. Obviamente, abrir muitas conexões pode afetar o desempenho por vários motivos: 
 * Criar uma conexão é uma operação cara.
 * Quando há muitas conexões abertas, leva mais tempo para criar uma nova e o servidor de banco de dados ficará sobrecarregado.
 * Aqui, o pool de objetos gerencia as conexões e fornece uma maneira de reutilizá-las e compartilhá-las. Também pode limitar o número máximo de objetos que podem ser criados. 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

//A classe Pool é a classe mais importante no padrão de design do pool de objetos. ObjectPool mantém uma lista de objetos disponíveis e uma coleção de objetos que já foram solicitados do pool.
abstract class ObjectPool<T> { 
    long deadTime; 
 
    Hashtable<T, Long> lock, unlock; 
 
    ObjectPool() { 
        deadTime = 50000; // 50 seconds 
        lock = new Hashtable<T, Long>(); 
        unlock = new Hashtable<T, Long>(); 
    } 
 
    abstract T create(); 
 
    abstract boolean validate(T o); 
 
    abstract void dead(T o); 
 
    //pega um objeto do pool 
    synchronized T takeOut() { 
        long now = System.currentTimeMillis(); 
        T t; 

        //percorre os objetos livres pra achar algum que esteja disponível e válido
        if (unlock.size() > 0) { 
            Enumeration<T> e = unlock.keys(); 
            while (e.hasMoreElements()) { 
                t = e.nextElement(); 
                if ((now - unlock.get(t)) > deadTime) { 
                    // object has dead
                    unlock.remove(t); 
                    dead(t); 
                    t = null; 
                } 
                else { 
                    if (validate(t)) { 
                        unlock.remove(t); 
                        lock.put(t, now); 
                        return (t); 
                    } 
                    else { 
                        // object failed validation 
                        unlock.remove(t); 
                        dead(t); 
                        t = null; 
                    } 
                } 
            } 
        } 
        // nenhum objeto disponível no pool, então cria um novo
        t = create(); 
        lock.put(t, now); 
        return (t); 
    } 

    //devolve um objeto para o pool
    synchronized void takeIn(T t) { 
        lock.remove(t); 
        unlock.put(t, System.currentTimeMillis()); 
    } 
} 



class JDBCConnectionPool extends ObjectPool<Connection> { 
    String dsn, usr, pwd; 
 
    JDBCConnectionPool(String driver, String dsn, String usr, String pwd) 
    { 
        super(); 
        try { 
            Class.forName(driver).newInstance(); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        this.dsn = dsn; 
        this.usr = usr; 
        this.pwd = pwd; 
    } 
 
    Connection create() 
    { 
        try { 
            return (DriverManager.getConnection(dsn, usr, pwd)); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
            return (null); 
        } 
    } 
 
    void dead(Connection o) 
    { 
        try { 
            ((Connection)o).close(); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    boolean validate(Connection o) 
    { 
        try { 
            return (!((Connection)o).isClosed()); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
            return (false); 
        } 
    } 
} 
 
class Main { 
    public static void main(String args[]) 
    { 
        // Create the ConnectionPool: 
        JDBCConnectionPool pool = new JDBCConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb: //localhost/mydb", "sa", "password"); 
 
        // pega uma conexão do pool 
        Connection con = pool.takeOut(); 

        //devolve pro pool
        pool.takeIn(con); 
    } 
} 