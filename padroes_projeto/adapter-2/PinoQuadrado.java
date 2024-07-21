package com.example;

/*
 * PinoQuadrado não são compatíveis com BuracoRedondo (eles foram implementados por uma equipe de desenvolvimento anterior). 
 * Mas temos que integrá-los em nosso programa.
 */
public class PinoQuadrado {
    private double width;

    public PinoQuadrado(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
