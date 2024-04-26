/*
O Diretor define a ordem das etapas de construção. 
Funciona com um objeto construtor através da interface comum do Builder. 
Portanto, pode não saber qual produto está sendo construído
*/
public class Director {
    public void constructCarroEsportivo(Builder builder) {
        builder.setTipoCarro(TipoCarro.CARRO_ESPORTIVO);
        builder.setLugares(2);
        builder.setMotor(new Motor(3.0, 0));
        builder.setTransmissao(Transmissao.SEMI_AUTOMATICO);
        builder.setComputadorDeBordo(new ComputadorDeBordo());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCarroUrbano(Builder builder) {
        builder.setTipoCarro(TipoCarro.CARRO_URBANO);
        builder.setLugares(2);
        builder.setMotor(new Motor(1.2, 0));
        builder.setTransmissao(Transmissao.AUTOMATICO);
        builder.setComputadorDeBordo(new ComputadorDeBordo());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setTipoCarro(TipoCarro.SUV);
        builder.setLugares(4);
        builder.setMotor(new Motor(2.5, 0));
        builder.setTransmissao(Transmissao.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
