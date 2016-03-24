package day12;


public class Launcher {

    public static void main(String[] args) {

        System.out.println("Running "+Thread.currentThread().getName());

        new MyThread().start();

        new Thread(new MyRunnable()).start();



    }
}
