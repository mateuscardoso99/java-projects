import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * Java byte Array é usado para armazenar apenas valores de tipo de dados de byte
 * Um grupo de dígitos binários ou bits (geralmente oito) operados como uma unidade. Um byte considerado como uma unidade de tamanho de memória. O byte é uma unidade de informação digital que geralmente consiste em oito bits
 * O byte é um dos tipos de dados primitivos em Java. Isso significa que o byte Java tem o mesmo tamanho de um byte na memória do computador: são 8 bits e podem conter valores que variam de -128 a 127
 * Você pode usar uma matriz de bytes para armazenar uma coleção de dados binários ( byte[] ), por exemplo, o conteúdo de um arquivo. A desvantagem disso é que todo o conteúdo do arquivo deve ser carregado na memória
 */

public class byteArray {
    public static void main(String[] args) {
        byte[] byteArray = new byte[10]; //array de bytes com capacidade de 10bytes

        // DECLARAÇÃO DE ARRAY DE BYTE JAVA
        byte b[];
        //ALOCAÇÃO DE MEMÓRIA PARA JAVA BYTE ARRAY
        b = new byte[4];
        //ATRIBUINDO ELEMENTOS PARA JAVA BYTE ARRAY
        b[0] = 20;
        b[1] = 10;
        b[2] = 30;
        b[3] = 5;

        //ou: byte b[] = {20,10,30,5};

        System.out.println("Exemplo de matriz de bytes Java");
        for(int i=0;i<b.length;i++){
            System.out.println("Elemento no Índice : "+ i + " " + b[i]);
        }

        //CONVERTER STRING PARA BYTES
        String str = "converte String em array de bytes em Java"; 
		byte[] bytearray = str.getBytes(); 
		System.out.println(Arrays.toString(bytearray));//SAÍDA (valores da tabela ascii) [99, 111, 110, 118, 101, 114, 116, 101, 32, 83, 116, 114, 105, 110, 103, 32, 101, 109, 32, 97, 114, 114, 97, 121, 32, 100, 101, 32, 98, 121, 116, 101, 115, 32, 101, 109, 32, 74, 97, 118, 97]
    
        //outra forma
        // String str2 = "converte String"; 
		// byte[] bytearray2 = Base64.getDecoder().decode(str2); 
		// System.out.println(Arrays.toString(bytearray2));

        //converter array byte[] para String em Java:

        //Converter um Array de bytes em String em Java sem codificação de caracteres:
        byte[] bytes = "converte um Array de bytes em String em Java sem codificação de caracteres ".getBytes(); 
		System.out.println(Arrays.toString(bytes)); 
		// Cria uma string a partir do array de bytes 
		// sem especificar a codificação de caracteres 
		String string = new String(bytes); 
		System.out.println(string); 

        //com codificação de caracteres:
        byte[] bytes1 = "converte um Array de bytes em String em Java com codificação de caracteres UTF-8 ".getBytes(StandardCharsets.UTF_8); 
		// Cria uma string a partir do array de bytes com a codificação "UTF-8" 
		String str1 = new String(bytes1, StandardCharsets.UTF_8); 
		System.out.println(str1); 

        //outra forma:
        byte[] bytearray2 = " converter array de bytes em string em Java 8 ".getBytes(); 
		String str2 = Base64.getEncoder().encodeToString(bytearray2); 
		System.out.println(str2); 



        //GRAVAR BYTES EM ARQUIVO:
        byte[] bs = "hello".getBytes();
		File file = new File("c:\\demo.txt");
		try
		{
			OutputStream os = new FileOutputStream(file);//Cria um fluxo de saída de arquivo para gravar no arquivo representado pelo objeto File especificado
			os.write(bs);
			System.out.println("Write bytes to file.");
			os.close();

            //mostrar conteudo
            System.out.println("Print File Content");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
}
