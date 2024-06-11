//adaptador trabalha tanto com o cliente quanto com o serviço
//ele traduz as chamadas do cliente de um modo que o serviço possa entender e usar
public class Adaptador implements InterfaceApp{
    private final ServiceBiblioteca serviceBiblioteca;

    public Adaptador(){
        this.serviceBiblioteca = new ServiceBiblioteca();
    }

    @Override
    public void displayMenus(XmlData xmlData) {
        JsonData jsonData = new JsonData(); //converter pra JSONData 
        this.serviceBiblioteca.displayMenus(jsonData);
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = new JsonData(); //converter pra JSONData
        this.serviceBiblioteca.displayRecommendations(jsonData); 
    }
    
}
