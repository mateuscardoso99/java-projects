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
                metodo.invoke(p,"carlos");//executa método setNome e altera o nome da pessoa
            }
        }
        Method getNome = p.getClass().getDeclaredMethod("getNome");
        System.out.println(getNome.invoke(p));//executa o método getNome com o novo nome
	}
}
