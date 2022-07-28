package strings;
import java.lang.String;

public class gerenciaString {
    
    int numCaracteres(String a){
        int t;
        t=a.length();
        return t;
    }
    
    String maiusculo(String b){
        return b.toUpperCase();
    }
    
    boolean confereVazio(String c){
        boolean t=c.isEmpty();
        return t;
    }
    
    int ocorrencias(String d, char e){
        char v=0;
        int cont=0;
        
        for(int i=0;i<d.length();i++){
            v=d.charAt(i);
            if(v==e)
            cont++;
        }
        return cont;
    }
    
    
    String[] inverte(String f){
        String resultado[]=f.split("");
        for(int i=resultado.length-1;i>=0;i--){
            System.out.println(resultado[i]);
        }
        return resultado;
    }
    
    
    public static void main(String[] args) {
        gerenciaString g=new gerenciaString();
        
        System.out.println(g.numCaracteres("exemplo"));
        System.out.println(g.confereVazio(""));
        System.out.println(g.maiusculo("estado"));
        System.out.println(g.inverte("hoje é sexta"));
        System.out.println("número de ocorrências da letra E: "+g.ocorrencias("televisão", 'e'));
    }
    
    
}
