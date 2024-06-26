package com.example;

//manipulador que verifica se o nome do usuário existe no banco de dados
//se não existir retorna falso e encerra o processamento
//senão passa a solicitação pro próximo manipulador da cadeia
public class ValidPasswordHandler extends Handler {
    private final Database database;

    public ValidPasswordHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("senha incorreta");
            return false;
        }
        return handleNext(username, password);
    }
}
