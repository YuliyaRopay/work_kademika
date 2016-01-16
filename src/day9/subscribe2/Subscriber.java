package day9.subscribe2;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer{

    public String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Publisher publisher=(Publisher) o;
        System.out.println("Subscriber "+name+" update "+publisher.name);
    }

}
