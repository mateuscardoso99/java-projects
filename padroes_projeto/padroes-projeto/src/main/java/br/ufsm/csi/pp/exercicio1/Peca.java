package br.ufsm.csi.pp.exercicio1;

public class Peca implements Forma2D, Forma3D {

    private String identificacao;
    private Forma2D[] formas;
    private Float peDireito;

    public Float getPeDireito() {
        return peDireito;
    }

    public void setPeDireito(Float peDireito) {
        this.peDireito = peDireito;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Forma2D[] getFormas() {
        return formas;
    }

    public void setFormas(Forma2D[] formas) {
        this.formas = formas;
    }

    public Float getArea() {
        float areaTotal = 0f;
        for (Forma2D forma : formas) {
            areaTotal += forma.getArea();
        }
        return areaTotal;
    }

    public Float getVolume() {
        return getArea() * peDireito;
    }
}
