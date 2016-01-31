package day10.annotation;


import java.util.ArrayList;
import java.util.List;

@ServiceTypeAnnotation
public class ServiceNew {

    private String str1;
    private int int1;

    public ServiceNew() {
    }

    @ServiceMethodAnnotation
    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    @ServiceMethodAnnotation
    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }
}
