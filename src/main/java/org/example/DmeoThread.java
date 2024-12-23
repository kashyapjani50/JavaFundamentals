package org.example;

public class DmeoThread extends Thread {

    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        DmeoThread t1 = new DmeoThread();
     //   Thread t2 = new Thread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(2000);
        System.out.println(t1.getState());
        t1.join();
     //   t2.join();
     //   System.out.println(t2.getState());
        System.out.println(t1.getState());





//        for (int i = 0 ; i<1; i++)
//        {
//            System.out.println(Thread.currentThread().getId());
//            System.out.println(Thread.currentThread().getName());
//        }


        System.out.println("From threadDemo class..");
          System.out.println(Thread.currentThread().getName());
          System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getClass());



    }
}
