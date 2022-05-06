package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Vendedor;

public class VendedorTableModel extends AbstractTableModel{
    
    private List<Vendedor> listaVendedores;
    private String[] colunas = {"Nome", "Salário", "CPF", "Endereço", "Percentual"};

    public VendedorTableModel() {
        listaVendedores = new ArrayList<>();
    }
    
    public VendedorTableModel(List<Vendedor> vendedores){
        this();
        this.listaVendedores.addAll(vendedores);
    }
    
    @Override
    public int getRowCount() {
        return listaVendedores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Vendedor v = listaVendedores.get(linha);
        switch(coluna){
            case 0:
                return v.getNome();
            case 1:
                return v.getSalario();
            case 2:
                return v.getCpf();
            case 3:
                return v.getEndereco();
            case 4:
                return v.getPercentual();
            
            default:
                return "";                   
        }
    }
    
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    
    public Vendedor getVendedor(int linha){
        if(linha >= listaVendedores.size()){
            return null;
        }
        return listaVendedores.get(linha);
    }

}


