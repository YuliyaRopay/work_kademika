package day10.reflaction;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
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


    public T initClass(Class<T> c, List<Object> listObjects) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        int objCount=listObjects.size();

        //System.out.println("size="+objCount);
        //System.out.println("constr="+c.getConstructors().length);

        for(Constructor constructor:c.getConstructors()){

            Class[] paramTypes = constructor.getParameterTypes();

            int paramCount=paramTypes.length;
            //System.out.println("param="+paramCount);

            if(objCount==paramCount && checkConstructor(constructor,listObjects)){
                T createdObject=(T)c.getConstructor(paramTypes).newInstance(listObjects.toArray());
                //System.out.println("obj"+createdObject.getClass().getName());
                return createdObject;
            }
        }

        return null;
    }



    private Method findMethod(Class<T> c, String methodName) {
        for (Method method : c.getMethods()) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }

        return null;
    }


    private Boolean checkConstructor(Constructor constructor, List<Object> listObjects){

        Class[] paramTypes = constructor.getParameterTypes();

        for(int i=0;i<paramTypes.length;i++){

            String paramTypeStr=paramTypes[i].getSimpleName();
            if(paramTypeStr.equalsIgnoreCase("int")){
                paramTypeStr="integer";
            }
            String listTypeStr=listObjects.get(i).getClass().getSimpleName();

            //System.out.println("param="+paramTypeStr);
            //System.out.println("list=" +listTypeStr);
            if(!paramTypeStr.equalsIgnoreCase(listTypeStr)){
                return false;
            }
        }

        return true;
    }



}
