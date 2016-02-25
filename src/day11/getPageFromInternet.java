package day11;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class getPageFromInternet {

    public static void main(String[] args) throws IOException {

        String path="https://www.wikipedia.org/";
        String charset=StandardCharsets.UTF_8.name();

        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), charset));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testHTML.html")));
        try {
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(inputLine);
                System.out.println(inputLine);
            }
        } finally {
            bufferedReader.close();
            bufferedWriter.close();

        }

    }

}
