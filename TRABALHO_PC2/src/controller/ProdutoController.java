package controller;

import java.util.ArrayList;
import model.bean.Produto;
import model.dao.ProdutoDAO;

public class ProdutoController {
    public boolean create(String descr, double p){
        Produto prod = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();
        
        prod.setDescricao(descr);
        prod.setPreco(p);
        
        return pdao.create(prod);
    }
    
    
    public ArrayList<Produto> read(){
        ProdutoDAO pd = new ProdutoDAO();
        
        return pd.read();
    }
    
    
    public boolean update(int id, String descr, double p){
        Produto prod = new Produto();
        ProdutoDAO pd = new ProdutoDAO();
        
        prod.setId(id);
        prod.setDescricao(descr);
        prod.setPreco(p);
        
        return pd.update(prod);
    }
    
    
    public void delete(Produto p){
        ProdutoDAO pd = new ProdutoDAO();
        
        pd.delete(p);
    }
    
    public ArrayList<Produto> buscaPorDescricao(String descr){
        ProdutoDAO pd = new ProdutoDAO();
        
        return pd.buscaPorDescricao(descr);
    }
}
