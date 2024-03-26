package br.ufsm.csi.pp.exercicio1;

public class SemiCirculo implements Forma2D{

    private Float angulo;
    private Float raio;

    public Float getAngulo() {
        return angulo;
    }

    public void setAngulo(Float angulo) {
        this.angulo = angulo;
    }

    public Float getRaio() {
        return raio;
    }

    public void setRaio(Float raio) {
        this.raio = raio;
    }

    @Override
    public Float getArea() {
        return (float) (Math.PI * Math.pow(raio, 2.0)) * (angulo / 360f);
    }
}
