package org.example;

public class DeadLock {

    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();
        //Paper paper1 = new Paper();

        Thread thread1 = new Thread(() -> pen.writeWithPenAndPaper(paper), "THREAD 1 ");
        Thread thread2 = new Thread(() -> paper.writeWithPaperAndPen(pen) , "Thread 2");

        thread1.start();
        thread2.start();
    }
}


class Pen {

    public  void writeWithPenAndPaper(Paper paper)  {{
            System.out.println(Thread.currentThread().getName() + " Is Using Pen :");
            paper.finishWriting();
        }

    }

    public  void finishWriting()
    {
        synchronized(this)
        {
            System.out.println(Thread.currentThread().getName() + " Finished Using Pen :");
        }

    }

}

class Paper{

    public  void writeWithPaperAndPen(Pen pen)
    {
        synchronized(this)
        {
            System.out.println(Thread.currentThread().getName() + " Is Using Paper :" );
            pen.finishWriting();
        }

    }

    public  void finishWriting()
    {
        synchronized(this)
        {
            System.out.println(Thread.currentThread().getName() + " Finished Using Paper :" );
        }

    }
}

