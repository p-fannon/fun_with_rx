package runner;

import io.reactivex.rxjava3.disposables.Disposable;
import programs.FizzBuzz;
import programs.RandomList;
import programs.ToDo;

public class RxProgramRunner {
    public void run() throws Throwable {
        FizzBuzz fb = new FizzBuzz();
        Disposable d = fb.go();
        Thread.sleep(500);
        d.dispose();
        ToDo td = new ToDo();
        td.go();
        RandomList rl = new RandomList();
        rl.rxFilter();
    }
}
