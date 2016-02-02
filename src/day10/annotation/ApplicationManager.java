package day10.annotation;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationManager {

    public ApplicationManager() {
    }

    public void run(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("Type Annotation");
        if(c.getAnnotationsByType(ServiceTypeAnnotation.class).length>0){
            System.out.println("Class "+c.getName()+" has ServiceTypeAnnotation");
        }
        else {
            System.out.println("Class "+c.getName()+" has not ServiceTypeAnnotation");
        }

        System.out.println();
        System.out.println("Method Annotation");
        for(Method m:c.getDeclaredMethods()){
            for(Annotation a:m.getAnnotations()){
                System.out.println("Method "+m.getName()+" has "+a.toString());
            }
        }

        System.out.println();
        System.out.println("Check init method");
        for(Method m:c.getDeclaredMethods()){
            if(m.getAnnotationsByType(initServiceAnnotation.class).length>0){
                m.invoke(c.newInstance());
            }
        }
    }


    public <T> T getService(Class<T> c) throws IllegalAccessException, InstantiationException {
      return c.newInstance();
    }

}

