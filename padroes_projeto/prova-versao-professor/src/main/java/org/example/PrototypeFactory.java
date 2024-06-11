package br.ufsm.csi.pp;

/**
 * Interface que representa o framework de c�pia de objetos.
 */
public interface PrototypeFactory {

    /**
     * m�todo que recebe um objeto criando uma c�pia deste. Ver arquivo LEIAME.
     * @param prototype objeto original a partir do qual ser� feita a c�pia.
     * @return o objeto copiado'
     */
    Object copyFromPrototype(Object prototype);

}
