package org.example;

import java.util.List;
import java.util.Set;
import java.util.Map;

public class ClasseA {
    private String nome;
    private Integer idade;
    private String endereco;
    private double idColuna;
    private Integer[] arrayClassePrimitiveInteger;
    private List<Integer> numerosCollection;
    private long[] arrayPrimitive;
    private InnerClasse innerClasse;
    private String[] arrayClassePrimitiveString;
    private Set<InnerClasse> collectionInnerClasse;
    private ClasseB classeB;
    private Map<String, String> mapa1;
    private Map<Long, ClasseB> mapa2;
    private Map<ClasseC, ClasseC> mapa3;

    @JSON
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JSON
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @JSON
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @JSON
    public double getIdColuna() {
        return idColuna;
    }
    public void setIdColuna(double idColuna) {
        this.idColuna = idColuna;
    }

    @JSON
    public Integer[] getArrayClassePrimitiveInteger() {
        return arrayClassePrimitiveInteger;
    }
    public void setArrayClassePrimitiveInteger(Integer[] arrayClassePrimitiveInteger) {
        this.arrayClassePrimitiveInteger = arrayClassePrimitiveInteger;
    }

    @JSON
    public List<Integer> getNumerosCollection() {
        return numerosCollection;
    }
    public void setNumerosCollection(List<Integer> numerosCollection) {
        this.numerosCollection = numerosCollection;
    }

    @JSON
    public long[] getArrayPrimitive() {
        return arrayPrimitive;
    }
    public void setArrayPrimitive(long[] arrayPrimitive) {
        this.arrayPrimitive = arrayPrimitive;
    }

    @JSON
    public InnerClasse getInnerClasse() {
        return innerClasse;
    }
    public void setInnerClasse(InnerClasse innerClasse) {
        this.innerClasse = innerClasse;
    }

    @JSON
    public String[] getArrayClassePrimitiveString() {
        return arrayClassePrimitiveString;
    }
    public void setArrayClassePrimitiveString(String[] arrayClassePrimitiveString) {
        this.arrayClassePrimitiveString = arrayClassePrimitiveString;
    }

    @JSON
    public Set<InnerClasse> getCollectionInnerClasse() {
        return collectionInnerClasse;
    }
    public void setCollectionInnerClasse(Set<InnerClasse> collectionInnerClasse) {
        this.collectionInnerClasse = collectionInnerClasse;
    }

    @JSON
    public ClasseB getClasseB() {
        return classeB;
    }
    public void setClasseB(ClasseB classeB) {
        this.classeB = classeB;
    }

    @JSON
    public Map<String, String> getMapa1() {
        return mapa1;
    }
    public void setMapa1(Map<String, String> mapa1) {
        this.mapa1 = mapa1;
    }
    
    @JSON
    public Map<Long, ClasseB> getMapa2() {
        return mapa2;
    }
    public void setMapa2(Map<Long, ClasseB> mapa2) {
        this.mapa2 = mapa2;
    }

    //@JSON
    public Map<ClasseC, ClasseC> getMapa3() {
        return mapa3;
    }
    public void setMapa3(Map<ClasseC, ClasseC> mapa3) {
        this.mapa3 = mapa3;
    }

    public static class InnerClasse {
        private String descricao;
        private String texto;

        public InnerClasse(String descricao, String texto) {
            this.descricao = descricao;
            this.texto = texto;
        }
        
        @JSON
        public String getDescricao() {
            return descricao;
        }
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        @JSON
        public String getTexto() {
            return texto;
        }
        public void setTexto(String texto) {
            this.texto = texto;
        }        
    }
}

