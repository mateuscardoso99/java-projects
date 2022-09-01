package ligarTV;

abstract class Eletronico implements Comportamentos{
    private String estado;
    private int volume;
    private int brilho;
    private float bateria;

    public Eletronico(String estado, int volume, int brilho, float bateria){
        this.estado = estado;
        this.volume = volume;
        this.brilho = brilho;
        this.bateria = bateria;
    }

    public String getEstado(){
        return estado;
    }
    public int getVolume(){
        return volume;
    }
    public int getBrilho(){
        return brilho;
    }
    public float getBateria(){
        return bateria;
    }
    public void setEstado(String est){
        estado = est;
    }
    public void setVolume(int vol){
        volume = vol;
    }
    public void setBrilho(int br){
        brilho = br;
    }
    public void setBateria(float b){
        bateria = b;
    }
}
