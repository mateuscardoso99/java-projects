package com.example;

import java.util.ArrayList;
import java.util.List;

//invoker
public class Routine {
    public List<Command> commands = new ArrayList<>();

    public void adicionaCommand(Command command){
        commands.add(command);
    }

    public void executarCommands(){
        commands.forEach(Command::execute);
    }
}
