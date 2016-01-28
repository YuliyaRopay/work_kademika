package day10.reflaction;


import day10.Duck;
import day10.Eagle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class LauncherBirds {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Duck duck =new Duck();
        Eagle eagle=new Eagle();

        duck.setName("duck1");
        duck.setPrice(20);
        duck.setColor("red");

        System.out.println();
        printClassInfo(duck.getClass());
        System.out.println();
        printClassMethod(duck.getClass());
        System.out.println();
        printClassFields(duck.getClass());

        System.out.println(">init");
        Map<String, Object> dataForClass=new HashMap<String, Object>();
        dataForClass.put("setName","EagleNew");
        dataForClass.put("setId",12L);
        dataForClass.put("setPrice",300);
        dataForClass.put("setAge",4);
        CreateClass newClass=new CreateClass();
        newClass.initClass(Eagle.class, dataForClass);


    }

    public static void printClassInfo(Class classPrint){
        System.out.println("> Class Info: ");
        System.out.println("Class name: "+classPrint.getSimpleName());
        System.out.println("package: "+classPrint.getPackage());
        System.out.println("superclass: "+classPrint.getSuperclass().getName());

    }


    public static void printClassMethod(Class classPrint){
        System.out.println("> Class methods: ");
        for(Method m:classPrint.getMethods()){
            System.out.println(m.getName());
        }
    }


    public static void printClassFields(Class classPrint){
        System.out.println("> Class fields: ");
        for(Field f:classPrint.getDeclaredFields()){
            System.out.println(f.getName());
        }
    }


}
