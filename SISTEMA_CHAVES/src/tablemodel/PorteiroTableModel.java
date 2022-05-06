package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Porteiro;

public class PorteiroTableModel extends AbstractTableModel{

    private List<Porteiro> listaPorteiros;
    private String[] colunas = {"Nome","Situação"};
    
    public PorteiroTableModel(){
        listaPorteiros = new ArrayList<>();
    }
    
    public PorteiroTableModel(List<Porteiro> porteiros){
        this();
        this.listaPorteiros.addAll(porteiros);
    }
    
    @Override
    public int getRowCount() {
        return listaPorteiros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Porteiro pt = listaPorteiros.get(linha);
        switch(coluna){
            case 0:
                return pt.getNome();
            case 1:
                return pt.getSituacao();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Porteiro getPorteiro(int linha){
        if(linha >= listaPorteiros.size()){
            return null;
        }
        return listaPorteiros.get(linha);
    }
    
}
