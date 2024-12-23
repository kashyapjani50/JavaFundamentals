package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {


    private int count = 0;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static final Lock readLock = lock.readLock();
    private static final Lock writeLock =lock.writeLock();


    public void increment() {

        try {
            count++;
            Thread.sleep(0);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally{

        }
    }

    public int getCount() {

        try
        {
            return count;
        }
        finally {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();

        long str = System.currentTimeMillis();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                for (int i = 0; i < 1; i++) {
                    System.out.println(Thread.currentThread().getName() + " Read " + readWriteCounter.getCount());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                readLock.unlock();
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                for (int i = 0; i < 1; i++) {
                   readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + " Incremented.." + readWriteCounter.getCount());
                }
                writeLock.unlock();
            }
        };

        Thread t1 = new Thread(writeTask ,"Write");
        Thread t4 = new Thread(writeTask ,"Write1");
        Thread t2 = new Thread(readTask , "Reader 1");
        Thread t3 = new Thread(readTask , "Reader 2");
        Thread t5 = new Thread(readTask , "Reader 3");
        Thread t6 = new Thread(readTask , "Reader 4");
        Thread t7= new Thread(readTask , "Reader 5");
        Thread t8 = new Thread(readTask , "Reader 6");
        Thread t9 = new Thread(readTask , "Reader 7");
        Thread t10 = new Thread(readTask , "Reader 8");
        Thread t11 = new Thread(writeTask ,"Write 3");
        Thread t12 = new Thread(writeTask ,"Write 4");




        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();




        t1.join();
        t2.join();
        t3.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
        t4.join();
        t11.join();
        t12.join();

        System.out.println("Final Count " + readWriteCounter.getCount());
        System.out.println(System.currentTimeMillis()-str + "time" );

    }
}
