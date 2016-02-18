package day11.files;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class JDKWriter implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try(
                //java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
                FileOutputStream fos =new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
                ){
            //fileWriter.write(data);
            outputStreamWriter.write(data);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
