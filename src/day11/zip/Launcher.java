package day11.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Launcher {
    public static void main(String[] args) {


        ZipFiles zipFiles=new ZipFiles("D:\\Java_docs\\","!book","ZipNewTest.zip");
        zipFiles.zip();

        System.out.println( );

        UnZipFile unZipFile=new UnZipFile("D:\\Java_docs\\", "ZipNewTest.zip");
        unZipFile.unZip();


    }

}
