package com.example;

//manipulador que verifica se a senha do usuário existe no banco de dados
//se não existir retorna falso e encerra o processamento
//senão passa a solicitação pro próximo manipulador da cadeia
public class UsuarioExisteHandler extends Handler {
    private final Database database;

    public UsuarioExisteHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidUser(username)) {
            System.out.println("nome de usuário não encontrado");
            System.out.println("Sign Up to our app now!");
            return false;
        }
        return handleNext(username, password);
    }
}
