import java.io.*;


public class DemoFileWriter {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("data/info.txt");
                FileWriter writer = new FileWriter("data/out1.txt", true)){

             int symbol = reader.read();
            System.out.println(symbol);

            writer.write(symbol);


            char [] buffer = new char[8];
            int charNum = reader.read(buffer);
            while (charNum != -1) {
                System.out.println("charNum: " + charNum);
                writer.write(buffer, 0, charNum);
                charNum = reader.read(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
