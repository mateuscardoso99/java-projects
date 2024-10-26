package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.example.Alice.ObjetoTroca;

/*
 * Implementar o envio de arquivo entre Alice e Bob com garantia de confidencialidade e integridade. Pode ser usado qualquer dos algoritmos vistos (chave de sessão ou DH - MAC ou assinatura).
 */

//CONFIDENCIALIDADE: garantido pela criptografia, pra criptografar se usa a chave pública e a chave privada pra descriptografar
//INTEGRIDADE: garantido pela assinatura digital, pra criptografar se usa a chave privada e a chave pública pra descriptografar
public class Bob {
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


    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException, UnknownHostException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //passo 1
        System.out.println("1: [BOB] Criando par de chaves crito assimétrica para critografar/descriptografar a chave de sessão...");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair parChaves = keyPairGenerator.generateKeyPair();

        
        //passo 2
        System.out.println("2: [BOB] Enviando para Alice a chave pública gerada no passo anterior...");
        Socket socket = new Socket("localhost", 8090);
        ObjectOutputStream ou = new ObjectOutputStream(socket.getOutputStream());
        ou.writeObject(parChaves.getPublic());



        //passo 11
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
        System.out.println("11: [BOB] Recebido de Alice a mensagem, a chave de sessão criptografada, o hash criptografado e a chave pública de Alice para descriptografar o hash");
        ObjetoTroca objetoTroca = (ObjetoTroca) oi.readObject();


        //passo 12
        System.out.println("12: [BOB] Descriptografando o hash da mensagem com a chave pública enviada por Alice...");
        PublicKey chavePublicaAliceAssinaturaDigital = objetoTroca.getChavePublicaAssinaturaDigital();
        Cipher cipherRSA_AssinaturaDigital = Cipher.getInstance("RSA");
        cipherRSA_AssinaturaDigital.init(Cipher.DECRYPT_MODE, chavePublicaAliceAssinaturaDigital);
        byte[] hashDescriptografado = cipherRSA_AssinaturaDigital.doFinal(objetoTroca.getHashCriptografado());


        //passo 13
        System.out.println("13: [BOB] Descriptografando a chave de sessão com a minha chave privada gerada no passo 1...");
        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, parChaves.getPrivate());
        byte[] chaveSessaoDescriptografada = cipherRSA.doFinal(objetoTroca.getChaveSessaoCriptografada());


        //passo 14
        System.out.println("14: [BOB] Descriptografando a mensagem de Alice com a chave de sessão...");
        Cipher cipherAES = Cipher.getInstance("AES");
        SecretKey chaveSessao = new SecretKeySpec(chaveSessaoDescriptografada, "AES");
        cipherAES.init(Cipher.DECRYPT_MODE, chaveSessao);
        byte[] mensagemAliceDescriptografada = cipherAES.doFinal(objetoTroca.getArquivoCriptografado());


        //passo 15
        System.out.println("15: [BOB] Gerando hash do conteúdo da mensagem de Alice...");
        MessageDigest digest = MessageDigest.getInstance("SHA256");
        byte[] hash = digest.digest(mensagemAliceDescriptografada);


        //passo 16
        System.out.println("16: [BOB] Comparando o hash gerado com o hash enviado por Alice...");
        boolean saoIguais = Arrays.equals(hash, hashDescriptografado);

        if(!saoIguais){
            System.out.println("[BOB] HASHS NÃO SÃO IGUAIS. ASSINATURA INVÁLIDA");
        }
        else{
            System.out.println("[BOB] ASSINATURA É VÁLIDA. HASHS SÃO IGUAIS. INTEGRIDADE GARANTIDA");
            System.out.println("[BOB] MENSAGEM DE ALICE DESCRIPTOGRAFADA: " + new String(mensagemAliceDescriptografada, "UTF8"));
        }

        socket.close();
    }

}
