package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Chave;

public class ChaveTableModel extends AbstractTableModel{
    private List<Chave> listaChaves;
    private String[] colunas = {"Sala","Situação","Porteiro"};
    
    public ChaveTableModel(){
        listaChaves = new ArrayList<>();
    }
    
    public ChaveTableModel(List<Chave> chaves){
        this();
        this.listaChaves.addAll(chaves);
    }
    
    @Override
    public int getRowCount() {
        return listaChaves.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Chave ch = listaChaves.get(linha);
        switch(coluna){
            case 0:
                return ch.getSala();
            case 1:
                return ch.getSituacao();
            case 2:
                return ch.getPorteiro().getNome();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Chave getChave(int linha){
        if(linha >= listaChaves.size()){
            return null;
        }
        return listaChaves.get(linha);
    }
}
