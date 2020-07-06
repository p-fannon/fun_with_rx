package main;

import runner.RxProgramRunner;

public class Main {
    public static void main(String[] args) {
        RxProgramRunner runner = new RxProgramRunner();
        try {
            runner.run();
        } catch (Throwable e) {
            System.out.println(":(");
        }

    }
}
