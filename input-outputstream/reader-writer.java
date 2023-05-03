/**
 * Reader e Writer são classes abstratas para leitura e gravação de fluxos de caracteres.
 * 
 * FileWriter: é usada para gravar dados orientados a caracteres em um arquivo. É uma classe orientada a caracteres que é usada para manipulação de arquivos em java. Ao contrário da classe FileOutputStream, você não precisa converter string em array de bytes porque fornece método para escrever string diretamente.
 * FileReader: é usada para ler dados do arquivo. Ele retorna dados em formato de byte como a classe FileInputStream.
 * BufferedWriter: é usada para fornecer buffer para instâncias do Writer. Isso torna o desempenho rápido. Ele herda a classe Writer. Os caracteres de buffer são usados ​​para fornecer a gravação eficiente de arrays, caracteres e strings únicos.
 * BufferedReader: é usada para ler o texto de um fluxo de entrada baseado em caracteres. Ele pode ser usado para ler dados linha por linha pelo método readLine(). Isso torna o desempenho rápido. Ele herda a classe Reader.
 * CharArrayReader é usada para ler a matriz de caracteres como um leitor (stream). Ele herda a classe Reader.
 * CharArrayWriter: pode ser usada para gravar dados comuns em vários arquivos. Esta classe herda a classe Writer. Seu buffer aumenta automaticamente quando os dados são gravados neste fluxo
 * PrintWriter é a implementação da classe Writer. Ele é usado para imprimir a representação formatada de objetos no fluxo de saída de texto.
 * StringWriter é um fluxo de caracteres que coleta a saída do buffer de string, que pode ser usado para construir uma string
 * StringReader é um fluxo de caracteres com string como fonte. Ele pega uma string de entrada e a transforma em um fluxo de caracteres. Ele herda a classe Reader.
 */

class reader {
    public static void main(String[] args) {
        
    }
}
