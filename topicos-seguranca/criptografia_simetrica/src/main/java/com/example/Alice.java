package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

//alice vai escolher um arquivo, criptografar e enviar para bob
public class Alice {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        JFileChooser fc = new JFileChooser("");
        System.out.println("SELECIONANDO ARQUIVO");
        JFrame jFrame = new JFrame();
        int retorno = fc.showDialog(jFrame, "OK");//se um arquivo foi escolhido retorna JFileChooser.APPROVE_OPTION
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[(int) fis.getChannel().size()];//pega tamanho do arquivo
            fis.read(bytes);//coloca o inputStream (fluxo de bytes) para dentro biteArray
            fis.close();
            System.out.println("ARQUIVO SELECIONADO");

            //cifrando arquivo
            Cipher cipherAES = Cipher.getInstance("AES");
            SecretKey keyAES = KeyGenerator.getInstance("AES").generateKey();//vai gerar uma chave aleatória para o algoritmo passado
            
            cipherAES.init(Cipher.ENCRYPT_MODE, keyAES);//critografia simétrica usa a mesma chave pra encriptar/desencriptar, então precisa passar qual modo se deseja, nesse caso encriptar
            byte[] textoCifrado = cipherAES.doFinal(bytes);//criptografa o texto puro e retorna o texto cifrado
            
            System.out.println("[ALICE] texto cifrado: " + new String(textoCifrado));

            Socket s = new Socket("localhost", 5555);
            
            //*poderia enviar os bytes de chave e do arquivo juntos sem usar uma classe usando DataOutputStream
            
            ObjetoEnvio objetoEnvio = new ObjetoEnvio(f.getName(), textoCifrado, keyAES);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(objetoEnvio);
            s.close();

            //Bob.recebeArquivoCriptografado(textoCifrado, keyAES);            
        }
        jFrame.dispose();
    }

    public static class ObjetoEnvio implements Serializable{
        private String nomeArquivo;
        private byte[] textoCifrado;
        private SecretKey chave;
        
        public ObjetoEnvio(String nomeArquivo, byte[] textoCifrado, SecretKey chave) {
            this.nomeArquivo = nomeArquivo;
            this.textoCifrado = textoCifrado;
            this.chave = chave;
        }

        public String getNomeArquivo() {
            return nomeArquivo;
        }
        public void setNomeArquivo(String nomeArquivo) {
            this.nomeArquivo = nomeArquivo;
        }
        public byte[] getTextoCifrado() {
            return textoCifrado;
        }
        public void setTextoCifrado(byte[] textoCifrado) {
            this.textoCifrado = textoCifrado;
        }
        public SecretKey getChave() {
            return chave;
        }
        public void setChave(SecretKey chave) {
            this.chave = chave;
        }
    }
}
