package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Desenvolva um framework que converte objetos de qualquer classe para uma representação JSON
 * Cada atributo que fará parte do JSON deverá ter
 * um método GET com uma anotação especial
 * "@JSON".
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ClasseTeste teste = new ClasseTeste();
        teste.setNome("joao");
        teste.setIdade(19);
        teste.setEndereco("rua das couves");

        new Main().convert(teste);        
    }

    public <T> void convert(T object) throws IllegalAccessException, InvocationTargetException{
        Class<?> classe = object.getClass();

        StringBuilder json = new StringBuilder("{");

        Method[] metodos = classe.getMethods();

        for(Method m : metodos){
            Annotation[] anotacoesDoMetodo = m.getDeclaredAnnotations();

            /*for(Annotation a : anotacoesDoMetodo){
                System.out.println(a.toString());
            }*/

            if(Arrays.stream(anotacoesDoMetodo).anyMatch(a -> a.toString().endsWith("JSON()")) && m.getName().startsWith("get")){
                String nomePropriedade = m.getName().substring(3).toLowerCase();
                Object valorPropriedade = m.invoke(object);

                json.append("\"" + nomePropriedade + "\"");
                json.append(":");
                json.append("\"" + valorPropriedade + "\",");
            }

        }

        json.deleteCharAt(json.lastIndexOf(",")).append("}");

        System.out.println(json);
    }
}