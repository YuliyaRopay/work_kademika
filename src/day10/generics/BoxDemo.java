package day10.generics;


public class BoxDemo {

    public static void main(String[] args) {

        Box<Integer> box= new Box<Integer>();
        box.setItem(10);
        System.out.println(box.getItem());

        Box<String> box2= new Box<String>();
        box2.setItem("string");
        System.out.println(box2.getItem());
    }
}
