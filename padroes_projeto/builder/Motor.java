//Apenas mais uma característica de um carro.
public class Motor {
    private final double volume;
    private double quilometragem;
    private boolean ligado;

    public Motor(double volume, double quilometragem) {
        this.volume = volume;
        this.quilometragem = quilometragem;
    }

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void andar(double quilometragem) {
        if (ligado) {
            this.quilometragem += quilometragem;
        } else {
            System.err.println("Não é possível andar(), você deve ligar o motor primeiro!");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getQuilometragem() {
        return quilometragem;
    }
}
