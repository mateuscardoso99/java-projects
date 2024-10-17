package br.ufsm.poli.csi.cripto.assimetrico;

import javax.crypto.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Alice {

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, ClassNotFoundException {

        JFileChooser fc = new JFileChooser("");
        System.out.println("Selecionando arquivo");
        if (fc.showDialog(new JFrame(), "OK") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            FileInputStream fin = new FileInputStream(f);
            byte[] bArray = new byte[(int) fin.getChannel().size()];
            fin.read(bArray);
            System.out.println("Arquivo selecionado");
            Socket s = new Socket("localhost", 5555);

            ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
            PublicKey publicKey = (PublicKey) oin.readObject();//recebe a chave publica de bob

            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] textoCifrado = cipherRSA.doFinal(bArray); //usa a chave publica recebida pra criptografar a mensagem

            ObjetoTroca objetoTroca = new ObjetoTroca();
            objetoTroca.setArquivoCriptografado(textoCifrado);
            objetoTroca.setNomeArquivo(f.getName());

            ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
            oout.writeObject(objetoTroca);
            s.close();

        }
    }

}
