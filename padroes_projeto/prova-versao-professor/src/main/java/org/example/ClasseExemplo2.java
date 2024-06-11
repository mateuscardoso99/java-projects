package br.ufsm.csi.pp.exemplos;

import br.ufsm.csi.pp.annotations.DeepCopy;

public class ClasseExemplo2 {

    private Long codigo;
    private String nome;
    @DeepCopy
    public ClasseExemplo3 exemplo3;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
