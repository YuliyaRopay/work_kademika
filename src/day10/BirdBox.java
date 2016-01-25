package day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BirdBox<T extends Bird>{

    private List<T> birds;

    public BirdBox(){
        birds=new ArrayList<T>();
    }

    public void addBird(T bird){
        birds.add(bird);
    }

    public List<T> getBirds(){
        return new ArrayList<T>(birds);
    }

    public void removeBird(T bird){
        birds.remove(bird);
    }

    public void sortByName(){
        birds.sort(new Comparator<T>() {
                       @Override
                       public int compare(T o1, T o2) {
                           return (o1.getName().compareTo(o2.getName()));
                       }
                   }
        );
    }
}
