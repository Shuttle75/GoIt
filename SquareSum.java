import java.util.concurrent.ExecutionException;

interface SquareSum {

    long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException;

}