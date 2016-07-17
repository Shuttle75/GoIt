/**
 * Created by shuttle on 18.07.16.
 */
public class IntTask<Integer> implements Task<Integer> {
    Integer result;

    public IntTask(Integer aInteger) {
        result = aInteger;
    }

    @Override
    public void execute() {

    }

    @Override
    public Integer getResult() {
        return result;
    }
}
