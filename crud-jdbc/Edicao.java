import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Edicao {
    private int id;
    private int numEdicao;
    private LocalDate dataEdicao;
    private int numArtigos;

    public Edicao(int id, int numEdicao, LocalDate dataEdicao, int numArtigos){
        this.id = id;
        this.numEdicao = numEdicao;
        this.dataEdicao = dataEdicao;
        this.numArtigos = numArtigos;
    }

    public Edicao(int numEdicao, LocalDate dataEdicao, int numArtigos){
        this.numEdicao = numEdicao;
        this.dataEdicao = dataEdicao;
        this.numArtigos = numArtigos;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getNumEdicao(){
        return this.numEdicao;
    }

    public void setNumEdicao(int num){
        this.numEdicao = num;
    }

    public LocalDate getDataEdicao(){
        return this.dataEdicao;
    }

    public void setDataEdicao(LocalDate data){
        this.dataEdicao = data;
    }

    public int getNumArtigos(){
        return this.numArtigos;
    }

    public void setNumArtigos(int num){
        this.numArtigos = num;
    }

    public static boolean getEdicao(int id){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.prepareStatement("SELECT * FROM edicoes WHERE id = ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException exception){
            exception.printStackTrace();
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }

    public static void inserir(Edicao edicao){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO edicoes (id,numEdicao,dataEdicao,numArtigos) VALUES (?,?,?,?);");
            stmt.setInt(1, edicao.getId());
            stmt.setInt(2, edicao.getNumEdicao());
            stmt.setDate(3, java.sql.Date.valueOf(edicao.getDataEdicao()));
            stmt.setInt(4, edicao.getNumArtigos());
            int success = stmt.executeUpdate();

            if(success == 1){
                System.out.println("edicao inserida com sucesso");
            }
            else{
                System.out.println("Erro ao inserir edicao");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally{
            Conexao.closeConnection(con, stmt);
        }
    }

    public static void update(Edicao edicao ,int id){
        Connection con = Conexao.getConnection();
        PreparedStatement statement = null;

        try {
            if(Edicao.getEdicao(id)){
                statement = con.prepareStatement("UPDATE edicoes SET numedicao = ?,dataedicao = ?,numartigos = ? WHERE id = ?;");
                statement.setInt(1, edicao.getNumEdicao());
                statement.setDate(2, java.sql.Date.valueOf(edicao.getDataEdicao()));
                statement.setInt(3, edicao.getNumArtigos());
                statement.setInt(4, edicao.getId());

                int success = statement.executeUpdate();
                if(success == 1){
                    System.out.println("edicao atualizada com sucesso");
                }
                else{
                    System.out.println("Erro ao atualizar edicao");
                }
            }
            else{
                System.out.println("edicao nao existe");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(con, statement);
        }
    }

    public static void delete(int id){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            if(Edicao.getEdicao(id)){
                stmt = con.prepareStatement("DELETE FROM edicoes WHERE id = ?;");
                stmt.setInt(1, id);
                int success = stmt.executeUpdate();

                if(success == 1){
                    System.out.println("edicao apagada com sucesso");
                }
                else{
                    System.out.println("Erro ao apagar edicao");
                }
            }
            else{
                System.out.println("edicao nao existe");
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
}
