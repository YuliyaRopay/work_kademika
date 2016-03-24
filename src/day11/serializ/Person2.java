package day11.serializ;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person2 implements Externalizable {

    private String name;
    private String surname;
    private int age;

    public Person2() {
    }

    public Person2(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeInt(name.getBytes().length);
        out.write(name.getBytes());
    }


    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        this.age=in.readInt();
        int length=in.readInt();
        byte[] buf=new byte[length];
        in.read(buf);
        this.name=new String(buf);

    }
}
