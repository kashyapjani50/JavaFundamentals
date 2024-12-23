package org.example;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class FairUnfairLock {

    private ReentrantLock unfairlock = new ReentrantLock();

    public void assessResouce() {
        unfairlock.lock();
        try {
            out.println(Thread.currentThread().getName() + " Acquired the Lock..");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            out.println(Thread.currentThread().getName() + " Released The Lock...");
            unfairlock.unlock();

        }
    }

    public static void main(String[] args) {
        FairUnfairLock fairUnfairLock = new FairUnfairLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                fairUnfairLock.assessResouce();
            }
        };


        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        Thread t3 = new Thread(task, "Thread3");

        t1.start();
        t2.start();
        t3.start();

    }
}
