package DBField;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

/**
 * A diferença básica de uma interface comum e uma annotation é o símbolo de @ (arroba) antes da palavra interface. Os “atributos” da anotação são métodos, 
 * que no exemplo acima é o nome da tabela no banco. As regras para os atributos/métodos é que eles só podem retornar: primitivos, Strings, enum, Class ou um array dos anteriores.
 */

/**
    A anotação @Target indica para qual tipo de elemento java a anotação que estamos definindo irá tratar. Ele pode ser:
    TYPE: para classes, interfaces, ou enums;
    FIELD: para atributos;
    METHOD: para métodos;
    PARAMETER: para parâmetros de métodos;
    CONSTRUCTOR: em construtores;
    LOCAL_VARIABLE: em variáveis locais;
    ANNOTATION_TYPE: em uma outra anotação;
    PACKAGE: nos pacotes java.
 */

/**
    Já a anotação @Retention indica por quanto tempo a anotação será retida. Pode assumir os valores:
    RUNTIME: as anotações são armazenadas na classe e estão disponíveis em tempo de execução;
    SOURCE: as anotações são armazenadas na classe, mas NÃO estão disponíveis em tempo de execução;
    CLASS: as anotações NÃO são armazenadas na classe (default).
 */

//Por último, a anotação @Inherited indica que as subclasses herdarão essa anotação.
//A anotação acima servirá para mapear uma classe em uma tabela do banco de dados.
//Ela será utilizada apenas em classes, ficará disponível em tempo de execução e poderá ser herdada por subclasses que a usarem.

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface DBTable {
  public String table();
}



//Vamos agora para a anotação que mapeará atributos em campos da tabela
//A anotação acima, é apenas para atributos, terá sua informação disponível em tempo de execução e terá o atributo column. Definimos um valor default para a coluna, para que o nome do atributo seja igual ao nome do campo da tabela, não seja preciso preencher.
//Vamos agora usar essas anotações em duas classes: Pessoa e Funcionário. Essa segunda herdando da primeira

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface DBField {
  String colummn() default "";
}



@DBTable(table="TBPessoa")
class Pessoa {
    @DBField(colummn="str_nome")
    private String nome;

    @DBField(colummn="str_end")
    private String endereco;

    @DBField
    private int idade;

    public Pessoa(String nome,
        String endereco, int idade) {

        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public int getIdade() {
        return idade;
    }
}

//O mais importante dessa classe é o mapeamento que fizemos da classe com o nome da tabela e dos atributos com os campos. 
//Tudo isso só usando nossas próprias anotações.
@DBTable(table="TBFunc")
class Funcionario extends Pessoa {
    @DBField(colummn="num_ctps")
    String ctps;

    public Funcionario(String nome, String endereco,
        int idade, String ctps) {

        super(nome, endereco, idade);
        this.ctps = ctps;
    }
    public String getCtps() {
        return ctps;
    }
}


//Agora vamos criar a classe que lerá objetos (de qualquer classe) e procurará nossas anotações para fazer uma inclusão (FAKE claro :) no banco de dados.
class Repositorio {
    public void insert(Object obj) throws Throwable {
        // Tenta obter nossa anotação na classe
        DBTable persistable = obj.getClass().getAnnotation(DBTable.class);
    
        // Se tiver a anotação...
        if (persistable != null){
            String tabela = persistable.table();
            // Map para montar o SQL campo/valor :)
            HashMap keyAndValues = new HashMap();
    
            // Obtém os atributos da classe via reflection  
            Field[] fields = getFields(obj.getClass());
                for (Field field : fields) {
                // como os atributos são private,
                // setamos ele como visible
                field.setAccessible(true);
                DBField coluna = field.getAnnotation(DBField.class);
        
                // Se o atributo tem a anotação
                if (coluna != null){
                    // Verifica se está vazio pra usar o
                    // nome do próprio atributo
                    String columnName = 
                    coluna.colummn().equals("") ?
                    field.getName() : coluna.colummn();
                
                    // Adiciona campo/valor no map
                    keyAndValues.put(
                    columnName, field.get(obj).toString());
                }
            }
   
            // Varre o map para montar o SQL
            String values = "";
            Set keys = keyAndValues.keySet();
            for (String campo: keys) {
                if (!values.equals("")) values += ",";
                String valor = keyAndValues.get(campo);
                values += campo +"='"+ valor +"'";
            }
  
            String sql = "INSERT INTO "+ tabela + " values("+ values +")";
            System.out.println("SQL---->"+ sql);
        }
    }
  
    // Método recursivo para obter os atributos da 
    // class e da superclasse
    public Field[] getFields(Class c){
      // Se tem superclasse
      if (c.getSuperclass() != null){
        // Chama o próprio método para pegar os 
        // atributos da superclasse
        Field[] superClassFields = 
          getFields(c.getSuperclass());
        // Pega os atributos da própria classe
        Field[] thisFields = c.getDeclaredFields();
   
        // array com todos os atributos
        Field[] allFields = new Field[
          superClassFields.length +
          thisFields.length];
  
        // Copia os atributos da superclasse 
        System.arraycopy(superClassFields, 0,
          allFields, 0, superClassFields.length);
        // Copia os atributos da classe atual
        System.arraycopy(thisFields, 0, allFields,
          superClassFields.length, thisFields.length);
     
        return allFields;
  
      // Se não tem superclasse, retorna os 
      // próprios atributos
      } else {
        return c.getDeclaredFields();
      }
    }


  public static void main(String[] args) {
    Repositorio repo = new Repositorio();

    Pessoa p = new Pessoa("Nelson", "Rua tal", 28);
    Funcionario f = new Funcionario(
      "Glauber", "Rua x", 18, "1234");

    try {
      repo.insert(p);
      repo.insert(f);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}

//O resultado é apresentado abaixo:

//SQL — →INSERT INTO TBPessoa values(str_nome=’Nelson’,idade=’28',str_end=’Rua tal’)
//SQL — →INSERT INTO TBFunc values(str_nome=’Glauber’,idade=’18',str_end=’Rua x’,num_ctps=’1234')

//Como podemos observar, o mesmo repositório está persistindo duas classes distintas, baseando-se apenas nas notações que usamos nelas. Esse recurso pode trazer inúmeras vantagens para o desenvolvimento de aplicações facilitando a componentização da sua aplicação.
