package com.example;

public class Main {
    public static void main(String[] args) {
        BancoDadosService bancoDadosService = new BancoDadosService();

        Handler handler = new ValidaDadosFormularioHandler(
                            new VerificaUsuarioExisteHandler(bancoDadosService, 
                                new CriaUsuarioHandler(bancoDadosService, null)
                            )
        );

        CriarUsuarioService criarUsuarioService = new CriarUsuarioService(handler);

        criarUsuarioService.criarUsuario("joao", "joao@gmail.com", "1234");
        criarUsuarioService.criarUsuario("celso", "joao@gmail.com", "1234");
        criarUsuarioService.criarUsuario("joao", null, null);
        criarUsuarioService.criarUsuario("maria", "maria@maria", "gf42ww");
        criarUsuarioService.criarUsuario(null, null, null);
        criarUsuarioService.criarUsuario("carlos", "carlos@teste", "90887d");

        System.out.println("\nusuários cadastrados: ");
        bancoDadosService.getUsuarios().stream().forEach(u -> System.out.println(u.toString()));
    }
}