package programs;

import io.reactivex.rxjava3.functions.Predicate;

public class PrimeNumbersOnly implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        for (int i = 2; i < integer/2; i++) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }
}
