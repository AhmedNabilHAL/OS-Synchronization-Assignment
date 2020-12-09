import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    static FileWriter fw;
    static {
        File  file = new File("Router Log.txt");
        try {
            file.createNewFile();
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Log File location :"+file.getAbsolutePath());
    }

    static synchronized void write(String s) {
        try {
            fw.write(s+'\n');
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
