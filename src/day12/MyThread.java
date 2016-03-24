package day12;

public class MyThread extends  Thread{

    @Override
    public void run() {
        System.out.println("Running Thread "+Thread.currentThread().getName()+" "+this.getClass().getSimpleName());
    }

}
