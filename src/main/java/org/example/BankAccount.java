package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;
public class BankAccount
{
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        out.println(Thread.currentThread().getName() + " Attempting withdraw : " + amount);
            if(lock.tryLock(1000 , TimeUnit.MICROSECONDS))
            {
                if (balance >= amount)
                {
                    try
                    {
                        Thread.sleep(3000);
                        balance -= amount;
                        out.println(Thread.currentThread().getName() + " Remaining : " + balance);
                    } catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    } finally
                    {
                        lock.unlock();
                    }

                }
                else
                {
                    out.println(Thread.currentThread().getName() + " Insufficient Balance : ");
                }
            }
            else
            {
                out.println(Thread.currentThread().getName() + " Could not Acquire The Lock Will Try Again Later : ");
            }

    }

}


