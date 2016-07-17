/**
 * Created by shuttle on 18.07.16.
 */
public class LongTask<Long> implements Task<Long> {
    Long result;

    public LongTask(Long aLong) {
        result = aLong;
    }

    @Override
    public void execute() {

    }

    @Override
    public Long getResult() {
        return result;
    }
}
