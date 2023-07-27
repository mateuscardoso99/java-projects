//Junit: framework de testes unitários (teste de funcionalidades específicas, métodos) para java
//adicionar no pom.xml dependencia do junit
//ideal é que cada classe tenha uma classe de teste junit

class Calculadora{
    public int somar(String expressao) {
        int soma=0;
        for(String valor:expressao.split("\\+")){
            soma+=Integer.valueOf(valor);
        }
        return soma;
    }
}

//exemplo teste junit
class CalculadoraTeste{

    //@Test //anotacao junit de teste, existem varias
    public void teste_somar(String expressao) {
        Calculadora c = new Calculadora();
        int soma = c.somar("1+1+1");
        //assertEquals(3,soma);//metodo do junit, tem tbm assertFalse pra ver se resultado é false e vários outros, todos da classe org.junit.Assert
    }
}

//Rules do junit permite criar pastas/arquivos/conexoes com bd durante o teste
//quando for fazer build do projeto esses testes serão executados e caso não passem o build dá erro, dando mais confiança ao software
//mocks: objetos e dados ficticios para testes