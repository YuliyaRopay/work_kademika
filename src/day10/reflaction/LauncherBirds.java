package day10.reflaction;


import day10.Bird;
import day10.Duck;
import day10.Eagle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LauncherBirds {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

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

        System.out.println();
        System.out.println("> init class");
        Map<String, Object> dataForClass=new HashMap<String, Object>();
        dataForClass.put("setName","EagleNew");
        dataForClass.put("setAge",4);
        dataForClass.put("setId",12L);
        dataForClass.put("setPrice",300);

        CreateClass newClass=new CreateClass();
        Eagle eagleNew= (Eagle) newClass.initClass(Eagle.class, dataForClass);
        System.out.println(eagleNew.toString());


        System.out.println();
        System.out.println("> init class by constructor");
        List<Object> paramList=new ArrayList<>();
        paramList.add(24L);
        paramList.add("EagleNew2");
        paramList.add(600D);
        paramList.add(8);

        Eagle eagleNew2= (Eagle) newClass.initClass(Eagle.class, paramList);
        System.out.println(eagleNew2.toString());


        System.out.println();
        System.out.println("> set private fields");
        Bird eaglePrivate=new Eagle();
        Map<String, Object> dataForPrivateFields=new HashMap<String, Object>();

        dataForPrivateFields.put("age",1);
        setPrivates(eaglePrivate,dataForPrivateFields);
        System.out.println(eaglePrivate.toString());

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

    public static void setPrivates(Object object, Map<String,Object> mapList) throws NoSuchFieldException, IllegalAccessException {

        for(String keyInit: mapList.keySet()){

            //System.out.println(keyInit+"="+mapList.get(keyInit));
            Field field=object.getClass().getDeclaredField(keyInit);
            //System.out.println("field="+field.getName());
            field.setAccessible(true);
            field.set(object,mapList.get(keyInit));

        }
    }
}
