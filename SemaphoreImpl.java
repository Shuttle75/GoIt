public class SemaphoreImpl implements Semaphore{

    private int permits;
    private final Object lock = new Object();

    public SemaphoreImpl(int permits) {
        this.permits = permits;
    }

    @Override
    public void acquire() throws InterruptedException{
        synchronized (lock) {
            this.permits--;
            if (this.permits < 0) {
                lock.wait();
            }
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException{
        synchronized (lock) {
            this.permits -= permits;
            if (this.permits - permits < 0) {
                lock.wait();
            }
        }
    }

    @Override
    public void release() {
        synchronized (lock) {
            if(permits < 0) {
                lock.notify();
            }
            permits++;
        }
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            if (this.permits < 0) {
                for (int i = this.permits; i < (this.permits + permits); i++) {
                    lock.notify();
                }
                this.permits += permits;
            }
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }


}