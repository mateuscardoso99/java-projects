package com.example;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void adicionaCommand(Command command){
        commands.add(command);
    }

    public void execute(){
        commands.forEach(c -> c.execute());
        commands.clear();
    }
}
