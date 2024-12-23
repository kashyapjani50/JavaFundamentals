package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final ReentrantLock lock = new ReentrantLock(true); // Fair lock

    public void accessResource() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            // Critical section
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " relesed the lock");
        }
    }

    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();
        Runnable task = example::accessResource;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
