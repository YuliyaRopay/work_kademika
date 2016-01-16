package day9.subscribe2;


public class Launcher {

    public static void main(String[] args) {

        Publisher journal=new Journal("journal_1");
        Publisher newspaper=new Newspaper("newspaper_1");

        Subscriber subscriber1=new Subscriber("subscribe_1");
        Subscriber subscriber2=new Subscriber("subscribe_2");
        Subscriber subscriber3=new Subscriber("subscribe_3");

        journal.addObserver(subscriber1);
        journal.addObserver(subscriber2);
        newspaper.addObserver(subscriber2);
        newspaper.addObserver(subscriber3);

        journal.newEdition();
        newspaper.newEdition();

    }
}
