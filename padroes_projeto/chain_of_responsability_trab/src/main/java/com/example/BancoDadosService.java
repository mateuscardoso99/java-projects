package com.example;

import java.util.HashSet;
import java.util.Set;

public class BancoDadosService {
    private Set<Usuario> usuarios = new HashSet<>();
    private static Long id = 1l;

    public Usuario insertUsuario(Usuario u){
        u.setId(id++);
        usuarios.add(u);
        return u;
    }

    public Usuario findByEmail(String email){
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public Set<Usuario> getUsuarios(){
        return usuarios;
    }
}
