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
        teste.setIdColuna(Double.valueOf(234));
        teste.setNumeros(new Integer[]{1,2,5,9,6});
        teste.setNumeros2(List.of(57,23,656,32));

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

            if(Arrays.stream(anotacoesDoMetodo).anyMatch(a -> a.annotationType().equals(JSON.class)) && m.getName().startsWith("get")){
                String nomePropriedade = m.getName().substring(3);
                
                nomePropriedade = Character.toLowerCase(nomePropriedade.charAt(0)) + nomePropriedade.substring(1);

                Object valorPropriedade = m.invoke(object);

                json.append("\"" + nomePropriedade + "\"");
                json.append(":");

                Class<?> retornoMetodo = m.getReturnType();

                if(retornoMetodo.isPrimitive()){
                    json.append(valorPropriedade);
                    json.append(",");
                }
                else if(retornoMetodo.isArray()){
                    json.append('[');

                    int length = Array.getLength(valorPropriedade);

                    for(int i=0; i<length; i++){
                        json.append(Array.get(valorPropriedade, i));
                        json.append(",");
                    }

                    json.append(']');
                }
                else if(Collection.class.isAssignableFrom(retornoMetodo)){
                    json.append('[');

                    json.append(']');
                }
                else{
                    json.append("\"" + valorPropriedade + "\",");
                }

                //System.out.println(m.getName() + " " + m.getReturnType().isPrimitive());
                //System.out.println(m.getName() + " " + m.getReturnType().isArray());
                //System.out.println(Collection.class.isAssignableFrom(m.getReturnType()));

            }

        }

        json.deleteCharAt(json.lastIndexOf(",")).append("}");

        System.out.println(json);
    }
}
