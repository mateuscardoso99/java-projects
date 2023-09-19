/**
 * Um Record, nada mais é que um tipo de classe que armazena dados. É a mesma ideia de construção similar a um JavaBean, 
 * possui construtor, atributos e métodos acessores. Porém, ao invés de possibilitar qualquer alteração a classe é imutável. 
 * Também possui os métodos equals, hashCode e toString().
 * records são imutáveis, então não pode ser alterada posteriormente a sua criação por isso não existe setters
 * Records gera automaticamente equals, hashCode e toString
 * 
 * Abaixo algumas restrições referentes a este tipo de classe:
 * Uma Record class não possui uma cláusula extends
 * não pode ser abstrato
 * todos os atributos são finais
 * Não pode declarar campos de instância
 * Não pode declarar métodos nativos
 * 
 * Além das restrições acima, uma classe de registro se comporta como uma classe normal:
 * Uma instância de Record é criada com a expressão new
 * Pode ser declarada como um tipo genérico
 * Pode declarar métodos, atributos e inicializadores estáticos
 * Pode declarar métodos de instância
 * Pode implementar interfaces
 * Utilizar annotations
 * Podem ser serializados e desserializado
 */

//classe tradicional
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

//com record
//Dado a contexto de imutabilidade, existe apenas um construtor com todos os atributos. Também não existem métodos setter.
//Outra diferença entre o primeiro design e este usando records é que os métodos acessores não usam a terminologia com “get” apenas o próprio nome do atributo, ou seja, ao invés de getName(), apenas name();
//Dentre várias possibilidades usando records, uma utilidade seria serializar e desserializar classes que representam payloads de comunicação, também chamados de DTOs.
//Dentre várias possibilidades usando records uma seria Mensagens enviadas e recebidas de comunicação assíncrona
public record Pessoa(String nome, Integer idade){}
