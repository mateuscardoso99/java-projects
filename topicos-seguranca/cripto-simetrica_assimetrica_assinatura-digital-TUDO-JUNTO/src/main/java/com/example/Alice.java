package com.example;

import javax.crypto.*;
import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

/*
 * Implementar o envio de arquivo entre Alice e Bob com garantia de confidencialidade e integridade. Pode ser usado qualquer dos algoritmos vistos (chave de sessão ou Diffie Helmann - MAC ou assinatura).
 */

 /*
 * PODE-SE USAR A TANTO A CHAVE PRIVADA QUANTO A CHAVE PÚBLICA PARA CIFRAR E DESCIFRAR
 * QUANDO SE DESEJA REALIZAR UMA ASSINATURA DIGITAL USA-SE A CHAVE PRIVADA PRA CRIPTOGRAFAR E A CHAVE PUBLICA PRA VERIFICAR A ASSINATURA
 * QUANDO SE CRIPTOGRAFA PARA GARANTIR A CONFIDENCIALIDADE USA-SE A CHAVE PÚBLICA PRA CRIPTOGRAFAR E A CHAVE PRIVADA PRA DESCRIPTOGRAFAR
 */

/*
– CHAVE DE SESSÃO: 
    CHAVE SIMÉTRICA É CRIPTOGRAFADA COM CRIPTO ASSIMÉTRICA
    Uma chave simétrica é escolhida para codificar uma sessão; 
    RSA é utilizado para troca da chave simétrica de forma segura; 
    Durante a sessão é utilizado um algoritmo rápido de criptografia como DES, 3DES ou AES (https).
*/

//MD5, SHA1, SHA-256: algoritmos de hash mais usados


/*
 * ASSINATURA DIGITAL: 
 * - Mesmas premissas da assinatura física de documentos: 
 * - Deve ser verificável: reconhecer quem assinou; 
 * - Não falsificável: impossível falsificar uma assinatura; 
 * - Não-repúdio: pessoa não pode negar que concorda com o documento assinado; 
 * - Funções de hash sozinhas não são aplicáveis para Assinatura Digital pois: 
 *      - O Hash pode ser gerado por qualquer um, tornando a assinatura fasificável;
 *      - o hash é uma parte da assinatura digital
 * - Criptografia de chaves assimétricas podem ser usadas: 
 *      - Mensagem é criptografada com a chave privada e descriptografada com a chave pública; 
 *      - Na prática: 
 *          - Como a criptografia assimétrica é muito complexa ela é feita apenas no hash da mensagem, que criptografado é a assinatura do documento.
 */
public class Alice {
    /* passo a passo
     * 1. Bob cria o seu par de chaves (pública e privada) para criptografar/descriptografar a chave de sessão (criptografia assimétrica)
     * 2. Bob envia a sua chave pública para Alice
     * 3. Alice recebe a chave pública de Bob
     * 4. Alice cria uma chave simétrica e usa ela pra criptografar a mensagem (gerando a chave de sessão)
     * 5. Alice criptografa a mensagem usando a chave de sessão
     * 6. Alice usa a chave pública recebida de Bob para criptografar a chave simétrica (chave de sessão) 
     * 7. Alice cria o seu par de chaves para a assinatura digital (pública e privada) (criptografia assimétrica) 
     * 8. Alice gera um hash da mensagem que vai enviar para Bob
     * 9. Alice usa sua chave privada que criou no passo 5 pra criptografar o hash da mensagem
     * 10. Alice envia para Bob a mensagem criptografada com a chave simétrica, a chave simétrica criptografada com a chave pública de Bob (chave de sessão), o hash criptografado da mensagem, e a sua chave pública que ela criou no passo 5
     * 11. Bob recebe tudo isso
     * 12. Bob usa a chave pública que Alice enviou pra descriptografar o hash da mensagem dela
     * 13. Bob usa a sua chave privada criada no passo 1 pra descriptografar a chave de sessão
     * 14. Bob usa a chave de sessão pra descriptografar a mensagem de Alice
     * 15. Bob gera um hash da mensagem que Alice enviou
     * 16. Bob compara os hashs e verifica se são iguais (verificação da assinatura). Se forem iguais, foi garantida a integridade
     */

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, ClassNotFoundException {
        //passo 3:
        System.out.println("[ALICE] Aguardando conexão na porta 8090...");

        ServerSocket serverSocket = new ServerSocket(8090);
        Socket socket = serverSocket.accept();

        System.out.println("[ALICE] Conexão recebida");

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



            //passo 7: Alice gera o seu par de chaves para a assinatura digital
            System.out.println("7: [ALICE] Criando par de chaves crito assimétrica para Assinatura digital...");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair parChavesAssinaturaDigital = keyPairGenerator.generateKeyPair();



            //passo 8: gera um hash da mensagem que vai enviar para Bob
            System.out.println("8: [ALICE] Gerando hash do conteúdo do arquivo...");
            MessageDigest digest = MessageDigest.getInstance("SHA256");
            byte[] hash = digest.digest(bytesArquivo);


            //passo 9: Alice criptografa o hash da mensagem com sua chave privada
            System.out.println("9: [ALICE] Gerando Assinatura digital: Criptografando hash gerado com a chave privada gerada no passo 7...");
            Cipher cipherRSA_Assinatura = Cipher.getInstance("RSA");
            cipherRSA_Assinatura.init(Cipher.ENCRYPT_MODE, parChavesAssinaturaDigital.getPrivate());
            byte[] hashCriptografado = cipherRSA_Assinatura.doFinal(hash);
            

            //passo 10: envia os dados para bob. envia a mensagem, o hash criptografado, a chave pública correspondente e o algoritmo são todos enviados. Isso é classificado como uma mensagem com assinatura digital.
            System.out.println("10: [ALICE] Enviando para Bob a mensagem, a chave de sessão criptografada, o hash criptografado e a chave pública de Alice para descriptografar o hash");
            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografado(textoCifrado);
            objetoTroca.setNomeArquivo(f.getName());
            objetoTroca.setChaveSessaoCriptografada(chaveSessaoCifrada);
            objetoTroca.setHashCriptografado(hashCriptografado);
            objetoTroca.setChavePublicaAssinaturaDigital(parChavesAssinaturaDigital.getPublic());

            ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
            oout.writeObject(objetoTroca);
        }

        serverSocket.close();
    }


    public static class ObjetoTroca implements Serializable {
        private String nomeArquivo;
        private byte[] arquivoCriptografado;
        private byte[] chaveSessaoCriptografada;
        private byte[] hashCriptografado; //assinatura digital
        private PublicKey chavePublicaAssinaturaDigital; //chave pública para descriptografar hash criptografado

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
        public PublicKey getChavePublicaAssinaturaDigital() {
            return chavePublicaAssinaturaDigital;
        }
        public void setChavePublicaAssinaturaDigital(PublicKey chavePublicaAssinaturaDigital) {
            this.chavePublicaAssinaturaDigital = chavePublicaAssinaturaDigital;
        }
        public byte[] getChaveSessaoCriptografada() {
            return chaveSessaoCriptografada;
        }
        public void setChaveSessaoCriptografada(byte[] chaveSessaoCriptografada) {
            this.chaveSessaoCriptografada = chaveSessaoCriptografada;
        }
        public byte[] getHashCriptografado() {
            return hashCriptografado;
        }
        public void setHashCriptografado(byte[] hashCriptografado) {
            this.hashCriptografado = hashCriptografado;
        }
    }

}
