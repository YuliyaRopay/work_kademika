package day10.annotation;


public class Launcher {
    public static void main(String[] args) {

        ApplicationManager am=new ApplicationManager();
        ServiceNew sn=new ServiceNew();

        am.run(sn.getClass());
        System.out.println();
        System.out.println();
        am.run(Service.class);


    }

}
