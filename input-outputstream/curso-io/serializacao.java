/*
Java fornece um mecanismo chamado serialização de objetos, onde um objeto pode ser representado como uma sequência de bytes que inclui os dados do objeto, bem como informações sobre o 
tipo do objeto e os tipos de dados armazenados no objeto.
Depois que um objeto serializado é gravado em um arquivo, ele pode ser lido do arquivo e desserializado, ou seja, as informações de tipo e os bytes que representam o objeto e 
seus dados podem ser usados ​​para recriar o objeto na memória.
O mais impressionante é que todo o processo é independente da JVM, o que significa que um objeto pode ser serializado em uma plataforma e desserializado em uma plataforma totalmente diferente.
As classes ObjectInputStream e ObjectOutputStream são fluxos de alto nível que contêm os métodos para serializar e desserializar um objeto.
*/

//ObjectInputStream e ObjectOutputStream lidam com serialização e deserialização de objetos java

//serialização: é quando um objeto é transformado, em uma cadeia de bytes e desta forma pode ser manipulado de maneira mais fácil, seja através de transporte pela rede ou salvo no disco. Após a transmissão ou o armazenamento esta cadeia de bytes pode ser transformada novamente no objeto Java que o originou
//deserialização: reconstrução de um objeto a partir de um fluxo de entrada

//ObjectInput estende a interface DataInput, o que significa que um ObjectInputStream herda todos os comportamentos de leitura de tipos primitivos e strings como um DataInputStream
//ObjectOutput estende a interface DataOutput, o que significa que um ObjectOutputStream herda todos os comportamentos de escrever tipos primitivos e strings como um DataOutputStream


//instanciar um objeto e serializar, depois desserializar este objeto e mostrar no console
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Main {
    public static void serializar() throws FileNotFoundException, IOException, NotSerializableException{
        Main.Gato gato = new Main.Gato("joao",4,"preto","80cm");

        File f = new File("gato.json");

        OutputStream os = new FileOutputStream(f.getAbsolutePath());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(gato);

        objectOutputStream.close();
    }

    public static void desserializar(String arquivo)throws FileNotFoundException, IOException, NotSerializableException, ClassNotFoundException{
        ObjectInputStream ob = new ObjectInputStream(new FileInputStream(arquivo));
        Gato objetoDesserializado = (Gato) ob.readObject();
        System.out.println(objetoDesserializado.getNome());
        System.out.println(objetoDesserializado.getIdade());
        System.out.println(objetoDesserializado.getCor());
        System.out.println(objetoDesserializado.getTamanho());
        ob.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, NotSerializableException, ClassNotFoundException{
       serializar();
       desserializar("gato.json");
    }


    //Serializable é considerada como uma interface marcadora ou de tag, porque não tem nenhum método a implementar. Sua única finalidade é anunciar que a classe pode ser serializada. Ou seja os objetos desse tipo poderão ser salvos através do mecanismo de serialização
    private static class Gato implements Serializable{
        private static final Long serialVersionUID = 2L;//se a classe for alterada (mudanças nas propriedades) as versões do serialVersionUID não será a mesma quando for desserializar (pois a jvm gera um automatico e ao mudar propriedades é gerado outro), por isso quando mudar propriedades precisa mudar o serialVersion pra que eles batam
        private String nome;
        private int idade;
        private String cor;
        private String tamanho; //private transient String tamanho faria com que o atributo fosse invisivel, não é considerado como uma alteração

        public Gato() {}

        public Gato(String nome, int idade, String cor, String t) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
            this.tamanho = t;
        }

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public int getIdade() {
            return idade;
        }
        public void setIdade(int idade) {
            this.idade = idade;
        }
        public String getCor() {
            return cor;
        }
        public void setCor(String cor) {
            this.cor = cor;
        }

        public String getTamanho() {
            return tamanho;
        }

        public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
        }
    }
}
