package decorator;

//classe wrapper (casca)
/**
 * este é o objeto baseDecorator, ele pode referenciar o objeto concreto como também seus decoradores SEMPRE por meio da interface comum INotifier
 * ele deve ser estendido por decorators concretos que são facebookDecorator e whatsAppDecorator
 * esses decorators substituem os métodos do decorador base e executam seu comportamento personalizado antes ou depois de chamar o método pai
 */
public abstract class BaseNotifierDecorator implements INotifier{
    private final INotifier wrapped; //aqui pode entrar qualquer coisa que implemente INotifier, isso permite alterar o comportamento em tempo de execução, como enviar notificação por whatsapp e/ou facebook
    protected final DatabaseService databaseService;

    BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String msg) {
        wrapped.send(msg);
    }

    @Override
    public String getUsername() {
        return wrapped.getUsername();
    }
}
