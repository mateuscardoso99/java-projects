package com.example;

public class FecharPortaCommand implements Command{
    private Device device;

    public FecharPortaCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("fechando porta");
        device.onOff();
    }
}
