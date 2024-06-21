class A{
    private String nome;
    private int idade;

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

    /**
     * método de comparação de objetos
     * se não for sobrescrito, será usado o equals da classe Object
     * o equals da classe Object APENAS considera iguais objetos que tenham o mesmo endereço de memória ou seja a mesma instância
     * queremos tambem que sejam considerados iguais os objetos que tenham
     * o mesmo valor pro nome e pra idade, pra isso o método foi sobrescrito
     * 
     * método contains de um arraylist se baseia no equals pra verificar se um item existe ou não
     * ao sobrescrever o equals tambem será preciso sobrescrever o hashcode
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)//comparando endereços de memória
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A other = (A) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idade != other.idade)
            return false;
        return true;
    }

    /**
     * se usar uma coleção do tipo HashSet, ao usar contains() não vai funcionar pois ele ainda 
     * vai considerar iguais apenas objetos que tenham o mesmo endereço de memória ou seja a mesma instância
     * Mas por que se o equals() está implementado e comparando os objetos baseado no nome e idade? 
     * Porque em uma coleção que se usa código hash é importante primeiro determinar em que “região” esse objeto está.
     * Essa “região” é um espaço dentro da coleção onde os objetos ficam agrupados por semelhança, facilitando assim os encontrar.

     * ex: existem 3 caixas que agrupam nomes que começam com uma letra, "J", "P" ou "D"
     * Imagine buscar um nome qualquer, por exemplo, “Pedro”, você já iria na caixa que a inicial seja “P” e então compararia os nomes lá dentro
     * Com a coleções que usam hash é a mesma coisa, se quisermos encontrar um produto qualquer, 
     * temos que primeiro determinar o código hash e então olhar dentro dessa “caixa” os objetos com o método equals()
     * uma busca assim é bem mais rápida do que comparar um a um os objetos
     * Para gerar o código hash em um objeto, precisamos sobrescrever o método hashCode(). Ele irá retornar um inteiro que representa o “código da caixa que ele ficará”

     * tabelas de hash usam uma função de hash pra gerar o código hash, essa função em java é o hashCode()
     
     * tabela de hash utiliza o hashCode() de cada objeto para localizar de forma direta o seu lugar na tabela;

     * sempre que equals() for sobrescrito hashCode() também precisa ser, para que Sempre que dois objetos forem iguais, estes devem possuir o mesmo hashCode();

     * pode haver mais de um objeto com o mesmo código hash, nesse caso a tabela terá uma lista desses objetos e vai procurar em cada um o objeto certo

     * Dois objetos diferentes podem ter o mesmo hashCode, mas isto deve ser evitado

     * método contains() de um hashSet se baseia no hashCode pra verificar se um item existe ou não

     *Um algoritmo bem implementado reduz o número de colisões e um algoritmo mal implementado aumenta-o. Por exemplo, você pode substituir hashCode() para que retorne um valor constante. Neste caso, todos os elementos serão armazenados em um balde (reduzindo o desempenho), privando-nos da propriedade mais importante graças à qual o HashMap é tão eficiente.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + idade;
        return result;
    }    




    
    /*
    EXEMPLO HASHCODE:
    */
    public static class DataKey {

	    private String name;
	    private int id;

        // getter and setter methods

    	@Override
    	public String toString() {
    		return "DataKey [name=" + name + ", id=" + id + "]";
    	}

    }

    import java.util.HashMap;
    import java.util.Map;
    
    public class HashingTest {
    
    	public static void main(String[] args) {
    		Map<DataKey, Integer> hm = getAllData();
    
    		DataKey dk = new DataKey();
    		dk.setId(1);
    		dk.setName("Pankaj");
    		System.out.println(dk.hashCode());
    
    		Integer value = hm.get(dk); //null
    
    		System.out.println(value);
    
    	}
    
    	private static Map<DataKey, Integer> getAllData() {
    		Map<DataKey, Integer> hm = new HashMap<>();
    
    		DataKey dk = new DataKey();
    		dk.setId(1);
    		dk.setName("Pankaj");
    		System.out.println(dk.hashCode());
    
    		hm.put(dk, 10);
    
    		return hm;
        }
    }

    //Quando executamos o programa acima, ele será impresso null. É porque o método Object hashCode() é usado para encontrar a "caixa" para procurar a chave. 
    //Como não temos acesso às chaves HashMap e estamos criando a chave novamente para recuperar os dados, você notará que os valores do código hash de ambos os objetos são diferentes e, 
    //portanto, o valor não foi encontrado.
    //OBRIGATÓRIAMENTE PRECISA SOBREESCREVER O EQUALS E HASHCODE AO TRABALHAR COM COLLECTIONS BASEADAS EM HASH, COMO SET E MAP

    /*
    Em termos muito simples, as implementações de tabela Java Hash usam a seguinte lógica para operações get e put nas collections baseadas em hash.

    Primeiro identifique a “caixa” a ser usado usando o código hash da “chave”.
    Se não houver objetos presentes na "caixa" com o mesmo código hash, adicione o objeto para operação put e retorne nulo para operação get. (por isso o get da linha 118 retorna null)
    Se houver outros objetos na “caixa” com o mesmo código hash, o método “chave” equals() entra em ação.
    Se equals() retornar true e for uma operação put, o valor do objeto será substituído.
    Se equals() retornar falso e for uma operação put, uma nova entrada será adicionada ao intervalo.
    Se equals() retornar true e for uma operação get, o valor do objeto será retornado.
    Se equals() retornar false e for uma operação get, então null será retornado.

    O fenômeno quando duas chaves têm o mesmo código hash é chamado de colisão hash. Se o método hashCode() não for implementado corretamente, haverá um número maior de colisões de hash e as 
    entradas do mapa não serão distribuídas corretamente, causando lentidão nas operações get e put. Esta é a razão para o uso de números primos na geração de código hash para que as 
    entradas do mapa sejam distribuídas adequadamente em todos as "caixas".

    JÁ VIMOS ACIMA QUE SE HASHCODE() NÃO FOR IMPLEMENTADO, NÃO SEREMOS CAPAZES DE RECUPERAR O VALOR PORQUE O HASHMAP USA CÓDIGO HASH PARA ENCONTRAR A "CAIXA" PARA PROCURAR A ENTRADA. 
    SE USARMOS APENAS HASHCODE() E NÃO IMPLEMENTARMOS EQUALS(), ENTÃO O VALOR TAMBÉM NÃO SERÁ RECUPERADO PORQUE O MÉTODO EQUALS() RETORNARÁ FALSO, POIS O EQUALS() DE OBJECT COMPARA ENDEREÇOS DE MEMÓRIA APENAS
    
    DICAS:
        Use as mesmas propriedades nas implementações dos métodos equals() e hashCode(), para que seu contrato não seja violado quando qualquer propriedade for atualizada.
        
        É melhor usar objetos imutáveis ​​como chave da tabela Hash para que possamos armazenar em cache o código hash em vez de calculá-lo em cada chamada. 
        É por isso que String é um bom candidato para chave de tabela Hash porque é imutável e armazena em cache o valor do código hash.
        
        Implemente o método hashCode() para que ocorra o menor número de colisões de hash e as entradas sejam distribuídas uniformemente em todos as "caixas".
    */
    
}
