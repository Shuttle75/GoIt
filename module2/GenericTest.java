import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by shuttle on 25.06.16.
 */
public class GenericTest {
    GenericExt genericExt = new GenericExt();

    @Test
    public void GenericExtTest1 () {
        ArrayList<Task<Integer>> arrayList = new ArrayList();
        arrayList.add(new IntTask(10));
        arrayList.add(new IntTask(20));
        arrayList.add(new IntTask(30));
        arrayList.add(new IntTask(40));
        genericExt.test(arrayList);
    }
}