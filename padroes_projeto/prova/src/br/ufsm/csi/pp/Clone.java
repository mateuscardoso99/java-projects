package br.ufsm.csi.pp;

import br.ufsm.csi.pp.annotations.DeepCopy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Clone implements PrototypeFactory{
    @Override
    public Object copyFromPrototype(Object prototype) {
        try {
            Object copia = prototype.getClass().getDeclaredConstructor().newInstance();

            Field[] atributos = prototype.getClass().getDeclaredFields();

            for(Field f : atributos){
                DeepCopy anotacao = f.getAnnotation(DeepCopy.class);

                String nomeMetodo = f.getName().substring(0,1).toUpperCase() + f.getName().substring(1);
                System.out.println("\nFIELD: " + f.getName() + " TEM ANOTACAO: " + (anotacao != null));

                if(anotacao != null){
                    //System.out.println("aa " + f.getName());
                    if(f.getModifiers() == Modifier.PUBLIC) {
                        Object valor = f.get(prototype);
                        f.set(copia, copyFromPrototype(valor));
                    }
                    else{//private ou protected, usar getter
                        f.setAccessible(true); //não se usa setAcessible pois faz com que um atributo privado se torne acessível podendo gerar problemas de segurança
                        Method metodo = prototype.getClass().getDeclaredMethod("get" + nomeMetodo);
                        Object valor = metodo.invoke(prototype);
                        f.set(copia, copyFromPrototype(valor));
                    }

                }else{
                    if(f.getModifiers() == Modifier.PUBLIC) {//public
                         Object valor = f.get(prototype);
                         f.set(copia, valor);
                    }
                    else{//private ou protected, usar getter
                        f.setAccessible(true);
                        Method metodo = prototype.getClass().getDeclaredMethod("get" + nomeMetodo);
                        Object valor = metodo.invoke(prototype);
                        f.set(copia, valor);
                    }
                }

            }

            return copia;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
