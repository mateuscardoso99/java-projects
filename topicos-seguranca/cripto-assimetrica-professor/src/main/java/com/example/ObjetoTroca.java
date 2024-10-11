package br.ufsm.poli.csi.cripto.assimetrico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.security.PublicKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjetoTroca implements Serializable {

    private String nomeArquivo;
    private byte[] arquivoCriptografado;
    private PublicKey key;
    private byte[] chaveSessao;

}
