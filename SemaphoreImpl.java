public class SemaphoreImpl implements Semaphore{

    private int permits;
    private static int maxPermits;
    private final Object lock = new Object();

    public SemaphoreImpl(int permits) {
        this.permits = permits;
        this.maxPermits = permits;
    }

    @Override
    public void acquire() throws InterruptedException{
        synchronized (lock) {
            if (permits > 0) {
                permits--;
            } else {
                lock.wait();
            }
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException{
        synchronized (lock) {
            if (this.permits - permits > 0) {
                this.permits -= permits;
            } else {
                lock.wait();
            }
        }
    }

    @Override
    public void release() {
        synchronized (lock) {
            if(permits < maxPermits) {
                permits++;
            } else {
                lock.notify();
            }
        }
    }

    @Override
    public void release(int permits) {
        if (this.permits + permits < maxPermits) {
            this.permits += permits;
        } else {
            lock.notify();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }


}