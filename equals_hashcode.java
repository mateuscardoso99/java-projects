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
     * 
     * ex: existem 3 caixas que agrupam nomes que começam com uma letra, "J", "P" ou "D"
     * Imagine buscar um nome qualquer, por exemplo, “Pedro”, você já iria na caixa que a inicial seja “P” e então compararia os nomes lá dentro
     * Com a coleções que usam hash é a mesma coisa, se quisermos encontrar um produto qualquer, 
     * temos que primeiro determinar o código hash e então olhar dentro dessa “caixa” os objetos com o método equals()
     * uma busca assim é bem mais rápida do que comparar um a um os objetos
     * Para gerar o código hash em um objeto, precisamos sobrescrever o método hashCode(). Ele irá retornar um inteiro que representa o “código da caixa que ele ficará”
     * 
     * método contains() de um hashSet se baseia no hashCode pra verificar se um item existe ou não
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + idade;
        return result;
    }    
}
