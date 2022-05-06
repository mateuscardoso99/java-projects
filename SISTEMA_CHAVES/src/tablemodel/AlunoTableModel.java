package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Aluno;

public class AlunoTableModel extends AbstractTableModel{
    private List<Aluno> listaAluno;
    private String[] colunas = {"Nome","Curso","Situação","Professor Responsável"};
    
    public AlunoTableModel(){
        listaAluno = new ArrayList<>();
    }
    
    public AlunoTableModel(List<Aluno> alunos){
        this();
        this.listaAluno.addAll(alunos);
    }
    
    @Override
    public int getRowCount() {
        return listaAluno.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluno al = listaAluno.get(linha);
        switch(coluna){
            case 0:
                return al.getNome();
            case 1:
                return al.getCurso();
            case 2:
                return al.getSituacao();
            case 3:
                return al.getProfessor().getNome();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Aluno getAluno(int linha){
        if(linha >= listaAluno.size()){
            return null;
        }
        return listaAluno.get(linha);
    }
}
