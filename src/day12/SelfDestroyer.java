package day12;


public class SelfDestroyer extends Thread{

    private volatile boolean killMe =false;

    public  void killMyself(){
        killMe=true;
    }


    @Override
    public void run() {
        while(!killMe){
            try{
                System.out.println("Enjoying life...");
                sleep(100);
            }catch(InterruptedException e){
                //sout
            }
        }
        System.out.println("Killing.....");
    }
}
