import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class io{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File f = new File("teste.txt");
        Reader reader = new FileReader(f.getName());//classe que lê arquivos de caracteres
        BufferedReader br = new BufferedReader(reader);//leitura é feita com os dados em um buffer para ficar mais rapido
        String line = br.readLine();//pega primeira linha

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));//mesma ideia do bufferedReader mas para escrita
        do{
            bw.write(line);
            bw.newLine();//insere uma linha no arquivo
            bw.flush();//faz com que os dados que estão no buffer em memoria sejam gravados no arquivo
            line = br.readLine();
        }while(line != null);

        
        //inserindo dados apartir do console
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("insira dados no arquivo: ");
        pw.flush();

        //busca os dados inseridos no console
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line2 = bReader.readLine();

        BufferedWriter bWriter = new BufferedWriter(new FileWriter(f.getName(), true));
        do{
            bWriter.write(line2);
            bWriter.newLine();
            line2 = bReader.readLine();
        }while(!(line2.equalsIgnoreCase("fim")));

        br.close();
        bw.close();
        bWriter.close();
        bReader.close();
        pw.close();
    }
}
