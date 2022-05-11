package ui;

/**
 * subscriber Observerin alicisi
 */

public class Subscriber implements IObserver{
    @Override
    public void update(String msg) {
        System.out.print(msg);
    }
}
