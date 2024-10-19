package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.example.Alice.ObjetoTroca;

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
public class Bob {
    
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
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
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


        //passo 9
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
        System.out.println("9: [BOB] Recebido de Alice a mensagem criptografada com a chave simétrica, a chave simétrica criptografada com a chave pública de Bob (chave de sessão), e o hash HMAC da mensagem + segredo");
        ObjetoTroca objetoTroca = (ObjetoTroca) oi.readObject();


        //passo 10
        System.out.println("10: [BOB] Descriptografando a chave de sessão com a minha chave privada gerada no passo 1...");
        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, parChaves.getPrivate());
        byte[] chaveSessaoDescriptografada = cipherRSA.doFinal(objetoTroca.getChaveSessaoCriptografada());


        //passo 11
        System.out.println("11: [BOB] Descriptografando a mensagem de Alice com a chave de sessão...");
        Cipher cipherAES = Cipher.getInstance("AES");
        SecretKey chaveSessao = new SecretKeySpec(chaveSessaoDescriptografada, "AES");
        cipherAES.init(Cipher.DECRYPT_MODE, chaveSessao);
        byte[] mensagemAliceDescriptografada = cipherAES.doFinal(objetoTroca.getArquivoCriptografado());


        //passo 12: gera um hash HMAC da mensagem + segredo
        System.out.println("12: [BOB] Gerando hash HMAC da mensagem + segredo...");
        Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(Segredo.SEGREDO.getBytes(), "HmacSHA256");
        hmacSHA256.init(secretKeySpec);
        byte[] hashHmacGerado = hmacSHA256.doFinal(mensagemAliceDescriptografada);

        System.out.println("[BOB]: HASH HMAC GERADO: " + new String(hashHmacGerado, "UTF8"));
        System.out.println("[BOB]: HASH HMAC GERADO Base64: " + Base64.getEncoder().encodeToString(hashHmacGerado));



        //passo 13: Bob compara os hashs e verifica se são iguais
        System.out.println("13: [BOB] Comparando o hash HMAC gerado com o hash HMAC enviado por Alice...");
        boolean saoIguais = Arrays.equals(hashHmacGerado, objetoTroca.getHashHMAC());//comparação deve ser feita nos bytes do hash

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
