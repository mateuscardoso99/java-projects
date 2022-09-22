import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Revista {
    private int id;
    private int codigo;
    private String titulo;
    private String tipo;
    private Edicao edicao;

    public Revista(int id, int codigo, String titulo, String tipo, Edicao edicao){
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.tipo = tipo;
        this.edicao = edicao;
    }

    public Revista(int codigo, String titulo, String tipo, Edicao edicao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.tipo = tipo;
        this.edicao = edicao;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int code){
        this.codigo = code;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String t){
        this.titulo = t;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Edicao getEdicao(){
        return this.edicao;
    }

    public void setEdicao(Edicao e){
        this.edicao = e;
    }

    public Optional<Revista> getRevista(int id){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.prepareStatement("SELECT revista.*, edicoes.id as eid, edicoes.numedicao, edicoes.dataedicao, edicoes.numartigos FROM revista JOIN edicoes ON revista.idedicao = edicoes.id WHERE revista.id = ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if(rs.next()){
                Edicao ed = new Edicao(
                    rs.getInt("eid"),
                    rs.getInt("numedicao"),
                    rs.getDate("dataedicao").toLocalDate(),
                    rs.getInt("numartigos")
                );

                Revista r = new Revista(
                    rs.getInt("id"),
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getString("tipo"), 
                    ed
                );

                return Optional.of(r);
            }
            else{
                return null;
            }
        }catch(SQLException exception){
            exception.printStackTrace();
            return null;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }

    public static List<Revista> findAllRevistas(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Revista> revistas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT revista.*, edicoes.id as eid, edicoes.numedicao, edicoes.dataedicao, edicoes.numartigos FROM revista INNER JOIN edicoes ON edicoes.id = revista.idEdicao;");
            rs = stmt.executeQuery();

            while(rs.next()){
                Edicao edicao = new Edicao(
                    rs.getInt("eid"),
                    rs.getInt("numedicao"),
                    rs.getDate("dataedicao").toLocalDate(),
                    rs.getInt("numartigos")
                );

                Revista revista = new Revista(
                    rs.getInt("id"),
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getString("tipo"),
                    edicao
                );

                revistas.add(revista);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(con, stmt);
        }

        return revistas;
    }

    public void inserir(Revista r){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO revista (id,codigo,titulo,tipo,idEdicao) VALUES (?,?,?,?,?);");
            stmt.setInt(1, r.getId());
            stmt.setInt(2, r.getCodigo());
            stmt.setString(3, r.getTitulo());
            stmt.setString(4, r.getTipo());
            stmt.setInt(5, r.getEdicao().getId());

            int success = stmt.executeUpdate();

            if(success == 1){
                System.out.println("revista inserida com sucesso");
            }
            else{
                System.out.println("Erro ao inserir revista");
            }

        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }

    public void delete(int id){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            if(this.getRevista(id) != null){
                stmt = con.prepareStatement("DELETE FROM revista WHERE id = ?;");
                stmt.setInt(1, id);
                int success = stmt.executeUpdate();

                if(success == 1){
                    System.out.println("revista apagada com sucesso");
                }
                else{
                    System.out.println("Erro ao apagar revista");
                }
            }
            else{
                System.out.println("revista nao existe");
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
}
