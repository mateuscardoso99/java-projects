package com.example;

/*
 * O Adapter é um padrão de projeto estrutural, que permite a colaboração de objetos incompatíveis.
 * O Adapter atua como um wrapper entre dois objetos. 
 * Ele captura chamadas para um objeto e as deixa reconhecíveis tanto em formato como interface para este segundo objeto.
 * 
 * O padrão Adapter é bastante comum no código Java. É frequentemente usado em sistemas baseados em algum código legado. Nesses casos, os adaptadores criam código legado com classes modernas.
 * 
 * Existem alguns adapters padrão nas bibliotecas principais do Java:
 * java.util.Arrays#asList()
 * java.util.Collections#list()
 * java.util.Collections#enumeration()
 * java.io.InputStreamReader(InputStream) (retorna um objeto Reader)
 * java.io.OutputStreamWriter(OutputStream) (retorna um objeto Writer)
 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal() e #unmarshal ()
 * 
 * Identificação: O Adapter é reconhecível por um construtor que utiliza uma instância de tipo abstrato/interface diferente. 
 * Quando o adaptador recebe uma chamada para qualquer um de seus métodos, ele converte parâmetros para o formato apropriado 
 * e direciona a chamada para um ou vários métodos do objeto envolvido.
 * 
 * 
 * 
 * Colocando pinos quadrados em orifícios redondos:
 * Este exemplo simples mostra como um adaptador pode fazer com que objetos incompatíveis funcionem juntos.
 */
public class Main {
    public static void main(String[] args) {
        BuracoRedondo hole = new BuracoRedondo(5);
        PinoRedondo rpeg = new PinoRedondo(5);

        //método hole.fits() recebe um objeto PinoRedondo, nesse caso vai funcionar
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        PinoQuadrado smallSqPeg = new PinoQuadrado(2);
        PinoQuadrado largeSqPeg = new PinoQuadrado(20);
        // hole.fits(smallSqPeg); // não compila pois hole.fits() recebe um objeto PinoRedondo. e está sendo passado um objeto PinoQuadrado

        // Adapter resolve o problema.
        PinoQuadradoAdapter smallSqPegAdapter = new PinoQuadradoAdapter(smallSqPeg);
        PinoQuadradoAdapter largeSqPegAdapter = new PinoQuadradoAdapter(largeSqPeg);

        if (hole.fits(smallSqPegAdapter)) {//funciona pois hole.fits() está recebendo um PinoQuadradoAdapter que herda de PinoRedondo
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
