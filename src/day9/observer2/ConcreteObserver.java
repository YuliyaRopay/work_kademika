package day9.observer2;

public class ConcreteObserver implements Observer {
	
	@Override
	public void update() {
		System.out.println(this.toString() + " notified.");
	}
	
}
