package day10;

import day10.container.Service;
import day10.container.ServiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ServiceTests {

    private ServiceRepository serviceRepository;

    @Before
    public void init(){
        serviceRepository=new ServiceRepository();
    }


    @Test
    public void checkAddService(){
        int lengthStart=serviceRepository.getSize();
        Service service=new Service("ServiceTestLength");
        serviceRepository.addService(service);
        Assert.assertEquals(lengthStart+1, serviceRepository.getSize());
    }

    @Test
    public void checkRemoveService(){
        Service service1=new Service("ServiceTestLength1");
        Service service2=new Service("ServiceTestLength2");
        serviceRepository.addService(service1);
        serviceRepository.addService(service2);
        int lengthStart=serviceRepository.getSize();
        serviceRepository.removeService(service2);
        Assert.assertEquals(lengthStart-1, serviceRepository.getSize());
    }



}
