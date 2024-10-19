package br.ufsm.poli.csi.cripto;

import java.io.Serializable;
import java.math.BigInteger;

public class TrocaDiffieHellman implements Serializable{
    private BigInteger q;
    private BigInteger a;
    private BigInteger chavePublica;

    public BigInteger getQ() {
        return q;
    }
    public void setQ(BigInteger q) {
        this.q = q;
    }
    public BigInteger getA() {
        return a;
    }
    public void setA(BigInteger a) {
        this.a = a;
    }
    public BigInteger getChavePublica() {
        return chavePublica;
    }
    public void setChavePublica(BigInteger chavePublica) {
        this.chavePublica = chavePublica;
    }
}
