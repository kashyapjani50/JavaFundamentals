package org.example;

import static java.lang.System.*;

public class Prority extends Thread
{
    public Prority(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for(int i = 0 ; i<1; i++)
        {
            out.println(Thread.currentThread().getName() + " Prority : " + Thread.currentThread().getPriority() + " Count : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                out.println(e);
            }

        }
    }

    public static void main(String[] args)
    {
        Prority myThread1 = new Prority("KASHYAP");
        Prority myThread2 = new Prority("DEEP");
        Prority myThread3 = new Prority("AVNISH");
        myThread1.setPriority(Thread.MIN_PRIORITY);
        myThread1.start();
        myThread2.setPriority(Thread.MAX_PRIORITY);
        myThread2.start();
        myThread3.setPriority(Thread.NORM_PRIORITY);
        myThread3.start();
    }
}
