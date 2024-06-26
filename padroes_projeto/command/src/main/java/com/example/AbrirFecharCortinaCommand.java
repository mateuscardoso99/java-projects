package com.example;

//CONCRETE COMMAND, que implementa interface Command
//Classe que implementa Command e modela uma operação específica do Receiver
public class AbrirFecharCortinaCommand implements Command{
    private Cortina cortina;

    public AbrirFecharCortinaCommand(Cortina cortina){
        this.cortina = cortina;
    }

    @Override
    public void execute() {
        cortina.abrirFechar();
    }
    
}
