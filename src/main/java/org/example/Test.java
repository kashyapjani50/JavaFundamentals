package org.example;

import static java.lang.System.out;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread T1 = new MyThread(counter);
        MyThread T2 = new MyThread(counter);

        T1.start();
        T2.start();

        T1.join();
        T2.join();

        out.println(counter.getCount());


    }
}
