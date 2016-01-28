package day10.reflaction;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateClass <T>{

    public  T initClass(Class<T> c, Map<String,Object> fields) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        T createdObject= c.newInstance();
        for(String keyInit: fields.keySet()){

            System.out.println(keyInit+" "+fields.get(keyInit));
            Object objectInit=fields.get(keyInit);
            System.out.println(objectInit.getClass().getTypeName());
            System.out.println();
            Method method = createdObject.getClass().getMethod(keyInit, (new Class[] {objectInit.getClass()}));
           // Method method = createdObject.getClass().getMethod(keyInit, (new Class[] {Long.class}));



            //System.out.println(fields.get(key));
            //Method method = createdObject.getClass().getMethod("setName", (new Class[] {String.class}));
            //Method method2 = createdObject.getClass().getMethod(key, object.getClass());
            //System.out.println("result"+method.getName());
            //method.invoke(createdObject,"newEagle");



            //for(Method m: createdObject.getClass().getDeclaredMethods()){
            //    System.out.println(m.getName());
            //}

        }



        return createdObject;
    }

}
/*
    public T initClass(Class<T> aClass, Map<String, Object> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T classObject = aClass.newInstance();

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            for(Method method : aClass.getMethods()) {
                if(method.getName().contains("set" + entry.getKey())) {
                    method.invoke(classObject, entry.getValue());
                }
            }
        }
        return classObject;
    }
//////////////////////////////////////
     public T  initClass(Class<T> clas, Map<String,Object> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T o = clas.newInstance();

       for (Method m : clas.getMethods()) {
           if (m.getName().contains("set")) {
               Object arg = map.get(m.getName().substring(3).toLowerCase());
               m.invoke(o, arg);
           }
       }
        return o;
    }
//////////////////////////////////////////

public T initClass(Class<T> c, Map<String, Object> args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T obj = c.newInstance();
		Method[] methods = c.getMethods();

		for(Entry<String, Object> e : args.entrySet()){
			for(Method method : methods){
				String methodName = method.getName();
				if(methodName.contains("set" + e.getKey())){
					method.invoke(obj, e.getValue());
				}
			}
		}
		return obj;
	}
 */
