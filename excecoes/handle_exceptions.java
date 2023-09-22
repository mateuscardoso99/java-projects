/*
Todas as classes de exceção são subtipos da classe java.lang.Exception. 
A classe Exception é uma subclasse da classe Throwable. Além da classe Exception, há outra subclasse chamada Error, que é derivada da classe Throwable. 
Erros são condições anormais que ocorrem em caso de falhas graves, não são tratadas pelos programas Java. Erros são gerados para indicar erros gerados pelo ambiente de tempo de execução. 
Exemplo: JVM está sem memória. Normalmente, os programas não podem se recuperar de erros. A classe Exception tem duas subclasses principais: classe IOException e classe RuntimeException.
*/

//ex: receber exceção lançada no método que foi chamado
//Exceções verificadas: Uma exceção verificada é uma exceção que é verificada (notificada) pelo compilador em tempo de compilação, também chamada de exceções de tempo de compilação. Essas exceções não podem ser simplesmente ignoradas, o programador deve cuidar (tratar) dessas exceções
//exemplos: ClassNotFoundException, SQLException, IOException, FileNotFoundException, InstantiationException, InterruptedException

//Exceções não verificadas: Uma exceção não verificada é uma exceção que ocorre no momento da execução. Eles também são chamados de exceções de tempo de execução. Isso inclui bugs de programação, como erros de lógica ou uso indevido de uma API. As exceções de tempo de execução são ignoradas no momento da compilação
//exemplos: ClassCastException, NullPointerException, ArithmeticException, ArrayIndexOfBoundsException, ArrayStoreException, IllegalThreadStateException

//LAMBDA FUNCTIONS NÃO PODEM LANÇAR EXCEÇÕES VERIFICADAS DEVE TRATAR ELAS EXPLICITAMENTE OU PASSAR PARA UMA INTERFACE FUNCIONAL QUE A TRATE, SÓ LANÇAM APENAS NÃO VERIFICADAS

public ResponseEntity<String> enviarEmail(@RequestBody String texto){
       try{
            enviarEmailService.enviar(texto);//se acontecer uma exceção no método abaixo, cai no catch
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

public void enviar(String texto) throws Exception{
        try{
            //enviar email
        }catch(Exception ex){
            LOGGER.log(Level.SEVERE, "Problemas ao enviar e-mail", ex);
            throw new Exception(ex.getMessage());//será retornada a exception no método que chamou este
        }
}

//bloco try catch não é preciso, apenas throws exception, pois ele indica que o método que chama deve tratar a exceção
public void enviar(String texto) throws Exception{
       //enviar email
}
