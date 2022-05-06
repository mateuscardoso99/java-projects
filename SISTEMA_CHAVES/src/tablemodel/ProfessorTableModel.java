package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Professor;

public class ProfessorTableModel extends AbstractTableModel{
    
    private List<Professor> listaProfessores;
    private String[] colunas = {"Nome","Graduação","Situação"};
    
    public ProfessorTableModel(){
        listaProfessores = new ArrayList<>();
    }
    
    public ProfessorTableModel(List<Professor> professores){
        this();
        this.listaProfessores.addAll(professores);
    }
    
    @Override
    public int getRowCount() {
        return listaProfessores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Professor prof = listaProfessores.get(linha);
        switch(coluna){
            case 0:
                return prof.getNome();
            case 1:
                return prof.getGraduacao();
            case 2:
                return prof.getSituacao();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Professor getProfessor(int linha){
        if(linha >= listaProfessores.size()){
            return null;
        }
        return listaProfessores.get(linha);
    }
}
