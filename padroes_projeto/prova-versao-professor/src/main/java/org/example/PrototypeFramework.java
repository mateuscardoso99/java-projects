package br.ufsm.csi.pp;

import br.ufsm.csi.pp.annotations.DeepCopy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class PrototypeFramework implements PrototypeFactory {
    @Override
    public Object copyFromPrototype(Object prototype) {
        try {
            Object copia = prototype.getClass().getConstructor().newInstance();
            for (Field propriedade : prototype.getClass().getDeclaredFields()) {
                if ((propriedade.getModifiers() & Modifier.PUBLIC) == 1) {
                    if (propriedade.getAnnotation(DeepCopy.class) != null) {
                        propriedade.set(copia, copyFromPrototype(propriedade.get(prototype)));
                    } else {
                        propriedade.set(copia, propriedade.get(prototype));
                    }
                } else {
                    String nomeMetodoGet = "get" + propriedade.getName().substring(0, 1).toUpperCase() + propriedade.getName().substring(1);
                    String nomeMetodoSet = "set" + propriedade.getName().substring(0, 1).toUpperCase() + propriedade.getName().substring(1);
                    Object value = prototype.getClass().getMethod(nomeMetodoGet).invoke(prototype);
                    if (propriedade.getAnnotation(DeepCopy.class) != null) {
                        value = copyFromPrototype(value);
                    }
                    prototype.getClass().getMethod(nomeMetodoSet, value.getClass()).invoke(copia, value);
                }
            }
            return copia;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
