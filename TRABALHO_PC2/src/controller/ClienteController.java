package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;

public class ClienteController {
    
    public boolean insert(String nome,String endereco,String aniversario,String fone,String cpf){
        Cliente c = new Cliente();
        ClienteDAO cdao = new ClienteDAO();
        
        c.setNome(nome);
        c.setEndereco(endereco);
        c.setAniversario(aniversario);
        c.setTelefone(fone);
        c.setCpf(cpf);
        
        return cdao.insert(c);
    }
    
    public ArrayList <Cliente> read(){
        ClienteDAO cd = new ClienteDAO();
        
        return cd.read(); 
    }
    
    
    public boolean update(int id,String nome,String endereco,String aniversario,String fone,String cpf){
        Cliente c = new Cliente();
        ClienteDAO cd = new ClienteDAO();                
        c.setId(id);
        c.setNome(nome);
        c.setEndereco(endereco);
        c.setAniversario(aniversario);
        c.setTelefone(fone);
        c.setCpf(cpf);
        
        return cd.update(c);
    }  
    
    public boolean delete(Cliente c){
        ClienteDAO cd = new ClienteDAO();

        return cd.delete(c);
    }
    
    public ArrayList<Cliente> buscaNome(String n){
        ClienteDAO cd = new ClienteDAO();
        
        return cd.buscaPorNome(n);
    }
    
    public ArrayList<Cliente> buscacpf(String cpf){
        ClienteDAO cd = new ClienteDAO();
        
        return cd.buscaPorCPF(cpf);
    }
}
