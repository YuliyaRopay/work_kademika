package day11.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {

   private String pathName;
    private String folderName;
    private String zipName;

    public ZipFiles() {
    }

    public ZipFiles(String pathName, String folderName, String zipName) {
        this.pathName=pathName;
        this.zipName = zipName;
        this.folderName = folderName;
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }


    public void zip() {

        File path=new File(pathName+folderName);

        try (ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(pathName + zipName));)
        {
           zipFiles(zipOutStream, path);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println( "! Result archive "+pathName + zipName);
    }

    private void zipFiles(ZipOutputStream zipOutStream, File path) throws IOException {

        for (File file : path.listFiles()){

            if(file.isFile()){
                System.out.println("Zipping... "+file.getAbsolutePath());
                addFile(file, zipOutStream);
            }
            else{
                zipFiles(zipOutStream, file);
            }
        }
    }

    private void addFile(File file, ZipOutputStream stream) throws IOException {

        stream.putNextEntry(new ZipEntry(file.getName()));

        byte[] buffer = new byte[1024];
        int count;

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while ((count = fileInputStream.read(buffer)) > 0) {
                stream.write(buffer, 0, count);
            }

        }

        stream.closeEntry();
    }

}
