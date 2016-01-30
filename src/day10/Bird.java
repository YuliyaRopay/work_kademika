package day10;


public abstract class Bird {
    private long id;
    private String name;
    private double price;

    public Bird() {
    }

    public Bird(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Bird(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" : "+price;
    }
}
