package br.ufsm.poli.csi.cripto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*
 * Implementar a troca de arquivos entre Bob-Alice com troca de chave simétrica através do algoritmo de Diffie-Hellman. 
 * O algoritmo deve ser implementado com o Util.java para a geração dos números "q" e "a" e não deve ser usado cipher RSA nem DH, apenas o cipher AES para cifrar o arquivo após a troca de chaves com o Diffie-Hellman.
 */
public class Bob {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //PASSO 1: Bob gera Q, A e X
        System.out.println("[BOB] Gerando Q, A e X.");

        BigInteger[] qa = Util.geraQA(256);
        BigInteger x = Util.geraNumeroMenorQue(qa[0]);







        //PASSO 2: Bob gera sua chave pública e envia para Alice
        System.out.println("[BOB] Gerando chave pública (Ya)...");

        BigInteger chavePublica = Util.power(qa[1], x, qa[0]);

        TrocaDiffieHellman diffieHellman = new TrocaDiffieHellman();
        diffieHellman.setQ(qa[0]);
        diffieHellman.setA(qa[1]);
        diffieHellman.setChavePublica(chavePublica);

        System.out.println("[BOB] Enviando Q, A e a Chave Pública (Ya) para Alice.");
        
        Socket socket = new Socket("localhost", 8090);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(diffieHellman);









        //PASSO 6: Bob aguarda Alice enviar sua chave pública
        //ServerSocket serverSocket = new ServerSocket(8091);
        System.out.println("[BOB] Aguardando conexão na porta 8091.");

        //socket = serverSocket.accept();
        System.out.println("[BOB] Conexão recebida.");

        ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
        TrocaDiffieHellman recebeChavePublica = (TrocaDiffieHellman) oin.readObject();

        System.out.println("[BOB] Recebida a Chave Pública (Yb) de Alice.");
        





    



        //PASSO 8: Bob calcula o valor de K baseado na chave de alice
        System.out.println("[BOB] Calculando o valor de K baseado na Chave Pública (Yb) recebida de Alice.");

        BigInteger k = Util.power(recebeChavePublica.getChavePublica(), x, qa[0]);

        byte[] kToByteArray = k.toByteArray();

        if(kToByteArray.length > 32){
            System.out.println("[BOB] bytes de K maior que 32, causa erro ao gerar a chave, convertendo pra length = 32");
            byte[] aux = new byte[32];
            System.arraycopy(kToByteArray, 1, aux, 0, 32);
            kToByteArray = aux;
        }







        //Com o K calculado, Bob pode gerar a sua chave secreta
        System.out.println("[BOB] Gerando a Chave secreta simétrica com base no valor de K calculado.");

        Cipher cipherAES = Cipher.getInstance("AES");
        SecretKey keyAES = new SecretKeySpec(kToByteArray, "AES");
        System.out.println("[BOB] CHAVE SIMÉTRICA GERADA");







        //Bob recebe o arquivo cifrado, descriptografa com sua chave secreta que foi gerada apartir de K
        //não há envio da chave, cada lado gera sua chave baseado no seu próprio valor de K
        oin = new ObjectInputStream(socket.getInputStream());

        System.out.println("[BOB] Arquivo criptografado recebido de Alice.");

        ObjetoTroca objetoTroca = (ObjetoTroca) oin.readObject();
        cipherAES.init(Cipher.DECRYPT_MODE, keyAES);

        System.out.println("[BOB] Descriptografando arquivo...");

        byte[] textoPlano = cipherAES.doFinal(objetoTroca.getArquivoCriptografado());

        System.out.println("[BOB] Texto plano decifrado: " + new String(textoPlano, "UTF8"));

        socket.close();
    }


}
