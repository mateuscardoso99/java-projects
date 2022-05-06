package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Aula;

public class AulaTableModel extends AbstractTableModel{
    private List<Aula> listaAula;
    private String[] colunas = {"Chave","Professor","Aluno","Porteiro","Data Início","Data Fim","Status"};
    
    public AulaTableModel(){
        listaAula = new ArrayList<>();
    }
    
    public AulaTableModel(List<Aula> aulas){
        this();
        this.listaAula.addAll(aulas);
    }
    
    @Override
    public int getRowCount() {
        return listaAula.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aula al = listaAula.get(linha);
        switch(coluna){
            case 0:
                return al.getChave().getSala();
            case 1:
                return al.getProfessor().getNome().equals("") ? "-" : al.getProfessor().getNome();
            case 2:
                return al.getAluno().getNome().equals("") ? "-" : al.getAluno().getNome();
            case 3:
                return al.getPorteiro().getNome();
            case 4:
                return al.getDataInicio();
            case 5:
                return al.getDataFim().equals("") ? "-" : al.getDataFim();
            case 6:
                return al.getStatus();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Aula getAula(int linha){
        if(linha >= listaAula.size()){
            return null;
        }
        return listaAula.get(linha);
    }
}
