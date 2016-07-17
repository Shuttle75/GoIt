import java.util.concurrent.ExecutionException;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by shuttle on 07.07.16.
 */
public class SquareSumTest {
    SquareSumImpl squareSum = new SquareSumImpl();
    long result;

    @Test
    public void Test1() throws ExecutionException, InterruptedException {

        int[] arr0 = {1, 2, 3};
        result = squareSum.getSquareSum(arr0, 3);
        Assert.assertEquals((long) 14, result);
        System.out.println("Result " + result);
        System.out.println("");
    }

    @Test
    public void Test2() throws ExecutionException, InterruptedException {

        int[] arr1 = {2, 2, 2, 2, 2};
        result = squareSum.getSquareSum(arr1, 5);
        Assert.assertEquals((long) 20, result);
        System.out.println("Result " + result);
    }
}
