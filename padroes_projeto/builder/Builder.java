
//A interface do Builder define todas as formas possíveis de configurar um produto.
public interface Builder {
    void setTipoCarro(TipoCarro tipo);
    void setLugares(int lugares);
    void setMotor(Motor motor);
    void setTransmissao(Transmissao transmissao);
    void setComputadorDeBordo(ComputadorDeBordo computadorDeBordo);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}