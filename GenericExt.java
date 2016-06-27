import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuttle on 27.06.16.
 */
public class GenericExt {

    public interface Executor<E> {

        void addTask(Task<? extends E> task) throws RuntimeException;

        void addTask(Task<? extends E> task, Validator<? extends E> validator) throws RuntimeException;

        void execute();

        List<E> getValidResults() throws RuntimeException;

        List<E> getInvalidResults() throws RuntimeException;
    }


    public static class ExecutorImpl<E> implements Executor <E>{
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

            if(validator.isValid(task.getResult())) {
                listTask.add(task);
            }
        }

        @Override
        public void execute() {
            isExecuted = true;

            for (Task<Number> l: listTask) {
                if(Long.valueOf(l.getResult().toString()) > 20) {
                    listValid.add(l.getResult());
                }
                else {
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


    public interface Task<E> {
        // Метода запускает таск на выполнение
        void execute();

        // Возвращает результат выполнения
        E getResult();
    }

    public static class LongTask<Long> implements Task<Long> {
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

    public static class IntTask<Integer> implements Task<Integer> {
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


    public interface Validator<E> {
        boolean isValid(E result);
    }

    public static class NumberValidator<Number> implements Validator<Number> {

        @Override
        public boolean isValid(Number result) {
            if (Integer.valueOf(result.toString()) > 0) {
                return true;
            }
            return false;
        }
    }

    public void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }

        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }

        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }

    @Test
    public void GenericExtTest1 () {
        ArrayList<Task<Integer>> arrayList = new ArrayList();
        arrayList.add(new IntTask(10));
        arrayList.add(new IntTask(20));
        arrayList.add(new IntTask(30));
        arrayList.add(new IntTask(40));
        test(arrayList);
    }
}
