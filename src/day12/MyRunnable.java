package day12;


public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Running Runnable"+Thread.currentThread().getName()+" "+this.getClass().getSimpleName());
    }

}
