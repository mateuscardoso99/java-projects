//Atributos voláteis

//Trabalhar com várias threads causa muito mais dor de cabeça do que se possa imaginar. 
//Isso ocorre porque frequentemente várias threads precisam acessar e modificar objetos compartilhados.

//Imagine o seguinte cenário:

long i = 0;
void thread1() {
  //
  i++;
  //
}
void thread2() {
  //
  if (i == 1) {
    fazAlgo();
  }
  //
}

/*
No exemplo, as duas threads acessam a mesma variável. 
Assumindo que a leitura da thread2 ocorre, numa sequência de tempo, exatamente após o incremento da thread1, 
você acha que pode ocorrer algum problema de concorrência, considerando que o incremento parece uma operação atômica?

Uma análise ingênua diria que está tudo bem com as threads pois as duas executam operações atômicas de escrita e leitura, 
logo fazAlgo() seria executado sem problemas.

Errado.

Cada thread pode estar sendo executada em um processador diferente. 
Cada processador pode ter um cache próprio. Variáveis são lidas e gravadas primeiro no cache local 
antes de irem para a memória principal. Então, é possível que a segunda thread leia o valor antigo da variável

O cenário problemático ocorreria assim:

- T1 lê o valor de i = 0 da memória principal e faz o incremento; o novo valor i = 1 é armazenado no cache local, mas não na memória principal.
- T2 lê o valor de i = 0 da memória principal e não entra no if.

Pior que isto, variáveis de 64 bits como long e double podem ter sua escrita em memória dividida pela JVM em dois ciclos de 32 bits, 
o que poderia levar uma leitura completamente corrompida de seus valores.

Tais cenários são relativamente raros, mas extremamente difíceis de identificar em softwares complexos, 
causando aquele tipo de problema intermitente e ocasional que acaba sendo varrido para debaixo do tapete.

A solução, neste caso, é simples:

volatile long i = 0;

Um atributo volátil tem garantia de que o valor atualizado estará sempre disponível para outras threads, 
sendo gravado na memória principal assim que atualizado, de forma atômica.

Isso significa que, sempre que o valor for modificado em um processador, ocorrerá um flush para a memória principal, 
portanto as outras threads vão ver sempre o valor mais atualizado e não um possível valor defasado.

Claro que isso não é gratuito. 
Fazer o flush do cache para a memória principal penaliza o desempenho, 
afinal existe uma razão para os fabricantes de hardware colocarem caches nos processadores. 
É muito mais rápido acessar um registrador ou cache primário do que acessar a memória RAM.

Uma solução alternativa seria usar métodos de sincronização como um bloco synchronized ou variáveis atômicas como AtomicLong, 
os quais podem ser necessários quando há modificação concorrente, mas que são mais lentos.

No caso de escrita concorrente, como bem lembrado pelo Rafael na outra resposta, uma variável volatile ainda poderia incorrer em condição de corrida 
pois as duas threads podem ler o mesmo valor da memória principal, e o valor final dependeria de qual das threads escreveria ele por último.

Curiosamente, a classe AtomicLong usa volatile:

  private volatile long value;

Qual a diferença então? Ocorre que as classes atômicas usam a técnica conhecida como compare and swap, 
isto é, a operação de atualização da variável é condicionado ao valor antigo. 
Por exemplo, cada thread envia uma instrução parecido com "atualize o valor 1 para 2". 
O processador então garante que a variável somente será atualizada para 2 se o valor dela for 1, 
caso contrário a operação falha. 
Digamos que o valor agora era 3 e a operação falhou. A thread agora tenta novamente com "atualize o valor 3 para 2" e assim por diante até obter sucesso. 
Esta técnica garante que a atualização segura do valor em memória

*/



/*
é preciso ter em mente que um atributo volatile tem a função de não guardar caches, 
o que acaba auxiliando o problema da situação abaixo:

volatile int i = 0;                                                              
void thread1() {                                                                 
  i++;                                                                 
}                                                                 
void thread2() {                                                                 
  i++;                                                                 
} 

Porém, esta solução não elimina o problema de condição de corrida, pois, se ambas as threads tentarem incrementar ao mesmo tempo a variável, 
o volatile não impede que este valor mantenha-se errado. Para isto, é necessário sincronizar este trecho da incrementação como uma zona crítica.



Um uso mais apropriado para esta variável seria algo do tipo:

public class Foo extends Thread {
    private volatile boolean close = false;
    public void run() {
        while(!close) {
            // do work
        }
    }
    public void close() {
        close = true;
        // interrupt here if needed
    }
}


*/







