package programs;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
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
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single());
    }
}
