package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;

/**
 * Certificado Autoassinado:
        - certificado autoassinado é um certificado digital assinado pela própria entidade que o cria, ao invés de ser assinado por uma autoridade externa.
        - Geralmente utilizado para testes internos, desenvolvimento ou situações em que a confiança não é uma preocupação primordial.
        - Como a assinatura é gerada pela própria entidade, não há validação de identidade externa. Portanto, quem recebe o certificado precisa confiar manualmente nesse certificado, o que pode ser problemático em um ambiente público ou na internet.
        - Navegadores e sistemas podem emitir avisos de segurança ao encontrar um certificado autoassinado, pois não podem verificar sua autenticidade.



 * Certificado Assinado por CA:
        - certificado digital que foi verificado e assinado por uma autoridade certificadora confiável.
        - Usado amplamente em ambientes de produção, como em sites HTTPS, e-commerce, e outras situações onde a segurança e confiabilidade são essenciais.
        - A CA faz a verificação da identidade do solicitante antes de emitir o certificado, proporcionando um nível de confiança maior para quem o recebe.
        - Certificados assinados por CA são amplamente aceitos e não geram avisos em navegadores, desde que a CA seja reconhecida como confiável.
        - têm um custo associado, que varia de acordo com a autoridade e o tipo de certificado.




 * diferença entre usar chaves de criptografia com e sem certificado:
        - Quando utiliza chaves sem certificados, as chaves públicas devem ser compartilhadas manualmente ou de alguma outra forma que não envolva um sistema de certificação. Isso pode levar a problemas de autenticidade, pois não há garantia de que a chave pública realmente pertence à entidade que diz ser.
        - Sem um certificado, um atacante pode potencialmente interceptar e fornecer sua própria chave pública para a comunicação que se parece ser de uma fonte confiável, permitindo a interceptação de mensagens (ataque de Man-in-the-Middle).
        - A gestão de chaves pode ser mais complexa, pois não há uma infraestrutura padrão para validar ou revogar chaves

        - Quando as chaves públicas são usadas em conjunto com certificados digitais, um Certificado de Autoridade (CA) assina essas chaves, garantindo sua autenticidade. Isso significa que você pode confiar que a chave pública realmente pertence à entidade que a representa.
        - O uso de certificados geralmente se insere em uma Infraestrutura de Chaves Públicas (PKI), que fornece uma estrutura para emissão, revogação e gestão de certificados. Isso ajuda a criar um ambiente mais seguro e confiável.
        - Como as chaves públicas são assinadas e verificáveis, isso reduz o risco de ataques de Man-in-the-Middle e outros problemas relacionados à autenticidade.
        - O uso de certificados pode simplificar a experiência do usuário, já que muitos sistemas e aplicações podem validar automaticamente certificados de autoridade confiáveis.



 * Certificado Digital e Identidade de Chave Pública:
        - Um certificado é um documento que associa uma identidade a uma determinada chave pública. Os certificados são assinados por uma entidade de terceiros chamada Certificate Authority (CA).

    Sabemos que se o hash que deciframos com a chave pública publicada corresponder ao hash real, então a mensagem é assinada. 
    No entanto, como sabemos que a chave pública realmente veio da entidade certa? Isso é resolvido pelo uso de certificados digitais.


    Um Certificado Digital contém uma chave pública e é ele próprio assinado por outra entidade. 
    A assinatura dessa entidade pode ser verificada por outra entidade e assim por diante. Acabamos tendo o que chamamos de cadeia de certificados. 
    Cada entidade de nível superior certifica a chave pública da próxima entidade. A entidade de nível mais alto é autoassinada, o que significa que sua chave pública é assinada por sua própria chave privada.
    
    O X.509 é o formato de certificado mais usado, e é enviado como formato binário (DER) ou formato de texto (PEM). 
    O JCA já fornece uma implementação para isso por meio da classe X509Certificate.






 * Para criar um par de chaves privada e pública com certificados, usaremos o Java keytool.
        - Vamos gerar um par de chaves para o remetente usando o comando genkeypair:
                - keytool -genkeypair -alias remetenteKeyPar -keyalg RSA -keysize 2048 -dname "CN=Baeldung" -validity 365 -storetype JKS -keystore remetente_keystore.jks -storepass minhasenha

        - Isso cria uma chave privada e sua chave pública correspondente para nós. A chave pública é encapsulada em um certificado autoassinado X.509 que é encapsulado por sua vez em uma cadeia de certificados de elemento único. Armazenamos a cadeia de certificados e a chave privada no arquivo Keystore remetente_keystore.jks , que podemos processar usando a KeyStore API .
        - Aqui, usamos o formato de key store JKS. Além disso, devemos lembrar da senha e do alias, pois os usaremos na próxima subseção ao carregar o arquivo Keystore.
 
 
        PUBLICAR CHAVE PÚBLICA: 
            - Antes de podermos publicar a chave pública, precisamos primeiro decidir se usaremos um certificado autoassinado ou um certificado assinado por uma CA.
            - Ao usar um certificado autoassinado, precisamos apenas exportá-lo do arquivo Keystore. Podemos fazer isso com o comando exportcert :
                    - keytool -exportcert -alias remetenteKeyPar -storetype JKS -keystore remetente_keystore.jks -file remetente_certificate.cer -rfc -storepass minhasenha

            - Caso contrário, se formos trabalhar com um certificado assinado por CA, então precisamos criar uma solicitação de assinatura de certificado (CSR) . Fazemos isso com o comando certreq :
                    - keytool -certreq -alias remetenteKeyPar -storetype JKS -keystore remetente_keystore.jks -file -rfc -storepass minhasenha > remetente_certificate.csr
            - O arquivo CSR, remetente_certificate.csr, é então enviado para uma Autoridade Certificadora para fins de assinatura. Quando isso for feito, receberemos uma chave pública assinada encapsulada em um certificado X.509, em formato binário (DER) ou texto (PEM). Aqui, usamos a opção "-rfc" para um formato PEM.
            
            - A chave pública que recebemos da CA, remetente_certificate.cer, agora foi assinada por uma CA e pode ser disponibilizada para clientes.

 




 * Carregando uma chave pública para verificação:
            - No lado do receptor, precisamos de um arquivo Keystore para armazenar a chave pública. Vamos criar um Keystore vazio:
                    - keytool -delete -alias receptorKeyPair -storepass minhasenha -keystore receptor_keystore.jks 
                    - keytool -genkeypair -alias receptorKeyPair -keyalg RSA -keysize 2048 -dname "CN=Baeldung" -validity 365 -storetype JKS -keystore receptor_keystore.jks -storepass minhasenha 

            - Tendo acesso à chave pública, um receptor pode carregá-la em seu Keystore usando o comando importcert:
                    - keytool -importcert -alias importReceptorKeyPair -storetype JKS -keystore receptor_keystore.jks -file remetente_certificate.cer -rfc -storepass minhasenha
 */
public class Main {
    public static void main(String[] args) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        //Usando a API KeyStore e o arquivo remetente_keystore.jks, podemos obter um objeto PrivateKey :
        KeyStore keyStorePrivateKey = KeyStore.getInstance("JKS");
        keyStorePrivateKey.load(new FileInputStream("remetente_keystore.jks"), "minhasenha".toCharArray());
        PrivateKey privateKey = (PrivateKey) keyStorePrivateKey.getKey("remetenteKeyPar", "minhasenha".toCharArray());


        //usando a API KeyStore como antes, podemos obter uma instância PublicKey :
        KeyStore keyStorePublicKey = KeyStore.getInstance("JKS");
        keyStorePublicKey.load(new FileInputStream("receptor_keystore.jks"), "minhasenha".toCharArray());
        Certificate certificate = keyStorePublicKey.getCertificate("importReceptorKeyPair");
        PublicKey publicKey = certificate.getPublicKey();

        //Agora que temos uma instância da PrivateKey no lado do remetente e uma instância da PublicKey no lado do destinatário, podemos iniciar o processo de assinatura e verificação.
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
    }
}
