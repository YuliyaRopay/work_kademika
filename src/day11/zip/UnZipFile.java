package day11.zip;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFile {

    private String pathName;
    private String zipName;
    private String pathUnZip;

    public UnZipFile() {
    }

    public UnZipFile(String pathName, String zipName) {
        this.pathName = pathName;
        this.zipName = zipName;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public void unZip(){

        pathUnZip=pathName+ zipName.substring(0,zipName.lastIndexOf("."))+"\\";

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathName+zipName))){

            ZipEntry entry = zipInputStream.getNextEntry();

            while (entry != null) {
                createFile(zipInputStream, entry);
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();

            System.out.println("! Result path "+pathName+ zipName.substring(0,zipName.lastIndexOf(".")));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void createFile(ZipInputStream zipInputStream, ZipEntry entry) throws IOException {

        String fileName = entry.getName();
        File newFile = new File(pathUnZip+ fileName);
        byte[] buffer = new byte[1024];
        System.out.println("Unzipping...: " + newFile.getAbsolutePath());

        if (entry.isDirectory()) {
            newFile.mkdir();
        } else {
            new File(newFile.getParent()).mkdirs();
            try (FileOutputStream fileOutputStream  = new FileOutputStream(newFile)) {
                int length;
                while((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
            }
        }
    }

}

