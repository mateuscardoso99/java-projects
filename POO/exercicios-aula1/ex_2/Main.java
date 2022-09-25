/*
 * Crie uma classe Tempo que guarde as horas,
minutos e segundos em atributos separados.
Crie métodos get e set para cada um destes
atributos e certifique-se que as faixas de valores
estão entre as permitidas para cada um deles.
Crie uma classe de exemplo para Tempo
 */

public class Main {
    public static void main(String[] args) {
        Tempo t =new Tempo();
        t.setHoras(67);
        t.setHoras(22);
        t.setMinutos(34);
        t.setSegundos(89);
        t.setSegundos(34);
        t.incrementarHoras(t.getHoras());
        t.incrementarHoras(t.getHoras());
        t.incrementarMinutos(t.getMinutos());
        System.out.println("tempo em segundos: "+t.tempoEmSegundos());
        System.out.printf("%s\n",t.toString());
    }
}
