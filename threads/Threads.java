//processos não compartilham o mesmo espaço de endereçamento, então não é possível compartilhar dados entre eles
//threads são processos que compartilham o mesmo espaço de endereçamento de memória, isso permite que várias threads usem a mesma variável
//o que pode erros nessas variáveis (chamado de acesso a área crítica), por isso se usa semáforos, monitores, syncronized etc..

// Threads permite que um programa opere com mais eficiência 
// fazendo várias coisas ao mesmo tempo. Os threads podem ser 
// usados ​​para executar tarefas complicadas em segundo plano sem 
// interromper o programa principal

//Existem duas maneiras de criar um thread. Ele pode ser criado estendendo a classe Thread e substituindo seu método run():
//Outra maneira de criar um thread é implementar a interface Runnable:

//Se a classe estender a classe Thread, o thread pode ser executado criando uma instância da classe e chamando seu método start():
//se a classe extende Thread não poderá extender outra, por isso a melhor forma é segunda


//Como os threads são executados ao mesmo tempo que outras partes do programa, 
//não há como saber em que ordem o código será executado. 
//Quando as threads e o programa principal estão lendo e escrevendo as mesmas variáveis, os valores são imprevisíveis. 
//Os problemas resultantes disso são chamados de problemas de simultaneidade.

//Para evitar problemas de simultaneidade, é melhor compartilhar o mínimo possível de atributos entre as threads. 
//Se os atributos precisarem ser compartilhados, uma solução possível é usar o método isAlive() da classe Thread
//para verificar se a Thread terminou a execução antes de usar quaisquer atributos que a Thread possa alterar

class Teste extends Thread{
    public static int amount = 0;

    public static void main(String[] args) {
        Teste thread = new Teste();
        thread.start(); //invoca o método run()

        // Espere a thread terminar
        // while(thread.isAlive()) {
        //     System.out.println("Waiting...");
        // }

        System.out.println(thread.getState());//retorna o estado da thread, executando, terminado etc..
        System.out.println(amount);
        amount++;
        System.out.println(amount);
        System.out.println(thread.getState());
    }
    public void run() {
        amount++;
    }
}


//Se a classe implementa a interface Runnable, o encadeamento pode ser executado 
//passando uma instância da classe para o construtor de um objeto Thread e, em seguida, 
//chamando o método start()
class Main implements Runnable {
    public static void main(String[] args) {
        Main obj = new Main();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This code is outside of the thread");
    }
    public void run() {
        System.out.println("This code is running in a thread");
    }
}
