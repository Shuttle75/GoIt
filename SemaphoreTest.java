public class SemaphoreTest {
    SemaphoreImpl semaphore;

    public static void main(String[] args) {
        new SemaphoreTest().Test();
    }

    public void Test() {
        semaphore = new SemaphoreImpl(5);
        // +permits - доступные разрешения
        // -permits - остановленные потоки


        int permits = semaphore.getAvailablePermits();

        try {
            for(int i = 0; i < 10; i++) {
                Thread.sleep(100);
                new Thread(new Worker()).start();
            }

            Thread.sleep(100);
            System.out.println("Permits " + semaphore.getAvailablePermits());
            semaphore.release();

            Thread.sleep(100);
            System.out.println("Permits " + semaphore.getAvailablePermits());
            semaphore.release(7);

            Thread.sleep(100);
            System.out.println("Permits " + semaphore.getAvailablePermits());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            /*
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
        */
    }

    public class Worker implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Before WAIT " + Thread.currentThread().getName());
                System.out.println("Permits " + semaphore.getAvailablePermits());
                semaphore.acquire();
                System.out.println("After WAIT " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
