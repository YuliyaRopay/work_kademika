package day11;

import java.io.File;

public class PathToFile {
    public static void main(String[] args) {

        File file= new File("test.txt");

        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);

        for(File f: File.listRoots()){
            System.out.println(f.getAbsolutePath());
        }

        System.out.println(getRelativeFileDir());
        System.out.println(getFilePath());

        getHomePath();
    }

    //
    public static String getFilePath(){
        String path="src/day11/io/files/";
        path=path.replace("/", File.separator);

        File thisFile= new File(path, PathToFile.class.getSimpleName()+".java");

        return thisFile.getAbsolutePath();
    }

    //
    public static String getRelativeFileDir(){
        String path="src/day11/io/files/";
        return path.replace("/", File.separator);
    }

    //
    public static void getHomePath(){
        String path=System.getProperty("user.dir");
        File file=new File(path);

        System.out.println("");
        for (File f : file.listFiles()){
            System.out.println(f.getAbsolutePath());
        }
    }
}
