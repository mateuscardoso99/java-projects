package br.ufsm.poli.csi.cripto;

import javax.crypto.*;
import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Alice {

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(5560);
        System.out.println("[ALICE] Aguardando conexão na porta 5560.");
        Socket socket = ss.accept();
        System.out.println("[ALICE] Conexão recebida.");
  
        //recebe a chave publica de bob
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
        EnvioChavePublica ei = (EnvioChavePublica) oi.readObject();

        JFileChooser fc = new JFileChooser("");
        System.out.println("Selecionando arquivo");

        if (fc.showDialog(new JFrame(), "OK") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            FileInputStream fin = new FileInputStream(f);
            byte[] bArray = new byte[(int) fin.getChannel().size()];
            fin.read(bArray);
            System.out.println("Arquivo selecionado");

            //criptografa o arquivo com cripto simétrica
            Cipher cipherAES = Cipher.getInstance("AES");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey keyAES = keyGenerator.generateKey();
            cipherAES.init(Cipher.ENCRYPT_MODE, keyAES);

            byte[] textoCifrado = cipherAES.doFinal(bArray);

            Socket s = new Socket("localhost", 5555);
            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografiaSimetrica(textoCifrado);

            //critpografa a chave simetrica com cripto assimétrica (essa é a chave de sessão)
            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.ENCRYPT_MODE, ei.getPublicKey());
            cipherRSA.update(keyAES.getEncoded());
            byte[] chaveSimetricaCriptografada = cipherRSA.doFinal();

            objetoTroca.setChaveSimetricaCriptografada(chaveSimetricaCriptografada);

            objetoTroca.setNomeArquivo(f.getName());

            //envia para bob
            ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
            oout.writeObject(objetoTroca);
            s.close();


        }
    }

}
