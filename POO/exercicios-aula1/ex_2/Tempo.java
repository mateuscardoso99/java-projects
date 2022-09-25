public class Tempo {
    private int horas;
    private int minutos;
    private int segundos;

    public int getHoras(){
        return this.horas;
    }
    public int getMinutos(){
        return this.minutos;
    }
    public int getSegundos(){
        return this.segundos;
    }

    public void setHoras(int horas){
        if(horas < 0 || horas > 23){
            System.out.println("hora invalida");
        }
        else{
            this.horas = horas;
        }
    }

    public void setMinutos(int mins){
        if(mins < 0 || mins > 59){
            System.out.println("minutos invalido");
        }
        else{
            this.minutos = mins;
        }
    }

    public void setSegundos(int s){
        if(s < 0 || s > 59){
            System.out.println("segundos invalido");
        }
        else{
            this.segundos = s;
        }
    }

    public void incrementarHoras(int h){
        if(this.horas == 23){
            this.horas = 0;
        }
        else{
            this.horas++;
        }
    }

    public void incrementarMinutos(int m){
        if(this.minutos == 59){
            this.minutos = 0;
            this.horas++;
        }
        else{
            this.minutos++;
        }
    }

    public void incrementarSegundos(int s){
        if(this.segundos == 59){
            this.segundos = 0;
            this.minutos++;
        }
        else{
            this.segundos++;
        }
    }

    public int tempoEmSegundos(){
        return this.horas * 3600 + this.minutos * 60 + this.segundos;
    }

    public String toString(){
        return String.valueOf(this.horas)+":"+String.valueOf(this.minutos)+":"+String.valueOf(this.segundos);
    }
}
