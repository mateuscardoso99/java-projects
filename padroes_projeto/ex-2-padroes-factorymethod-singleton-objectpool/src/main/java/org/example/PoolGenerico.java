package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/*
https://java-design-patterns.com/patterns/object-pool/#explanation

 * Implemente um Pool Genérico (classe concreta) de objetos a partir da interface:
    public interface Pool<T> {
        T acquire();
        void release(T t);
    }
    O pool deverá manter no mínimo 3 instâncias criadas e deverá
    instanciar no máximo 20. Caso algum cliente tente fazer acquire e o
    máximo já tenha sido atingido, deverá esperar até que algum outro
    cliente devolva outro objeto (problema dos produtores vs. Consumidores).
 */
public class PoolGenerico<T> implements Pool<T>{
    private Class<?> classe;
    private List<T> livres = new LinkedList<>();
    private List<T> usados = new LinkedList<>();

    public PoolGenerico(Class<?> obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        this.classe = obj;

        for(int i=0; i<3; i++){
            T novaInstancia = (T) obj.getDeclaredConstructor().newInstance();
            livres.add(novaInstancia);
        }
    }

    @Override
    public T acquire() {
        synchronized(usados){
            if(usados.size() == 20){
                try {
                    System.out.println("LIMITE DO POOL ATINGIDO, DORMINDO...");
                    usados.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            T novaInstancia;

            try {
                if(livres.isEmpty()){
                    novaInstancia = (T) classe.getDeclaredConstructor().newInstance();
                }
                else{
                    novaInstancia = livres.remove(0);
                }

                usados.add(novaInstancia);

                System.out.println("OBJETO DO POOL FOI PEGO");
                System.out.println("QTD LIVRES NO POOL: " + livres.size());
                System.out.println("QTD USADOS NO POOL: " + usados.size());

                return novaInstancia;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public void release(T t) {
        synchronized(usados){
            usados.remove(t);
            livres.add(t);

            System.out.println("OBJETO FOI DEVOLVIDO AO POOL");
            System.out.println("QTD LIVRES: " + livres.size());
            System.out.println("QTD USADOS: " + usados.size());

            usados.notify();
        }
    }
    
}
