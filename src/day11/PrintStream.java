package day11;

import java.io.*;

public class PrintStream {
    public static void main(String[] args) {

        PrintStream printStream=new PrintStream();

        //
        byte[] bytes={0,1,2,3,4,5,6,7,8,0};
        ByteArrayInputStream in= new ByteArrayInputStream(bytes);
        printStream.printStreamData(in);


        //
        System.out.println();
        System.out.println();
        try (InputStream in2=new FileInputStream("data.txt")){
            printStream.printStreamData2(in2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //
    public void printStreamData(ByteArrayInputStream in){
        int i;
        System.out.print("[");
        while((i=in.read())!=-1){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.print("]");
    }

    //
    public void printStreamData2(InputStream in) throws IOException {
        StringBuilder builder = new StringBuilder();
        int i;
        while((i=in.read())!=-1){
            builder.append((char) i);
        }
        System.out.println(builder);
    }
}
