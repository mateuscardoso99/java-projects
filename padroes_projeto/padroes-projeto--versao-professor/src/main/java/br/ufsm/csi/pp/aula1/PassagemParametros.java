package br.ufsm.csi.pp.aula1;

public class PassagemParametros {

    public static void main(String[] args) {
        Classe1 obj = new Classe1();
        obj.valor = 10;
        String temp = obj.str;
        metodo3(obj);
        System.out.println(obj.str);
        System.out.println(temp);

    }

    public static String metodo3(String str) {
        return str + "1";
    }

    public static void metodo3(Classe1 objeto) {
        objeto.str = objeto.str + "1";
    }

    public static void metodo1(Classe1 objeto) {
        objeto.valor = objeto.valor + 1;
    }

    public static void metodo2(Integer valor) {
        valor = valor + 1;
        System.out.println(valor);
    }

    public static class Classe1 {
        public int valor = 0;
        public String str = "string";
    }

}
