package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

//criptografia assimétrica também chamada de "criptografia de chave pública"
//alice vai receber a chave pública de bob
//escolher um arquivo, criptografá-lo usando a criptografia simétrica
//e usa-rá a chave publica recebida de bob para criptografar a chave simétrica

//obs: algoritmos de cifra requerem bytes para executar a criptografia/descriptografia

//usar a crito assimétrica para criptografar a chave simétrica terá como resultado uma chave simétrica cifrada com RSA por exemplo, essa chave é tambem chamada de chave de sessão
public class Alice {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        PublicKey chavePublica = null;

        //bob vai enviar sua chave pública para alice
        try(ServerSocket serverSocket = new ServerSocket(5550)){
            System.out.println("[ALICE] aguardando chave pública porta 5550");

            Socket socket = serverSocket.accept();

            ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());

            chavePublica = (PublicKey) oi.readObject();

            System.out.println("CHAVE PÚBLICA RECEBIDA. ALGORITMO: " + chavePublica.getAlgorithm());
        }        
        
        JFileChooser fc = new JFileChooser("");
        System.out.println("SELECIONANDO ARQUIVO");
        JFrame jFrame = new JFrame();
        int retorno = fc.showDialog(jFrame, "OK");//se um arquivo foi escolhido retorna JFileChooser.APPROVE_OPTION
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(f);

            System.out.println("ARQUIVO SELECIONADO");
            
            byte[] bytesArquivo = new byte[(int) fis.getChannel().size()];
            fis.read(bytesArquivo);//coloca o inputStream (fluxo de bytes) para dentro biteArray
            fis.close();

            Socket s = new Socket("localhost", 5555);

            /*
             * como o RSA só consegue criptografar mensagens que sejam menores que o tamanho da chave secreta dividido por 8
             * se a chave secreta tem 2048 bits então no máximo mensagens de 256 bytes serão criptografadas
             * então uma solução possível seria usar a criptografia simétrica pra criptografar a mensagem
             * e usar a criptografia assimétrica para criptografar a chave simétrica e enviar para o destinatário o conteúdo criptografado com criptografia simétrica
             */
            Cipher cipherAES = Cipher.getInstance("AES");
            SecretKey keyAES = KeyGenerator.getInstance("AES").generateKey();

            cipherAES.init(Cipher.ENCRYPT_MODE, keyAES);//critografia simétrica usa a mesma chave pra encriptar/desencriptar, então precisa passar qual modo se deseja, nesse caso encriptar
            byte[] textoCifradoSimetrico = cipherAES.doFinal(bytesArquivo);//criptografa o texto puro e retorna o texto cifrado
            
            //criptografa a chave simétrica usando criptografia assimétrica
            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.ENCRYPT_MODE, chavePublica);
            byte[] chaveSimetricaCifrada = cipherRSA.doFinal(keyAES.getEncoded());//criptografa a chave simétrica
            
            System.out.println("[ALICE] texto puro: " + new String(bytesArquivo, StandardCharsets.UTF_8));
            System.out.println("[ALICE] texto criptografado criptografia simetrica: " + new String(textoCifradoSimetrico, StandardCharsets.UTF_8));
            System.out.println("[ALICE] chave simetrica: " + new String(keyAES.getEncoded(), StandardCharsets.UTF_8));
            System.out.println("[ALICE] chave simetrica criptografada: " + new String(chaveSimetricaCifrada, StandardCharsets.UTF_8));

            ObjetoEnvio objetoEnvio = new ObjetoEnvio(textoCifradoSimetrico, chaveSimetricaCifrada);
            ObjectOutputStream ou = new ObjectOutputStream(s.getOutputStream());
            ou.writeObject(objetoEnvio);

            s.close();
        }
        jFrame.dispose();
    }

    public static class ObjetoEnvio implements Serializable{
        private byte[] textoCifrado;
        private byte[] chaveSimetricaCriptografada;
        
        public ObjetoEnvio(byte[] textoCifrado, byte[] chaveSimetricaCriptografada) {
            this.textoCifrado = textoCifrado;
            this.chaveSimetricaCriptografada = chaveSimetricaCriptografada;
        }

        public byte[] getTextoCifrado() {
            return textoCifrado;
        }
        public void setTextoCifrado(byte[] textoCifrado) {
            this.textoCifrado = textoCifrado;
        }
        public byte[] getChaveSimetricaCriptografada() {
            return chaveSimetricaCriptografada;
        }
        public void setChaveSimetricaCriptografada(byte[] chaveSimetricaCriptografada) {
            this.chaveSimetricaCriptografada = chaveSimetricaCriptografada;
        }
    }
}
