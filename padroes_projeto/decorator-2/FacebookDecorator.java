package decorator;

public class FacebookDecorator extends BaseNotifierDecorator {

    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    public void send(String msg) {
        super.send(msg); //chama o método send do objeto INotifier recebido por parametro, este objeto tambem vai executar o seu método send e vai chamar o send do objeto recebido por parametro e assim por diante, recursivamente
        String fbName = databaseService.getFBNameFromUsername(getUsername());
        System.out.println("Sending " + msg + " on Facebook to " + fbName);
    }

}
