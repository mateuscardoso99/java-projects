package com.example;

import java.util.LinkedList;
import java.util.List;

public class Serasa implements Observer{
    private List<Conta> devedores = new LinkedList<>();

    @Override
    public void update(Observavel observavel) {
        if(observavel instanceof Conta){
            Conta c = (Conta) observavel;
            System.out.println(c.getSaldo());
            if(c.getSaldo() < 0 && !devedores.contains(observavel)){
                System.out.println("adicionado no serasa");
                devedores.add(c);
            }
            else{
                devedores.remove(c);
            }
        }
    }
    
}
