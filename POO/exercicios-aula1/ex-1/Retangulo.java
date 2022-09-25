package ex_1;

public class Retangulo {
    private float altura;
    private float largura;

    public float getAltura(){
        return this.altura;
    }

    public void setAltura(float a){
        if(this.validarAlturaLargura(a)){
            this.altura = a;
        }
        else{
            System.out.print("altura invalida");
        }
    }

    public float getLargura(){
        return this.largura;
    }

    public void setLargura(float l){
        if(this.validarAlturaLargura(l)){
            this.largura = l;
        }
        else{
            System.out.println("largura invalida");
        }
    }

    private boolean validarAlturaLargura(float valor){
        if(valor < 0 || valor > 20){
            return false;
        }
        return true;
    }

}
