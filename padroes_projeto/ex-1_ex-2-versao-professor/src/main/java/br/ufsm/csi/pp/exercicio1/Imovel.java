package br.ufsm.csi.pp.exercicio1;

public class Imovel implements Forma2D, Forma3D {

    private String identificacao;
    private String proprietario;
    private String endereco;
    private TipoUso tipoUso;

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoUso getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(TipoUso tipoUso) {
        this.tipoUso = tipoUso;
    }

    public Peca[] getPecas() {
        return pecas;
    }

    public void setPecas(Peca[] pecas) {
        this.pecas = pecas;
    }

    public enum TipoUso {  COMERCIAL, RESIDENCIAL }


    private Peca[] pecas;

    public Float getArea() {
        float areaTotal = 0f;
        for (Peca p : pecas) {
            areaTotal += p.getArea();
        }
        return areaTotal;
    }

    public Float getVolume() {
        float volumeTotal = 0f;
        for (Peca p : pecas) {
            volumeTotal += p.getVolume();
        }
        return volumeTotal;
    }

}
