package org.example;

public enum days {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FIRDAY,
    SATURDAY,
    SUNDAY;

    days() {
        System.out.println(this.name());
    }

    public void disply()
    {
        System.out.println("Days : " + this.name());
    }


}
