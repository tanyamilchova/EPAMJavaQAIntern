import java.io.*;
import java.util.Arrays;

public class DemoFiles {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("data/info.txt");
            System.out.println("Abailable: " + inputStream.available());
            System.out.println("char is: " + (char) inputStream.read());
            System.out.println("Abailable: " + inputStream.available());
            System.out.println(inputStream.read());
            System.out.println("Abailable: " + inputStream.available());
            byte[]arr = new byte[16];
            System.out.println(inputStream.read(arr));
            System.out.println(Arrays.toString(arr));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
