package day11.files;



public class Demo {
    public static void main(String[] args) {
        String fileName = "data.txt";

        FileWriter writer = new LegacyFileWriter();
        writer.write("I love programming", fileName);

        FileReader reader = new LegacyFileReader();
        System.out.println(reader.read(fileName));

        writer=new DefaultFileWriter();
        writer.write("Me too", fileName);

        reader= new DefaultFileReader();
        System.out.println(reader.read(fileName));

        writer=new JDKWriter();
        writer.write("Hi from JDK Writer", fileName);

        reader= new JDKReader();
        System.out.println(reader.read(fileName));
    }
}
