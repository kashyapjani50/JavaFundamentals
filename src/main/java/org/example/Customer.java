package org.example;

class Bank extends Thread {
    private static int bal = 5000; // Shared balance among all threads
    private int withdraw; // Instance variable for each thread

    Bank(int withdraw) {
        this.withdraw = withdraw; // Assign the withdraw amount to this instance
    }

    public static synchronized void with(int withdrawAmount, String name) {
        if (withdrawAmount <= bal) {
            System.out.println(name + " withdraws money: " + withdrawAmount);
            bal -= withdrawAmount;
            System.out.println("Remaining balance: " + bal);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(name + " attempted to withdraw, but insufficient balance.");
        }
    }

    public static synchronized void display()  {
        System.out.println("Another Method" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
       // with(withdraw, name); // Pass the instance's withdraw amount
        display();
    }
}

public class Customer {
    public static void main(String[] args) throws InterruptedException {
        Bank obj1 = new Bank(500);
        Bank obj2 = new Bank(500);
//        Bank obj3 = new Bank(250);
//        Bank obj4 = new Bank(100);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj1);
        Thread t3 = new Thread(obj2);
//        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj2);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t4.setName("Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
//


//        t1.join();
//        t2.join();
//        t3.join();
//        t4.join();
    }
}
