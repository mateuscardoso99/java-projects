package decorator;

/**
 * 
 * DECORATOR permite anexar novos comportamentos a um objeto colcando esse objeto dentro de um objeto wrapper (casca) que contém esses comportamentos
 * 
 * o cliente nesse caso a classe Main interage apenas com a interface
 * 
 * problema:
 * um sistema tem uma classe pra enviar notificações aos usuários por email,
 * mas em algum momento deseja-se enviar notifições também por whatsapp, facebook e SMS
 * poderia criar uma classe de notificação pra cada um desses tipos, mas e se precisar
 * enviar notificação pra vários desses meios juntos? teria que criar uma classe pra
 * cada um como FacebookWhatsAppNotifier por exemplo isso não ficaria bom
 * 
 */
public class Main {
    public static void main(String[] args) {
        //aqui será chamado o método send() de facebookDecorator, que invocará o send() do whatsAppDecorator através do super.send(), que invocará o send() de notifier através do super.send() também
        INotifier notifyAll = new FacebookDecorator(new WhatsAppDecorator(new Notifier("Geekific"))); //envia notificação por facebook, whatsapp e email
        notifyAll.send("Like and Subscribe!!!");

        System.out.println("==========================================");

        INotifier notifyFbMail = new FacebookDecorator(new Notifier("Geekific"));//envia notificação por facebook e email apenas
        notifyFbMail.send("Like and Subscribe!!!");
    }
}
