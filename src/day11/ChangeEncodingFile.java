package day11;


import day11.files.*;

import java.io.*;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class ChangeEncodingFile {

    public static void main(String[] args) {

        File file= new File("data.txt");
        File fileEncoding=new File("data_encoding.txt");

        String currentEncoding="ISO_8859_1";
        String neededEncoding="UTF_16BE";

        ChangeEncodingFile encodingFile=new ChangeEncodingFile();
        encodingFile.changeEncoding(file, fileEncoding, currentEncoding, neededEncoding);
    }

    //
    public void changeEncoding(File file, File fileEncoding, String currentEncoding, String neededEncoding){

        StringBuilder builder=new StringBuilder();

        try(
                FileInputStream fis= new FileInputStream(file);
                InputStreamReader reader= new InputStreamReader(fis);
                BufferedReader bufferedReader=new BufferedReader(reader);
                FileOutputStream fos =new FileOutputStream(fileEncoding);
                OutputStreamWriter writer=new OutputStreamWriter(fos, neededEncoding);
                BufferedWriter bufferedWriter=new BufferedWriter(writer);)
        {
            String str;
            while((str=bufferedReader.readLine())!=null){
                builder.append(str);
                bufferedWriter.write(str);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(builder);

    }
}
