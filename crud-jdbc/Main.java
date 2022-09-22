import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Edicao e1 = new Edicao(1,1, LocalDate.now(), 10);
        Edicao e2 = new Edicao(2,2, LocalDate.now(), 14);
        Edicao e3 = new Edicao(3,3, LocalDate.now(), 15);

        Edicao.inserir(e1);
        Edicao.inserir(e2);
        Edicao.inserir(e3);
        
        Revista r1 = new Revista(1,2003, "teste", "esportes", e1);
        Revista r2 = new Revista(2,2004, "ola mundo", "esportes", e2);
        Revista r3 = new Revista(3,2006, "revista 1", "esportes", e2);
        Revista r4 = new Revista(4,1998, "eua", "esportes", e3);
        Revista r5 = new Revista(5,1970, "epoca", "esportes", e1);

        r1.inserir(r1);
        r2.inserir(r2);
        r3.inserir(r3);
        r4.inserir(r4);
        r5.inserir(r5);

        List<Revista> revistas = new ArrayList<>();
        revistas = Revista.findAllRevistas();

        for (Revista revista : revistas) {
            System.out.println("revista: "+revista.getTitulo()+"edicao: "+revista.getEdicao().getNumEdicao());
        }

        Edicao.delete(e3.getId());

        e1.setNumEdicao(44);
        e1.setNumArtigos(56);
        Edicao.update(e1, e1.getId());
        
        r1.delete(r1.getId());
        r2.delete(30);
    }
}
