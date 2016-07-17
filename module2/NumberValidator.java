/**
 * Created by shuttle on 18.07.16.
 */
public class NumberValidator<Number> implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
        if (Integer.valueOf(result.toString()) > 0) {
            return true;
        }
        return false;
    }
}
