package programs;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FizzBuzz {
    public Disposable go() {
        return Flowable.range(1, 100)
                .map(x -> x * x)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this::fizzBuzz);
    }

    public void fizzBuzz(Integer x) {
        if (x % 3 == 0 && x % 10 == 0) {
            System.out.println("Fizzbuzz: " + x);
        } else if (x % 10 == 0) {
            System.out.println("Fizz: " + x);
        } else if (x % 3 == 0) {
            System.out.println("Buzz: " + x);
        }
    }
}
