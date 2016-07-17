import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuttle on 18.07.16.
 */
public class ExecutorImpl<E> implements Executor<E> {
    ArrayList<Task> listTask = new ArrayList();
    ArrayList<Number> listValid = new ArrayList();
    ArrayList<Number> listInvalid = new ArrayList();
    boolean isExecuted = false;

    @Override
    public void addTask(Task task) throws RuntimeException {
        if (isExecuted) {
            throw new RuntimeException();
        }

        listTask.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) throws RuntimeException {
        if (isExecuted) {
            throw new RuntimeException();
        }

        if (validator.isValid(task.getResult())) {
            listTask.add(task);
        }
    }

    @Override
    public void execute() {
        isExecuted = true;

        for (Task<Number> l : listTask) {
            if (Long.valueOf(l.getResult().toString()) > 20) {
                listValid.add(l.getResult());
            } else {
                listInvalid.add(l.getResult());
            }
        }
    }

    @Override
    public List getValidResults() throws RuntimeException {
        if (!isExecuted) {
            throw new RuntimeException();
        }
        return listValid;
    }

    @Override
    public List getInvalidResults() throws RuntimeException {
        if (!isExecuted) {
            throw new RuntimeException();
        }
        return listInvalid;
    }
}
