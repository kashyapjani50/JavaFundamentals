package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();


    public void outerMethod()
    {
        lock.lock();
        try
        {
            out.println("Outer Method");
            innerMethod();
        }
        finally {
            lock.unlock();
        }
    }

    public void innerMethod()
    {
        lock.lock();
        try
        {
            out.println("Inner Method");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example =new ReentrantExample();
        example.outerMethod();
    }

}
