package com.thou.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")  //neu muon dat ten table khac ten class
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") //thieu se thanh varcha(255)
    private String id;  //key tu tang thi la Long int
    //=> trong thiet ke cong nghiep, dung chuan thi viet key nhu nay khong tot

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", length = 50, nullable = false)
    //@Nationalized => hard-coded voi Hibernate deu ra nvarchar()
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "GPA")
    private double gpa;

    //contructor rong, full tam so. neu key tu tang thi key khong dua vao constructor
    //get set tostring
    //CO THE DUNG LOMBOK DE TRANH BOILER-PLATE


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
