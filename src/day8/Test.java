package day8;

/**
 * Created by Julia on 21.08.2015.
 */
public class Test {
    public static void main(String[] args) {
        int end = Integer.MAX_VALUE;
        System.out.println("=end "+end);
        int start = end - 10;
        System.out.println("=sta "+start);
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println("="+count);
    }
}
