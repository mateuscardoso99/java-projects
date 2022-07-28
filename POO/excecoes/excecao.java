package exceção;


public class excecao {
    
    public static void main(String[] args) {
        System.out.println("início da main");
        metodo1();
        System.out.println("fim da main");
    }
    
    public static void metodo1(){
        System.out.println("inicio do metodo1");
        metodo2();
        System.out.println("fim do metodo1");
    }
    
    public static void metodo2(){
        System.out.println("inicio do metodo2");
        int array[]=new int[10];
        try{
            for(int i=0;i<15;i++){
                array[i]=i;
                System.out.println(i);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("o vetor tem 10 elementos e não 15");
        }
        
        System.out.println("fim do metodo2");
    }
    
}
