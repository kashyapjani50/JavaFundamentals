package org.example;

public class variable {

     private static final int c =15; // global

    int a = 10; // instance

    public void abc()
    {
        int b = 10; // local
        System.out.println(b);
        //System.out.println(a);
        System.out.println(c);
    }

    public void display()
    {

        //System.out.println(b);
        System.out.println(a);
        System.out.println(c);
    }

}


