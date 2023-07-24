//DataInputStream e DataOutputStream le e grava dados binários em tipos primitivos java (int, double...)

//manipulando arquivo binário

//Obs: System.out e System.in são instancias de printStream e System.in é do tipo InputStream

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f = new File("arquivo.bin");

        PrintStream ps = new PrintStream(System.out);//tanto printWriter como printStream escrevem no console, o primeiro é orientado a caracteres e o outro a bytes
        ps.flush();

        OutputStream os = new FileOutputStream(f.getPath());
        DataOutputStream dos = new DataOutputStream(os);

        Scanner scan = new Scanner(System.in);

        ps.print("nome: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);//escreve no arquivo binario uma string

        ps.print("idade: ");
        int idade = scan.nextInt();
        dos.writeInt(idade);//escreve no arquivo binario um int

        //ler char
        //char r = (char) System.in.read(); //em vez de usar scanner, usa-se System.in pra ler char


        //lendo arquivo binário
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(f.getPath()));
        String lerNome = dataInputStream.readUTF();
        int lerIdade = dataInputStream.readInt();
        //ordem de leitura deve ser igual a ordem de escrita

        System.out.println(nome,idade);

        dataInputStream.close();
        dos.close();
        scan.close();
        ps.close();
    }
}
