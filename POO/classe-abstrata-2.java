abstract class A{

    public abstract void imprimir(String txt);
    public void imprimir2(String txt){
        imprimir(txt);
        teste();
    }

    public void teste(){
        System.out.println("teste");
    }
}

class B extends A{

    @Override
    public void imprimir(String txt) {
        System.out.println(txt);
    }

    public void teste(){
        System.out.println("teste2222");
    }

    public static void main(String[] args) {
        B b = new B();
        b.imprimir("ola");
        b.imprimir2("oi");//imprimir2 chama método teste(), esse método tem nas 2 classes, nesse caso será chamado o método teste() da classe filha pois ela implementou a própria versão dele
        //imprimir2() não tem existe classe B, mas por herdar de A é como se existisse
    }
    
}
