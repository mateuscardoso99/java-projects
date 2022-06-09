# conceitos

## anotações
- @Controller
Associada com classes que possuem métodos que processam requests numa aplicação web.

- @Repository
Classes que fazem o acesso ao BD. Comumente associada a DAO’s.

- @Service
Associada com classes que representam a ideia do Service do Domain Driven Design. Para ficar menos teórico pense em classes que representam algum fluxo de negócio da sua aplicação. Por exemplo, um fluxo de finalização de compra envolve atualizar manipular o carrinho, enviar email, processar pagamento etc. Este é o típico código que temos dificuldade de saber onde vamos colocar, em geral ele pode ficar num Service

- @Autowired
Anotação utilizada para marcar o ponto de injeção na sua classe. Você pode colocar ela sobre atributos ou sobre o seu construtor com argumentos.

- @RequestMapping
Geralmente utilizada em cima dos métodos de uma classe anotada com @Controller. Serve para você colocar as rotas da sua aplicação que, quando acessados por algum cliente, deverão ser direcionados para o determinado método.

- @ResponseBody
Utilizada em métodos anotados com @RequestMapping para indicar que o retorno do método deve ser automaticamente escrito na resposta para o cliente. Muito comum quando queremos retornar JSON ou XML em função de algum objeto da aplicação.

- @EnableAsync
Essa aqui não é tão comum, mas muitas vezes você precisa ações no sistema em background(outra thread). Essa annotation deve ser colocada em alguma classe marcada com @Configuration, para que o Spring habilite o suporte a execução assíncrona.

- @Async
Uma vez que seu projeto habilitou o uso de execução de métodos assíncronos com a @EnableAsync, você pode marcar qualquer método de um bean gerenciado do projeto com essa annotation. Quando tal método for invocado, o Spring vai garantir que a execução dele será em outra thread.

- @Required
Esta anotação é aplicada em métodos bean setter. Considere um cenário em que você precisa impor uma propriedade obrigatória. A anotação @Required indica que o bean afetado deve ser preenchido no momento da configuração com a propriedade necessária. Caso contrário, uma exceção do tipo BeanInitializationException será lançada.

- @Entity
Classe que mapeia uma tabela do banco de dados

- @Table
Mapeia o nome da tabela do BD com uma classe que é Entity 

- @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
Indica que a propriedade é um ID auto-increment

- @Column
Mapeia o nome de uma coluna do BD com um atributo de uma classe

- @NotBlank
Define que o atributo não pode ser setado com um valor em branco

- @Size(max = 50)
tamanho máximo de um atributo em caracteres

- @Email
Indica que o atributo deve ser um email válido

- @Path Variable
Declara um parâmetro de rota

- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
Mapeia rotas com os respectivos tipos

- @RestController
A anotação @RestController marca a classe como um controlador em que cada método retorna um objeto de domínio em vez de uma view. Ao anotar uma classe com essa anotação, você não precisa mais adicionar @ResponseBody a todo o método RequestMapping. Isso significa que você não usa mais view-resolvers ou envia html em resposta. Você apenas envia o objeto de domínio como resposta HTTP no formato que é entendido pelos consumidores como JSON.


## relacionamentos

- N pra N
- @ManyToMany(fetch = FetchType.LAZY)

parâmetros: 
    - cascade: As operações que precisam ser refletidas no alvo da associação.
    - fetch: Informa se o alvo da associação precisa ser obtido apenas quando for necessário ou se sempre - deve trazer.
    - mappedBy: Informa o atributo que é dono do relacionamento.
    - targetEntity: A classe entity que é alvo da associação.

- @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))//N pra N

- 1 pra N
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="aula_id")

- mais sobre relacionamentos: http://www.universidadejava.com.br/jee/jpa-manytoone/

- mais anotações: https://springframework.guru/spring-framework-annotations/



# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#using.devtools)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

