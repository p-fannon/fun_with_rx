import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz();
        fb.go();
        Thread.sleep(500);
        ToDo td = new ToDo();
        td.go();
    }

    public static class FizzBuzz {
        public void go() {
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

    public static class ToDo {
        List<String> todos = new ArrayList<>();

        public ToDo() {
            todos.add("Find Roy Batty");
            todos.add("Take Spinner to garage");
            todos.add("Retire Roy Batty");
            todos.add("Run away with Rachael");
        }

        public void go() throws InterruptedException {
            Observable<String> todoObservable = getData(todos);
            Disposable disposable = todoObservable.subscribe(System.out::println);
            Thread.sleep(100);
            disposable.dispose();
            System.out.println("Directed by Ridley Scott");
        }

        public Observable<String> getData(List<String> list) {
            return Observable.range(0, list.size())
            .map(list::get)
                    .subscribeOn(Schedulers.single())
                    .observeOn(Schedulers.io());
        }
    }
}
