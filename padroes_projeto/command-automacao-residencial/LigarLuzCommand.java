package com.example;

public class LigarLuzCommand implements Command{
    private Device device;

    public LigarLuzCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("ligando luz");
        device.onOff();
    }
    
}
