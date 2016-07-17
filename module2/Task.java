/**
 * Created by shuttle on 18.07.16.
 */
public interface Task<E> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    E getResult();
}
