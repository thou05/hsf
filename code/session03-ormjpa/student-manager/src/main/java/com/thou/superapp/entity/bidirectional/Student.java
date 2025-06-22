package com.thou.superapp.entity.bidirectional;

import jakarta.persistence.*;

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

    //SV THUOC VE 1 MAJOR TAI 1 THOI DIEM, 1 BIEN MAJOR MA THOI, KHONG PHAI LIST NHU BEN KIA
    @ManyToOne
    @JoinColumn(name = "MajorId") //ca Major va Student deu co quyen khai bao joincolumn, neu dung uni-directional relationship
    //gio lam bi-directional, 2 thang nhin qua lai voi nhau, thi ta tra quyen giu joincolumn ve thanh N cho no giong goc nhin table
    private Major major;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

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
        return String.format("|%3s|%-40s|%4d|%4.1f|", id, name, yob, gpa);
    }
}
