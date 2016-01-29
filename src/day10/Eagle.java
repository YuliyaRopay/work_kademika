package day10;


public class Eagle extends Bird{

    private int age;

    public Eagle() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "["+super.getId()+" : "+super.getName()+" : "+age+" : "+super.getPrice()+" ]";
    }
}
