package com.example;

//EXEMPLO DE UM CONTROLLER

//@Controller
//@RequestMapping("/criar-conta")
public class CriarContaController {
    //@Autowired
    private CriarUsuarioService criarUsuarioService;

    //@RequestMapping(method = RequestMethod.POST)
    public boolean criarUsuario(String nome, String email, String senha){
        return criarUsuarioService.criarUsuario(nome, email, senha);
    }
}
