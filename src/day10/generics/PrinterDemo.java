package day10.generics;

import java.util.Arrays;
import java.util.List;

public class PrinterDemo {
    public static void main(String[] args) {

        List<String> strings= Arrays.asList(new String[]{"one","two"});
        print(strings);

        List<Integer> integers=Arrays.asList(new Integer[]{1,2});
        print(integers);
    }

    public static <E> void print(List<E> elements){
        for(E e: elements){
            System.out.println(e.toString());
        }
    }
}
