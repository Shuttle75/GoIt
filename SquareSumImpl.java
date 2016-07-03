import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumImpl implements SquareSum{

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {
        Phaser phaser = new Phaser(numberOfThreads);
        phaser.register();

        long longResult = 0;
        List<Callable<Integer>> callables = new ArrayList<>();
        for(int value : values) {
            callables.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName()+" arrived");
                    Thread.sleep(1000); // Все потоки ждут одновременно 1 сек
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(Thread.currentThread().getName()+" after passing barrier");
                    return value * value;
                }
            });
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        phaser.arriveAndDeregister(); // Отпускаем для вычисления

        List<Future<Integer>> result = executor.invokeAll(callables);

        for (Future f : result) {
            longResult += Long.valueOf(f.get().toString());
        }
        executor.shutdown();

        return longResult;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareSumImpl squareSum = new SquareSumImpl();
        int[] arr0 = {1, 2, 3};
        System.out.println("Result " + squareSum.getSquareSum(arr0, 3));
        int[] arr1 = {2, 2, 2, 2, 2};
        System.out.println("Result " + squareSum.getSquareSum(arr1, 5));
    }
}
