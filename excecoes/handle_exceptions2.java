import java.io.IOException;

/*
catch (MyException e) {
    throw new MyException ("Error processing request", e);
}
vs:
catch (MyException e) {
    throw e;
}
A primeira abordagem seria melhor porque você mudaria sua mensagem para uma mais amigável. Talvez você também possa registrá-lo (stacktrace ou qualquer outra coisa ...) antes de jogá-lo novamente

Não vejo sentido em capturar a exceção e lançá-la novamente. Um cenário raro pode ser que você precise executar alguma operação quando a exceção ocorreu, 
mas ao mesmo tempo relatar a exceção ao chamador para tomar a ação apropriada.
Se for esse o caso, a primeira abordagem é melhor porque você está apenas lançando a mesma exceção novamente (em vez de criar uma nova vez). 
A propósito, ambas as abordagens preservarão o rastreamento de pilha , apenas o caso é que a primeira evitará a criação de objetos desnecessários 
*/



//quando é dado throw new independente de qual exceção for, todas tem um construtor que pode ser passada uma string com a mensagem de erro

class A{
    void testeA() throws Exception{
        throw new Exception("sdf");
    }
}

class B{
    void testeB() throws IOException{
        throw new IOException("exception lançada em testeB");
    }
}

class C{
    void testeC(B b){
        try{
            b.testeB();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("finally");
        }
    }
}

class D{
    void testeD(B b) throws Exception{
        try{
            b.testeB();
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw new Exception("Exception lançada"); //passa a exceção pro metodo que o chamou
        }finally{//sempre executa, com ou sem exceção ocorrida
            System.out.println("finally");
        }
    }
}

public class Main{
    //sem throws Exception não compila pois é preciso tratar aqui a exceção gerada em testeA() ou repassar pro metodo chamador usando "throws Exception"
    //nesse caso é usado throws RuntimeException, nesse caso se um método chamado aqui gerar uma RuntimeException ou 
    //outra exceção que é filha de RuntimeException essa exceção será passada pro método que chamou o metodo Main abaixo
    //se um metodo chamado aqui gerar uma Exception e não RuntimeException causa um erro de compilação
    //esse é o caso do metodo testeD() que lança uma Exception e o metodo Main que chamou ele
    //não trata e nem repassa exceções dessa classe, a solução seria ter um try catch na chamada de testeD tratando a exceção da classe Exception
    //ou na declaração do metodo Main ter throws RuntimeException, Exception
	public static void main(String[] args) throws RuntimeException{
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();

// se não definir throws Exception na declaração, precisa do bloco try catch pra tratar a exceção da classe Exception
// 		try{
// 		    a.testeA();
// 		}catch(Exception e){
// 		    System.out.println("ola");
// 		}
    
        c.testeC(b);
        
        try{
            d.testeD(b);
        }catch(Exception r){
            System.out.println("exceção tratada metodo Main");
        }
	}
}
