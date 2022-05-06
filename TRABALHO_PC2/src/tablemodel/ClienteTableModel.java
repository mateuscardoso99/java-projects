package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Cliente;

public class ClienteTableModel extends AbstractTableModel{
    
    private List<Cliente> listaClientes;
    private String[] colunas = {"Nome", "Endereço", "Aniversário", "Telefone", "CPF"};

    public ClienteTableModel() {
        listaClientes = new ArrayList<>();
    }
    
    public ClienteTableModel(List<Cliente> clientes){
        this();
        this.listaClientes.addAll(clientes);
    }
    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente c = listaClientes.get(linha);
        switch(coluna){
            case 0:
                return c.getNome();
            case 1:
                return c.getEndereco();
            case 2:
                return c.getAniversario();
            case 3:
                return c.getTelefone();
            case 4:
                return c.getCpf();
            
            default:
                return "";                   
        }
    }
    
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    
    public Cliente getCliente(int linha){
        if(linha >= listaClientes.size()){
            return null;
        }
        return listaClientes.get(linha);
    }

}

