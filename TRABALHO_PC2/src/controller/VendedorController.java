package controller;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import model.bean.Vendedor;
import model.dao.VendedorDAO;

public class VendedorController {
    Connection con = ConnectionFactory.getConnection();
        
        public boolean insert(String nome,double salario,String cpf,double p,String endereco){
            Vendedor v = new Vendedor();
            v.setNome(nome);
            v.setSalario(salario);
            v.setCpf(cpf);
            v.setPercentual(p);
            v.setEndereco(endereco);
            
            VendedorDAO vd = new VendedorDAO();
            return vd.insert(v);
        }
        
        
        public ArrayList<Vendedor> select(){
            VendedorDAO vd = new VendedorDAO();
            return vd.select();
        }
        
        
        public boolean apagar(Vendedor v){
            VendedorDAO vd = new VendedorDAO();
            return vd.apagar(v);
        }
        
    
        public boolean update(int id,String nome,double salario,String cpf,double p,String endereco){
            Vendedor v = new Vendedor();
            v.setId(id);
            v.setNome(nome);
            v.setSalario(salario);
            v.setCpf(cpf);
            v.setPercentual(p);
            v.setEndereco(endereco);
            
            VendedorDAO vd = new VendedorDAO();
            return vd.update(v);
        }
        
        
        public ArrayList<Vendedor> buscaNome(String n){
        VendedorDAO cd = new VendedorDAO();
        
        return cd.buscaPorNome(n);
    }
    
    public ArrayList<Vendedor> buscacpf(String cpf){
        VendedorDAO cd = new VendedorDAO();
        
        return cd.buscaPorCPF(cpf);
    }
}
