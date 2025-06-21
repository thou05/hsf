package com.thou.superapp.entity.unione;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "GPA")
    private double gpa;

    //private String majorId;
    //=>KHONG VIET KHOA NGOAI KIEU NAY
    //VI NO NGHI THEO STYLE TABLE/CSDL => KHONG DUNG TUY DUY OOP


    //private Majoir major
    /*
    NGHI DUNG TU DUY OOP, CAC OBJECT CO MOI QUAN HE
    STUDENT THAM CHIEU DEN THONG TIN MAJOR - OBJECT
    co cach de conver tu oop thanh table/pk, join column => ORM MAPPING
    can 1 thang giup anh xa 2 the gioi de cho tuong thich: JPA/HIBERNATE
     */


    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                '}';
    }
}
