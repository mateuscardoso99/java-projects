package com.example;

public class CriarUsuarioService {
    private final Handler handler;

    public CriarUsuarioService(Handler handler) {
        this.handler = handler;
    }

    public boolean criarUsuario(String nome, String email, String senha) {
        if (handler.handle(nome, email, senha)) {
            System.out.println("conta criada com sucesso\n");
            return true;
        }
        return false;
    }
}
