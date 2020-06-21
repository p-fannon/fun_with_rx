import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz();
        fb.go();
        Thread.sleep(500);
    }

    public static class FizzBuzz {
        public  void go() {
            Flowable.range(1, 100)
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
}
