package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
    Vamos considerar um cenário em que duas partes querem se comunicar e precisam de uma abordagem para verificar se as 
    mensagens que recebem não foram adulteradas. Hash-based Message Authentication Code (HMAC) é uma boa solução.

    - HMAC é um método criptográfico que garante a integridade da mensagem entre duas partes.
    - O algoritmo HMAC consiste em uma chave secreta e uma função hash . A chave secreta é uma informação única ou uma sequência de caracteres. Ela é conhecida tanto pelo remetente quanto pelo destinatário da mensagem.
    - A função hash é um algoritmo de mapeamento que converte uma sequência em outra sequência.


    -------------------------

    
    - O HMAC não envolve criptografia/descriptografia, desde que a mesma chave secreta seja usada para assinar a mesma mensagem, a assinatura gerada será sempre a mesma.
    - Isso significa que podemos validar a autenticidade de solicitações HTTP, mensagens WebSocket, eventos etc., contraassinando os dados recebidos e comparando as assinaturas.
    - Precisamos apenas de dois componentes para gerar uma assinatura HMAC: uma chave secreta e os dados para hash.
    - A secret-key (segredo) pode ser uma String simples de caracteres alfanuméricos. Quanto maior o número de caracteres, melhor
    - A mensagem pode ser JSON, XML ou um dado String simples; realmente não importa.

    MAC: Código de Autenticação de Mensagem:
    1) Alice cria a mensagem "m" e concatena a um segredo "s", também conhecido por Bob. Alice calcula o hash: H(m+s). 
    2) Alice anexa o H(m+s) à mensagem m, criando uma mensagem extendida (m, H(m+s));
    3) Bob recebe a mensagem e calcula H(m+s), comparando com o que foi recebido; 
    4) Man in the middle não conhece "s" (segredo), portanto não consegue criar mensagens falsas e nem adulterar. Se ele usar um segredo diferente os hashs não vão bater
    GARANTIA DE INTEGRIDADE!

    somente origem e destino conhecem o segredo
    H(m+s): é o cálculo do hash da mensagem + segredo, como o segredo só é conhecido por origem e destino, a integridade é garantida

    HMAC (Hash-based Message Authentication Code) é uma forma de garantir a integridade e autenticidade de uma mensagem. 
    O HMAC combina uma função hash criptográfica com uma chave secreta.


    HMAC é adequado para autenticação de mensagens, mas não deve ser usado como um substituto para assinaturas digitais em todos os casos.
    ** Outra forma de garantir integridade é usando assinatura digital.







    ----------------------------


    Aplicações de segurança:
    Solicitar proteção contra falsificação:
        Pela natureza do mecanismo HMAC, podemos usá-lo para proteger contra falsificação de solicitação. 
        Como? O remetente e o destinatário da solicitação teriam compartilhado a chave secreta por meio de um canal seguro em um processo único, e as comunicações subsequentes seguirão este padrão:
            - O remetente pretende enviar uma mensagem "Hello World"
            - O remetente irá gerar uma assinatura HMAC da mensagem usando a chave secreta compartilhada
            - O remetente enviará tanto a assinatura resultante quanto a mensagem "Hello World" simples
            - O Receptor, ao receber a mensagem, também irá gerar sua própria assinatura para a mensagem "Hello World" simples recebida com sua própria cópia da chave secreta compartilhada.
            - O Receptor agora irá comparar a assinatura recebida com a sua própria assinatura gerada
            - Se a assinatura for exatamente a mesma, então o Receptor processará a mensagem. Caso contrário, rejeitará a mensagem
            - Se em algum momento a mensagem for modificada por pessoas mal-intencionadas entre o Remetente e o Destinatário, a mensagem terá assinaturas diferentes e se tornará inválida.

    Proteção contra ataques de repetição:
        Podemos aprimorar esse protocolo adicionando mais um ingrediente - o unix atual timestamp. 
        Tanto o Remetente quanto o Receptor concordarão com uma duração para a qual uma solicitação pode ser considerada válida.

        Por exemplo, qualquer solicitação com mais de 10 segundos será considerada obsoleta e não será processada.
            - O remetente assinará "Hello World" + unix atual timestampem em milissegundos com a chave secreta compartilhada
            - O remetente enviará "Hello World", timestamp signature para o destinatário
            - O receptor calculará a diferença de tempo entre o timestamp recebido e seu próprio unix timestamp atual
            - Se a diferença de tempo for maior que o limite acordado, o pedido será rejeitado por obsoleto.
            - O Destinatário, ao validar o timestamp, procederá então à assinatura da mensagem recebida "Hello World" + timestamp à comparação signature como habitual para determinar a autenticidade da mensagem
            - Este protocolo impedirá que um intermediário repita requisições antigas ou modifique as requisições em andamento. Essas técnicas são geralmente usadas para proteger endpoints de API, como web callbacks ou APIs internas.
*/
public class Alice {

    /* passo a passo
     * 1. Bob cria o seu par de chaves (pública e privada) para criptografar/descriptografar a chave de sessão (criptografia assimétrica)
     * 2. Bob envia a sua chave pública para Alice
     * 3. Alice recebe a chave pública de Bob
     * 4. Alice cria uma chave simétrica e usa ela pra criptografar a mensagem (gerando a chave de sessão)
     * 5. Alice criptografa a mensagem usando a chave de sessão
     * 6. Alice usa a chave pública recebida de Bob para criptografar a chave simétrica (chave de sessão) 
     * 7. Alice gera um hash HMAC da mensagem + segredo
     * 8. Alice envia para Bob a mensagem criptografada com a chave simétrica, a chave simétrica criptografada com a chave pública de Bob (chave de sessão), e o hash HMAC da mensagem + segredo
     * 9. Bob recebe tudo isso
     * 10. Bob usa a sua chave privada criada no passo 1 pra descriptografar a chave de sessão
     * 11. Bob usa a chave de sessão pra descriptografar a mensagem de Alice
     * 12. Bob gera um hash HMAC da mensagem que Alice enviou + segredo 
     * 13. Bob compara os hashs e verifica se são iguais. Se forem iguais, foi garantida a integridade
     */
    
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, ClassNotFoundException {
        System.out.println("[ALICE] Aguardando conexão na porta 8090...");

        ServerSocket serverSocket = new ServerSocket(8090);
        Socket socket = serverSocket.accept();

        System.out.println("[ALICE] Conexão recebida");

        //passo 3: Alice recebe a chave pública de Bob
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
        PublicKey chavePublicaBob = (PublicKey) oi.readObject();

        System.out.println("3: [ALICE] Chave pública de Bob recebida");


        JFileChooser fc = new JFileChooser("");
        System.out.println("[ALICE] Selecionando arquivo");

        if (fc.showDialog(new JFrame(), "OK") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            FileInputStream fin = new FileInputStream(f);
            byte[] bytesArquivo = new byte[(int) fin.getChannel().size()];
            fin.read(bytesArquivo);
            System.out.println("Arquivo selecionado");
            fin.close();

            //passo 4: cria a chave de sessão
            System.out.println("4: [ALICE] Gerando chave de sessão...");
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256);
            SecretKey chaveSessao = kg.generateKey();



            //passo 5: criptografa o arquivo usando a chave de sessão
            System.out.println("5: [ALICE] Criptografando arquivo com a chave de sessão...");
            Cipher cipherAES = Cipher.getInstance("AES");
            cipherAES.init(Cipher.ENCRYPT_MODE, chaveSessao);
            byte[] textoCifrado = cipherAES.doFinal(bytesArquivo);



            //passo 6: criptografando a chave de sessão com a chave publica de bob
            System.out.println("6: [ALICE] Criptografando a chave de sessão com a Chave pública recebida de Bob...");
            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.ENCRYPT_MODE, chavePublicaBob);
            byte[] chaveSessaoCifrada = cipherRSA.doFinal(chaveSessao.getEncoded());



            //passo 7: gera um hash HMAC da mensagem + segredo
            System.out.println("7: [ALICE] Gerando hash HMAC da mensagem + segredo...");
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(Segredo.SEGREDO.getBytes(), "HmacSHA256");
            hmacSHA256.init(secretKeySpec);
            byte[] hashHmacGerado = hmacSHA256.doFinal(bytesArquivo);

            System.out.println("[ALICE]: HASH HMAC GERADO: " + new String(hashHmacGerado, "UTF8"));
            System.out.println("[ALICE]: HASH HMAC GERADO em Base64 (para visualização apenas): " + Base64.getEncoder().encodeToString(hashHmacGerado));



            //passo 8. Alice envia para Bob a mensagem criptografada com a chave simétrica, a chave simétrica criptografada com a chave pública de Bob (chave de sessão), e o hash HMAC da mensagem + segredo
            System.out.println("10: [ALICE] Enviando para Bob a mensagem criptografada com a chave simétrica, a chave simétrica criptografada com a chave pública de Bob (chave de sessão), e o hash HMAC da mensagem + segredo");
            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografado(textoCifrado);
            objetoTroca.setNomeArquivo(f.getName());
            objetoTroca.setChaveSessaoCriptografada(chaveSessaoCifrada);
            objetoTroca.setHashHMAC(hashHmacGerado);

            ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
            oout.writeObject(objetoTroca);
        }

        serverSocket.close();
    }


    public static class ObjetoTroca implements Serializable {
        private String nomeArquivo;
        private byte[] arquivoCriptografado;
        private byte[] chaveSessaoCriptografada;
        private byte[] hashHmac; //hash HMAC

        public String getNomeArquivo() {
            return nomeArquivo;
        }
        public void setNomeArquivo(String nomeArquivo) {
            this.nomeArquivo = nomeArquivo;
        }
        public byte[] getArquivoCriptografado() {
            return arquivoCriptografado;
        }
        public void setArquivoCriptografado(byte[] arquivoCriptografado) {
            this.arquivoCriptografado = arquivoCriptografado;
        }
        public byte[] getChaveSessaoCriptografada() {
            return chaveSessaoCriptografada;
        }
        public void setChaveSessaoCriptografada(byte[] chaveSessaoCriptografada) {
            this.chaveSessaoCriptografada = chaveSessaoCriptografada;
        }
        public byte[] getHashHMAC() {
            return hashHmac;
        }
        public void setHashHMAC(byte[] hashHmac) {
            this.hashHmac = hashHmac;
        }
    }

}
