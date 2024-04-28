// Os produtos concretos são criados pela fábrica concreta correspondente

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("botão pra Windows criado");
    }
}
