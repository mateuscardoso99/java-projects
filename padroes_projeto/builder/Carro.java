//Carro é uma classe de produto

public class Carro {
    private final TipoCarro tipoCarro;
    private final int lugares;
    private final Motor motor;
    private final Transmissao transmissao;
    private final ComputadorDeBordo computadorDeBordo;
    private final GPSNavigator gpsNavigator;
    private double combustivel = 0;

    public Carro(TipoCarro tipoCarro, int lugares, Motor motor, Transmissao transmissao, ComputadorDeBordo computadorDeBordo, GPSNavigator gpsNavigator) {
        this.tipoCarro = tipoCarro;
        this.lugares = lugares;
        this.motor = motor;
        this.transmissao = transmissao;
        this.computadorDeBordo = computadorDeBordo;
        if (this.computadorDeBordo != null) {
            this.computadorDeBordo.setCarro(this);
        }
        this.gpsNavigator = gpsNavigator;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setcCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public int getLugares() {
        return lugares;
    }

    public Motor getMotor() {
        return motor;
    }

    public Transmissao getTransmissao() {
        return transmissao;
    }

    public ComputadorDeBordo getComputadorDeBordo() {
        return computadorDeBordo;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}
