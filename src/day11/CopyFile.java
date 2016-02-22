package day11;

import java.io.*;
import java.nio.file.Files;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        CopyFile copyFile=new CopyFile();
        copyFile.copyFile("data.txt", "data_copy.txt");
        copyFile.streamCopyFile("data.txt", "data_stream_copy.txt");
        copyFile.streamCopyFile2("data.txt", "data_stream_copy2.txt");
        copyFile.bufferedCopyFile("data.txt", "data_buffered_copy.txt");

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

    //
    public void bufferedCopyFile(String fileOriginName, String fileCopyName){

        StringBuilder builder = new StringBuilder();

        try(    FileInputStream fileIS = new FileInputStream(fileOriginName);
                BufferedInputStream bufferedIS =new BufferedInputStream(fileIS,256);
                FileOutputStream fileOS = new FileOutputStream(fileCopyName);
                BufferedOutputStream bufferedOS=new BufferedOutputStream(fileOS,256); ){

            int i;
            while((i=bufferedIS.read())!=-1){
                bufferedOS.write((char) i);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
