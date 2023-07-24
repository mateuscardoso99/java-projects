import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class io2{
    public static void main(String[] args) {
        //copiando arquivo com classes input/output stream
        File f = new File("teste.txt");

        InputStream in = new FileInputStream(f.getName());
        BufferedInputStream bin = new BufferedInputStream(in);

        String nomeArquivoCopia = "teste-copy.txt";
        File fCopy = new File(nomeArquivoCopia);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopia));
        int line = 0;
        while((line = bin.read()) != 1){//se metodo read() retornar -1 não tem mais bytes a serem lidos
            bos.write(line);//cada byte lido retorna um int, que é convertido pra char
            bos.flush();//descarrega do buffer pra gravar no arquivo
        }

        bos.close();
        bin.close();
    }
}