package day11.serializ;


import java.io.*;

public class DataIO {

    //
    public static void main(String[] args) throws IOException {

        writeToFile("output.dat");
        readFromFile("output.dat");
    }

    //
    public static void readFromFile(String file) throws IOException {

        try(DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readChar());
        }
    }

    //
    public static void writeToFile(String file) throws IOException {

        try(DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            dos.writeInt(10);
            dos.writeFloat(25.3f);
            dos.writeChar('s');
        }
    }
}
