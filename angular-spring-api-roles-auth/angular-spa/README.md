# conceitos
- arquivos .spec.ts são arquivos usados em testes

- arquivos environment.ts e environment.prod.ts é onde vão as variáveis de ambiente

- arquivo polyfills.ts ajuda na compatibilidade do código entre navegadores

- services: é uma classe que tem como objetivo Fornecer um Serviço a um Componente, Diretiva ou a outro Serviço. O Serviço pode estar buscando dados do back-end, executando uma lógica de negócios, etc.

- component: contém a lógica de interação de dados e usuário que define como a Visualização se parece e se comporta. Uma visualização em Angular refere-se a um modelo (HTML). Os Componentes Angulares são classes JavaScript simples e definidas usando @Component Decorator. Este Decorador fornece ao componente a Visão para exibir e Metadados sobre o Componente O Componente é responsável por fornecer os dados para a visualização.

- diretivas: A diretiva Angular nos ajuda a manipular o DOM. Você pode alterar a aparência, o comportamento ou o layout de um elemento DOM usando as diretivas. Eles ajudam você a estender o HTML. As diretivas Angular são classificadas em três categorias com base em como elas se comportam. São Diretivas de Componentes, Estruturais e de Atributos O ngFor é uma diretiva estrutural Angular, que repete uma parte do template HTML uma vez por cada item de uma lista iterável (Collection). O ngSwitch nos permite adicionar/remover o elemento DOM. É semelhante à instrução switch do Javascript. O ngIf nos permite adicionar/remover o elemento DOM. A diretiva ngClass é uma diretiva de atributo angular, que nos permite adicionar ou remover classes CSS a um elemento HTML. A diretiva ngStyle permite modificar o estilo de um elemento HTML usando a expressão. Usando o ngStyle você pode alterar dinamicamente o estilo do seu elemento HTML.

- pipes: Os Pipes são usados ​​para transformar os dados. Por exemplo, o pipe Date formata a data de acordo com as regras de localidade. Podemos passar argumentos para pipes e chain pipes. O Angular também nos permite criar o Custom Pipe


## ciclo de vida

- constructor: Constructor não é um gancho de ciclo de vida nem é específico para Angular. É um recurso Javascript. É um método que é invocado quando uma classe é criada. Angular faz uso de um construtor para injetar dependências. Neste ponto, nenhuma das propriedades de entrada dos componentes está disponível para uso. Nem seus componentes filho são construídos. Os conteúdos projetados também não estão disponíveis. Portanto, não há muito que você possa fazer neste método. E também é recomendável não usá-lo Uma vez que o Angular instancia a classe, ele inicia o primeiro ciclo de detecção de alterações do componente.

- ngOnChanges: invocado sempre que qualquer propriedade de entrada vinculada a dados do componente ou diretiva for alterada.

- ngOnInit: O Angular gera o gancho ngOnInit, após criar o componente e atualizar suas propriedades de entrada. Este hook é acionado apenas uma vez e imediatamente após sua criação (durante a primeira detecção de alteração). Este é um lugar perfeito onde você deseja adicionar qualquer lógica de inicialização para seu componente. Aqui você tem acesso a todas as propriedades de entrada do componente. Você pode usá-los em solicitações http get para obter os dados do servidor de back-end ou executar alguma lógica de inicialização etc. Mas observe que nenhum componente filho ou conteúdo projetado está disponível neste momento. Portanto, quaisquer propriedades que decoramos com @ViewChild, @ViewChildren , @ContentChild & @ContentChildren não estarão disponíveis para uso.

- ngDoCheck: O Angular invoca o evento de gancho ngDoCheck durante cada ciclo de detecção de alterações. Esse gancho é invocado mesmo se não houver alteração em nenhuma das propriedades. Angular o invoca após os ganchos ngOnChanges & ngOnInit. Use este gancho para implementar uma detecção de alteração personalizada, sempre que o Angular falhar ao detectar as alterações feitas nas propriedades de entrada. Esse gancho é particularmente útil quando você opta pela estratégia de detecção de alterações Onpush. O gancho Angular ngOnChanges não detecta todas as alterações feitas nas propriedades de entrada.

- ngAfterContentInit: O gancho do ciclo de vida é chamado depois que o conteúdo projetado do Componente foi totalmente inicializado.

- ngAfterContentChecked: ngAfterContentChecked O gancho do ciclo de vida é chamado durante cada ciclo de detecção de alterações após o Angular concluir a verificação do conteúdo projetado do componente.

- ngAfterViewInit: é chamado após a visualização do componente e todas as visualizações filhas serem totalmente inicializadas.

- ngAfterViewChecked: O Angular dispara este gancho depois de verificar e atualizar as visualizações do componente e as visualizações filhas.

- ngOnDestroy: é chamado logo antes da instância Component/Directive ser destruída pelo Angular Você pode executar qualquer lógica de limpeza para o componente aqui. Este é o local correto onde você deseja cancelar a assinatura de Observables e desanexar manipuladores de eventos para evitar vazamentos de memória.

* os hooks de ciclo de vida precisam ser importados nos componentes para serem usados.


## módulos
- O módulo Angular (também conhecido como ngModule) nos ajuda a organizar as partes do aplicativo em blocos coesos de funcionalidade. Cada bloco se concentra em fornecer uma funcionalidade ou um recurso específico. O módulo Angular deve implementar um recurso específico. Os Componentes, Diretivas, Serviços que implementam tal funcionalidade, passarão a fazer parte desse Módulo. O design modular ajuda a manter a separação de interesses. Mantenha os recursos juntos. Facilita a manutenção do código. Facilita a reutilização do código. O próprio Angular é construído sobre o conceito de Módulos. O @angular/core é o módulo principal do Angular, que implementa a funcionalidade principal do Angular, serviços de baixo nível e utilitários.

@NgModule({
  declarations: [],
  imports:      [],
  providers:    [],
  exports:      [],
  bootstrap:    [],
  entrycomponents: []
})

- declarations: É aqui que os componentes, diretivas e pipes que pertencem a este NgModule são declarados. Você deve adicionar apenas aqueles que pertencem a este módulo. O Componente não pode pertencer a mais de um módulo. Os services não devem ser declarados aqui. Eles são definidos na matriz Angular Providers.

- providers: Os Services que você deseja adicionar à coleção global de services são adicionados aqui. Os services ficam então disponíveis para injeção via injeção de dependência.
Os services são globais em escopo. Os services adicionados ao array Providers estão disponíveis para injeção em todo o aplicativo.

- imports: Se você deseja que este ngModule exija algum recurso ou funcionalidade, esses módulos precisam ser importados aqui.

- exports: Se você deseja que outros módulos usem o componente, pipes, diretivas deste NgModule, eles devem ser especificados aqui.

- bootstrap: O componente principal deste módulo, que precisa ser carregado quando o módulo é carregado, é especificado aqui. Isso é obrigatório se você for o primeiro módulo (chamado de módulo raiz) carregado quando o aplicativo Angular for iniciado. É responsabilidade do módulo raiz carregar a primeira visualização e isso é feito especificando o componente aqui. Se o módulo não for o módulo raiz, você deve manter isso em branco.

- entrycomponents: Os componentes que são carregados dinamicamente precisam ser declarados aqui. Os componentes são carregados quando o angular: 
- Localiza o seletor de componentes no HTML 
- Declarado no array bootstrap 
- Declarado na definição de raiz.

Se o seu componente não estiver listado em nenhum dos itens acima, ele precisa ser declarado no EntryComponent para que o Angular saiba onde encontrá-los e compilá-los.


## alguns decorators:
- @Injectable: Decorator que marca uma classe como disponível para ser fornecida e injetada como uma dependência.

- Observable: funcionalidade da biblioteca rxjs, que é utilizada internamente pelo framework e já é instalada quando você cria uma nova aplicação Angular. Com Observables, conseguimos lidar com transferência de dados assíncrona. Muitas vezes, seu uso é semelhante ao de Promises do Javascript, porém, podendo ser uma fonte de transferência de dados contínua, ou seja, o Observable poderá emitir dados várias vezes em momentos distintos de sua existência.

Seu uso consiste em basicamente se inscrever (subscribe) à um Observable, informando o que deverá ser feito com o dado que irá receber. Essa inscrição poderá escutar 3 interações: sucesso, erro e completo (encerrado). Podemos informar no próprio subscribe, via parâmetro, as funções que devem ser executadas quando alguma dessas interações ocorrerem, sendo somente função de sucesso obrigatória.

o método next() emite os dados para todos os inscritos
Além do método next(), temos o error(), ao qual, pode-se passar uma mensagem de erro que, da mesma forma que passo dados através do next(), o Observable emitirá à todos observadores.
Por fim, o observador também disponibiliza o método complete(), que aciona a terceira função que passamos por parâmetro, encerrando o Observable no mesmo instante, porém, sem passar nenhuma informação.




# AngularSpringApi

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.0.0.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.