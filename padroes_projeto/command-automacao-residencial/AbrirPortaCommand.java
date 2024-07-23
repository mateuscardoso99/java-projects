package com.example;

public class AbrirPortaCommand implements Command{
    private Device device;

    public AbrirPortaCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("abrindo porta");
        device.onOff();
    }
    
}
