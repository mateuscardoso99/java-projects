public class CryptoFactory {
    public static CryptoService getCryptoService(String moeda){
        if(moeda.equals("BTC")){
            return new BitcoinService();
        }
        else if(moeda.equals("ETH")){
            return new EthereumService();
        }
        return null;
    }
}
