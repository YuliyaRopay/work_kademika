package day11.serializ;


import java.io.*;

public class SimpleObjectIO {

    //
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        writeToFile("output.dat");
        readFromFile("output.dat");
    }


    //
    public static void readFromFile(String file) throws IOException, ClassNotFoundException {

        try(ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){

            Person person=(Person) ois.readObject();
            System.out.println(person.getName()+person.getSurname());

            person=(Person) ois.readObject();
            System.out.println(person.getName()+person.getSurname());

            person=(Person) ois.readObject();
            System.out.println(person.getName()+person.getSurname());
        }
    }

    //
    public static void writeToFile(String file) throws IOException {

        try(ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            out.writeObject(new Person("Inna","Ivanova"));
            out.writeObject(new Person("Vasya","Petrov"));
            out.writeObject(new Person("Filya","Sidorov"));
        }
    }

}
