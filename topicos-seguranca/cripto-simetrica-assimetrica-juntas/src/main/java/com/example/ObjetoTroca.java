package br.ufsm.poli.csi.cripto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.SecretKey;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjetoTroca implements Serializable {

    private String nomeArquivo;
    private byte[] arquivoCriptografiaSimetrica;
    private byte[] chaveSimetricaCriptografada;

}
