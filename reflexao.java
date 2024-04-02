import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection serve para determinar métodos e atributos que serão utilizados de determinada classe (que você nem conhece) em tempo de execução.
 * Há inúmeras utilidades para esse tipo de tarefa, podemos citar por exemplo a instalação de plugins adicionais ao nosso software desenvolvido
 */
class Pessoa{
    private String nome;
    private Integer idade;
    public Pessoa() {

    }
    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((idade == null) ? 0 : idade.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idade == null) {
            if (other.idade != null)
                return false;
        } else if (!idade.equals(other.idade))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    }
}

class Teste {
    public static void main(String[] args) throws Exception{
	Object classe = Class.forName("Pessoa").getDeclaredConstructor().newInstance();//criando instancia de pessoa
        Object c2 = Pessoa.class.getDeclaredConstructor().newInstance();//outra forma de instanciar
        
        Pessoa p1 = (Pessoa) c2;
        p1.setNome("maria");
        p1.setIdade(56);

        System.out.println(p1.getNome());
        System.out.println("classe: "+classe.getClass().getName()+", pacote: "+classe.getClass().getPackageName()+", classe mãe: "+classe.getClass().getSuperclass());
        System.out.println("métodos");
        for(Method metodo : classe.getClass().getMethods()){
            System.out.println("método: "+metodo.getName()+", total de parametros: "+metodo.getParameters().length+", tipo de retorno: "+metodo.getReturnType()+", é publico? "+Modifier.isPublic(metodo.getModifiers()));
        }
        System.out.println("atributos");
        for(Field atributo : classe.getClass().getDeclaredFields()){
            System.out.println("atributo: "+atributo.getName()+" tipo: "+atributo.getType());
        }

        Pessoa p = new Pessoa("joao",35);
        for(Method metodo : p.getClass().getMethods()){
            if(metodo.getName().equals("setNome")){
                metodo.invoke(p,"carlos");//executa método setNome e altera o nome da pessoa, precisa passar o objeto de Pessoa e os paranetros
            }
        }
        Method getNome = p.getClass().getDeclaredMethod("getNome");
        System.out.println(getNome.invoke(p));//executa o método getNome com o novo nome
    }

    //getDeclaredMethodsinclui todos os métodos declarados pela própria classe.
    //getMethods retorna apenas métodos públicos, mas também aqueles herdados de uma classe base (aqui de java.lang.Object).

    //o mesmo vale pra getDeclaredConstructors() e getConstructors()

    //getFields() Todos os campos public em toda a hierarquia de classes.
    //getDeclaredFields() Todos os campos, independentemente de sua acessibilidade, mas apenas para a classe atual, e não para quaisquer classes base das quais a classe atual possa estar herdando.

    //getDeclaredAnnotations() Retorna anotações que estão diretamente presentes neste elemento. Este método ignora anotações herdadas. Se não houver anotações diretamente presentes neste elemento, o valor de retorno será um array de comprimento zero
    //getAnnotations() fornece anotações diretamente implementadas e herdáveis(@Inherited) de sua classe mãe


    /*
    	Collection<Conta> e = (Collection<Conta>) metodoGetContas.invoke(banco); //método retorna uma Set<Conta>

        System.out.println("\nMÉTODOS DAS CONTAS DO BANCO");
        System.out.println("TOTAL DE CONTAS NO BANCO: " + e.getClass().getMethod("size").invoke(e)); // interface Set possui método size(), aqui é invocado pra pegar o total de contas

        Stream<Conta> s = (Stream<Conta>) e.getClass().getMethod("stream").invoke(e); // interface Set tem um método stream(), aqui é invocado e pega o retorno que é um Stream

        s.forEach(c -> System.out.println("NUMERO DAS CONTAS: "+c.getNumero())); //percorre o stream e mostra os numeros das contas
    */
}
