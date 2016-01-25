package day10;

import java.util.ArrayList;
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




}
