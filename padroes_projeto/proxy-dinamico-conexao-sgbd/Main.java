package com.example;

/*
 *  Re-implementar o exercício do Pool Genérico, porém:
 *      1. O pool não será mais genérico. Será um Pool para Conexões com um SGBD qualquer (java.sql.Connection);
 *      2. O pool não terá o método release();
 *      3. Ao invés disso o cliente recebe um proxy para uma conexão, e quando este invocar “close()” isto terá o mesmo efeito de release.
 *      4. Faça o Pool receber um DataSource como parâmetro, para criação das conexões.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
