package exceção;

import java.util.InputMismatchException;
import java.util.Scanner;

public class excecao2 implements Interface{

    @Override
    public void soma(int x, int z) {
        int soma=x+z;
        System.out.println(soma);
    }

    @Override
    public void multiplica(int y, int u) {
        int m=y*u;
        System.out.println(m);
    }
    
    public static void main(String[] args) {
        excecao2 ex=new excecao2();
        Scanner s=new Scanner(System.in);
        int a=0,p=0;
        System.out.println("digite um número");
        try{
            a=s.nextInt();
        }catch(InputMismatchException i){
            System.out.println("nesse campo só é permitido números"+i);
        }
        
        System.out.println("digite outro número");
        try{
            p=s.nextInt();
        }catch(InputMismatchException i){
            System.out.println("nesse campo só é permitido números"+i);
        }
        
        ex.soma(a, p);
        ex.multiplica(a, p);
        
    }
}
