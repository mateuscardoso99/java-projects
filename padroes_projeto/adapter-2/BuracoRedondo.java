package com.example;

/*
 * BuracoRedondo são compatíveis com pinos redondos
 */
public class BuracoRedondo {
    private double radius;

    public BuracoRedondo(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(PinoRedondo pinoRedondo) {
        boolean result;
        result = (this.getRadius() >= pinoRedondo.getRadius());
        return result;
    }
}
