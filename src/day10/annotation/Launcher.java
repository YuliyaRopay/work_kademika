package day10.annotation;


import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        ApplicationManager am=new ApplicationManager();

        am.run(ServiceNew.class);

        System.out.println();
        System.out.println();

        am.run(Service.class);


    }

}
