package br.ufsm.csi.pp;

import br.ufsm.csi.pp.exemplos.ClasseExemplo;
import br.ufsm.csi.pp.exemplos.ClasseExemplo2;
import br.ufsm.csi.pp.exemplos.ClasseExemplo3;

import java.time.Instant;
import java.util.Date;

//nome: mateus cardoso

public class Main{
    public static void main(String[] args) {
        //classExemplo3
        ClasseExemplo3 classeExemplo3 = new ClasseExemplo3();
        classeExemplo3.setCodigo(345342l);

        ClasseExemplo classeExemploInner = new ClasseExemplo();
        classeExemploInner.setCodigo(6785655l);
        classeExemploInner.setId(1l);
        classeExemploInner.atributo1 = "attr 1";
        classeExemploInner.atributo2 = "attr 2";
        classeExemploInner.dataCriacao = new Date();

        classeExemplo3.exemplo = classeExemploInner;


        //classeExemplo2
        ClasseExemplo2 classeExemplo2 = new ClasseExemplo2();
        classeExemplo2.setCodigo(456454l);
        classeExemplo2.setNome("classeExemplo2");
        classeExemplo2.exemplo3 = classeExemplo3;


        //classeExemplo
        ClasseExemplo classeExemplo = new ClasseExemplo();
        classeExemplo.dataCriacao = Date.from(Instant.now());
        classeExemplo.atributo1 = "joao";
        classeExemplo.atributo2 = "attr 2222";
        classeExemplo.setId(356l);
        classeExemplo.setCodigo(36302l);
        classeExemplo.setExemplo2(classeExemplo2);


        Clone clone = new Clone();

        //copia classeExemplo
        ClasseExemplo copiaClasseExemplo = (ClasseExemplo) clone.copyFromPrototype(classeExemplo);

        //copia classeExemplo2
        ClasseExemplo2 copiaClasseExemplo2 = (ClasseExemplo2) clone.copyFromPrototype(classeExemplo2);

        //copia classeExemplo3
        ClasseExemplo3 copiaClasseExemplo3 = (ClasseExemplo3) clone.copyFromPrototype(classeExemplo3);




        //teste classeExemplo
        System.out.println("\n\nclasseExemploOriginal: "
                + "\nendereço original: " + classeExemplo + "\n"
                + classeExemplo.atributo1 + "\n"
                + classeExemplo.atributo2 + "\n"
                + classeExemplo.getId() + "\n"
                + classeExemplo.getCodigo() + "\n"
                + "endereço objeto aninhado original: " + classeExemplo.getExemplo2() + "\n"
                + classeExemplo.getExemplo2().getNome() + "\n"
                + classeExemplo.getExemplo2().getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.getId() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.atributo1 + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.atributo2 + "\n"
        );

        System.out.println("copiaClasseExemplo: "
                + "\nendereço copia: " + copiaClasseExemplo + "\n"
                + copiaClasseExemplo.atributo1 + "\n"
                + copiaClasseExemplo.atributo2 + "\n"
                + copiaClasseExemplo.getId() + "\n"
                + copiaClasseExemplo.getCodigo() + "\n"
                + "endereço objeto aninhado copia: " + copiaClasseExemplo.getExemplo2() + "\n"
                + copiaClasseExemplo.getExemplo2().getNome() + "\n"
                + copiaClasseExemplo.getExemplo2().getCodigo() + "\n"
                + copiaClasseExemplo.getExemplo2().exemplo3.getCodigo() + "\n"
                + copiaClasseExemplo.getExemplo2().exemplo3.exemplo.getId() + "\n"
                + copiaClasseExemplo.getExemplo2().exemplo3.exemplo.getCodigo() + "\n"
                + copiaClasseExemplo.getExemplo2().exemplo3.exemplo.atributo1 + "\n"
                + copiaClasseExemplo.getExemplo2().exemplo3.exemplo.atributo2 + "\n"
        );










        //teste classeExemplo2
        System.out.println("classeExemplo2 Original: "
                + "\nendereço original: " + classeExemplo2 + "\n"
                + classeExemplo2.getCodigo() + "\n"
                + classeExemplo2.getNome() + "\n"
                + "endereço objeto aninhado original: " + classeExemplo2.exemplo3 + "\n"
                + classeExemplo2.exemplo3.getCodigo() + "\n"
                + classeExemplo2.exemplo3.exemplo.atributo1 + "\n"
                + classeExemplo2.exemplo3.exemplo.atributo2 + "\n"
                + classeExemplo2.exemplo3.exemplo.getId() + "\n"
                + classeExemplo2.exemplo3.exemplo.getCodigo() + "\n"
        );

        System.out.println("classeExemplo2 Cópia: "
                + "\nendereço original: " + copiaClasseExemplo2 + "\n"
                + copiaClasseExemplo2.getCodigo() + "\n"
                + copiaClasseExemplo2.getNome() + "\n"
                + "endereço objeto aninhado Cópia: " + copiaClasseExemplo2.exemplo3 + "\n"
                + copiaClasseExemplo2.exemplo3.getCodigo() + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.atributo1 + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.atributo2 + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.getId() + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.getCodigo() + "\n"
        );










        //teste classeExemplo3
        System.out.println("classeExemplo3 Original: "
                + "\nendereço original: " + classeExemplo3 + "\n"
                + classeExemplo3.getCodigo() + "\n"
                + "endereço objeto aninhado original: " + classeExemplo3.exemplo + "\n"
                + classeExemplo3.exemplo.getCodigo() + "\n"
                + classeExemplo3.exemplo.getId() + "\n"
                + classeExemplo3.exemplo.atributo1 + "\n"
                + classeExemplo3.exemplo.atributo2 + "\n"
        );

        System.out.println("classeExemplo3 Cópia: "
                + "\nendereço original: " + copiaClasseExemplo3 + "\n"
                + copiaClasseExemplo3.getCodigo() + "\n"
                + "endereço objeto aninhado Cópia: " + copiaClasseExemplo3.exemplo + "\n"
                + copiaClasseExemplo3.exemplo.getCodigo() + "\n"
                + copiaClasseExemplo3.exemplo.getId() + "\n"
                + copiaClasseExemplo3.exemplo.atributo1 + "\n"
                + copiaClasseExemplo3.exemplo.atributo2 + "\n"
        );



        //trocar propriedade copiaClasseExemplo2 não afeta original
        copiaClasseExemplo2.exemplo3.setCodigo(333333333333l);

        System.out.println("\n\n\n\n\n\n\nclasseExemplo2 Original depois das trocas de propriedades: "
                + "\nendereço original: " + classeExemplo2 + "\n"
                + classeExemplo2.getCodigo() + "\n"
                + classeExemplo2.getNome() + "\n"
                + "endereço objeto aninhado original: " + classeExemplo2.exemplo3 + "\n"
                + "código: " + classeExemplo2.exemplo3.getCodigo() + "\n"
                + classeExemplo2.exemplo3.exemplo.atributo1 + "\n"
                + classeExemplo2.exemplo3.exemplo.atributo2 + "\n"
                + classeExemplo2.exemplo3.exemplo.getId() + "\n"
                + classeExemplo2.exemplo3.exemplo.getCodigo() + "\n"
        );

        System.out.println("classeExemplo2 Cópia: "
                + "\nendereço original: " + copiaClasseExemplo2 + "\n"
                + copiaClasseExemplo2.getCodigo() + "\n"
                + copiaClasseExemplo2.getNome() + "\n"
                + "endereço objeto aninhado Cópia: " + copiaClasseExemplo2.exemplo3 + "\n"
                + "código: " + copiaClasseExemplo2.exemplo3.getCodigo() + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.atributo1 + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.atributo2 + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.getId() + "\n"
                + copiaClasseExemplo2.exemplo3.exemplo.getCodigo() + "\n"
        );


        //testes
        copiaClasseExemplo.setExemplo2(null);
        System.out.println("\n\nclasseExemploOriginal: "
                + "\nendereço original: " + classeExemplo + "\n"
                + classeExemplo.atributo1 + "\n"
                + classeExemplo.atributo2 + "\n"
                + classeExemplo.getId() + "\n"
                + classeExemplo.getCodigo() + "\n"
                + "endereço objeto aninhado original: " + classeExemplo.getExemplo2() + "\n"
                + classeExemplo.getExemplo2().getNome() + "\n"
                + classeExemplo.getExemplo2().getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.getId() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.getCodigo() + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.atributo1 + "\n"
                + classeExemplo.getExemplo2().exemplo3.exemplo.atributo2 + "\n"
        );

        System.out.println("copiaClasseExemplo: "
                + "\nendereço copia: " + copiaClasseExemplo + "\n"
                + copiaClasseExemplo.atributo1 + "\n"
                + copiaClasseExemplo.atributo2 + "\n"
                + copiaClasseExemplo.getId() + "\n"
                + copiaClasseExemplo.getCodigo() + "\n"
                + "endereço objeto aninhado copia: " + copiaClasseExemplo.getExemplo2() + "\n"
                + copiaClasseExemplo.getExemplo2()
        );



        PrototypeFactory prototypeFactory = null; //todo coloque aqui a forma de obter uma instância da sua implementação
        //todo chame aqui os casos de teste implementados.
    }
}
