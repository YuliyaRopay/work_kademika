package day10;

import day10.reflaction.CreateClass;
import day10.reflaction.LauncherBirds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(JUnit4.class)
public class initClassTest {

    Object object;
    List<Object> paramList;
    CreateClass newClass;

    @Before
    public void init() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        newClass=new CreateClass();
        paramList=new ArrayList<>();
        paramList.add(24L);
        paramList.add("EagleNew2");
        paramList.add(600D);
        paramList.add(8);
        object= newClass.initClass(Eagle.class, paramList);
    }

    @Test
    public void testInitClass(){
        Assert.assertNotNull(object);
    }


    @Test
    public void testCheckFieldValues() throws NoSuchFieldException, NoSuchMethodException {
        Eagle eagle=(Eagle) object;
        //Assert.assertEquals("int", object.getClass().getDeclaredField("age").getType().getSimpleName());
        Assert.assertEquals("Error in the ID", 24L,eagle.getId());
        Assert.assertEquals("Error in the NAME", "EagleNew2",eagle.getName());
        Assert.assertEquals("Error in the AGE", 8, eagle.getAge());

    }

    @Test
    public  void testSetPrivateFieldAge() throws NoSuchFieldException, IllegalAccessException {

        Eagle eagle=new Eagle();
        Map<String, Object> dataForPrivateFields=new HashMap<String, Object>();
        dataForPrivateFields.put("age",1);
        LauncherBirds.setPrivates(eagle,dataForPrivateFields);
        Assert.assertEquals(1,eagle.getAge());

    }
}




