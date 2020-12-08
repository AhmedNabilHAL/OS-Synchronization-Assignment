public class Network {

    static public void main(String[] args) throws InterruptedException {
        Router router = new Router(2);
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
        router.release(1);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
        Thread.sleep(2000);
        router.release(0);
        Thread.sleep(2000);
        System.out.println(router.getConnectedDevices());
    }
}
