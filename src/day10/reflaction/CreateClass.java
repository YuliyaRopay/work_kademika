package day10.reflaction;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateClass <T>{

    public  T initClass(Class<T> c, Map<String,Object> fields) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        T createdObject= c.newInstance();

        for(String keyInit: fields.keySet()){

            Object objectInit=fields.get(keyInit);
            Method method=findMethod(c,keyInit);
            if(method!=null){
                method.invoke(createdObject,objectInit);
            }

        }

        return createdObject;
    }


    private Method findMethod(Class<T> c, String methodName) {
        for (Method method : c.getMethods()) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }

        return null;
    }

}
