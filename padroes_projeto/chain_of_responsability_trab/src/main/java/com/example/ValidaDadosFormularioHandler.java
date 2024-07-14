package com.example;

public class ValidaDadosFormularioHandler extends BaseHandler{

    public ValidaDadosFormularioHandler(Handler next){
        this.setNextHandler(next);
    }

    @Override
    public boolean handle(String nome, String email, String senha) {
        boolean valid = true;
        if(nome == null){
            System.out.println("nome inválido");
            valid = false;
        }
        if(email == null){
            System.out.println("email inválido");
            valid = false;
        }
        if(senha == null){
            System.out.println("senha inválida");
            valid = false;
        }
        return valid ? this.handleNext(nome, email, senha) : false;
    }
    
}
