/******************************************************************************

Quando trabalhamos com herança e dizemos que uma subclasse PessoaFisica e PessoaJuridica são filhas da super classe Pessoa,
podemos então dizer que um PessoaFisica É UMA Pessoa e PessoaJuridica É UMA Pessoa, justamente por ser uma extensão ou tipo mais especificado deste. 
Essa é a semântica da herança.

Exemplo de polimorfismo.
Dizer que uma Pessoa É UMA PessoaFisica está errado, porque ela pode também ser uma PessoaJuridica.

Quando trabalhamos com uma variável do tipo Pessoa que é uma super classe, podemos fazer está variável receber um objeto do 
tipo PessoaFisica ou PessoaJuridica, por exemplo:

Pessoa fisica = new PessoaFisica();
Pessoa juridica = new PessoaJuridica();

Com isso, podemos dizer que polimorfismo é a capacidade de um objeto ser referenciado de diversas formas diferentes 
e com isso realizar as mesmas tarefas (ou chamadas de métodos) de diferentes formas.


Um exemplo do uso do polimorfismo utilizando a classe Pessoa, seria todas as subclasses sobrescreverem o método public String getNome().

A subclasse PessoFisica sobrescreve o método public String getNome() e retorna a seguinte frase: “Pessoa Fisica: nomePessoa – CPF: cpfPessoa”.
A subclasse PessoaJuridica sobrescreve o método public String getNome() e retorna a seguinte frase: “Pessoa Juridica: nomePessoa – CNPJ: cnpjPessoa”.

Desta maneira, independentemente do nosso objeto PessoaFisica e PessoaJuridica ter sido atribuído a uma 
referencia para Pessoa, quando chamamos o método public String getNome() de ambas variáveis, temos a seguinte saída:

Pessoa Fisica: Cristiano - CPF: 0
Pessoa Juridica: Rafael - CNPJ: 0

Mesmo as variáveis sendo do tipo Pessoa, o método public String getNome() foi chamado da classe PessoaFisica e PessoaJuridica,
porque durante a execução do programa, a JVM percebe que a variável fisica está guardando um objeto do tipo PessoaFisica, 
e a variável juridica está guardando um objeto do tipo PessoaJuridica.


*******************************************************************************/

class Pessoa {
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }
}


class PessoaFisica extends Pessoa {
  private long cpf;

  public PessoaFisica() {
  }

  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return "Pessoa Fisica: " + super.getNome() + " - CPF: " + this.getCpf();
  }
}


class PessoaJuridica extends Pessoa {
  private long cnpj;

  public PessoaJuridica() {
  }

  public long getCnpj() {
    return cnpj;
  }

  public void setCnpj(long cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome() {
    return "Pessoa Juridica: " + super.getNome() + " - CNPJ: " + this.getCnpj();
  }
}


class Main{
    public static void main(String[] args){
        Pessoa fisica = new PessoaFisica();
        fisica.setNome("Cristiano");
        //fisica.setCpf(12345678901L);
        
        //se tentar utilizar a variável do tipo Pessoa para atribuir o CPF através do método public void setCpf(long cpf) 
        //teremos um erro de compilação, pois somente a classe PessoaFisica possui este método
        //e a variavel fisica é do tipo Pessoa e não PessoaFisica
        //portanto a variavel fisica só pode chamar os metodos da classe Pessoa pois é o tipo dela
        
        /* mesmo o objeto sendo do tipo PessoaFisica, quando chamamos um método através da classe Pessoa, 
        só podemos chamar os métodos que existem na classe Pessoa */
        
        // Durante a execução do programa, a JVM verifica qual a classe de origem do objeto e chama o método desta classe.
        // Para podermos atribuir o valor para CPF ou CNPJ, é preciso ter variáveis do tipo PessoaFisica e PessoaJuridica
        //como no exemplo abaixo:
        
        // PessoaFisica fisica = new PessoaFisica();
        // fisica.setNome("Cristiano");
        // fisica.setCpf(12345678901L);
    
        // PessoaJuridica juridica = new PessoaJuridica();
        // juridica.setNome("Rafael");
        // juridica.setCnpj(1000100012345678L);
        
        
    
        Pessoa juridica = new PessoaJuridica();
        juridica.setNome("Rafael");
    
        Pessoa[] pessoas = new Pessoa[2];
        pessoas[0] = fisica;
        pessoas[1] = juridica;
    
        for(Pessoa pessoa : pessoas) {
          System.out.println(pessoa.getNome());
        }
        
        
        
        /*
        Se criarmos variáveis do tipo PessoaFisica ou PessoaJuridica, atribuirmos os valores para nome e cpf ou cnpj, 
        depois disso podemos fazer variáveis do tipo Pessoa terem referencia para o mesmo objeto que as variáveis do 
        tipo PessoaFisica e PessoaJuridica:
        */
        
        Pessoa pessoa1 = fisica;
        Pessoa pessoa2 = juridica;
    
        System.out.println("Pessoa 1");
        System.out.println(pessoa1.getNome());
    
        System.out.println("Pessoa 2");
        System.out.println(pessoa2.getNome());
        
        //Na linha 138 foi criado uma variável pessoa1 do tipo Pessoa que recebe um objeto do tipo PessoaFisica.
        //Na linha 139 foi criado uma variável pessoa2 do tipo Pessoa que recebe um objeto do tipo PessoaJuridica.
        
        
        
        
        /*
        Vimos anteriormente que uma Pessoa (super classe) nem sempre É UMA PessoaFisica (subclasse), mas quando estamos trabalhando 
        com uma super classe e temos a certeza de qual o tipo de subclasse ele está representando podemos fazer o casting de objetos, 
        para guardar o objeto em sua classe, funciona de forma similar ao casting de atributos primitivos:
        */
        PessoaFisica f2 = (PessoaFisica) pessoa1;
        f2.setCpf(12345678901L);
    
        PessoaJuridica j2 = (PessoaJuridica) pessoa2;
        j2.setCnpj(1000100012345678L);
        
        
    }
}

