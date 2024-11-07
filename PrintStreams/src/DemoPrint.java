import java.io.*;

public class DemoPrint {
    public static void main(String[] args) {
        File file = new File("data\\res.txt");
        double[]values = {1.2, 4.5, 0.8, 6.8};
        try(PrintStream stream = new PrintStream(new FileOutputStream(file))) {
            for (double value : values){
                stream.printf("Java %.2g%n ", value);
                System.setOut(stream);
                System.out.printf(" %.2g%n ", value);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            new PrintWriter(new PrintStream(new FileOutputStream(file)));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
