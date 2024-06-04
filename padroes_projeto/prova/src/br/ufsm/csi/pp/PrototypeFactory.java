package br.ufsm.csi.pp;

/**
 * Interface que representa o framework de cópia de objetos.
 */
public interface PrototypeFactory {

    /**
     * método que recebe um objeto criando uma cópia deste. Ver arquivo LEIAME.
     * @param prototype objeto original a partir do qual será feita a cópia.
     * @return o objeto copiado'
     */
    Object copyFromPrototype(Object prototype);

}
