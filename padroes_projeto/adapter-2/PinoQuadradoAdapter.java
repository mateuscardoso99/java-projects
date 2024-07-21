package com.example;

/*
 * Adaptador permite encaixar pinos quadrado em buracos redondos
 */
public class PinoQuadradoAdapter extends PinoRedondo {
    private PinoQuadrado pinoQuadrado;

    public PinoQuadradoAdapter(PinoQuadrado pinoQuadrado) {
        this.pinoQuadrado = pinoQuadrado;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((pinoQuadrado.getWidth() / 2), 2) * 2));
        return result;
    }
}
