package composição;

public class Produto {
    private int code, quant;
    private float preco;
    private String descr;
    private Data vencimento;

    public Produto(int code, int quant, float preco, String descr, Data vencimento) {
        this.code = code;
        this.quant = quant;
        this.preco = preco;
        this.descr = descr;
        this.vencimento = vencimento;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Data getVencimento() {
        return vencimento;
    }

    public void setVencimento(Data vencimento) {
        this.vencimento = vencimento;
    }
    
    public void verificaValidade(){
        Data hoje=new Data(22,07,2019);
        Data resultado=new Data(vencimento.getDia()-hoje.getDia(),
                                vencimento.getMes()-hoje.getMes(),
                                vencimento.getAno()-hoje.getAno());
        int diasRestantes=0;
        
        if(resultado.getAno()>0){
            diasRestantes+=resultado.getAno()*365;
            diasRestantes+=resultado.getMes()*30;
            diasRestantes+=resultado.getDia();
            System.out.println("dias restantes: "+diasRestantes);
        }
        
        else if(resultado.getAno()==0){
            if(resultado.getMes()>0){
                diasRestantes+=resultado.getMes()*30;
                diasRestantes+=resultado.getDia();
                System.out.println("dias restantes: "+diasRestantes);
            }
              
        else if(resultado.getMes()==0){
            if(resultado.getDia()>=0){
                diasRestantes+=resultado.getDia();
                System.out.println("dias restantes: "+diasRestantes);
            }
            else{
                System.out.println("vencido");
            }
        }
        
        else{
            System.out.println("vencido");
        }
    }
        
        else{
            System.out.println("vencido");
        }
        
}
    
    
    
    public void vender(int v){
        if(v>this.quant)
            System.out.println("\nnão é possível comprar estoque insuficiente.");
        
        else
            this.quant-=v;
            System.out.println("\nquantidade restante: "+this.quant);
    }
    
    
    public void verificaEstoque(){
        if(quant>0)
            System.out.println("ainda há mercadoria");
        else
            System.out.println("não tem mais mercadoria");
    }
    
    
    public static void main(String[] args) {
        Data dr=new Data(6,9,2020);
        Produto p=new Produto(54376,26,246,"roupa",dr);
        p.verificaValidade();
        p.vender(13);
        p.verificaEstoque();
        
        System.out.println("código: "+p.getCode());
        System.out.println("preço: "+p.getPreco());
        System.out.println("descrição: "+p.getDescr());
    }
}
