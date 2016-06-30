public class SemaphoreTest {
    SemaphoreImpl semaphore;

    public static void main(String[] args) {
        new SemaphoreTest().Test();
    }

    public void Test() {
        semaphore = new SemaphoreImpl(5);

        int permits = semaphore.getAvailablePermits();

        for(int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
        System.out.println("Permits " + semaphore.getAvailablePermits());
        semaphore.release(3);
        System.out.println("Permits " + semaphore.getAvailablePermits());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Permits " + semaphore.getAvailablePermits());
                    System.out.println("Before WAIT " + Thread.currentThread().getName());
                    semaphore.acquire(3);
                    System.out.println("After WAIT " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public class Worker implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Permits " + semaphore.getAvailablePermits());
                System.out.println("Before WAIT " + Thread.currentThread().getName());
                semaphore.acquire();
                System.out.println("After WAIT " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
