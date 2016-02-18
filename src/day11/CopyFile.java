package day11;

import java.io.*;
import java.nio.file.Files;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        CopyFile copyFile=new CopyFile();
        copyFile.copyFile("data.txt", "data_copy.txt");
        copyFile.streamCopyFile("data.txt", "data_stream_copy.txt");
        copyFile.streamCopyFile2("data.txt", "data_stream_copy2.txt");

    }

    //
    public void copyFile(String fileOriginName, String fileCopyName) throws IOException {

        File fileOrigin=new File(fileOriginName);
        File fileCopy=new File(fileCopyName);
        Files.copy(fileOrigin.toPath(), fileCopy.toPath());
    }

    //
    public void streamCopyFile(String fileOriginName, String fileCopyName){

        FileInputStream fileIS=null;
        FileOutputStream fileOS=null;

        try {
            fileIS=new FileInputStream(fileOriginName);
            fileOS=new FileOutputStream(fileCopyName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileIS.read(buffer)) > 0) {
                fileOS.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileIS.close();
                fileOS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //
    public void streamCopyFile2(String fileOriginName, String fileCopyName){

        try(FileInputStream fileIS=new FileInputStream(fileOriginName);
            FileOutputStream fileOS = new FileOutputStream(fileCopyName)){

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileIS.read(buffer)) > 0) {
                fileOS.write(buffer, 0, length);
            }

        } catch(IOException e){
        e.printStackTrace();
        }
    }
}
