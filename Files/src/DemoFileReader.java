import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DemoFileReader {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("data/info.txt")){
            int symbol = reader.read();
            System.out.println(symbol);
            int symbol1 = reader.read();
            System.out.println(symbol1);
            int symbol2 = reader.read();
            System.out.println(symbol2);
            char [] buffer = new char[8];
            reader.skip(2);
            reader.read(buffer);
            System.out.println(Arrays.toString(buffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
