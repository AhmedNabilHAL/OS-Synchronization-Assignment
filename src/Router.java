import java.util.ArrayList;
import java.util.List;

public class Router {
    List<Device> deviceList;
    int maxAllowedConnections;
    int currentConnections;
    MySemaphore sem;

    public Router(int maxAllowedConnections){
        this.maxAllowedConnections = maxAllowedConnections;
        sem = new MySemaphore(maxAllowedConnections);
        deviceList = new ArrayList<Device>();
        currentConnections = 0;
    }

    public void occupy(String name, Type type){
        Device d = new Device(++currentConnections, sem, name, type);
        d.start();
        deviceList.add(d);
    }

    public void release(int deviceIdx){
        if (deviceIdx >= deviceList.size()) {
            System.out.println("no such index");
            return;
        }
        deviceList.get(deviceIdx).release();
        deviceList.remove(deviceIdx);
    }
    public void releaseAll(){
        for(Device d : deviceList)
            d.release();
        deviceList.clear();
    }
    public String getConnectedDevices(){
        return deviceList.toString();
    }
}
