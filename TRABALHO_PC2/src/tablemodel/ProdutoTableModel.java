package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Produto;

public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> listaProdutos;
    private String[] colunas = {"Descrição", "Preço"};

    public ProdutoTableModel() {
        listaProdutos = new ArrayList<>();
    }
    
    public ProdutoTableModel(List<Produto> produtos){
        this();
        this.listaProdutos.addAll(produtos);
    }
    
    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto p = listaProdutos.get(linha);
        switch(coluna){
            case 0:
                return p.getDescricao();
            case 1:
                return p.getPreco();
            
            default:
                return "";                   
        }
    }
    
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    
    public Produto getProdutos(int linha){
        if(linha >= listaProdutos.size()){
            return null;
        }
        return listaProdutos.get(linha);
    }

}

