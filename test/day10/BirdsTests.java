package day10;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BirdsTests {

    private Duck duck;
    private Eagle eagle;

    @Before
    public void init(){

        duck=new Duck();
        eagle=new Eagle();

    }

    @Test
    public void checkEagleSetAge(){
        int age=4;
        eagle.setAge(age);
        Assert.assertEquals(age, eagle.getAge());
    }

    @Test
    public void checkDuckColorValue(){
        Assert.assertTrue("Default color = yellow", duck.getColor().equalsIgnoreCase("yellow"));
    }


}
