package com.example;

public class CriaUsuarioHandler extends BaseHandler{
    private BancoDadosService bdService;

    public CriaUsuarioHandler(BancoDadosService bancoDadosService, Handler nextHandler){
        this.bdService = bancoDadosService;
        this.setNextHandler(nextHandler);
    }

    @Override
    public boolean handle(String nome, String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        bdService.insertUsuario(usuario);
        System.out.println(usuario.toString());
        return this.handleNext(nome, email, senha);
    }
    
}
