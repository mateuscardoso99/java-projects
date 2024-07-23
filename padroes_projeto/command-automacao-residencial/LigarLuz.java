package com.example;

//receiver
public class LigarLuz extends Device{

    public boolean isLigado(){
        return isOn;
    }

    @Override
    public void onOff() {
        this.isOn = true;
    }

    
}
