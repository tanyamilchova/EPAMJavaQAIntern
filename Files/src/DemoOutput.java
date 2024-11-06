import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;

public class DemoOutput {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("data/out.txt", true)){
            outputStream.write(48);
            byte[] value = {65, 67, 100};
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            outputStream.write(value);
                }catch (IOException e){
            e.printStackTrace();
        }
    }
}
