package br.ufsm.csi.pp.exemplos;

import br.ufsm.csi.pp.annotations.DeepCopy;

import java.util.Date;

public class ClasseExemplo {

    private Long id;
    private Long codigo;
    public String atributo1;
    public String atributo2;
    public Date dataCriacao;
    @DeepCopy
    private ClasseExemplo2 exemplo2;

    public ClasseExemplo2 getExemplo2() {
        return exemplo2;
    }

    public void setExemplo2(ClasseExemplo2 exemplo2) {
        this.exemplo2 = exemplo2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
