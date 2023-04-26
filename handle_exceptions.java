//ex: receber exceção lançada no método que foi chamado

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
