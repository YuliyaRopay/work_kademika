package day10.container;


import java.util.ArrayList;
import java.util.List;

public class ServiceRepository<T extends Service> {

    private List<T> services;

    public ServiceRepository() {
        services=new ArrayList<T>();
    }

    public void addService(T service){
        services.add(service);
    }

    public void removeService(T service){
        services.remove(service);
    }

    public List<T> getService(){
        return services;
    }

    public int getSize(){
        return services.size();
    }
}
