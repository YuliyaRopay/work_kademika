package day11.bytes;


import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class BAISWriter {
    public static void main(String[] args) {

        byte[] bytes={63,64,65,56,67,-27,-128,0};

        ByteArrayOutputStream  outStream=new ByteArrayOutputStream();

        for(int i=0; i<bytes.length; i++){
            outStream.write(bytes[i]);
        }

        System.out.print(Arrays.toString(outStream.toByteArray()));
    }
}

