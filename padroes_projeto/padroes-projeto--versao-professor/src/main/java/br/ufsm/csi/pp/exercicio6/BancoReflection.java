package br.ufsm.csi.pp.exercicio6;

import br.ufsm.csi.pp.exercicio2.Banco;
import br.ufsm.csi.pp.exercicio2.ContaBancaria;
import br.ufsm.csi.pp.exercicio7.JSON;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BancoReflection {

    @SneakyThrows
    public static void main(String[] args) {
        new BancoReflection().invoke();
    }

    public void printClasses() {
        printClass(Banco.class);
        printClass(ContaBancaria.class);
    }

    @SneakyThrows
    public void invoke() {
        Object banco = Banco.class.getConstructor().newInstance();
        invokeExtrato(banco);
    }

    public void invokeExtrato(Object banco) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = banco.getClass().getMethod("extrato", String.class);
        System.out.println("[INVOKE extrato] " + method.invoke(banco, "342304927"));
    }

    public void printClass(Class classe) {
        for (Field f : classe.getDeclaredFields()) {
            System.out.println("[" + classe.getName() + "][FIELD] " + f.getType() + " " + f.getName());
        }
        for (Method m : classe.getDeclaredMethods()) {
            System.out.println("[" + classe.getName() + "][METHOD] " + m.getReturnType() + " " + m.getName());

        }
    }

}
