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
    private Class<T> classe;
    private List<T> criados = new LinkedList<>();
    private List<T> livres = new LinkedList<>();

    public PoolGenerico(Class<T> obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        this.classe = obj;

        for(int i=0; i<3; i++){
            T novaInstancia = this.classe.newInstance();
            livres.add(novaInstancia);
            criados.add(novaInstancia);
        }
    }

    @Override
    public T acquire() {
        synchronized(this){
            try {
                if (!livres.isEmpty()) {//se tem livres retorna um deles
                    return livres.removeFirst();
                } else {
                    if (criados.size() < 20) {
                        T novaInstancia = this.classe.newInstance();
                        criados.add(novaInstancia);
                        return novaInstancia;
                    } else {//se já está lotado dorme
                        this.wait();

                        //depois de acordar retorna um dos livres
                        return livres.removeFirst();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public void release(T t) {
        synchronized(this){
            if(criados.contains(t)) {
                livres.add(t);
                //quando um objeto é devolvido notifica a thread que está esperando na linha 47
                this.notify();
            }
            else{
                throw new IllegalArgumentException("objeto não criado por este pool");
            }
        }
    }

}
