class Sobrecarga{
    //mesmo nome, tipos de parametros ou quantidade diferentes

    public int funcao(){
        return 1;
    }

    public char funcao(char i){
        return i;
    }

    public int funcao(int i){
        return i;
    }

    public int funcao(int a, int b){
        return a;
    }

    //erro, funcao() sem parametros ja foi declarada
    //public void funcao(){}
}