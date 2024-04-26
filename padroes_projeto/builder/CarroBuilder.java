
//Os construtores concretos implementam etapas definidas na interface comum.
public class CarroBuilder implements Builder{
    private TipoCarro tipoCarro;
    private int lugares;
    private Motor motor;
    private Transmissao transmissao;
    private ComputadorDeBordo computadorDeBordo;
    private GPSNavigator gpsNavigator;

    @Override
    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    @Override
    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    @Override
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public void setTransmissao(Transmissao transmissao) {
        this.transmissao = transmissao;
    }

    @Override
    public void setComputadorDeBordo(ComputadorDeBordo computadorDeBordo) {
        this.computadorDeBordo = computadorDeBordo;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Carro getResult() {
        return new Carro(tipoCarro, lugares, motor, transmissao, computadorDeBordo, gpsNavigator);
    }
}
