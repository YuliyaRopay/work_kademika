package day11.bytes;

import java.io.ByteArrayInputStream;

public class PrintStream {
    public static void main(String[] args) {

        PrintStream printStream=new PrintStream();

        byte[] bytes={0,1,2,3,4,5,6,7,-128,0};
        ByteArrayInputStream inputStream= new ByteArrayInputStream(bytes);
        printStream.printStreamData(inputStream);

    }

    public void printStreamData(ByteArrayInputStream inputStream){
        int i;
        System.out.print("[");
        while((i=inputStream.read())!=-1){
            System.out.print((byte)i);
            System.out.print(" ");
        }
        System.out.print("]");
    }
}
