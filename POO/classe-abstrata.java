/******************************************************************************

1. Criar uma estrutura hierárquica que contenha+as+seguintes+classes:+
Veículo (classe abstrata)+com+um+atributo velocidade,+Bicicleta e Automóvel.+
2. Os+métodos da classe Veículo são todos abstratos e possuem+a+seguinte assinatura:+
a) public abstract float acelerar();
b) public abstract void parar();

3. Estes+métodos são implementados nas+subclasses+Automóvel e Bicicleta.++
4. Crie+um+classe+de+testes+com+o método main() e teste+as+classes+criadas acima.

*******************************************************************************/

abstract class Veiculo {

    private float velocidade;

    public Veiculo(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public abstract float acelerar();
    public abstract void parar();
}

class Automovel extends Veiculo{

    public Automovel(float vel) {
        super(vel);
    }

    @Override
    public float acelerar(){
        return this.getVelocidade()+10;
    }

    @Override
    public void parar(){
        this.setVelocidade(0);
    }
}

class Bicicleta extends Veiculo{

    public Bicicleta(float velocidade) {
        super(velocidade);
    }

    @Override
    public float acelerar(){
        return this.getVelocidade()+1;
    }

    @Override
    public void parar(){
        this.setVelocidade(0);
    }
}

public class Main{
    public static void main(String[] args) {
        Automovel a = new Automovel(0);
        Bicicleta b = new Bicicleta(0);
        a.acelerar();
        a.acelerar();
        b.acelerar();
        b.acelerar();
        a.acelerar();
        a.parar();
        b.parar();
    }
}
