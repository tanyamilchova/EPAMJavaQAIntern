import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class DemoPipeStreams {
    public static void main(String[] args) {
        try{
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream);

            Thread produser = new Thread(() ->{
                try {
                    String message = "Hello from producing a soup!";
                    outputStream.write(message.getBytes());
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            });

            Thread consumer = new Thread(() ->{
                try {
                    int data ;
                    while ((data = inputStream.read()) != -1) {
                        System.out.print((char) data);
                    }
                    inputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            });
            produser.start();
            consumer.start();

            produser.join();
            consumer.join();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
