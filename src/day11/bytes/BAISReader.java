package day11.bytes;

import java.io.ByteArrayInputStream;

public class BAISReader {
    public static void main(String[] args) {

        byte[] bytes={63,64,65,56,67,-27,-128,0};

        ByteArrayInputStream inputStream= new ByteArrayInputStream(bytes);

        int i;
        while((i=inputStream.read())!=-1){
            //System.out.print(i);
            System.out.print((byte)i);
            System.out.print(" ");
        }

    }
}
