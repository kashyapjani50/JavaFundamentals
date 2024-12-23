package org.example;

class bank extends Thread
{
     private static int bal = 5000;
     private static int withdraw;

    bank(int withdraw)
    {
        this.withdraw=withdraw;
    }

    public static synchronized void with()
    {
        String name  = Thread.currentThread().getName();
        if(withdraw<=bal)
        {
            System.out.println(name + " withdraw money..." + bal);
            bal = bal-withdraw;
            System.out.println("balance " + bal);
        }
        else
        {
            System.out.println("Insfficient...");
        }
    }

    @Override
    public void run() {
        with();
    }

}

public class Custpmer
{
    public static void main(String[] args) throws InterruptedException {

        bank obj =new bank(500);
        bank obj2 = new bank(500);

        bank obj4 = new bank(250);
        bank obj5 = new bank(100);

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj2);
        Thread t4 = new Thread(obj4);
        Thread t5 = new Thread(obj5);
//        Thread t4;
 //       t4 = new Thread(obj3);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
       t4.setName("Thered 4");
       t5.setName("Thread 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();


    }
}