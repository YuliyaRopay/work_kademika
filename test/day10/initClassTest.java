package day10;

import day10.reflaction.CreateClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


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

    /*
    @Test
    public void testCreateByConstructor(){
        Assert.assertEquals("Long Ok", 24L, object.getClass().);
    }*/
}

