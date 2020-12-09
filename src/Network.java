import java.util.Scanner;

public class Network {

    static public void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("What is number of WI-FI Connections?");
        int TC = in.nextInt();
        Router router = new Router(TC);
        System.out.println("What is number of devices Clients want to connect? ");
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            System.out.println("Enter Device " + (i + 1) + " name :");
            String deviceName;
            deviceName = in.next();
            System.out.println("Choose Device " + (i + 1) + "Type :\n1]Mobile\n2]PC\n3]Tablet");
            int deviceType = in.nextInt();
            router.occupy(deviceName, Type.values()[deviceType - 1]);
        }
        while(true){
            System.out.println("Enter Device index to logout,-1 to exit: ");
            int op = in.nextInt();
            if(op==-1){
                router.releaseAll();
                break;
            }
            router.release(op);
        }


       /*Router router = new Router(2);
        router.occupy("C1", Type.PC);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.occupy("C2", Type.TABLET);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.release(0);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.occupy("C3", Type.MOBILE);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.release(0);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.release(0);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());

*/
    }
}
