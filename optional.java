import java.util.Optional;

class Main {
    public static String metodo() {
        System.out.println("dentro do método");
        return "ola";
    }

    public static void main(String[] args) {
        //Optional<String> e = Optional.of(null); //erro Optional.of() não pode receber algo nulo então pra usar ele deve ter certeza que o valor não será nulo, melhor usar caso usar ofNullable() que suporta nulo
        Optional<String> e = Optional.ofNullable(null);
		System.out.println(e.orElseGet(()->"1"));//saida 1, orElseGet permite criar uma função a ser executada
        System.out.println(e.orElse("1"));//saida 1, pode passar uma função para o orElse tambem

        Optional<String> opt = Optional.empty();
        System.out.println(opt.orElse(metodo()));
        System.out.println(opt.orElseGet(() -> metodo()));
        //Como o Optional é vazio, ambos chamarão o método.

        //String valor = opt.orElseThrow(IllegalArgumentException::new);//caso se vazio orElseThrow lança um erro

        //Mas se o Optional não for vazio:
        opt = Optional.of("teste");
        System.out.println(opt.orElse(metodo()));
        System.out.println(opt.orElseGet(() -> metodo()));
        //O método só é chamado no primeiro caso, pois o retorno dele deve ser passado para orElse. com orElse o método é chamado mesmo se optional não for vazio
        //Já o orElseGet só chama o método se o Optional for vazio (então neste caso, ele não é chamado). só é chamado quando realmente necessário.

        Optional<String> e1 = Optional.ofNullable("er");
        System.out.println(e1.orElse("345345345"));//aqui como não foi chamado um metodo vai retornar "er" e não o valor dentro do orElse

        String t1 = e1.isPresent() ? e1.get() : null;
        //outra forma de fazer o mesmo da linha acima:
        t1 = e1.orElse(null); //retorno dentro do orElse deve ser do mesmo tipo
        System.out.println(t1);

	//ex: final Collection<T> teste = Optional.ofNullable(pessoa.getId()).map(p -> this.testeService.findById(p.getId())).orElseGet(() -> new ArrayList<>());
	//se caso pessoa.getId Não for NULL será retornado o que está no map(), senão é retornado o orElseGet

	/*
 	orElseGet vs. orElse
  	Ambos retornam algo se o Optional não tiver um valor.

    	A diferença é no orElse você fornece o valor a ser retornado, e no orElseGet você fornece um Supplier (um objeto que retorna o valor). Ex:

     	Optional<String> opt = Optional.empty();
	System.out.println(opt.orElse("ola"));
	System.out.println(opt.orElseGet(() -> "ola"));

 	Ambos imprimem "ola". Evidentemente que dentro do orElseGet você pode criar um método tão complexo quanto queira:
  	System.out.println(opt.orElseGet(() -> {
	    // faz outras coisas complexas aqui
	    return resultadoDasCoisasComplexasAcima;
	}));

 	Mas nada impede que o método que faz várias coisas complexas sejam chamado diretamente e o resultado passado para orElse:
	System.out.println(opt.orElse(metodoQueFazVariasCoisasComplexas()));
	A diferença é que nesse caso o método é chamado e seu retorno é passado para orElse. Já se eu chamar orElseGet, o método só é chamado se o Optional não tiver um valor:

	public String metodo() {
	    System.out.println("dentro do método");
	    return "ola";
	}
	...
	
	Optional<String> opt = Optional.empty();
	System.out.println(opt.orElse(metodo()));
	System.out.println(opt.orElseGet(() -> metodo()));
	Como o Optional é vazio, ambos chamarão pelo método. A saída é:

	dentro do método
	ola
	dentro do método
	ola
	Mas se o Optional não for vazio:
	
	Optional<String> opt = Optional.of("teste");
	System.out.println(opt.orElse(metodo()));
	System.out.println(opt.orElseGet(() -> metodo()));
	O método só é chamado no primeiro caso, pois o retorno dele deve ser passado para orElse. Já o orElseGet só chama o método se o Optional for vazio (então neste caso, ele não é chamado). 
 	A saída é:

	dentro do método
	teste
	teste
	Isso faz diferença nos casos em que o método a ser chamado é muito custoso (faz operações complexas, demoradas, gasta muito processamento ou memória, o objeto retornado é "muito grande", etc). 
 	Nesses casos, usar orElseGet é uma opção melhor que orElse, pois aí o método só é chamado quando realmente necessário.
  	*/
    }
}
