package br.ufsm.poli.csi.cripto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*
 * Implementar a troca de arquivos entre Bob-Alice com troca de chave simétrica através do algoritmo de Diffie-Hellman. 
 * O algoritmo deve ser implementado com o Util.java para a geração dos números "q" e "a" e não deve ser usado cipher RSA nem DH, apenas o cipher AES para cifrar o arquivo após a troca de chaves com o Diffie-Hellman.
 */

/*
 * Diffie-Hellman: 
 * – Primeiro esquema do tipo chave pública proposto; 
 * – Método prático para troca de chave secreta; 
 * – Usado na maioria dos produtos comerciais; 
 * – Segurança provida pela dificuldade de computação de logaritmos discretos.
 */
public class Alice {

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, ClassNotFoundException {
        //PASSO 3: Alice aguarda Bob enviar Q, A e sua chave pública
        ServerSocket serverSocket = new ServerSocket(8090);

        System.out.println("[ALICE] Aguardando conexão na porta 8090.");

        Socket socket = serverSocket.accept();

        System.out.println("[ALICE] Conexão recebida.");

        ObjectInputStream ooi = new ObjectInputStream(socket.getInputStream());
        TrocaDiffieHellman diffieHellman = (TrocaDiffieHellman) ooi.readObject();

        System.out.println("[ALICE] Recebido Q, A e a Chave Pública (Ya) de Bob.");









        //PASSO 4: Alice vai gerar sua chave pública baseado no Q e A recebidos de Bob
        System.out.println("[ALICE] Gerando chave pública (Yb) ...");

        BigInteger x = Util.geraNumeroMenorQue(diffieHellman.getQ());
        BigInteger chavePublica = Util.power(diffieHellman.getA(), x, diffieHellman.getQ());









        //PASSO 5: Alice então envia sua chave pública para Bob
        System.out.println("[ALICE] Enviando Chave Pública (Yb) gerada para Bob...");

        TrocaDiffieHellman enviarChavePublica = new TrocaDiffieHellman();
        enviarChavePublica.setChavePublica(chavePublica);

        //socket = new Socket("localhost", 8091);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(enviarChavePublica);









        //PASSO 7: Alice calcula o valor de K baseado na chave publica recebida de Bob
        System.out.println("[ALICE] Calculando o valor de K baseado na Chave Pública (Ya) recebida de Bob.");

        BigInteger k = Util.power(diffieHellman.getChavePublica(), x, diffieHellman.getQ());

        byte[] kToByteArray = k.toByteArray();

        //as vezes o byteArray de K fica maior que 32 bytes quando passado 256 bits de comprimento em Util.geraQA(256);
        //os bytes extra pode ser relativo ao sinal (positivo ou negativo)
        //https://stackoverflow.com/questions/17758905/converting-a-biginteger-into-a-key
        //causando erro de InvalidKeyException ao gerar a chave AES
        if(kToByteArray.length > 32){
            System.out.println("[ALICE] bytes de K maior que 32, causa erro ao gerar a chave, convertendo pra length = 32");
            byte[] aux = new byte[32];
            System.arraycopy(kToByteArray, 1, aux, 0, 32);
            kToByteArray = aux;
        }










        //Com o K calculado, Alice pode gerar a sua chave secreta
        System.out.println("[ALICE] Gerando a Chave secreta simétrica com base no valor de K calculado.");

        Cipher cipherAES = Cipher.getInstance("AES");
        SecretKey keyAES = new SecretKeySpec(kToByteArray, "AES");
        System.out.println("[ALICE] CHAVE SIMÉTRICA GERADA");
        




        


        System.out.println("[ALICE] Selecionando arquivo");

        JFileChooser fc = new JFileChooser("");
        if (fc.showDialog(new JFrame(), "OK") == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            FileInputStream fin = new FileInputStream(file);
            byte[] bytesDoArquivo = new byte[(int) fin.getChannel().size()];
            fin.read(bytesDoArquivo);
            
            
            System.out.println("[ALICE] Arquivo selecionado");


            //Alice criptografa o arquivo com sua chave secreta
            cipherAES.init(Cipher.ENCRYPT_MODE, keyAES);
            byte[] textoCifrado = cipherAES.doFinal(bytesDoArquivo);


            System.out.println("[ALICE] Texto cifrado: " + new String(textoCifrado, "UTF8"));


            //Alice envia para Bob o arquivo criptografado, não envia a chave secreta, Bob vai descriptografar usando a sua chave secreta baseado no seu próprio K
            System.out.println("[ALICE] Enviando arquivo cifrado para Bob...");

            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografado(textoCifrado);
            objetoTroca.setNomeArquivo(file.getName());

            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(objetoTroca);
            socket.close();
            fin.close();

        }
    }

}
