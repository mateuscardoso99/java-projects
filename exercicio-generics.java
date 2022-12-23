/*
Faça uma classe genérica Par que tem 2 parâmetro de
tipo – F e S, cada um representando respectivamente o
tipo do primeiro elemento e o tipo do segundo elemento
do par. Adicione os métodos set e get.
O cabeçalho da classe deve ser: public class Par
<F,S>.
Crie um array de Par e verifique se o método printArray
irá funcionar. Caso não funcionar, reescreva o método
pra que imprima os todos os pares do array
*/

class Par<F,S> {
     private F first;
     private S second;
    
     public Par(F x, S y){
         first=x;
         second = y;
     }
     public void setFirst(F x){
        first = x;
     }
     public void setSecond(S x){
        second = x;
     }
     public F getFirst(){
        return first;
     }
     public S getSecond(){
        return second;
     }
     public void printPar(){
        System.out.println("First: "+first+"\nSecond: "+second);
     }
}


public class Main {
     public static void main(String args[]){
         Par par1 = new Par<Integer,Double>(1,56.89);
         Par par2 = new Par<Integer,Double>(2,2.2);
         Par par3 = new Par<Integer,String>(3,"ola");
        
         Par[] arrayPar = new Par[3];
         arrayPar[0]=par1;
         arrayPar[1]=par2;
         arrayPar[2]=par3;
         printArray(arrayPar);
     }
     public static <T extends Par> void printArray(T[] array){
         for(int i=0;i<array.length; i++){
            System.out.println("First: "+array[i].getFirst());
            System.out.println("Second: "+array[i].getSecond());
         }
     }
}
