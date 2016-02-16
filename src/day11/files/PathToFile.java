package day11.files;

import java.io.File;

public class PathToFile {
    public static void main(String[] args) {

        File file= new File("test.txt");

        System.out.println("Property user.dir  "+System.getProperty("user.dir"));
        System.out.println("Separator "+File.separator);
        System.out.println("PathSeparator "+File.pathSeparator);

        System.out.println();
        System.out.println("ListRoot");
        for(File f: File.listRoots()){
            System.out.println(f.getAbsolutePath());
        }

        System.out.println();
        System.out.println("RelativeFileDir:");
        System.out.println(getRelativeFileDir());

        System.out.println();
        System.out.println("FilePath:");
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
