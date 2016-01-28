package birds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BirdsTest {
    BirdsStore store;

    @Before
    public void init(){
        store=new BirdsStore();
    }

    @Test
    public void checkNoneDiscount(){
        int price=49;
        double priceDiscount=store.getDiscountPrice(price);
        Assert.assertEquals(price,priceDiscount,0);
    }

    @Test
    public void checkDiscount5(){
        int price=50;
        double priceDiscount=store.getDiscountPrice(price);
        Assert.assertEquals(price*0.05,priceDiscount,0);
    }

    @Test
    public void checkDiscount10(){
        int price=1001;
        double priceDiscount=store.getDiscountPrice(price);
        Assert.assertEquals(price*0.1,priceDiscount,0);
    }
}
