package day11;


import java.io.*;
import java.io.PrintStream;

public class SysOutToFile {

    public static void main(String[] args) throws FileNotFoundException {

        SysOutToFile sysOutToFile=new SysOutToFile();
        File file=new File("sys_out_print.txt");

        sysOutToFile.printToFile(file,"Classic splitter of OutputStream");

        sysOutToFile.printToFile2(file,"This API (Application Programming Interface)");
        sysOutToFile.printToFile2(file,"document has pages corresponding to the items in the navigation bar");

        sysOutToFile.printToFile3(file,"Classic splitter of OutputStream 123456789");


    }

    //
    public void printToFile(File file, String textForPrint){

        try(FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            java.io.PrintStream printStream=new PrintStream(fileOutputStream);)
        {
            printStream.println(textForPrint);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //
    public void printToFile2(File file, String textForPrint){
        try(FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            PrintStream printStream = new PrintStream(fileOutputStream);)
        {
            System.setOut(printStream);
            System.out.println(textForPrint);

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //
    public void printToFile3(File file, String textForPrint) throws FileNotFoundException {

        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
        FileOutputStream fileOutputStreamError=new FileOutputStream(file,true);
        PrintStream out = new PrintStream(fileOutputStream);
        PrintStream err = new PrintStream(fileOutputStreamError);

        System.setOut(out);
        System.setErr(err);

        System.out.println(textForPrint);
        System.out.println(5/0);

    }



}


