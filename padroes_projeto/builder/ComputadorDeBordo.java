//Apenas mais uma característica de um carro.

public class ComputadorDeBordo {
    private Carro carro;

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void showNivelCombustivel() {
        System.out.println("Nível combustível: " + carro.getCombustivel());
    }

    public void showStatus() {
        if (this.carro.getMotor().isLigado()) {
            System.out.println("Carro está ligado");
        } else {
            System.out.println("Carro não está ligado");
        }
    }
}
