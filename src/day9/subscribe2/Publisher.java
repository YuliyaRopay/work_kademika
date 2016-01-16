package day9.subscribe2;

import java.util.Observable;

public abstract class Publisher extends Observable {

    protected String name;

    public Publisher(String name) {
        this.name = name;
    }

    public void newEdition() {
        System.out.println(name+" released a new number!!");
        setChanged();
        notifyObservers();
    }
}
