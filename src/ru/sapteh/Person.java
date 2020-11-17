package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private int id;
    private String lastname;
    private String name;
    private String fname;
    private Date date;

    public Person (int id, String lastname,  String name, String fname, Date date ){
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.fname = fname;
        this.date = date;
    }

    public int getYear(){
        Date date1 = new Date();
        return (int)(( date1.getTime()- getDate().getTime())/1000/24/60/60/30/12) ;
    }
    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getFname() {
        return fname;
    }
    private String dateToString(){
        return new SimpleDateFormat("dd.MM.yyyy").format(getDate());
    }

    public String toString(){
        return String.format("%d %s %s %s %s \n", getId(),getLastname(),getName(),getFname(),dateToString(),getYear());
    }
}
