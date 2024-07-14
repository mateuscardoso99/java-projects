package com.example;

public class VerificaUsuarioExisteHandler extends BaseHandler{
    private BancoDadosService bdService;

    public VerificaUsuarioExisteHandler(BancoDadosService bdService, Handler nextHandler){
        this.bdService = bdService;
        this.setNextHandler(nextHandler);
    }

    @Override
    public boolean handle(String nome, String email, String senha) {
        Usuario usuario = this.bdService.findByEmail(email);
        if(usuario != null){
            System.out.println("usuário " + usuario.getEmail() + " já cadastrado");
            return false;
        }
        return this.handleNext(nome, email, senha);
    }
    
}
