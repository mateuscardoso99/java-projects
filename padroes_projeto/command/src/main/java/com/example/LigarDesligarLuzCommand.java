package com.example;

//CONCRETE COMMAND, que implementa interface Command
//Classe que implementa Command e modela uma operação específica do Receiver
public class LigarDesligarLuzCommand implements Command{
    private Luz luz;

    public LigarDesligarLuzCommand(Luz luz){
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.ligarDesligarLuzes();
    }
    
}
