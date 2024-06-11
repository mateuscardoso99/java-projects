package br.ufsm.csi.pp;

import br.ufsm.csi.pp.exemplos.ClasseExemplo;
import br.ufsm.csi.pp.exemplos.ClasseExemplo2;
import br.ufsm.csi.pp.exemplos.ClasseExemplo3;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PrototypeFactory prototypeFactory = new PrototypeFramework();
        //todo chame aqui os casos de teste implementados.
        ClasseExemplo classeExemplo = new ClasseExemplo();
        ClasseExemplo2 classeExemplo2 = new ClasseExemplo2();
        ClasseExemplo3 classeExemplo3 = new ClasseExemplo3();
        classeExemplo.setExemplo2(classeExemplo2);
        classeExemplo.setId(1111L);
        classeExemplo.setCodigo(1000L);
        classeExemplo.atributo1 = "atributo1";
        classeExemplo.atributo2 = "atributo2";
        classeExemplo.dataCriacao = new Date();
        classeExemplo2.setCodigo(2222L);
        classeExemplo2.setNome("classeexemplo2");
        classeExemplo2.exemplo3 = classeExemplo3;
        classeExemplo3.setCodigo(3333L);
        classeExemplo3.exemplo = classeExemplo;
        ClasseExemplo copia = (ClasseExemplo) prototypeFactory.copyFromPrototype(classeExemplo);

        assert copia != classeExemplo;
        assert copia.dataCriacao == classeExemplo.dataCriacao;
        assert copia.atributo1 == classeExemplo.atributo1;
        assert copia.atributo2 == classeExemplo.atributo2;
        assert copia.getCodigo() == classeExemplo.getCodigo();
        assert copia.getId() == classeExemplo.getId();
        assert copia.getExemplo2() != classeExemplo.getExemplo2();
    }
}
