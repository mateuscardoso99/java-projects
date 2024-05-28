package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fabrica {
    public static Fabrica fabrica = null;
    public static Map<String, Servico> instanciasCriadas = new HashMap<>();
    private Fabrica(){}

    public static synchronized Fabrica getInstance(){
        if(fabrica == null)
            fabrica = new Fabrica();
        return fabrica;
    }

    public Servico criarInstancia(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //instanciasCriadas.keySet().stream().forEach(System.out::println);
        synchronized (this) {
            if (instanciasCriadas.containsKey(className)) {
                System.out.println(className + " encontrada no cache, retornando do cache");
                return instanciasCriadas.get(className);
            } else {
                System.out.println(className + " NÃO encontrada no cache, criando nova instancia");
                Class<?> c = Class.forName(className);
                Boolean implementaServico = Arrays.stream(c.getInterfaces()).anyMatch(g -> g.getName().endsWith("Servico"));
                System.out.println("implementaServico" + " = " + implementaServico);
                if (implementaServico) {
                    Servico novaInstancia = (Servico) c.getDeclaredConstructor().newInstance();
                    instanciasCriadas.put(className, novaInstancia);
                    return novaInstancia;
                }
                return null;
            }
        }
    }
}
