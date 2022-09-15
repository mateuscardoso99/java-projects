import java.util.ArrayList;
import java.util.List;

public class Compra {
    public Pessoa pessoa;
    public List<Produto> produtos = new ArrayList<>();

    public Compra(Pessoa p){
        this.pessoa = p;
    }

    public void comprar(Pessoa p, Produto prod){
        this.produtos.add(prod);
    }

    public void verificarCompra(){
        System.out.println("compras da pessoa: "+this.pessoa.consultaNome());

        for(int i=0;i<this.produtos.size();i++){
            System.out.println("Produto "+i+" "+this.produtos.get(i).consultaNome());
        }
    }
}
