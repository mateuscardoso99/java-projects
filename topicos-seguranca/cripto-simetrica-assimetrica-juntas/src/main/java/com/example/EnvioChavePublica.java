package br.ufsm.poli.csi.cripto;

import java.io.Serializable;
import java.security.PublicKey;

public class EnvioChavePublica implements Serializable{
    private PublicKey publicKey;

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    
}
