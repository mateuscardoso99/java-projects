//ex: receber exceção lançada no método que foi chamado
//Exceções verificadas: Uma exceção verificada é uma exceção que é verificada (notificada) pelo compilador em tempo de compilação, também chamada de exceções de tempo de compilação. Essas exceções não podem ser simplesmente ignoradas, o programador deve cuidar (tratar) dessas exceções
//Exceções não verificadas: Uma exceção não verificada é uma exceção que ocorre no momento da execução. Eles também são chamados de exceções de tempo de execução. Isso inclui bugs de programação, como erros de lógica ou uso indevido de uma API. As exceções de tempo de execução são ignoradas no momento da compilação

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
