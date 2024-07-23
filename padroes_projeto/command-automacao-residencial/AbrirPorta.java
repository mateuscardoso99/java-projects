package com.example;

//receiver
public class AbrirPorta extends Device{

    public boolean isAberta(){
        return isOn;
    }

    @Override
    public void onOff() {
        this.isOn = true;
    }
    
}
