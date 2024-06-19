public class BuyCryptoFacade {
    public void buyCryptoFacade(double valor, String moeda){
        DatabaseService dbService = new DatabaseService();
        User user = dbService.getUser("2");
        CryptoFactory.getCryptoService("BTC").buyCurrency(user, 1000);
        //enviar email.. ou qualquer outra coisa
    }
}
