package day10.annotation;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ApplicationManager {

    public ApplicationManager() {
    }

    public void run(Class c){


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
    }


}

/*

public void serviceCheck(Class clss){
		Annotation[] allAnnotations = clss.getAnnotations();
		boolean result = false;
		for(Annotation annotation : allAnnotations){
			if(annotation.annotationType().getName().equals(Service.class.getName())){
				System.out.println(clss.getName() + " has @Service annotation");
			}
		}
	}



	    public void runServiceMgr(Class clss) {

        Annotation annotation = clss.getAnnotation(Service.class);

        if (annotation instanceof Service) {
            System.out.println("Annotation Service is present in class " + clss.getSimpleName());
        }
    }




    public void checkPresentAnnotation(Class clazz) {

        if(clazz.isAnnotationPresent(Service.class)) {
            System.out.println("Annotation Sevice is present");
        } else {
            System.out.println("Annotation Sevice isn`t present");
        }
    }
 */