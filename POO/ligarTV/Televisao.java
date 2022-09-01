package ligarTV;

public class Televisao extends Eletronico{

    public Televisao(String estado, int volume, int brilho, float bateria){
        super(estado,volume,brilho,bateria);
    }

    public void ligar(){
        this.setEstado("ligado");
    }
    public void desligar(){
        this.setEstado("desligado");
    }
    public void aumentarVolume(){
        this.setVolume(this.getVolume()+1);
    }
    public void diminuirVolume(){
        this.setVolume(this.getVolume()-1);
    }
    public void aumentarBrilho(){
        this.setBrilho(this.getBrilho()+1);
    }
    public void diminuirBrilho(){
        this.setBrilho(this.getBrilho()-1);
    }
}
