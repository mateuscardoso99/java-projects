package model.bean;

public class Chave {
    private long id;
    private String sala;
    private String situacao;
    private Porteiro porteiro;

    public Chave() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Porteiro getPorteiro() {
        return porteiro;
    }

    public void setPorteiro(Porteiro porteiro) {
        this.porteiro = porteiro;
    }
    
    @Override
    public String toString(){
        return this.getSala();
    }
}
