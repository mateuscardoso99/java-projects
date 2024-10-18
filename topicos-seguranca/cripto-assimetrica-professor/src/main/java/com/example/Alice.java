package br.ufsm.poli.csi.cripto.assimetrico;

import lombok.SneakyThrows;

import javax.crypto.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/*
– Chave de sessão: 
    chave simétrica é cifrada com cripto assimétrica
    Uma chave simétrica é escolhida para codificar uma sessão; 
    RSA é utilizado para troca da chave simétrica de forma segura; 
    Durante a sessão é utilizado um algoritmo rápido de criptografia como DES, 3DES ou AES (https).
*/
public class Alice {

    @SneakyThrows
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        JFileChooser fc = new JFileChooser("");
        System.out.println("Selecionando arquivo");
        if (fc.showDialog(new JFrame(), "OK") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            FileInputStream fin = new FileInputStream(f);
            byte[] bArray = new byte[(int) fin.getChannel().size()];
            fin.read(bArray);
            System.out.println("Arquivo selecionado");

            //cria a chave de sessão
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256);
            SecretKey chaveSessao = kg.generateKey();

            //inicia conexao com o Bob e recebe a sua chave pública
            Socket s = new Socket("localhost", 5555);
            ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
            ObjetoTroca objetoChave = (ObjetoTroca) oin.readObject();

            //criptografa o arquivo com a chave de sessão e criptografa a chave de sessão com a chave publica do Bob
            Cipher cipherRSA = Cipher.getInstance("RSA");
            Cipher cipherAES = Cipher.getInstance("AES");
            cipherRSA.init(Cipher.ENCRYPT_MODE, objetoChave.getKey());
            cipherAES.init(Cipher.ENCRYPT_MODE, chaveSessao);
            byte[] chaveSessaoCifrada = cipherRSA.doFinal(chaveSessao.getEncoded());
            byte[] textoCifrado = cipherAES.doFinal(bArray);

            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografado(textoCifrado);
            objetoTroca.setNomeArquivo(f.getName());
            objetoTroca.setChaveSessao(chaveSessaoCifrada);

            //envia arquivo
            ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
            oout.writeObject(objetoTroca);
            s.close();


        }
    }

}
