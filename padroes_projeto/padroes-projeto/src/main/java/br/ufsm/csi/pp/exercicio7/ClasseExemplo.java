package br.ufsm.csi.pp.exercicio7;

public class ClasseExemplo {

    private Long id;
    private String nome;
    private String tipo;
    private int umPrimitivo;
    private String[] referencias;
    private InnerObject innerObject;

    @JSON
    public InnerObject getInnerObject() {
        return innerObject;
    }

    public void setInnerObject(InnerObject innerObject) {
        this.innerObject = innerObject;
    }

    public static class InnerObject {
        private String aStr;
        private Integer cod;

        @JSON
        public String getaStr() {
            return aStr;
        }

        public void setaStr(String aStr) {
            this.aStr = aStr;
        }

        @JSON
        public Integer getCod() {
            return cod;
        }

        public void setCod(Integer cod) {
            this.cod = cod;
        }
    }

    @JSON
    public int getUmPrimitivo() {
        return umPrimitivo;
    }

    public void setUmPrimitivo(int umPrimitivo) {
        this.umPrimitivo = umPrimitivo;
    }

    @JSON
    public String[] getReferencias() {
        return referencias;
    }

    public void setReferencias(String[] referencias) {
        this.referencias = referencias;
    }

    @JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JSON
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JSON
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*
        {
        "id": 12,
        "nome": "algumnome",
        "tipo": "algumtipo"
        }
     */

}
