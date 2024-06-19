package decorator;

/**
 * declara os comportamentos comuns para wrappers e objetos encapsulados
 */
public interface INotifier {

    void send(String message);

    String getUsername();

}