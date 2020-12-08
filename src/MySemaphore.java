public class MySemaphore {
    protected int value = 0 ;
    protected MySemaphore() { value = 0 ; }
    protected MySemaphore(int initial) { value = initial ; }
    public synchronized void acquire() {
        value-- ;
        if (value < 0)
            try { System.out.println(" and waiting"); wait(); } catch( InterruptedException e ) { }
    }
    public synchronized void release() {
        value++ ; if (value <= 0) notify();
    }
}
