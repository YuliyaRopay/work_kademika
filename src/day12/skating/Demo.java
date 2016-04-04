package day12.skating;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        System.out.println("We are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        final Random random =new Random();

        for(int i=0; i<10; i++){
            final Skater skater=new Skater("Skater "+i);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Skates skates=skatingRink.getSkates(skater);
                    sleep(random.nextInt(2000));
                    skatingRink.returnSkates(skates, skater);
                }
            }).start();

            sleep(random.nextInt(1000));
        }
    }

    private static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
