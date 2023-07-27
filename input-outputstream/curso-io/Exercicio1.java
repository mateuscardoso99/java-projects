import java.io.*;

//OutputStream:
//significa fluxo de saída
//O aplicativo Java usa um fluxo de saída para gravar dados em um destino; pode ser um arquivo, uma matriz, dispositivo periférico ou soquete.
//é uma classe abstrata. É a superclasse de todas as classes que representam um fluxo de saída de bytes. Um fluxo de saída aceita bytes de saída e os envia para algum coletor.

//InputStream:
//significa fluxo de entrada
//O aplicativo Java usa um fluxo de entrada para ler dados de uma origem; pode ser um arquivo, uma matriz, dispositivo periférico ou soquete.
//é uma classe abstrata. É a superclasse de todas as classes que representam um fluxo de entrada de bytes.

//BufferedReader:
//Lê o texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes e linhas

//BufferedWriter:
//A classe Bufferreader grava o texto no fluxo de saída de caracteres, armazenando os caracteres em buffer. Assim, fornece uma gravação eficiente de uma única matriz, caractere e strings.

//BufferedInputStream:
//adiciona funcionalidade a outro fluxo de entrada, ou seja, a capacidade de armazenar em buffer a entrada e oferecer suporte aos métodos de marcação e redefinição

//BufferedOutputStream:
//implementa um fluxo de saída em buffer. Ao configurar esse fluxo de saída, um aplicativo pode gravar bytes no fluxo de saída subjacente sem necessariamente causar uma chamada ao sistema subjacente para cada byte gravado

//OutputStreamWriter:
//conecta fluxos de caracteres a fluxos de bytes. Ele codifica caracteres em bytes usando um conjunto de caracteres especificado. 


//** tudo isso abaixo poderia tambem ser feito usando a classe Scanner

//Abra o teclado para escrever 3 filmes que você recomendaria e exiba esses filmes no console.
public class Exercicio1 {
    public static void abrirTecladoExibirConsole() throws IOException {
        //br.readLine() obriga a tratar excecoes
        //throws declarado para não precisar colocar dentro de try catch. isso obriga o método
        //que chamar esse a usar try catch ou tambem definir um throws
        
        System.out.println("Digite 3 sugestões de filmes: ");

        //abrindo teclado
        InputStream is = System.in; //abrindo um fluxo de dados para receber entrada através do teclado
        Reader isr = new InputStreamReader(is); //Ponte que transforma o fluxo do InputStream em character        
        BufferedReader br = new BufferedReader(isr);//lê o stream de character e armazena em um buffer para facilitar a leitura desses characteres

        //outra forma de fazer ao inves das 3 variaveis acima:
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //preparando a escrita no console
        OutputStream os = System.out; //abrindo um fluxo de dados para enviar dados para o console.
        OutputStreamWriter osr = new OutputStreamWriter(os); //ponte que transforma o fluxo OutputStream em character
        BufferedWriter bw = new BufferedWriter(osr);//grava o stream de character (texto) e armazena em um buffer para facilitar a escrita desses characteres

        //outra forma de fazer ao inves das 3 variaveis acima:
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //padrão decorator

        //agora precisamos ler do teclado e enviar para o console
        String line = br.readLine();//método readLine lê cada linha do texto e retorna uma String.

        do {
            bw.write(line); //pegue a linha lida através do teclado e armazene em um buffer
            bw.newLine(); //depois insira uma linha
            line = br.readLine(); //depois de realizado a cópia da linha acima, preenchemos a linha novamente
        } while(!line.isEmpty()); //quando a linha estiver vazia, pare.

        bw.flush();
        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoExibirConsole();
    }
}