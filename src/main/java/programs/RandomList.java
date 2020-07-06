package programs;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.*;

public class RandomList {
    List<Integer> list = new ArrayList<>();
    List<Integer> filteredList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Predicate<Integer> predicate = new PrimeNumbersOnly();

    public RandomList() {
        generateRandomList();
    }

    public void rxFilter() throws InterruptedException {
        boolean shouldContinue = true;
        do {
            System.out.println("Do you want a filter? (y/n)");
            String response = sc.nextLine();
            if (response.equals("y") || response.equals("Y")) {
                Disposable d = Observable.range(0, list.size())
                        .map(i -> list.get(i))
                        .filter(predicate)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.single())
                        .subscribe(this::result);
                Thread.sleep(500);
                d.dispose();
                Collections.sort(filteredList);
                System.out.println("Out of a randomly generated list of 100 numbers between 1 and 1000, it contains " + filteredList.size() + " prime numbers. They are:\n");
                for (int num : filteredList) {
                    System.out.print(num);
                    System.out.print(" ");
                }
                System.out.println("\n");
                generateRandomList();
            } else if (response.equals("n") || response.equals("N")) {
                System.out.println("Bye!");
                shouldContinue = false;
            } else {
                System.out.println("Try again.");
            }
        } while (shouldContinue);
    }

    private void generateRandomList() {
        filteredList.clear();
        list.clear();
        for (int i = 0; i < 100; i++) {
            list.add(new Random().nextInt(1000) + 1);
        }
    }

    private void result(Integer integer) {
        filteredList.add(integer);
    }
}
