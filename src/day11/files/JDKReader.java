package day11.files;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JDKReader implements FileReader{
    @Override
    public String read(String fileName) {
        StringBuilder builder=new StringBuilder();


        try(

                FileInputStream fis= new FileInputStream(fileName);
                InputStreamReader reader= new InputStreamReader(fis);
                //InputStreamReader reader= new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
                BufferedReader bufferedReader=new BufferedReader(reader);
                )
        {
            String str;
            while((str=bufferedReader.readLine())!=null){
                builder.append(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
}
