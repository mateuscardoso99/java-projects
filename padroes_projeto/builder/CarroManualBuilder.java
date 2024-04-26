
//Ao contrário de outros padrões de criação, o Builder pode construir produtos não relacionados, que não possuem a interface comum.

//Neste caso construímos um manual do usuário para um carro, seguindo os mesmos passos que construir um carro. 
//Isto permite produzir manuais para modelos de automóveis específicos, configurado com recursos diferentes.
public class CarroManualBuilder implements Builder{
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

    public Manual getResult() {
        return new Manual(tipoCarro, lugares, motor, transmissao, computadorDeBordo, gpsNavigator);
    }
}
