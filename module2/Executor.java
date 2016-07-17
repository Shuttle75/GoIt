import java.util.List;

/**
 * Created by shuttle on 18.07.16.
 */
public interface Executor<E> {

    void addTask(Task<? extends E> task) throws RuntimeException;

    void addTask(Task<? extends E> task, Validator<? extends E> validator) throws RuntimeException;

    void execute();

    List<E> getValidResults() throws RuntimeException;

    List<E> getInvalidResults() throws RuntimeException;
}
