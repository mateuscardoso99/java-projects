
//Carro manual é outro produto. Observe que ele não tem o mesmo ancestral como um carro. Eles não estão relacionados
public class Manual {
    private final TipoCarro tipoCarro;
    private final int seats;
    private final Motor motor;
    private final Transmissao transmissao;
    private final ComputadorDeBordo computadorDeBordo;
    private final GPSNavigator gpsNavigator;

    public Manual(TipoCarro tipoCarro, int seats, Motor motor, Transmissao transmissao, ComputadorDeBordo computadorDeBordo, GPSNavigator gpsNavigator) {
        this.tipoCarro = tipoCarro;
        this.seats = seats;
        this.motor = motor;
        this.transmissao = transmissao;
        this.computadorDeBordo = computadorDeBordo;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Tipo de carro: " + tipoCarro + "\n";
        info += "Total de lugares: " + seats + "\n";
        info += "Motor: volume - " + motor.getVolume() + "; quilometragem - " + motor.getQuilometragem() + "\n";
        info += "Transmissao: " + transmissao + "\n";
        if (this.computadorDeBordo != null) {
            info += "Computador de bordo: Funcional" + "\n";
        } else {
            info += "Computador de bordo: N/A" + "\n";
        }
        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Funcional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }
}
