import java.io.IOException;

/**
 * Implícitas: Exceções que não precisam de tratamento e demonstram serem contornáveis. Esse tipo origina-se da subclasse Error ou RunTimeException.
 * Explícitas: Exceções que precisam ser tratadas e que apresentam condições incontornáveis. Esse tipo origina do modelo throw e necessita ser declarado pelos métodos. É originado da subclasse Exception ou IOException.

 * Exception (java.lang.Exception: É a raiz das classes originárias da classe Throwable, onde mostra as situações em que a aplicação pode querer capturar e realizar um tratamento para conseguir realizar o processamento.
 * Error (java.lang.Error) – Também é raiz das classes originárias da classe Throwable, indicando as situações em que a aplicação não deve tentar tratar, como ocorrências que não deveriam acontecer. (erros de memória etc.)
 * printStrackTrace – método que imprime uma mensagem da pilha de erro encontrada em um exceção.
 * para tratar exceções usa-se as cinco palavras-chave: try, catch, throw, throws e finally
 */

class Teste{

    /* método declarado com throws faz com que quem chamar ele tenha que tratar a IOException
     * ou quem chamar também pode propagar o tratamento da exceção para um nível acima na pilha de execuções usando throws IOException também
     */
    public static void teste()throws IOException{
        //throw new lança uma exceção manualmente, que deve ser capturada pelo método que chamou ou ele tambem pode passar adiante na pilha usando throws IOException
        throw new IOException();//será retornada a exception no método que chamou este
    }

    public static void teste2()throws IOException{
        teste();
    }

    //teste2() chama teste() que retorna IOException, teste2() recebe essa exceção e não trata mas passa adiante na pilha para o método main, por fim cai no catch do método main e ele trata e exceção
    public static void main(String[] args){
        try {
            Teste.teste2();
        } catch (IOException e) {
            System.out.println("teste");
        }
    }

    /*
     * nesse caso NullPointerException, IllegalArgumentException são tratadas e se caso a exceção gerada
     * não for nenhuma delas o terceiro catch vai capturar seja qual for pois Exception é a classe mãe de todas
     * as exceções
     */
    public static void teste3(){
        try {
            
        } 
        catch (NullPointerException e) {
            // TODO: handle exception
        }
        catch (IllegalArgumentException e) {
            // TODO: handle exception
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * nesse caso diferente do teste3() as exceções não são tratadas mas passadas pra quem chamar
     */
    public static void teste4() throws NullPointerException, IllegalArgumentException, Exception{
        return;
    }
}
