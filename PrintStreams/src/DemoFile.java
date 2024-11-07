import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class DemoFile {
    public static void main(String[] args) {
        File file = new File("data" + File.separator + "info.txt");
        if(file.exists() && file.isFile()){
            System.out.print("Path " + file.getPath());
            System.out.print("AbsolutePath " + file.getAbsolutePath());
            System.out.print("Size " + file.length());
            System.out.print("Dir " + file.getParent());
            file.delete();

            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            File dir = new File("data");
            if(dir.exists() && dir.isDirectory()){
                for(File current : dir.listFiles()){
                    long millis = current.lastModified();
                    LocalDateTime dateTime = Instant.ofEpochMilli(millis)
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
                    System.out.print(current.getPath() + "\t" + current.length() + "\t" + dateTime);
                }
            }
            File root = File.listRoots()[0];
            System.out.printf("\n%s %,d free bytes ", root.getPath(), root.getUsableSpace(), root.getTotalSpace() );
        }
    }
}
