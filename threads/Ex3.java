/*
A thread A está executando seu processamento normalmente, até encontrar um "synchronized()". 
Neste ponto a thread A sabe que deve garantir a exclusão mútua do objeto que ela está trabalhando. 
Vamos supor que tenha um objeto chamado "b", ou seja, enquanto a thread A estiver com a "trava" de "b" ninguém poderá acessá-lo ou fazer qualquer outra operação com o mesmo.

Então com a trava do objeto "b" garantida, a execução continua até que a mesma encontra um "b.wait()". Neste ponto a thread A libera o objeto "b" (libera a trava) e “dorme” até que uma outra thread, 
através do mesmo objeto "b", a notifique que ela já pode "acordar".
Então imagine agora que a thread B que estava aguardando o objeto "b" ser liberado começa o seu processamento (já que a thread A está "dormindo"). 
Mas lembre-se: A thread B já estava em execução, mesmo quando a thread A estava sendo executada, mas ela estava aguardando a thread A liberar o objeto "b", pois ele estava como synchronized.
Após terminar todo processamento com o objeto "b", a thread B chamada o "b.notify()", para "acordar" a thread A. 
Mas atente há um ponto: diferente do wait (que libera a trava do objeto instantaneamente) o método notify não libera a trava do objeto, apenas acorda a thread que estava dormindo. 
Sendo assim, mesmo depois de acordar a thread A, a thread B continua sua execução até sair do bloco synchronized(). Ao sair, como a thread A já está acordada, 
automaticamente ela obtêm a trava do objeto "b", novamente.
A thread A continua a sua execução logo após a execução do "b.notify()" e termina a mesma com sucesso.
Neste cenário, foi possível perceber o funcionamento total de duas threads conversando entre si através de um objeto e seus métodos wait e notify
*/

public class ThreadA {
     public static void main(String[] args){
      ThreadB b = new ThreadB();
      b.start();

      synchronized(b){
          try{
              System.out.println("Aguardando o b completar...");
              b.wait();
          }catch(InterruptedException e){
              e.printStackTrace();
          }

          System.out.println("Total é igual a: " + b.total);
      }
  }
}
public class ThreadB extends Thread {
        int total;
         @Override
         public void run(){
             synchronized(this){
                 for(int i=0; i<200 ; i++){
                     total += i;
                 }
                 b.notify();
             }
         }
}
