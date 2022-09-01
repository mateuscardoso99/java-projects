package ligarTV;

public class Main{

    public static void main(String[] args) {
        Televisao tv = new Televisao("desligado", 0, 60, 85);
        tv.ligar();
        tv.aumentarVolume();
        tv.aumentarVolume();
        tv.aumentarBrilho();
        tv.aumentarVolume();
        tv.aumentarVolume();
        tv.setBateria(84);
        System.out.println("tv: "+tv.getEstado()
            +" volume: "+tv.getVolume()
            +" brilho: "+tv.getBrilho()
            +" bateria: "+tv.getBateria()+"%");
    }
}