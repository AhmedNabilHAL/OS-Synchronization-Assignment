import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Device extends Thread {
    MySemaphore sem;
    int connectionNo;
    String name;
    Type type;
    boolean exit;
    public Device(int connectionNo, MySemaphore sem, String name, Type type) {
        this.connectionNo = connectionNo;
        this.sem = sem;
        this.name = name;
        this.type = type;
        exit = false;
    }
    @Override
    public void run(){
        try {
            // First, get a permit.
             Writer.write(String.format("-(%s)(%s) arrived", name, type));

            // acquiring the lock
            sem.acquire();
            if (!exit) Writer.write(String.format("-Connection %d: %s Occupied", connectionNo, name));
            while(!exit) {
                 Writer.write(String.format("Connection %d: %s performing online activity", connectionNo, name));

                // Now, allowing a context switch -- if possible.
                // for thread B to execute
                Thread.sleep(1000);
            }
             Writer.write(String.format("-Connection %d: %s disconnected.", connectionNo, name));
            sem.release();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void release() {
        exit = true;
    }

    @Override
    public String toString(){
        return String.format("Connection %d: %s(%s)", connectionNo, name, type);
    }
}
