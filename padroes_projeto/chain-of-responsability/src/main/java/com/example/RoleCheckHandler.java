package com.example;

//manipulador que verifica se a role do usuário existe no banco de dados
//se for admin retorna true e encerra o processamento mostrando tela de admin
//senão retorna tela de usuário e passa a solicitação pro próximo manipulador da cadeia
public class RoleCheckHandler extends Handler{

    @Override
    public boolean handle(String username, String password) {
        if ("admin_username".equals(username)) {
            System.out.println("Loading Admin Page...");
            return true;
        }
        System.out.println("Loading Default Page...");
        return handleNext(username, password);
    }
    
}
