package org.example;

import org.example.classes.TipoUso;

import java.util.HashSet;
import java.util.Set;

import org.example.classes.Imovel;
import org.example.classes.Pecas.Losango;
import org.example.classes.Pecas.Peca;
import org.example.classes.Pecas.Quadrado;
import org.example.classes.Pecas.Retangulo;
import org.example.classes.Pecas.SemiCirculo;
import org.example.classes.Pecas.Triangulo;

/**
 * – Modelar e implementar um sistema de representação de um imóvel juntamente com o cálculo de área total construída do imóvel, bem como o seu volume interno;
 * – O imóvel deverá ter um conjunto de peças, sendo que cada uma deverá calcular a sua área com base nas formas geométricas que compõem a mesma;
 * – Deverão existir as seguintes formas: • (semi)Círculo, quadrado, losango, retângulo e triângulo;
 * • Cada forma deve contar com as medidas necessárias para implementar um método que calcula a sua área;
 * – Cada peça deverá ter o seu pé-direito de forma que se possa calcular o volume da mesma;
 * – Peças deverão ter identificação; – O imóvel deverá possuir identificação, tipo de uso (comercial, residencial), proprietário e endereço;
 */

public class Main {
    public static void main(String[] args) {
        SemiCirculo semiCirculo = new SemiCirculo(1, 12.5d);
        Losango losango = new Losango(1, 23.2d, 12.5d);
        Retangulo retangulo = new Retangulo(1,12.5d,2.4d);
        Quadrado quadrado = new Quadrado(1,12.5d,2.4d);
        Triangulo triangulo = new Triangulo(1,12.5d,2.4d);

        Set<Peca> pecas = new HashSet<>();
        pecas.add(semiCirculo);
        pecas.add(retangulo);
        pecas.add(losango);
        pecas.add(quadrado);
        pecas.add(triangulo);

        Imovel imovel = new Imovel("casa","joao","rua A", pecas, TipoUso.COMERCIAL);
        System.out.println(imovel.getAreaTotal() + " " +imovel.getTipoUso());
    }
}