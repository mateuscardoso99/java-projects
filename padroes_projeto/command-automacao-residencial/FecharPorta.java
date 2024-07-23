package com.example;

//receiver
public class FecharPorta extends Device{

    public boolean isAberta(){
        return isOn;
    }

    @Override
    public void onOff() {
        this.isOn = false;
    }
    
}