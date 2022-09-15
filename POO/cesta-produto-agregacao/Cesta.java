import java.util.List;
import java.util.ArrayList;

public class Cesta {
    private List<Produto> itens = new ArrayList<>();

    public Cesta(){}

    public void incluirItem(Produto prod){
        this.itens.add(prod);
    }

    public void exibeCesta(){
        for(Produto prod : itens){
            System.out.println("produto: "+prod.getNome());
            System.out.println("preço: "+prod.getPreco());
        }
    }

    public double fechaCompra(){
        double total = 0;

        for(int i=0;i<this.itens.size();i++){
            total+=this.itens.get(i).getPreco();
        }

        return total;
    }
}
