package day10;

public class BirdBoxDemo {

    public static void main(String[] args) {
        BirdBox<Bird> products =new BirdBox<Bird>();
        BirdBox<Eagle> eagles =new BirdBox<Eagle>();
        BirdBox<Duck> ducks =new BirdBox<Duck>();

        BirdBox<Bird> birds=new BirdBox<Bird>();
        birds.addBird(new Eagle());
        birds.addBird(new Duck());
        System.out.println(birds.toString());
    }
}
