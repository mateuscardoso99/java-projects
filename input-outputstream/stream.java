/**
 * Um programa que precise ler algum dado de algum local (uma fonte) precisa de um InputStream ou um Reader, por outro lado um programa que precise escrever um dado em algum local (destino) precisa de um OutputStream ou um Writer
 * Imagine um Stream como uma conexão com uma fonte ou destino de dados, onde esses dados podem ser passados via byte ou character. Por exemplo, um arquivo de texto pode representar um Stream, onde o seu programa irá ler esse Stream via byte ou character usando InputStream ou algum Reader
 * Vimos então que o InputStream faz parte da leitura de dados, ou seja, está conectado a alguma fonte de dados: arquivo, conexão de internet, vídeo e etc. O InputStream nos possibilita ler esse Stream em byte, um byte por vez. Acontece que se olharmos na classe InputStream veremos que ela é abstrata e nós somos obrigados a usar alguma outra classe que a implemente para fazer uso dos seus recursos. Algumas delas: FileInputStream, BufferedInputStream, DataInputStream e etc
 
 * Um Stream é uma sequência de dados. Em Java, um stream é composto de bytes.
 * Eava usa o conceito de stream para tornar a operação de E/S rápida.
 * Classes Stream (BufferedInputStream, InputStream, FileInputStream, DataInputStream) vs Classes Reader e Writer(Reader, Writer, BufferedReader, BufferedWriter, FileReader, FileWriter):
 * conceito de Stream é um bloco genérico para algum tipo de dados, podendo ele ser texto, vídeo, imagem e etc
 * InputStreams são usados ​​para ler bytes de um stream (fluxo de dados). Portanto, eles são úteis para dados binários, como imagens, vídeos e objetos serializados. 
 * Readers, por outro lado, são fluxos de caracteres, portanto, são mais bem usados ​​para ler dados de caracteres.

 * A classe InputStream é uma classe abstrata. É a superclasse de todas as classes que representam um fluxo de entrada de bytes.
 * InputStream faz parte da leitura de dados, ou seja, está conectado a alguma fonte de dados: arquivo, conexão de internet, vídeo e etc. O InputStream nos possibilita ler esse Stream em byte, um byte por vez.
 * InputStream O aplicativo Java usa um fluxo de entrada para ler dados de uma origem; pode ser um arquivo, uma matriz, dispositivo periférico ou soquete.
 
 * A classe OutputStream é uma classe abstrata. É a superclasse de todas as classes que representam um fluxo de saída de bytes (OutputStream). Um fluxo de saída aceita bytes de saída e os envia para algum coletor.
 * OutputStream é capaz de enviar dados a um determinado Stream, ao contrário do InputStream que faz a leitura do mesmo. Lembre-se que ao falarmos de “Stream” não estamos tratando especificamente de texto mas qualquer tipo de dado, usamos a leitura de texto apenas para facilitar o entendimento, mas outros métodos poderiam ser utilizados
 * OutputStream O aplicativo Java usa um fluxo de saída para gravar dados em um destino; pode ser um arquivo, uma matriz, dispositivo periférico ou soquete.
 
 * InputStreamReader: A função do InputStreamReader é servir como um adaptador entre as duas classes (Stream e Reader) - lê bytes de um lado, converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding). Ou seja, ele é um Reader que recebe um InputStream na construção, consumindo dados desse stream e apresentando-os como caracteres para o consumidor.
 * OutputStreamWriter: OutputStreamWriter é uma ponte de streams de caracteres para streams de bytes. Os caracteres gravados nele são codificados em bytes usando um charset específico ou o charset padrão da sistema operacional
 * A classe OutputStreamWriter é usada para escrever caracteres em um fluxo de saída binário, enquanto a classe BufferedWriter é usada para escrever caracteres em um buffer antes de escrever no fluxo de saída binário.

 * Quando você usa um Writer, você trabalha com String e char[], enquanto que com OutputStream você só pode usar byte[]
 * Mas se você tiver um OutputStream qualquer (como um FileOutputStream) é possível convertê-lo para um Writer se você usar um OutputStreamWriter

 * ByteArrayInputStream: permite que um buffer na memória seja usado como um InputStream. Você pode criar um fluxo baseado em um buffer de bytes que reside na memória , usando a ByteArrayInputStream e a ByteArrayOutputStream para ler e gravar em um buffer de bytes de maneira semelhante à leitura e gravação de um arquivo
 * InputStream, assim como o OutputStream, trabalha com bytes sem se importar com conversões de codificações, mas quando estamos trabalhando com texto puro e precisamos nos preocupar com acentuações e outras codificações específicas, então é importante ficar atento ao seu uso
 
 
 * FileOutputStream: é um fluxo de saída usado para gravar dados em um arquivo.
 * Se você precisar escrever valores primitivos em um arquivo, use a classe FileOutputStream. Você pode gravar dados orientados a bytes e também a caracteres por meio da classe FileOutputStream. Mas, para dados orientados a caracteres, é preferível usar FileWriter do que FileOutputStream.
 
 * FileInputStream: obtém bytes de entrada de um arquivo. Ele é usado para ler dados orientados a bytes (fluxos de bytes brutos), como dados de imagem, áudio, vídeo, etc. Você também pode ler dados de fluxo de caracteres. Mas, para ler fluxos de caracteres, é recomendável usar a classe FileReader.
 
 * BufferedOutputStream é usada para armazenar em buffer um fluxo de saída. Ele usa buffer internamente para armazenar dados. Ele adiciona mais eficiência do que gravar dados diretamente em um fluxo (mais rápido que FileOutputStream). Assim, torna o desempenho rápido. Para adicionar o buffer em um OutputStream, use a classe BufferedOutputStream
 * BufferedInputStream: é usada para ler informações do stream . Ele usa internamente o mecanismo de buffer para acelerar o desempenho. diferente do FileInputStream, que lê byte a byte, este lê um bloco inteiro de uma só vez, agilizando o processamento de leitura no disco
   Um exemplo prático: Se o seu arquivo possui 32768 bytes, para que um FileInputStream possa ler ele por completo, ele precisará fazer 32768 chamadas ao Sistema Operacional. Com um BufferedInputStream você precisará de apenas quadro chamadas, isso porque o BufferedInputStream armazena 8192 bytes em um buffer e os utiliza quando precisa. Resumindo, você deve usar o BufferedInputStream como um wrapper para o FileInputStream quando desejar ganhar mais velocidade
 
 * SequenceInputStream: é usada para ler dados de vários fluxos . Ele lê os dados sequencialmente (um por um).
 * ByteArrayOutputStream é usada para gravar dados comuns em vários arquivos. Nesse fluxo, os dados são gravados em uma matriz de bytes que pode ser gravada em vários fluxos posteriormente. O ByteArrayOutputStream contém uma cópia dos dados e os encaminha para vários fluxos
 * ByteArrayInputStream é composto por duas palavras: ByteArray e InputStream. Como o nome sugere, ele pode ser usado para ler a matriz de bytes como fluxo de entrada, passa um inputStream pra um byte[]
 * DataOutputStream e DataInputStream: permite que um aplicativo leia e grave tipos de dados Java primitivos no fluxo de saída de maneira independente da máquina.
 * PrintStream: fornece métodos para gravar dados em outro fluxo. A classe PrintStream libera automaticamente os dados, portanto, não há necessidade de chamar o método flush()


 * Lembre-se que ao falarmos de “Stream” não estamos tratando especificamente de texto mas qualquer tipo de dado, usamos a leitura de texto apenas para facilitar o entendimento, mas outros métodos poderiam ser utilizados
 
 * flush()
  Quando alguma escrita é feita em um arquivo em disco, pode ser que este dado ainda não tenha sido de fato escrito no disco, esteja em algum local na memória esperando o momento exato para ser gravado. 
  O método flush() força que este dado seja escrito imediamente no disco ou em qualquer outro local que você esteja tentando gravar.
  flush() só existe em OutputStream, e read() só existe em InputStream

 * close()
  O método close() deve ser chamado para fechar a escrita do arquivo e evitar que este fique aberto. Como várias exeções podem ocorrer durante a escrita do mesmo, e o 
  fechamento do arquivo deve ser sempre garantido, o ideal é que o close() fique no bloco finally de uma try-catch.
 */

class Teste{
    public static void main(String[] args) {

    }
}
