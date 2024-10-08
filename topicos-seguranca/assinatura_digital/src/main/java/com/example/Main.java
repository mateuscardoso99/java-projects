package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;

/*
    Assinatura digital é baseada em criptografia assimétrica.
 *  Assinatura Digital é uma técnica para garantir:

        - Integridade: a mensagem não foi alterada durante o transporte
        - Autenticidade: o autor da mensagem é realmente quem ele afirma ser
        - Não repúdio: o autor da mensagem não pode negar posteriormente que foi a fonte


    Tecnicamente falando, uma assinatura digital é um hash criptografado (digest, checksum) de uma mensagem, arquivo, email etc... 
    Isso significa que geramos um hash de uma mensagem e o criptografamos com uma chave privada de acordo com um algoritmo escolhido.
    A mensagem, o hash criptografado, a chave pública correspondente e o algoritmo são todos enviados. Isso é classificado como uma mensagem com assinatura digital.


    O hash unidirecional nada mais é do que um longo número de comprimentos fixos. Ele tem as seguintes características:
        - O valor de hash é único.
        - Qualquer alteração nos dados (mesmo modificar ou alterar um único caractere) resulta em um valor diferente .
        - O conteúdo dos dados hash não pode ser usado para outros propósitos. Então, é chamado de hash unidirecional.


    Para verificar a assinatura digital, o receptor da mensagem gera um novo hash da mensagem recebida, descriptografa o hash criptografado recebido usando a chave pública e os compara. 
    Se eles corresponderem, a Assinatura Digital é considerada verificada.


    Devemos notar que criptografamos apenas o hash da mensagem, e não a mensagem em si. Em outras palavras, a Assinatura Digital não tenta manter a mensagem em segredo. Nossa assinatura digital apenas prova que a mensagem não foi alterada em trânsito.
    Quando a assinatura é verificada, temos certeza de que somente o proprietário da chave privada pode ser o autor da mensagem .


    Em Java, a API de segurança JDK é usada para criar e implementar assinaturas digitais.


    Assinatura Digital é o mesmo que uma assinatura manuscrita, selo ou carimbo


    A chave pública é compartilhada entre todos aqueles que precisam validar a assinatura. Enquanto a chave privada não é compartilhada de forma alguma. Ela é usada apenas pelo signatário para assinar digitalmente uma mensagem ou documento.
    

    Autoridade Certificadora (CA): São organizações confiáveis ​​e amplamente reconhecidas por garantir a segurança de chaves e certificados digitais.
    Certificado Digital: O certificado digital contém a chave pública e também especifica a identidade associada à chave. Normalmente, os certificados são emitidos por autoridades confiáveis ​​que são válidos por um período.


    UM INDIVÍDUO QUE CRIA A ASSINATURA DIGITAL USA UMA CHAVE PRIVADA QUE CRIPTOGRAFA DADOS RELACIONADOS À ASSINATURA. 
    AQUELE QUE RECEBE OS DADOS ASSINADOS DIGITALMENTE USA A CHAVE PÚBLICA DO SIGNATÁRIO, QUE É A ÚNICA MANEIRA DE DESCRIPTOGRAFAR OS DADOS.

    Se o destinatário não conseguir abrir o documento ou a mensagem com a chave pública do signatário, isso significa que há um problema com o documento ou a assinatura.


    O mecanismo de assinatura digital exige que todas as partes acreditem que o indivíduo que cria a assinatura mantém a chave privada em segredo. 
    Na remota hipótese de outra pessoa acessar a chave de marcação privada, essa parte pode criar assinaturas digitais fraudulentas em nome do detentor da chave privada.
 * 
 */


//KEYPAIRGENERATOR VS KEYSTORE
//KeyPairGenerator é usado para gerar novas chaves, enquanto KeyStore é usado para armazenar e gerenciar estas chaves e seus certificados de maneira segura.
//KeyPairGenerator é voltado para a criação de chaves, enquanto KeyStore é voltado para a persistência e organização de chaves e certificados em um repositório seguro.
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, IOException, SignatureException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");

        KeyPair pair = keygen.generateKeyPair();   
        PrivateKey privateKey = pair.getPrivate(); //generates private key  
        PublicKey publicKey = pair.getPublic();  //generates public key  

        //Normalmente, usamos a classe MessageDigest com SHA ou MD5 para hash e a classe Cipher para criptografia.
        byte[] messageBytes = "Hello world".getBytes();

        //gerando hash
        MessageDigest md = MessageDigest.getInstance("SHA-256"); //Aqui, usamos o algoritmo SHA-256, que é o mais comumente usado. Outras alternativas são MD5, SHA-384 e SHA-512.
        byte[] messageHash = md.digest(messageBytes);

        //codificação de caracteres:
        //É necessário codificar o valor hash da mensagem a ser assinada. Podemos fazer isso com a classe DigestInfo:
        DigestAlgorithmIdentifierFinder hashAlgorithmFinder = new DefaultDigestAlgorithmIdentifierFinder();
        AlgorithmIdentifier hashingAlgorithmIdentifier = hashAlgorithmFinder.find("SHA-256");
        DigestInfo digestInfo = new DigestInfo(hashingAlgorithmIdentifier, messageHash);
        byte[] hashToEncrypt = digestInfo.getEncoded();

        //Criptografando o Hash Gerado
        //Para criptografar uma mensagem, precisamos de um algoritmo e uma chave privada. Aqui usaremos o algoritmo RSA . O algoritmo DSA é outra opção.

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptedMessageHash = cipher.doFinal(hashToEncrypt);
        //Neste ponto, a mensagem, a assinatura digital, a chave pública e o algoritmo são todos enviados, e o receptor pode usar essas informações para verificar a integridade da mensagem.




        //VERIFICANDO A ASSINATURA
        //Quando recebemos uma mensagem, precisamos verificar sua assinatura. Para isso, deciframos o hash criptografado recebido e o comparamos com um hash que fazemos da mensagem recebida.

        Cipher cipher2 = Cipher.getInstance("RSA");
        cipher2.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedMessageHash = cipher2.doFinal(encryptedMessageHash);

        //Em seguida, geramos um novo hash de mensagem a partir da mensagem recebida:

        byte[] messageBytes2 = "Hello world".getBytes();

        MessageDigest md2 = MessageDigest.getInstance("SHA-256");
        byte[] newMessageHash = md2.digest(messageBytes2);

        //Em seguida, calculamos o valor de hash codificado:
        DigestAlgorithmIdentifierFinder hashAlgorithmFinder2 = new DefaultDigestAlgorithmIdentifierFinder();
        AlgorithmIdentifier hashingAlgorithmIdentifier2 = hashAlgorithmFinder2.find("SHA-256");
        DigestInfo digestInfo2 = new DigestInfo(hashingAlgorithmIdentifier2, newMessageHash);
        byte[] hashToEncrypt2 = digestInfo2.getEncoded();

        //E, finalmente, verificamos se o hash da mensagem recém-gerada corresponde ao descriptografado:
        boolean isCorrect = Arrays.equals(decryptedMessageHash, hashToEncrypt2);
        System.out.println(isCorrect ? "ASSINATURA É VALIDA" : "ASSINATURA INVÁLIDA");










        //----------------------------------------------------------------------------------------






        //OUTRA FORMA DE ASSINAR USANDO CLASSE SIGNATURE:

        KeyPairGenerator keygen2 = KeyPairGenerator.getInstance("DSA", "SUN"); //DSA = (Algoritmo de Assinatura Digital). SUN é o provedor padrão integrado ao JDK

        KeyPair pair2 = keygen2.generateKeyPair();   
        PrivateKey privateKey2 = pair2.getPrivate(); //generates private key  
        PublicKey publicKey2 = pair2.getPublic();  //generates public key  
        

        //Para DSA, o tamanho da chave é 1024. Então, definirá o tamanho da chave para 1024. 
        //Outro parâmetro de aleatoriedade deve ser a instância da classe SecureRandom. Ele fornece um gerador de números aleatórios (RNG) criptograficamente forte
        //Ele usa o algoritmo SHA1PRNG fornecido pelo provedor SUN integrado.
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");   
        keygen2.initialize(1024, random); //generate key pair  

        //O algoritmo de assinatura que escolhemos, SHA256withRSA neste exemplo , é uma combinação de um algoritmo de hash e um algoritmo de criptografia. Outras alternativas incluem SHA1withRSA , SHA1withDSA e MD5withRSA , entre outros.
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey2);


        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();


        //VERIFICANDO A ASSINATURA
        Signature signature2 = Signature.getInstance("SHA256withDSA");
        signature2.initVerify(publicKey2);


        //precisamos adicionar os bytes da mensagem recebida ao objeto de assinatura invocando o método de UPDATE():
        signature2.update(messageBytes);

        //finalmente, podemos verificar a assinatura chamando o método verify :
        isCorrect = signature2.verify(digitalSignature);
        System.out.println(isCorrect ? "ASSINATURA É VALIDA" : "ASSINATURA INVÁLIDA");


    }
}
